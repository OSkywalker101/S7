# Unit V — Solutions to Common Parallel Programming Problems

> Source: Akhter & Roberts, *Multi-Core Programming* (Intel Press, 2006) — Ch. 7
> Place the matching textbook figures from the PDF where marked "🖼️".

---

## 1. Too Many Threads

- Threads add overhead: **creation, scheduling, context switching, memory (stack) usage**.
- **Time-slicing woes:** if runnable software threads exceed hardware threads, the OS time-slices. A thread holding a lock may be switched out, and all threads waiting on that lock stall (worse with **fair** locks).
- **Key rule:** *Runnable* threads — not blocked threads — cause time-slicing overhead. Blocked threads (waiting on I/O, mouse) are taken off the run schedule and cost little.
- **Best practice:** match the number of **runnable** threads to the number of **hardware threads** (sometimes limited by number of outer-level caches). **Never hard-code** the thread count — leave it a tuning parameter.
- **Organizing principle:** separate **compute threads** (runnable most of the time, fed from task queues, count = hardware threads) from **I/O threads** (mostly blocked, can be numerous).

### Managing threads effectively
1. **Let OpenMP do the work** — request loop iterations, not threads; the runtime picks the optimal thread count.
2. **Thread pool** — a set of long-lived threads servicing tasks from a queue; avoids per-task creation cost.
   - Windows: `QueueUserWorkItem`; .NET: `ThreadPool`; Java: `Executor`; **no standard pool in POSIX**.
3. **Write your own scheduler — work stealing:** each thread has a private task deque; when idle it **steals** from others. Gives good cache use and load balancing. Bias stealing toward **large** tasks. (Early Cilk scheduler.)

> 🖼️ **Image to add:** Time-slicing with a lock-holding thread blocking all waiters (convoy behind a sleeping lock holder).

---

## 2. Data Races, Deadlocks, and Live Locks

### 2.1 Data Races
- Unsynchronized access to shared memory → result depends on relative **timing** of threads.
- Example: two threads add to shared `x` (initial 0) → final can be **1, 2, or 3**.
- Races hide behind **language syntax**:
  - `x += 1` is really `temp = x; x = temp + 1` (interleavable).
  - Shared location accessed via different expressions, hidden in function calls.
  - Even "one instruction" fetch-update can be broken by hardware into interleaved reads/writes.
- **Higher-level races:** even when individual ops are synchronized, the *combination* can race. Example: using a list as a set of keys — if two threads both check "key absent" then both insert, the invariant "no duplicate key" breaks. Need a lock protecting the **invariant**, not just each operation.
- **Detection:** **Intel Thread Checker** works on actual memory locations (sees past syntax camouflage).

> 🖼️ **Image to add:** Figure 7.1 (two threads racing `x`) and Figure 7.2 (races hidden behind C++ syntax).

### 2.2 Atomicity notes
- Deliberate races can be useful ("latest current value"), but reads/writes must be **atomic**.
- Types longer than the natural word (e.g., 80-bit float) or **misaligned** accesses may not be atomic; an access straddling a **cache line** becomes two accesses.

### 2.3 Deadlock
- Occurs when threads are stuck in a **cycle** of resource/lock acquisition.
- Happens any time a thread needs **exclusive access to two or more** shared resources (locks, files).

**Four necessary conditions (all must hold):**
1. Access to each resource is **exclusive**.
2. A thread may **hold** one resource while **requesting** another.
3. No thread voluntarily **relinquishes** what it holds.
4. There is a **cycle** of threads/resources.

