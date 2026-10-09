# Unit IV — OpenMP: A Portable Solution for Threading

> Source: Akhter & Roberts, *Multi-Core Programming* (Intel Press, 2006) — Ch. 6
> Place the matching textbook figures from the PDF where marked "🖼️".

---

## 1. What is OpenMP? (A Portable Solution for Threading)

- **OpenMP** = **Open Multi-Processing**: a portable, **directive-based** API for shared-memory parallel programming in C/C++/Fortran.
- Based on **compiler pragmas** (`#pragma omp ...`) + a runtime library + environment variables.
- You parallelize **loops and regions**; OpenMP manages **thread creation, scheduling, and joining**.
- **Fork–join model:** the master thread spawns a team of threads at a parallel region; threads run concurrently; they join at the end of the region.
- **Advantages:** incremental parallelization (add pragmas), portable across compilers, less code than raw threads, automatically manages the number of threads.
- **Key philosophy:** don't hard-code thread count — let OpenMP choose the optimal number.

```c
#include <omp.h>
#pragma omp parallel for
for (int i = 0; i < n; i++)
    a[i] = b[i] + c[i];
```

> 🖼️ **Image to add:** Fork–join model — master thread forks a team at the parallel region, threads join back at the end.

---

## 2. Challenges in Threading a Loop

Not every loop can be parallelized. Common obstacles:

1. **Loop-carried dependence** — an iteration depends on a previous iteration's result.
2. **Data races** — concurrent unsynchronized access to shared data.
3. **Shared vs private data confusion** — variables incorrectly shared (or copied).
4. **Loop scheduling imbalance** — uneven work per iteration.
5. **Reduction variables** — accumulators that need special handling.
6. **Too little work / overhead** — parallel overhead exceeds the work.
7. **Iteration count / trip-count not known or too small.**

---

## 3. Loop-Carried Dependence

A dependency that crosses loop iterations, preventing parallel execution.

| Type | Meaning | Parallelizable? |
|---|---|---|
| **Flow (RAW)** | iteration i writes what i+1 reads | No (if forward) |
| **Anti (WAR)** | iteration i reads what i+1 writes | Sometimes (rename) |
| **Output (WAW)** | two iterations write the same location | No |

**Example (not parallelizable):**
```c
for (i = 1; i < n; i++)
    a[i] = a[i-1] + b[i];   // each depends on previous
```
**Transform to remove dependence:**
```c
for (i = 1; i < n; i++)
    a[i] = a[i-1] + b[i];
// -> prefix-sum (scan) algorithm, or
// use b[] independently:
for (i = 0; i < n; i++)
    c[i] = b[i] + b[i-1];   // no carried dependence
```

**Techniques to break dependence:** reorder loops (loop interchange), scalar expansion (temporaries), use a different algorithm (e.g., scan/reduction), privatize.

---

## 4. Data-Race Conditions

- A **data race** occurs when two threads access the same memory location, at least one writes, without synchronization, and the result depends on timing.
- OpenMP default: variables declared **outside** the parallel region are **shared**; variables declared **inside** are **private**.
- The **loop index** is private automatically.
- **Race example:**
```c
int sum = 0;
#pragma omp parallel for
for (i = 0; i < n; i++)
    sum += a[i];        // RACE: sum is shared and updated concurrently
```
- **Fix:** use `reduction`, or an atomic/critical section, or private partial sums.

---

## 5. Managing Shared and Private Data

| Clause | Meaning |
|---|---|
| `shared(x)` | One copy, visible to all threads (must synchronize writes) |
| `private(x)` | Each thread gets an uninitialized private copy |
| `firstprivate(x)` | Private copy **initialized** from the value before the region |
| `lastprivate(x)` | Private copy of the thread finishing the last iteration is copied back out |
| `default(shared)` / `default(none)` | Default sharing (use `none` to force explicit clauses — safer) |
| `threadprivate(x)` | File-scope globals become per-thread persistent |

