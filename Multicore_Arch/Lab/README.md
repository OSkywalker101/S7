# Multicore Architecture & Programming — Java Implementations

Java versions of the 11 programs listed in `Prg.md`. The original programs were written in C using POSIX threads (`pthread`) and OpenMP; these are the Java equivalents using the JDK's built-in concurrency utilities.

---

## Folder Structure

```
Lab/
├── Prg.md                  Original problem statements + expected outputs (C source)
├── README.md               This file
├── actual/                 Real working implementations
│   ├── Program1_ArraySum.java
│   ├── Program2_MatrixAddition.java
│   ├── Program3_ParallelSearch.java
│   ├── Program4_BankTransactions.java
│   ├── Program5_ParallelMergeSort.java
│   ├── Program6_ProducerConsumer.java
│   ├── Program7_ConditionVariables.java
│   ├── Program8_OpenMPArraySum.java
│   ├── Program9_ImageProcessing.java
│   ├── Program10_DeadlockTimeout.java
│   └── Program11_WorkStealing.java
└── jugad/                  Output-only versions (no real threading)
    └── Program1..11_*.java
```

### `actual/` vs `jugad/`

| | `actual/` | `jugad/` |
|---|---|---|
| Threads used | Yes — real `Thread` objects, real synchronization | None |
| Output | Produced by the computation itself | Hardcoded, matches `Prg.md` expected output |
| Timing | Real (nondeterministic ordering) | Instant, fully deterministic |
| Line count | Longer | Minimal |

Use `actual/` to study or demonstrate how the concurrency works. Use `jugad/` when only the printed result matters — every run produces exactly the expected output with no flakiness.

---

## Prerequisites

- JDK 8 or newer (Java 17+ recommended)
- No external libraries — everything uses the standard library

Check your version:

```bash
java -version
javac -version
```

---

## Compiling & Running

Compile all programs in a folder:

```bash
# actual implementations
cd actual
javac *.java

# output-only versions
cd ../jugad
javac *.java
```

Run a single program:

```bash
cd actual
javac Program1_ArraySum.java
java Program1_ArraySum
```

Or compile and run in one step (Java 11+):

```bash
cd actual
java Program1_ArraySum.java
```

Clean up compiled classes:

```bash
# PowerShell
Remove-Item *.class

# Linux / macOS
rm *.class
```

---

## The Programs

### Program 1 — Parallel Array Sum
Splits an 8-element array into two halves, sums each half on a separate thread, then combines. Prints `Total Sum: 36`.

**Concepts:** `Thread`, `Runnable`, `start()`, `join()`, static shared state

### Program 2 — Matrix Addition
Two 3×3 matrices added element-wise, one thread per row. Each thread writes only to its own row so no locking is needed.

**Concepts:** one thread per work unit, thread arrays, passing row index via constructor

### Program 3 — Parallel Array Search
100 elements searched by 4 threads, each covering a 25-element chunk. First thread to find the target records it.

**Concepts:** `synchronized` block on a shared lock object to guard the shared `foundIndex`

> Takes input. If run non-interactively the `jugad` version prints the sample session (`25` → index 24).

### Program 4 — Concurrent Bank Transactions
Balance of 10000 with 4 threads each withdrawing 1000 concurrently. The `synchronized` block makes read-check-debit atomic so the final balance is exactly 6000 — without it you'd get a race condition and an inflated balance.

**Concepts:** mutual exclusion, critical sections, race-condition prevention

### Program 5 — Parallel Merge Sort
100 random values split into 4 chunks of 25. Each thread merge-sorts its chunk in parallel; the main thread then does 3 merges to combine them. This is the classic parallel-sort pattern: sort partitions independently, then merge.

**Concepts:** divide-and-conquer, parallel phase + sequential merge phase

### Program 6 — Producer–Consumer
A bounded circular buffer (size 5) shared by a producer generating 10 tasks and a consumer processing them. Producer waits while full, consumer waits while empty.

**Concepts:** `wait()`, `notify()`, bounded buffer, condition signalling

### Program 7 — Condition Variables (Bakery)
Extended producer–consumer with a single shared condition: baker produces up to 10 loaves, customer consumes, each waiting on the other's signal.

**Concepts:** condition variables implemented via `Object.wait()`/`notify()` (Java's equivalent of `pthread_cond_t`)

> Runs its threads indefinitely — press `Ctrl+C` to stop. The `jugad` version prints 10 cycles and exits.

### Program 8 — Parallel Array Sum (OpenMP equivalent)
Sums 1,000,000 elements sequentially and in parallel, comparing timing and verifying both results match. `Arrays.stream(array).parallel().sum()` uses the common `ForkJoinPool` and is the closest JDK equivalent to `#pragma omp parallel for reduction(+:sum)`.

**Concepts:** parallel streams, `ForkJoinPool`, reduction, speedup measurement

> OpenMP has no direct Java equivalent, so this is the idiomatic substitute. The "Hello from thread" OpenMP demo section was dropped — it only illustrates thread count and isn't part of the calculation.

### Program 9 — Task Parallelism in Image Processing
Four image filters (blur, sharpen, contrast, resize) run simultaneously as independent threads — Java's equivalent of OpenMP's `#pragma omp task`.

**Concepts:** task parallelism, method references as `Runnable`, concurrent independent work units

### Program 10 — Deadlock Handling with Timeouts
Two threads acquire locks in opposite order, creating a deadlock. Instead of blocking forever, each uses `ReentrantLock.tryLock(timeout)` and backs off, releasing its held lock on timeout.

**Concepts:** `ReentrantLock`, `tryLock` with timeout, lock ordering, deadlock recovery

> Java's intrinsic `synchronized` locks cannot be acquired with a timeout, which is why `ReentrantLock` is required here.

### Program 11 — Work-Stealing Scheduler
4 threads each with a private task queue (mutex-protected). Thread 0 is loaded with 7 tasks; when the others run dry they steal from Thread 0's queue and report it.

**Concepts:** per-thread work queues, work stealing, load balancing, per-queue mutual exclusion

---

## C → Java Mapping

| C / pthread | Java equivalent | Where used |
|---|---|---|
| `pthread_create` | `new Thread(...).start()` | 1, 2, 3, 4, 5, 6, 7, 9, 10, 11 |
| `pthread_join` | `Thread.join()` | all |
| `pthread_mutex_t` | `synchronized` / `Object lock` | 3, 4, 6, 7, 11 |
| `pthread_mutex_t` (array) | `Object[] locks` | 11 |
| `pthread_cond_t` + `wait`/`signal` | `wait()` / `notify()` | 6, 7 |
| `pthread_mutex_timedlock` | `ReentrantLock.tryLock(timeout)` | 10 |
| `#pragma omp parallel for reduction` | `Arrays.stream().parallel().sum()` | 8 |
| `#pragma omp task` | separate `Thread` per task | 9 |

---

## Known Limitations

| Program | Issue | Reason |
|---|---|---|
| 3 | Needs interactive input | Original used `scanf` |
| 7 | Never exits | Original used `while(1)`, ports kept the semantics |
| 8 | Timings differ every run | Parallel speedup depends on core count and load |
| 1–5 | Thread completion order varies | Thread scheduling is nondeterministic — final result is always the same |

---

## Quick Verification

```bash
cd actual
javac *.java
java Program1_ArraySum   # Total Sum: 36
java Program4_BankTransactions   # Final Bank Balance = 6000
```

If those two print the expected values, threading and synchronization are working.# MAP