**Avoid by breaking any one condition:**
- **Replicate** the resource → each thread gets a private copy → no lock; merge later. Also improves scalability. (Breaks #1.)
- **Lock ordering** — always acquire resources in a consistent order (alphabetical, list order, tree pre-order, outside→inside for nested components). Prevents cycles. (Breaks #4.)
  - When no natural order exists, **sort locks by address**: thread must know all locks upfront, then acquire in `&x < &y` order. (See Figure 7.5.)
- **Try-lock + back-off** — attempt to acquire; if it fails, release everything and retry after a random delay (exponential back-off). Breaks #3, but is **unfair** and can cause **livelock**.
- **Avoid holding a lock while calling outside your component** (call chain may cycle back → deadlock).

> 🖼️ **Image to add:** Figure 7.4 (two-thread deadlock cycle), Figure 7.5 (locks ordered by address), Figure 7.6 (try-and-back-off).

### 2.4 Live Lock
- Threads continually conflict and back off, so **none makes progress**.
- Cured by **exponential back-off** (double the random wait each attempt). Eventual progress for at least one.
- Downside: **not fair** — no guarantee a particular thread progresses. If fairness matters, use **lock ordering** instead.

---

## 3. Heavily Contended Locks

- A contended lock is like a **tollgate**: if threads arrive faster than the critical section drains them, they form a **convoy** (convoying).
- **Fair** locks make it worse: if a lock-holding thread falls asleep, all threads behind it wait.
- The bottleneck is **serialization**, not lock speed.

> 🖼️ **Image to add:** Tollgate/convoy analogy — threads queued behind a contended lock.

---

## 4. Priority Inversion

- When priorities exist but hardware threads are fewer than software threads, a **low-priority** thread holding a lock can block a **high-priority** thread; meanwhile a **medium-priority** thread runs (because the high-priority one is blocked). High priority effectively loses to medium.
- **Famous real case:** NASA **Mars Pathfinder**.
- **Solutions:**
  - **Priority inheritance (lazy):** temporarily bump the lock-holder's priority to that of the highest waiter until it releases. Windows mutexes support this by default.
  - **Priority ceiling (eager):** assign the mutex a *ceiling* priority (= highest priority of any thread expected to hold it); on acquire, bump the thread to the ceiling. 
- **Pthreads:** supports **neither** by default; both optional. Use `pthread_mutexattr_setprotocol` / `getprotocol`.
- **Hand-coded spin locks** are prone to priority inversion; if protocols can't be added, restrict contenders to the **same priority**.

> 🖼️ **Image to add:** Figure 7.7 (priority inversion — low holds lock, high blocked, medium runs).

---

## 5. Solutions for Heavily Contended Locks

- A **faster lock** only gives a constant-factor improvement — it cannot fix **scalability** (locks inherently serialize).
- To improve scalability: **eliminate the lock** or **spread the contention**.

1. **Eliminate — replicate resources:** give each thread a private copy (e.g., per-thread event counters, summed at the end). Best if workable.
2. **Partition the resource** with a separate lock per partition.
   - **Hash table → array of sub-tables**, each with its own lock; hash keys to sub-tables. Threads mostly hit different sub-tables → less contention. (Figure 7.8.)
3. **Fine-grained locking:** lock each **bucket**. Allows concurrent access to different buckets. Complications: resizing (needs to exclude others) and per-lock space overhead. (Figure 7.9 combines reader-writer lock on array descriptor + per-bucket mutex.)
4. **Reader-writer locks:** multiple readers OR one writer. Great when **reads dominate writes**. Limitations: not a cure for *high* contention (memory contention at very high reader rates).
5. **Rework the decomposition** to lower contention — the reliable fix for high contention (e.g., combine sub-tables + fine-grained locking).

> 🖼️ **Image to add:** Figure 7.8 (hash table split into sub-tables) and Figure 7.9 (fine-grained locking with reader-writer mutex).

---

## 6. Non-Blocking Algorithms

- **Definition:** algorithms that don't use locks; stopping a thread does **not** prevent the rest of the system from progressing.
- **Guarantees (weak → strong):**
  - **Obstruction-free:** progress when no contention; livelock possible (exponential back-off helps).
  - **Lock-free:** the *system as a whole* always makes progress (at least one thread).
  - **Wait-free:** *every* thread always makes progress. Very rare.
- **Advantages:** immune to lock contention, **priority inversion**, and **convoying**.
- **Disadvantages:** much more complex; hard to verify; hard to handle memory reclamation.
- **Building block:** atomic operations (e.g., `Interlocked` class, CAS).
  - Trivial example: **interlocked increment** instead of a lock.
  - **Caution:** composing thread-safe operations ≠ thread-safe procedure. Example: **wrong** reference-count decrement-and-test (two threads both decrement and both see zero); **correct** = do decrement and test as one atomic op.
- **Fetch-and-op idiom:** read `x` → compute `x_new` → `InterlockedCompareExchange(&x, x_new, x_old)`; retry until the exchange succeeds. Safe when the order of `op` doesn't matter (commutative/associative).

> 🖼️ **Image to add:** Figure 7.10 (atomic ops & race conditions), Figure 7.11 (locked vs lockless fetch-and-op).

---

## 7. ABA Problem

- In fetch-and-op, between reading `x_old` and the compare-exchange, other threads might change `x` from **A → B → A**. The compare-exchange then succeeds as if nothing happened.
- Harmless **if** the operation's order doesn't matter. **Harmful** for non-blocking **linked structures** where `op` isn't a pure function (it touches a `next` field).
- **Broken lockless stack example:** `BrokenLocklessPop` — after reading `Top`, other pushes/pops change the stack, but the compare-exchange only checks `Top`, not `next` → corrupts the stack. (Figures 7.12–7.13.)
- **Solutions:**
  1. **Never reuse A** — in **garbage-collected** environments (Java/.NET), allocate fresh nodes instead of recycling.
  2. **Turn ABA into ABA′** — append a **serial number** to the pointer (double-wide compare-exchange). IA-32: `cmpxchg8b`; EM64T: `cmpxchg16b`; Itanium: `cmp8xchg16`.
  3. **Hazard pointers** — a mini garbage collector for pointers used in compare-exchange (Michael 2004).

> 🖼️ **Image to add:** Figure 7.12/7.13 (lockless stack + ABA sequence).

---

## 8. Cache Line Ping-Ponging

- Non-blocking algorithms can generate heavy **memory-bus traffic**: contending threads bounce the same **cache line** back and forth ("ping-pong").
- A **locked** algorithm may beat a non-blocking one if the lock hands off the cache line until done.
- Rough guide: a **fast spin lock** protecting a critical section with **no atomic ops** may outperform a non-blocking design needing **3+ highly contended atomics**. **Experiment.**

---

## 9. Memory Reclamation Problem

- Languages like C/C++ need explicit `free()`. It is **hard** to safely free a node used in a non-blocking algorithm.
- Why: after thread X removes a node, another thread Y may still be examining it (expecting its compare-exchange to fail and retry). If the node is freed, its field might coincidentally hold the expected value → Y succeeds incorrectly.
- **Solutions:** garbage collector / **hazard pointers**; or a **free list** associated with the structure — don't free nodes until the structure itself is freed.

---

## 10. Recommendations (Non-Blocking)

- Non-blocking algorithms are a research hot topic; hard to verify (wrong ones have been published).
- **Safe uses:**
  - Atomic **increment/decrement/fetch-and-add** used intuitively.
  - **Fetch-and-op** with **commutative & associative** ops.
  - Non-blocking **linked-structure** algorithms → **leave to experts**; use peer-reviewed algorithms; mind memory reclamation.
- Otherwise **stick with locks**; keep runnable threads ≤ hardware threads; avoid contention so the problems don't arise.

---

## 11. Thread-Safe Functions and Libraries

- **Thread-safe routine** = concurrently callable by clients without corruption.
- **Realistic convention:** instance routines are thread-safe when called on **different objects**, but not on the **same object** (unless documented). Implementers must protect **hidden shared state**.
- Example: **reference-counted strings** — each "string object" is a pointer to shared data + a reference count; updates to the count must use **atomic** operations.
- **Avoid hidden global state in interfaces:** `strtok` is a classic offender (keeps parser state between calls → not thread-safe). Fix: make the parser an **explicit argument** (re-entrant), or use **thread-local storage**.
- **Thread-safe vs thread-unsafe library versions:** use the thread-safe runtime (Windows: **`/MD`**, debug **`/MDd`**). Defaults from the single-core era are often **not** thread-safe. Check compiler docs.

> 🖼️ **Image to add:** Figure 7.14 (reference-counted string with hidden shared state).

---

## 12. Memory Issues

- Modern cores execute **hundreds of ops** per main-memory access; programs are limited by the **memory bottleneck**, not CPU speed.
- Multi-core **worsens** this unless bandwidth is conserved and contention avoided.

### 12.1 Bandwidth
- **Pack data tightly** and **move it less often**.
  - Boolean arrays → 1 bit/entry; use shortest sufficient integer type.
  - In C/C++, declare struct fields in **descending size order** to minimize padding. (Figure 7.15.)
  - `#pragma pack` can remove padding but may cause **misaligned** (slower) accesses — counterproductive.

### 12.2 Working in the Cache
- Mainstream languages have no explicit "move data" commands; movement arises from read/write patterns.
- Techniques:
  - **Cache-oblivious blocking:** recursively divide the problem until sub-problems fit in cache (e.g., FFTW).
  - **Reorder steps / interchange loops** to shrink the cache footprint.
- **Sieve of Eratosthenes example:**
  - **Cache-unfriendly** version: inner `Strike` walks the full array `composite` (much bigger than cache). (Figure 7.16.)
  - **Cache-friendly** version: process the sieve in **windows of size ≈ √n**, keeping suspended loop indices in `striker[]` and primes in `factor[]`. Extra bookkeeping, but ~**5× faster** when n exceeds cache size. (Figures 7.17–7.18.)

> 🖼️ **Image to add:** Figure 7.15 (padding), Figure 7.16 vs 7.17 (sieve), Figure 7.18 (performance step-up).

### 12.3 Memory Contention
- Multi-core adds **core-to-core** data movement. Two dependency types cause traffic:
  - **Read-write dependency:** core A writes a line, core B reads it.
  - **Write-write dependency:** core A writes, core B writes.
- **No traffic:** multiple cores only **read** a line (each keeps its own copy).
- **Minimize shared locations** → minimizes both lock contention *and* memory traffic. Let each thread work on **private copies**, merge at the end.
- **Parallel sieve walk-through (Figure 7.19):**
  - `factor[]` becomes **read-only** after filling → shareable.
  - `composite[]` → give each thread a **private window** (reduces space O(n) → O(√n)).
  - `count` → per-thread **partial counts**, summed at the end (avoid atomic contention).
  - `striker[]` → **private per thread**; break the loop-carried dependence by recomputing from scratch (`base` tracks the window start).

---

## 13. Cache-Related Issues

### 13.1 False Sharing
- The **cache line** (or sector) is the unit of interchange. If two threads write **different variables on the same cache line**, the line ping-pongs even though the variables are distinct.
- **Not true sharing** (no shared data) but *false* sharing (shared cache line).
- **Impact:** can be **~100×** slower. Performance improves as locations spread out; improves sharply at a **stride of 16 ints = 64 bytes** (cache line size). (Figure 7.21.)
- **Fix:** **align** variables/objects to cache-line boundaries:
  - Compiler alignment pragmas; Windows `__declspec(align(n))`.
  - **Cache-aligned malloc** — over-allocate, round up to the next cache line, store the real base just before the block (`CacheAlignedMalloc` / `CacheAlignedFree`, Figure 7.22).
- **Fundamental tension:** single-core wants **tight packing**; multi-core wants **separation** to avoid false sharing. Resolution: pack tightly, give each thread a **private copy**, merge later (extends to task stealing).

> 🖼️ **Image to add:** Figure 7.20 (ping-pong) and Figure 7.21 (performance vs stride showing the 64-byte jump).

### 13.2 Memory Consistency
- **Sequential consistency:** memory has one well-defined state; all threads see operations in program order.
- **Relaxed consistency:** a thread's writes may be seen by other threads in a **different order** (buffers, caches, store buffers, read-passes-read). A processor always sees **its own** accesses in order, but not others'.
- **Two sources of reordering:**
  1. **Hardware** — caches/buffers reorder.
  2. **Compiler** — optimizations (loop-invariant hoisting, speculation). Old languages (Fortran, C, C++) let compilers *assume single-threaded*; Java/C# only respect `volatile`.
- Compiler reordering affects even **time-sliced single-thread** execution.

**Current IA-32 Architecture (processor order):**
- **Relaxation for performance:** a read may pass a **write to a different location**.
- **Strictness for correctness:** an instruction with the **LOCK prefix** is a full **memory fence**; `xchg` has an implicit LOCK.
- Loads may pass loads but this is hidden (squashed/rerun if visible).
- IA-32 rules **break Dekker's Algorithm** (textbook mutual-exclusion without atomics) because both threads can read 0 (reads pass writes). Fix: insert explicit fences. (Figure 7.23.)
- **IA-32 fence instructions (Table 7.1):**
  | Mnemonic | Name | Effect |
  |---|---|---|
  | `mfence` | memory fence | neither reads nor writes cross |
  | `lfence` | load fence | reads may not cross |
  | `sfence` | store fence | writes may not cross |
- **Nontemporal stores** (MOVS/STOS) loosen ordering — issue `sfence` before signaling a consumer. "Write combining" memory ranges behave as nontemporal.

**Itanium Architecture:**
- No legacy software → cutting-edge relaxed model; simpler because rules are **uniform**.
- **Volatile** interpreted so most idioms work: volatile write = **store with release**, volatile read = **load with acquire**. Operations can't move **down over release** or **up over acquire**. (Figure 7.24.)
- **Two key idioms (Figure 7.25):**
  1. **Message passing:** sender writes data → **release** → sets flag; receiver waits on flag → **acquire** → reads data.
  2. **Memory cage:** starts with an **acquire fence**, ends with a **release fence**; keeps ops inside from escaping. Cages can **overlap** (an acquire can float backwards over a previous release) → fix Dekker with a full **`__memory_barrier()`**, not just acquires/releases.
- **Double-check idiom:** lazy initialization; declare the flag **volatile** so acquire/release fences are inserted. (Figure 7.26.)

**High-Level Languages (portability):**
- Easiest: use the language's **existing synchronization primitives** (they have correct fences built in). Issues appear only when you "roll your own."
- **C/C++:** no portable solution (at that time); use inline assembly fences on IA-32, or message-passing/cage + volatile on Itanium.
- **.NET:** use `volatile` → portable across architectures.
- **Java:** JSR-133 memory model ≈ Itanium/.NET; use `volatile`.

> 🖼️ **Image to add:** Figure 7.23 (Dekker on relaxed HW), Figure 7.24 (volatile message passing), Figure 7.25 (message-passing & cage idioms), Figure 7.26 (double-check idiom).

---

## 14. Avoiding Pipeline Stalls on IA-32

- Order of optimization: (1) get the **decomposition** right, (2) tune **cache** (avoid false sharing), (3) only then worry about the **pipeline**.
- **Serializing instructions** force all prior instructions to finish before later ones start:
  - LOCK-prefixed instructions, **memory fences**, `CPUID`, and memory `XCHG` (even without LOCK).
  - Essential when needed, but **expensive** — minimize.
- **Spin waits on HT:** a spinning thread can **starve** the very thread it waits on.
  - Insert **`PAUSE`** instruction (Pentium 4+) or **`HINT 0`** (Itanium) — tells hardware the thread is waiting.
  - On IA-32, spinning on a read can consume **bus bandwidth** → combine with **exponential back-off**. (`PAUSE` goes in the delay loop.) (Figure 7.27.)

> 🖼️ **Image to add:** Figure 7.27 (busy-wait loop with PAUSE).

---

## 15. Data Organization for High Performance

Classify every location into **four kinds of locality**:

| Locality | Description | Cost / behavior |
|---|---|---|
| **Thread private** | Private to a thread, never shared | Fast, stays in cache, no bus traffic, no sync |
| **Thread shared read-only** | Shared but never written (e.g., lookup tables) | Each core caches its own copy; no traffic |
| **Exclusive access** | Read/written under a lock | Migrates into cache on acquire, out on release |
| **Wild West** | Read/written by unsynchronized threads (incl. lock objects' guts) | Dangerous; cache-line ping-pong |

- **Locality can change** at runtime (private table → published read-only).
- **Good decomposition** favors **thread-private** and **read-only shared** data (low bus impact, no sync).
- **Don't mix localities on one cache line** → false sharing. Put **Wild West** data on separate cache lines (unless always accessed together by one thread).

---

## Key Points (Chapter Summary)

1. Match runnable software threads to hardware threads; **never hard-code** the count.
2. Find the zone between **too little** sync (wrong answers) and **too much** sync (slow answers).
3. Use tools (Intel Thread Checker) to detect races.
4. Keep locks private; don't hold a lock while calling other packages' code.
5. Prevent deadlock by **consistent lock ordering**.
6. Consider memory bandwidth/contention; pack tightly + private copies; separate localities onto separate cache lines.
7. Spread lock contention with **multiple distributed locks**.
8. Lockless algorithms: useful but **tricky** in non-GC languages; tread carefully.
9. **Cache lines are the quanta of information interchange** between hardware threads.
10. Rolling your own sync → understand the **memory consistency model**.
11. Serializing instructions (atomics, fences) are useful but **relatively expensive**.

---

## 🧠 How to Remember (Mnemonics & Tips)

- **Deadlock conditions = "M-H-N-C"**: **M**utual exclusion, **H**old-and-wait, **N**o preemption, **C**ircular wait. Break **any one**.
- **Deadlock fixes:** *"Order or don't hold."* (Consistent lock ordering / try-lock back-off.)
- **Livelock cure = exponential back-off** (but it's unfair).
- **Priority inversion fix:** *Inheritance (lazy) vs Ceiling (eager)* — "**I**nherit on demand, **C**eiling up front." Mars Pathfinder story!
- **Contended lock fix triangle:** *Eliminate* (replicate) · *Partition* (sub-tables/fine-grained) · *Read-writer* (read-heavy).
- **Non-blocking guarantees:** *"Obstruction-free < Lock-free < Wait-free"* (weakest → strongest). O-L-W.
- **ABA fix:** *"Never reuse A"* (GC), or *"A → A′"* with a serial number + double-wide CAS; or hazard pointers.
- **False sharing rule:** *"False sharing = different variables, same cache line."* Fix with **64-byte alignment** (16 ints).
- **Consistency model:** *"IA-32 = processor order (read may pass write), LOCK = fence; Itanium = volatile acquire/release; use provided sync primitives for portability."*
- **Spin wait = add PAUSE**, plus exponential back-off.
- **Four localities:** *"Private, Read-only, Exclusive, Wild West"* — favor the first two; never mix on a cache line.
- **Sieve lesson:** windowing (√n) beats one big array — *"fit it in cache, 5× faster."*

## ⭐ Likely Exam Questions
1. Explain the problems caused by too many threads and how to manage them (thread pools, work stealing).
2. What is a race condition? How can races hide behind language syntax?
3. State the four conditions for deadlock and the techniques to prevent it.
4. Explain priority inversion; compare priority inheritance and priority ceiling.
5. How do you handle heavily contended locks? (Replication, partitioning, fine-grained, reader-writer.)
6. Define non-blocking algorithms and their guarantees (obstruction/lock/wait freedom).
7. Explain the ABA problem and its solutions.
8. What is false sharing? Explain its performance impact and how to avoid it.
9. Explain memory consistency, sequential vs relaxed consistency, and the IA-32 vs Itanium models.
10. Explain the four kinds of data locality for high performance.
11. Explain the cache-friendly Sieve of Eratosthenes and why windowing helps.
12. What are serializing instructions and why are they expensive? What does PAUSE do?
