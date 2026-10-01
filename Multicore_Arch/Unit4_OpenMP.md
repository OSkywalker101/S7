# Unit 4: OpenMP — Parallel Programming with Directives

> Course: Multicore Architecture and Programming (CI71) | Source: `Multicore_Architecture.md` (lecture slides — OpenMP session)

---

## 1. Introduction to OpenMP

### 1.1 What is OpenMP?
- **Open Multi-Processing** — an API supporting **portable shared-memory multiprocessing programming** for C/C++ **and** Fortran.
- Standardized by the **OpenMP Architecture Review Board (ARB)**.
- Consists of:
  1. **Compiler directives** (`#pragma omp ...`) — the primary mechanism,
  2. **Runtime library routines** (`omp_get_thread_num()` etc.),
  3. **Environment variables** (`OMP_NUM_THREADS` etc.).
- Modern versions: **OpenMP 2.5/3.0**, **4.x** (accelerators, SIMD, tasks), **5.x**.
- Model: **fork–join**. A master thread forks a team of threads that each run the parallel region, then join back.

### 1.2 The fork–join execution model
```
master ──┬────────────┐
         │ fork       │
         ├  worker 1  ├  <-- team each runs parallel region
         ├  worker 2  ├
         ├  worker 3  ├
         ├  worker 4  ├
master ──┴────────────┘  <-- join
         (serial part)   (parallel region)   (serial part)
```
- **Serial part:** only the **master thread** runs (the default thread count = 1 for the initial region).
- **Parallel region:** `#pragma omp parallel` creates a **team** of threads; each member executes the same code (SPMD) unless work-sharing constructs divide it.
- At the end, **implicit barrier** = join → only master continues.

### 1.3 Execution modes — "Single Program Multiple Data (SPMD)"
- Each thread in the team runs the **same code block** but on **its own data / loop iterations** (identified by `omp_get_thread_num()`).

---

## 2. Challenges of Threading a Loop & Loop-Carried Dependence

### 2.1 The fundamental goal of OpenMP
- The **primary use**: turn **loops into parallel regions** so different cores execute **different iterations simultaneously**.
- Big wins from **Parallellizing Long-Running Loops** (PLRL) — loops dominate scientific/HPC code.

### 2.2 Two key concepts you must not confuse
1. **Loop-carried dependence** — the *correctness* problem:
   - iteration *i+1* needs a value written in iteration *i* (or earlier) → **can't** run iterations concurrently without breaking correctness.
   - Example (serial): `a[i] = a[i-1] + 1;` — each iteration reads previous → **loop-carried dependence** → NOT parallelizable as-is.
2. **Data race** — the *concurrency* problem:
   - two threads simultaneously read/write the same shared variable **without synchronization**.

### 2.3 Deciding "can this loop be parallelized?"
1. **Check for loop-carried dependences** — if none (or breakable via privatization/reduction), the loop is a candidate.
2. **Identify shared vs. private data.**
3. **Watch induction variables and `x = x + something` updates** (reductions).

---

## 3. The OpenMP Model: Shared Memory & Data Scoping

- **Shared-memory model:** all threads access a **common address space** (same variables). 
- Variables are **shared** by default; **private** copies possible.
- **Key directives for data scoping:**

| Directive/Clause | Effect |
|---|---|
| `shared(list)` | Variables shared by all threads (one copy) |
| `private(list)` | Each thread gets its **own copy** (uninitialized on entry!) |
| `firstprivate(list)` | Private, **initialized with the master's value** on entry |
| `lastprivate(list)` | Private; **last thread's value copied back** to the shared var on exit |
| `default(none)` | All variables **must be** explicitly listed (good hygiene/debugging) |
| `reduction(op:list)` | Combine each thread's partial result with `op` (safe, no races) |

---

## 4. Work-Sharing Constructs

### 4.1 `for` directive — loop partitioning
```c
#pragma omp parallel
{
    #pragma omp for
    for (i = 0; i < N; i++) {
        c[i] = a[i] + b[i];
    }
}
```
- The `for` work-share divides iterations among team threads. **No explicit partitioning code needed**.
- Combined form: `#pragma omp parallel for`.

