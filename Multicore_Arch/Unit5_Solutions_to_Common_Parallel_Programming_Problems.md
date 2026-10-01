# Unit 5: Solutions to Common Parallel Programming Problems

> Course: Multicore Architecture and Programming (CI71) | Sources: `Multicore_Architecture.md` (lecture slides), `quantitative_approach.md` (Hennessy-Patterson, memory-consistency/cache chapters), syllabus.txt (Unit V)

---

## 1. Overview: "Too Many Threads" and the Wall of Parallelism

### 1.1 The "too many threads" phenomenon
- Amdahl's Law (Unit 1) says speedup saturates; adding cores past a point yields little.
- **Oversubscription:** creating more threads than execution resources causes OS **context-switch overhead**, cache thrashing, and contention — often **speedup < 1**.
- Symptom: performance *degrades* as you add threads.
- Rule: thread count ≈ hardware threads ("logical processors"), not "the more the better".

### 1.2 "Need to synchronize" vs. "can't afford the cost"
- Synchronization is necessary for correctness but has a **cost**: waiting threads idle cores, locks serialize, barriers stall phases.
- The parallel-programmer's job: minimize synchronization frequency and cost.

---

## 2. The Common Problems (and Solutions) — Master Table

| # | Problem | Typical cause | Solution |
|---|---|---|---|
| 1 | **Too many threads** | Oversubscription, poor partitioning | Match threads to cores; improve decomposition |
| 2 | **Data races** | Unsafe shared-memory access | Locks/atomics; scope data `private`; reduction |
| 3 | **Deadlock** | Circular lock wait | Lock ordering, single-resource locking, timed locks |
| 4 | **Livelock** | Threads "dance" without progress (retry forever) | Add randomness/backoff, timeout, deterministic arbitration |
| 5 | **Contended (hot) locks** | Everyone fights for one lock | Lock striping / finer-grained locks / read-write locks / lock-free |
| 6 | **Priority inversion** | High-priority thread blocked by a low-priority thread holding a lock | Priority inheritance / ceiling protocol |
| 7 | **Non-blocking algorithms** | Locks cause blocking; the "free lunch" of lock-freedom | CAS/LF/ABA-safe schemes (below) |
| 8 | **ABA problem** | Compare-and-swap succeeds on stale-but-equal value | Tagged pointers / double-CAS / ABA-counter |
| 9 | **Cache-line ping-ponging / false sharing** | Different cores write to the same cache line | Padding, per-thread data layout, `private` copies |
| 10 | **Memory reclamation** | Can't free heap objects while other threads may still read them | Hazard pointers, epoch-based reclamation (RCU), reference counting |
| 11 | **Thread-unsafe functions** | Library uses global/static state | Lock inside function; thread-local storage; use reentrant variants |
| 12 | **Memory bandwidth / cache / memory contention** | All cores hit the same DRAM/bus | Data locality, NUMA-aware allocation, avoid traffic storms |
| 13 | **Memory consistency (ordering)** | Hardware/compiler reorder memory ops | Memory fences; release/acquire semantics; proper sync primitives |
| 14 | **Pipeline stalls / latency effects** | Instruction dependencies & long-memory latency | Software pipelining, prefetching, cache-blocking/tiling |

---

## 3. Deep Dives on the "Hot Topics"

### 3.1 False sharing & cache-line ping-ponging (very exam-popular)
- **False sharing:** two threads update **different variables** that live on the **same cache line**; the cache treats each write as "line is invalid elsewhere" → **miss + coherence traffic** even though no real sharing happened ("false" sharing).
- Effect: passive contention — frequent cache misses; performance nosedives.
- Analogy: two people editing two *different parts of the same page* — whenever one edits, the other's local copy is invalidated.
- **Solutions:**
  1. **Padding:** add dummy bytes so each thread's data occupies its own cache line (classic size = 64–128 bytes).
  2. **Data separation:** split hot per-thread arrays into separate arrays (`a[i]` vs. struct→ `a_own[i]`).
  3. **Private copies / reduction:** accumulate in private variables, merge once.
  4. **Blocking/tiling:** keep a thread working on a contiguous private region.
- **Cache line = unit of cache coherence**; if two cores share one line and one writes → line bounces between cores → ping-ponging.

### 3.2 Data races — review and hardening
- A data race = unsynchronized accesses, ≥1 writer → **undefined behavior** (in C++11, "data race ⇒ UB").
- Solutions: mutex/critical-section, atomic operations, `private`/`reduction` in OpenMP, message passing.

### 3.3 Deadlock & livelock
- **Deadlock** — circular wait, threads blocked forever (covered in Unit 3).
- **Livelock** — threads are *not blocked* but keep repeating actions, each reacting to the other so no progress (e.g., two people meeting in a corridor who keep stepping the same way).
  - Fix: random backoff, exponential backoff, timeouts, drop-and-reacquire.

### 3.4 Priority inversion
- A **high-priority** thread waits on a lock held by a **low-priority** thread; the low-priority thread is **preempted** by a **medium-priority** thread → the high-priority thread is effectively blocked by *medium* priority (the classic *Mars Pathfinder* bug!).
- **Solutions:** priority inheritance (temporarily raise lock holder's priority to the waiter's), priority ceiling protocol.
- Exam keyword: "Mars Pathfinder" story (the 1997 incident fixed by priority-inheritance patch).