**Rules of thumb:**
- **Read-only** data → `shared`.
- **Loop-local temporaries / accumulators** → `private` or `firstprivate`.
- Use `default(none)` so you must declare every variable's scope → avoids hidden races.
- Scalars written in the loop that shouldn't escape → `private`.

> 🖼️ **Image to add:** Diagram distinguishing one shared copy vs per-thread private copies.

---

## 6. Loop Scheduling and Partitioning

The `schedule` clause controls how iterations are assigned to threads.

| Schedule | Description | Best when |
|---|---|---|
| **`static`** | Iterations divided into equal chunks at compile time | Uniform work per iteration (predictable) |
| **`static, chunk`** | Round-robin blocks of size `chunk` | Some variation, low overhead |
| **`dynamic[, chunk]`** | Threads grab `chunk` iterations at a time (default 1) | Highly variable work (good load balance) |
| **`guided[, chunk]`** | Large chunks first, shrinking to `chunk` | Variable work, lower overhead than dynamic |
| **`runtime`** | Chosen at run time via `OMP_SCHEDULE` | Tuning without recompiling |
| **`auto`** | Compiler/runtime decides | Let the system choose |

- **Static** = least overhead, but poor balance if work varies.
- **Dynamic** = best balance, but higher overhead (atomic work-sharing).
- **Guided** = compromise; chunk size decreases over time.
- `nowait` can be added to remove the implicit barrier when safe.

```c
#pragma omp parallel for schedule(dynamic, 4)
for (i = 0; i < n; i++) heavy_work(i);
```

> 🖼️ **Image to add:** Visual of static vs dynamic vs guided iteration-to-thread assignment.

---

## 7. Effective Use of Reductions

- A **reduction** combines per-thread partial results into one using a commutative/associative operator.
- Syntax: `reduction(op:var)` where `op` ∈ `+ - * & | ^ && || max min`.
- Each thread gets a private copy initialized to the operator's identity (0 for +, 1 for *, etc.); copies are merged at the end.

```c
double sum = 0.0;
#pragma omp parallel for reduction(+:sum)
for (i = 0; i < n; i++)
    sum += a[i];         // safe and efficient
```

- **Effective use:** use reductions instead of `critical`/`atomic` for accumulators — far less contention.
- Multiple variables allowed: `reduction(+:x,y)`.
- **Caveat:** operation must be associative/commutative; floating-point results may differ slightly from sequential due to reordering.

---

## 8. Minimizing Threading Overhead

Sources of overhead:
1. **Thread creation/teardown** — avoid creating teams repeatedly; put loops inside one parallel region.
2. **Barriers** — each work-sharing region has an implicit barrier; use `nowait` where safe.
3. **Scheduling** — prefer `static` when work is uniform.
4. **False sharing** — pad/align per-thread data.
5. **Too fine granularity** — each thread must have enough work.

**Techniques:**
- Combine multiple loops under **one** `parallel` region (`omp parallel` + several `omp for`).
- Use `if(condition)` clause to run serially when the loop is small.
- Use `nowait` to skip unnecessary barriers.
- Use `single` instead of many `critical` sections.

---

## 9. Work-Sharing Sections

`omp sections` / `omp section` — assign **different blocks of code** to threads (task/functional parallelism).

```c
#pragma omp parallel sections
{
#pragma omp section
    compute_A();
#pragma omp section
    compute_B();
}
```

- Complements `omp for` (data parallelism). Use when you have distinct independent tasks.
- `single` — executes a block by exactly one thread (others skip; implicit barrier unless `nowait`).
- `master` — executes by the master thread only (no implicit barrier).

> 🖼️ **Image to add:** `sections` — different code blocks mapped to different threads.

---

## 10. Performance-Oriented Programming