### 4.2 Scheduling clauses (memorise — likely exam table)
| Schedule | Effect | Best for |
|---|---|---|
| **static** | Iterations divided into **equal chunks, assigned at compile time** (round-robin) | **Predictable, uniform work**; lowest overhead |
| **dynamic** | Chunks assigned **at runtime** from a shared work queue — threads pick the next chunk as they finish | **Varying/irregular work** (load balance) |
| **guided** | Large chunks first, **decreasing automatically** to a minimum size | Hybrid — reduces scheduling over-head while balancing |
| **runtime** | Scheduling decision **deferred to runtime** via `OMP_SCHEDULE` env var | Portability/tuning without recompiling |

Syntax: `schedule(static, chunk_size)` / `schedule(dynamic, size)` / `schedule(guided, min_size)` / `schedule(runtime)`.

> **Trick (the examiner loves this):** `static` asks *"how many iterations per chunk?"* with **no search/overhead**; `dynamic` trades scheduling overhead for **load balance** when work per iteration varies; `guided` = diminishing chunks to keep overhead low *and* balance good.

### 4.3 `reduction` clause — loop-reducing pattern
```c
#pragma omp parallel for reduction(+:sum)
for (i = 0; i < N; i++) sum += a[i];
```
- Each thread computes a **private partial sum**; at the end, partials are **combined with `+`** (safe, no races).
- Legal operations: `+ - * & | ^ && ||` (and min/max in later versions).
- **NOTE:** you must **NOT** put reduction variables in `private()` and then combine manually with a race-prone update — that's the classic bug.

### 4.4 `sections` — functional (task) decomposition in OpenMP
```c
#pragma omp parallel sections
{
    #pragma omp section
    { taskA(); }          // functions run concurrently
    #pragma omp section
    { taskB(); }
}
```
- Each `section` executes **once** by one thread (like task decomposition of Unit 2).

### 4.5 `single` directive
- Only **one thread** runs the enclosed code; others skip to the implicit barrier (or `nowait`).

---

## 5. Synchronization in OpenMP

| Construct | Purpose |
|---|---|
| **`barrier`** | **Explicit rendezvous**: every thread waits until ALL have arrived (implicit barrier also at end of `for`/`sections` unless `nowait`) |
| **`critical`** | Restricts a code block to **one thread at a time** (mutex-like) |
| **`atomic`** | Performs an update **atomically** for a **single statement** — cheaper than critical |
| **`ordered`** | Executes a block in **loop order** (like SPMD serialization) |
| **`master`** | Executes only on the **master thread** |
| **`nowait`** | Removes the **implicit barrier** at the end of a work-share → threads proceed without waiting |
| **`flush`** | Memory-consistency point: makes thread's view of shared vars **consistent** with memory |

> **⚠ nowait caution:** removing the barrier breaks ordering guarantees — only safe if downstream code doesn't depend on the other threads' work being done yet. It's a **performance/safety trade-off**; the classic exam question.

### 5.1 Choosing between `critical`, `atomic`, and `barrier`
- **critical:** arbitrary block; but only one thread at a time → contention.
- **atomic:** single statement, e.g., `omp atomic; x++;` — hardware-level cheap.
- **barrier:** you need ALL threads to reach a point (phase) — not a critical section.
- Triple-rule for answers: *mutual exclusion (critical/atomic), ordering (barrier/ordered), memory visibility (flush).*

---

## 6. Copy-In / Copy-Out & Task Queuing

### 6.1 Copy-in (`firstprivate`) & copy-out (`lastprivate`)
- **copy-in:** import the master's value into each thread's private copy **at region start** (`firstprivate`).
- **copy-out:** export the value of the "final/last thread" back to the shared variable **at region end** (`lastprivate`).
- Purpose: exchange data between the serial (master) world and the parallel team **without races**.

### 6.2 `task` — asynchronous task queuing (OpenMP 3.0+)
```c
#pragma omp task        // enqueue task
{ work(); }
#pragma omp taskwait    // wait until all tasks complete
```
- Threads pick tasks from the **task pool/queue** as they free up → dynamic load balancing.
- **Ideal for irregular (recursive) workloads** that can't be expressed as simple loops (e.g., recursive tree traversal, linked-list processing).
- `task` + `taskwait` is OpenMP's answer to *divide-and-conquer*/*task-decomposition* patterns.