### 3.5 Non-blocking (lock-free) algorithms & the ABA problem
- **Non-blocking / lock-free:** progress guaranteed without locks — based on **atomic compare-and-swap (CAS):** `CAS(addr, old, new)` atomically swaps if equal.
- Benefits: no blocking/deadlock, better scalability under contention; **complexity risk** is the catch.
- **ABA problem:** a thread reads **A**, another thread changes A→B→back to **A**, then the first thread's `CAS(A)` **succeeds incorrectly** (value matches, but the *state* changed — e.g., freed & reused pointer).
  - **Solutions:** tagged/hazard (64-bit value = pointer + tag), double-compare-and-swap (DCAS), or ABA-safe reclamation schemes.
- Memory reclamation is intertwined: you can't `free()` memory another thread might still reference → **hazard pointers, RCU (read-copy-update), epoch reclamation**.

### 3.6 Memory-consistency models (Hennessy-Patterson §5.6)
- **Sequential consistency (SC):** the result of any execution is as if all memory ops were executed in some total order; each thread's order preserved. — *Intuitive but constrains hardware/compiler optimizations.*
- **Relaxed models** (TSO = x86 total-store-order, weak ordering, release/acquire; ARM/POWER): let the hardware reorder ops but provide **fence/fence-instructions** to restore order at synchronizing points.
- **Practical takeaway:** on relaxed systems, *plain shared-variable code is unsafe*; correct parallel code must use proper synchronization (which includes memory fences) — this is why Unit 3's `flush`/fence matters and why races are UB.
- Exam: define **SC**, define **release/acquire**, explain why synchronization must "include a fence/ordering".

### 3.7 IA-32 & Itanium — "bottom" of the stack (from the course narrative & quantitative approach)
- **IA-32 (x86 / Intel 32 architecture)** — CISC, register-accumulator heritage, heavily optimized with **superscalar OOO execution**, and in multi-core forms, **TSO** memory ordering.
- **Itanium (IA-64)** — explicitly-parallel instruction computing (**EPIC**); compiler exposes parallelism explicitly; **data speculation & control speculation** to hide memory latency; exposed **memory-ordering model** meant to reduce fence reliance. (Itanium is the historical context in the *Quantitative Approach*; modern focus is x86-64 and ARM processors.)
- **Why these matter for parallel programmers:** the ISA defines the **ordering guarantees** your threading library builds upon. Know what "TSO" (store order) vs weak ordering imply for locks/fences.

### 3.8 Memory bandwidth, cache capacity & memory-latency effects
- All cores share **DRAM bandwidth** & last-level cache capacity → memory-bound code does **not** scale linearly (parallel bandwidth ceiling).
- Solutions: cache-blocking/tiling (process data in cache-sized tiles), prefetching, avoiding remote/off-chip traffic (think NUMA), reduce redundant reads.

---

## 4. The "Program Performance" Lens (tying it together)

- **Tools:** profilers, `omp_get_wtime()`, performance counters (cache misses, stalls, coherence traffic).
- **Process:** (1) get correct on 1 thread; (2) measure; (3) identify bottleneck (compute? memory? synchronization?); (4) fix *with the table above*; (5) re-measure and ensure **acceptable speedup** and **scalability** to more cores.
- **Rule of thumb:** if speedup plateaus at 2–4× on an 8-core machine, suspect serial fraction (Amdahl) or memory/coherence contention — not "add more threads".

---

## 5. Quick Revision & Exam Strategy

### One-liners
- False sharing: same **cache line**, different data, bogus coherence traffic → pad/separate.
- ABA: CAS passes on a recycled value → tag/DCAS.
- Priority inversion: low-priority holder blocks high-priority waiter → priority inheritance.
- Memory consistency: SC (intuitive) vs relaxed (fast but needs fences). x86 = TSO.
- Memory reclamation: hazard pointers / RCU / epochs.
- Livelock: busy retry, no progress; fix with backoff/timeouts.
- Non-blocking = lock-free via CAS — no deadlock, but ABA + reclamation hazards.

### Likely exam questions
1. True/False & fixing: the classic "the program uses 8 threads but runs slower than 2" — diagnose (oversubscription / false sharing / contention).
2. What is false sharing? Give an example & the padding solution. (10 marks)
3. Explain the ABA problem and its fixes in lock-free programming.
4. Explain priority inversion with the Mars Pathfinder example & solutions.
5. What are memory-consistency models? Distinguish SC, TSO, weak/release-consistency; why are fences needed?
6. List solutions to each of: deadlock, livelock, contended locks, cache-line ping-ponging, memory reclamation.
7. Why does memory bandwidth limit scaling? How does cache blocking help?

### Tips & Tricks
- **Answer in "problem → cause → solution" triadic form** — it maps 1:1 onto the exam's phrasing ("Solve the following problems…").
- Memorize the **14-line master table** (§2) — it instantly covers any short-note question.
- For false sharing, **draw two cores writing the same 64-byte line** (indices `a[i]`, `a[j]` adjacent) and show the invalidation messages bouncing — a picture carries the explanation.
- Attach **Mars Pathfinder** to priority inversion and **CAS-pointer+tag** to ABA; these "stories" earn extra credit.
- For memory-consistency: define SC by its order-violation test angle; state TSO for x86; say ARM/POWER are weak; fence = restore order at sync points.
- Connect to earlier units: contention ⇔ small-critical-section rule (Unit 3), scheduling/load balance (Unit 2 & 4) — "solutions" must be a coherent story across units.

---
*Sources: Multicore_Architecture.md (lecture slides); quantitative_approach.md (models of memory consistency §5.6, cache hierarchies); syllabus.txt (Unit V).*