- Let OpenMP manage the number of threads; **never hard-code** it.
- Match runnable threads to hardware threads.
- Keep the parallel region large (amortize fork/join cost).
- Avoid false sharing; keep threads on private data and merge at the end.
- Prefer reductions over locks; prefer `static` scheduling for uniform loops.
- Tune granularity; measure.
- Watch the **serial fraction** (Amdahl) and the memory bandwidth ceiling.

---

## 11. Using Barrier and No Wait

- OpenMP inserts **implicit barriers** at the end of `parallel for`, `sections`, `single`.
- **`barrier`** directive: explicit synchronization point — all threads wait.
- **`nowait`** clause: removes the implicit barrier (use only when following code doesn't depend on results — otherwise races).

```c
#pragma omp parallel
{
#pragma omp for nowait
    for (i=0;i<n;i++) a[i] = work(i);   // no barrier; safe if b doesn't depend on a
#pragma omp for
    for (i=0;i<n;i++) b[i] = a[i];      // has implicit barrier
}
```
- **Rule:** add `nowait` only when you can prove no cross-thread dependency.

> 🖼️ **Image to add:** Two `omp for` loops with a barrier between them; `nowait` removes the barrier.

---

## 12. Interleaving Single-Thread and Multi-Thread Execution

- Some code must run serially (I/O, setup, sequential algorithm parts).
- Use `single`/`master` inside a parallel region for serial work without leaving the region.
- Use `#pragma omp parallel` guard conditions to run parallel or serial code based on size (`if` clause).
- OpenMP lets you keep one `parallel` region and interleave parallel and single-threaded segments, avoiding repeated fork/join overhead.

```c
#pragma omp parallel
{
#pragma omp single
    init();             // one thread initializes
#pragma omp for
    for(...) compute(); // all threads
#pragma omp master
    report();           // master only
}
```

---

## 13. Data Copy-In and Copy-Out

- `firstprivate(var)` — **copy in**: private copy initialized with the value from before the region (useful for input values).
- `lastprivate(var)` — **copy out**: the private value from the thread doing the **last** iteration is written back to the shared variable (useful for loop results).
- `copyin(var)` — for `threadprivate` variables: copy the master's value into each thread's copy.
- `copyprivate(var)` — broadcast a `single` thread's private value to all other threads' copies.

```c
int last;
#pragma omp parallel for lastprivate(last)
for (i=0;i<n;i++) { last = i; work(i); }
// after loop, last == n-1 (value from final iteration)
```

---

## 14. Protecting Updates of Shared Variables

For shared updates that aren't reductions:

| Construct | Use |
|---|---|
| **`atomic`** | Single fast update of one variable (`x += v`, `x++`); hardware atomic; cheapest |
| **`critical`** | Named or unnamed critical section; heavier but protects arbitrary code |

```c
#pragma omp parallel for
for (i=0;i<n;i++) {
    #pragma omp atomic
    counter++;                 // fast, single variable
}
```
- Prefer `atomic` for simple scalar updates; use `critical` for compound operations.
- Prefer `reduction` when accumulating — best performance.

> 🖼️ **Image to add:** Decision flow: reduction vs atomic vs critical for shared updates.

---

## 15. Intel Task Queuing Extension to OpenMP

- Classic OpenMP ties parallelism to loop/section **structures**; tasks allow **dynamic, irregular** parallelism.
- **Task queuing** (`#pragma omp task`) lets you create tasks that execute later, enabling **recursive and irregular** parallelism (e.g., tree traversals).
- Supports **task queues** for load balancing of unpredictable workloads.
- The standard later adopted `task` and `taskwait` (OpenMP 3.0).

```c
#pragma omp parallel
#pragma omp single
{
    #pragma omp task
    process_left();
    #pragma omp task
    process_right();
}
```

---

## 16. OpenMP Library Functions

| Function | Purpose |
|---|---|
| `omp_get_thread_num()` | ID of the calling thread (0 = master) |
| `omp_get_num_threads()` | Number of threads in current team |
| `omp_get_max_threads()` | Max threads available |
| `omp_set_num_threads(n)` | Set number of threads |
| `omp_get_num_procs()` | Number of processors |
| `omp_in_parallel()` | Are we inside a parallel region? |
| `omp_get_wtime()` | Wall-clock time (for timing) |
| `omp_set_dynamic()`, `omp_get_dynamic()` | Dynamic team sizing |
| `omp_init_lock`, `omp_set_lock` | OpenMP lock routines |

---

## 17. OpenMP Environment Variables

| Variable | Purpose |
|---|---|
| **`OMP_NUM_THREADS`** | Default number of threads |
| **`OMP_SCHEDULE`** | Default schedule for `schedule(runtime)` |
| **`OMP_DYNAMIC`** | Enable/disable dynamic thread count adjustment |
| **`OMP_NESTED`** | Enable/disable nested parallelism |
| `OMP_STACKSIZE` | Stack size per thread |
| `OMP_PROC_BIND` / `OMP_PLACES` | Thread affinity |

---

## 18. Compilation, Debugging, Performance

- **Compilation:** enable OpenMP support:
  - GCC/Clang: `-fopenmp`
  - Intel: `-qopenmp` / `-openmp`
  - MSVC: `/openmp` (older versions: `/openmp:experimental`)
  - Link the OpenMP runtime library.
- **Debugging:** common bugs = data races, wrong sharing, missing barriers. Use tools (**Intel Thread Checker**) and `default(none)` to catch scope mistakes.
- **Performance:** tune schedule, granularity, thread count; avoid false sharing; use reductions; measure with `omp_get_wtime`.

```bash
gcc prog.c -o prog -fopenmp
OMP_NUM_THREADS=4 ./prog
```

---

## OpenMP Directive Quick Reference

| Directive | Meaning |
|---|---|
| `parallel` | Start a parallel region |
| `parallel for` | Parallelize a for loop |
| `sections` / `section` | Functional parallelism |
| `single` / `master` | One thread / master only |
| `barrier` | Explicit sync point |
| `critical` | Mutual exclusion |
| `atomic` | Single atomic update |
| `reduction` | Parallel accumulator |
| `task` | Dynamic task |
| `nowait` | Skip implicit barrier |

---

## 🧠 How to Remember (Mnemonics & Tips)

- **OpenMP = "Pregma-driven":** you just say `#pragma omp` and the runtime handles threads. **Fork–join** is the mental model.
- **Sharing rule:** *"Outside = shared, Inside = private, Index = private."*
- **`default(none)` = "no hiding allowed"** → forces you to declare every variable → catches races early.
- **Schedule choice:** *"Static = predictable & fast; Dynamic = variable work & balanced; Guided = shrinking chunks (best of both)."*
- **Reduction = "spread then combine"** — each thread has its own partial, merged at the end.
- **`atomic` < `critical` in cost** but works only on one variable; **`reduction` beats both** for accumulators.
- **`nowait` warning:** *Only when the next loop doesn't read this one's output.*
- **First/last private:** *First = copy **in**, Last = copy **out**.*
- **Compile flags:** GCC `-fopenmp`, Intel `-qopenmp`, MSVC `/openmp`.

## ⭐ Likely Exam Questions
1. What is OpenMP? Explain the fork–join execution model.
2. Explain loop-carried dependence and how to identify/handle it.
3. How does OpenMP manage shared and private data? Explain `firstprivate`, `lastprivate`, `default(none)`.
4. Explain the OpenMP schedule clause options and when to use each.
5. Explain reductions with an example; why are they better than critical sections?
6. What are common OpenMP threading overheads and how do you minimize them?
7. Differentiate `atomic`, `critical`, and `reduction` for protecting shared updates.
8. Explain `barrier` and `nowait` with examples.
9. List and explain OpenMP library functions and environment variables.
10. How do you compile and debug an OpenMP program?