---

## 7. Library Functions & Environment Variables (memorize key few)

### 7.1 Runtime library (OpenMP API)
```c
#include <omp.h>
int    omp_get_num_threads(void);   // size of current team
int    omp_get_thread_num(void);    // own id in [0, n-1]
int    omp_get_num_procs(void);     // # of processors (logical)
void   omp_set_num_threads(int n);  // request team size
double omp_get_wtime(void);         // elapsed wall-clock (benchmarking!)
int    omp_get_max_threads(void);
```

### 7.2 Environment variables
| Variable | Effect |
|---|---|
| `OMP_NUM_THREADS` | Default team size (overridden by `omp_set_num_threads` and `num_threads` clause — precedence: clause > library > env > default) |
| `OMP_SCHEDULE` | Default schedule (`static`, `dynamic,size`, `guided`) when `schedule(runtime)` used |
| `OMP_DYNAMIC` | Allow runtime to shrink/grow the team adaptively (`true`/`false`) |

> **Precedence trick (exam question!):** `num_threads(4)` clause beats `omp_set_num_threads(4)` beats `OMP_NUM_THREADS=4` beats the OpenMP default (usually #cores). 

---

## 8. Minimizing Synchronization & Threading Overhead (performance rules)

1. **Parallelize the long-running loops**; leave short loops/overheads serial.
2. **Merge multiple parallel regions** — each fork/join has overhead; fewer regions = less overhead (OpenMP reuses thread teams).
3. **Use `private`/`reduction` to remove races** instead of sprinkling `critical` everywhere (critical = contention).
4. **Use `nowait` where safe** to avoid barrier stalls — but be careful with ordering.
5. **Match thread count to workload & machine** (`OMP_NUM_THREADS` ≈ cores, not more — oversubscription slows).
6. **Avoid false sharing** in arrays (see Unit 5): pad/lay out data so threads don't share cache lines they're both writing.
7. **Minimize work inside `critical`/`atomic`** — smaller critical section ⇒ bigger speedup (ties to Unit 3!).
8. **Verify correctness on 1 thread first**, then scale threads and check **speedup**.

---

## 9. Quick Revision & Exam Strategy

### Example exam-style worked program
```c
#include <stdio.h>
#include <omp.h>
int main() {
    int i, n = 100000;
    double sum = 0.0;
    double a[100000];
    for (i=0;i<n;i++) a[i] = i * 1.0;
    omp_set_num_threads(4);
    #pragma omp parallel for reduction(+:sum) schedule(static, 25000)
    for (i=0;i<n;i++) sum += a[i];
    printf("sum = %f, threads = %d\n", sum, omp_get_max_threads());
    return 0;
}
```
**Expected discussion points:** team of 4; static chunks of 25000 each; `reduction(+:sum)` is race-free; implicit barrier at loop end; speedup ≈ 4× minus fork/join + memory-bandwidth effects.

### Likely exam questions
1. Explain the OpenMP programming model (directives, runtime library, env vars) with the fork–join model.
2. Explain `schedule(static/dynamic/guided/runtime)` with situations. (10 marks)
3. "Why is it important to keep a critical section as small as possible?" (+ explain nowait trade-offs)
4. Explain parallelizing difficulties: loop-carried dependence, data race — with examples.
5. Explain `reduction`, `firstprivate`/`lastprivate` (copy-in/copy-out), `task`, `flush`.
6. Optimize a given serial loop with OpenMP; state the expected speedup.
7. Compare `critical` vs `atomic` vs `barrier` vs `task` (with situations).

### Tips & Tricks
- **Always write the fork–join diagram** for any OpenMP essay.
- For "difficulties" questions, give **a concrete loop** (e.g., `a[i]=a[i-1]+1`) that is serial due to loop-carried dependence, and one like `c[i]=a[i]+b[i]` that parallelizes cleanly.
- Quote the **schedule-reasoning table**; pair `dynamic` with "load balance for irregular work".
- For overhead minimization questions, answer in a **numbered list of 5–6 rules** (§8) — the examiner wants a checklist.
- Mention `omp_get_wtime()` for measuring speedup — shows practical awareness.

---
*Sources: Multicore_Architecture.md (OpenMP session, lecture slides); syllabus.txt (Unit IV).*