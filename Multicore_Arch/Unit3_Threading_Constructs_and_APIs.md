# Unit III — Threading & Parallel Programming Constructs + Threading APIs

> Source: Akhter & Roberts, *Multi-Core Programming* (Intel Press, 2006) — Ch. 4 & 5
> Place the matching textbook figures from the PDF where marked "🖼️".

---

# PART A — Threading & Parallel Programming Constructs (Ch. 4)

## 1. Synchronization

- **Synchronization** = coordinating threads so they access shared resources safely and in the right order.
- Needed because threads of a process share memory: unsynchronized access causes **race conditions**.
- Two purposes:
  1. **Mutual exclusion** — only one thread at a time in a critical section.
  2. **Ordering / coordination** — force one thread to wait for another (e.g., producer waits for consumer).
- **Cost:** synchronization serializes execution; too much destroys scalability.

### Race condition
- Result depends on the non-deterministic relative **timing** of threads.
- Classic example: two threads both do `x = x + 1` → final value can be 1 or 2 instead of 2.

> 🖼️ **Image to add:** Two threads racing on `x = x + 1`, showing interleaved read-modify-write producing wrong result.

---

## 2. Critical Sections

- A **critical section** is a region of code that accesses shared data and **must not be executed by more than one thread at a time**.
- Entering/leaving is guarded by a **lock/mutex**: `acquire()` … critical work … `release()`.
- Rules:
  - Keep critical sections **as short as possible** (less serialization).
  - Do **not** hold a lock while calling unknown/external code (risk of deadlock).
  - Prefer **private data** over shared data to avoid critical sections entirely.

```
acquire(lock);
// only one thread here
shared_counter++;
release(lock);
```

> 🖼️ **Image to add:** Multiple threads funneling through a single-lane "critical section" bridge (one at a time).

---

## 3. Deadlock

- **Deadlock:** two or more threads each hold a resource and wait forever for a resource the other holds.
- **Four Coffman conditions** (all must hold):
  1. **Mutual exclusion** — resources are exclusive.
  2. **Hold and wait** — a thread holds one resource while requesting another.
  3. **No preemption** — resources cannot be forcibly taken away.
  4. **Circular wait** — a cycle of threads each waiting on the next.

### Prevention (break any one condition)
| Break | Technique |
|---|---|
| Mutual exclusion | **Replicate the resource** so each thread has a private copy |
| Hold-and-wait | Request all resources at once (or none) |
| No preemption | Use **try-lock** and release held locks on failure (back-off) |
| Circular wait | **Acquire locks in a consistent global order** (e.g., by address) |

- **Most common cure:** consistent lock ordering.
- **Try-and-back-off** avoids no-preemption but is unfair and can cause **livelock** (see below).
- **Livelock:** threads keep conflicting and backing off, no one makes progress. Mitigate with **exponential back-off**.

> 🖼️ **Image to add:** Two-thread circular-wait deadlock diagram (T1 holds A wants B; T2 holds B wants A).

---

## 4. Synchronization Primitives

### 4.1 Semaphores
- A semaphore is a **counter** with two atomic operations:
  - **P / wait / acquire (down):** decrement; if count < 0, block.
  - **V / signal / release (up):** increment; wake a waiting thread.
- **Binary semaphore** (count 0/1) works as a **mutex**.
- **Counting semaphore** (count = N) allows up to N threads into a resource (pool).
- Semaphores can signal between threads (producer/consumer), unlike a plain mutex.

> 🖼️ **Image to add:** Semaphore as a gatekeeper with counter; binary vs counting.

### 4.2 Locks (Mutexes)
- **Mutex (mutual exclusion):** ownership-based lock; **only the owner can unlock**.
- **Spinlock:** busy-waits instead of blocking. Good for very short critical sections on multi-core (avoids context-switch cost); wasteful on single core.
- **Reader-writer lock:** many readers OR one writer at a time (great for read-heavy data).
- **Recursive (re-entrant) lock:** same thread can acquire it multiple times.
- **Scoped/RAII lock** (C++): lock acquired in constructor, released in destructor.

| Lock type | Behavior |
|---|---|
| Mutex | One owner at a time |
| Spinlock | Busy-wait acquire |
| Reader-writer | Concurrent readers, exclusive writer |
| Recursive | Owner may re-acquire |

### 4.3 Condition Variables
- Used to **wait for a condition** to become true (not just for mutual exclusion).
- Always used with a mutex:
  - `wait(cv, mutex)` — atomically releases mutex and blocks.
  - `signal(cv)` — wake one waiter.
  - `broadcast(cv)` — wake all waiters.
- Waiters re-check the predicate in a **while loop** (guard against spurious wakeups).

```c
// consumer
lock(m);
while(!ready) wait(cv, m);
consume();
unlock(m);

// producer
lock(m);
ready = true;
signal(cv);
unlock(m);
```

> 🖼️ **Image to add:** Condition-variable flow: waiter releases mutex and sleeps; signaler wakes it, waiter re-acquires mutex.

### 4.4 Messages
- Threads communicate by **sending/receiving messages** instead of sharing memory (avoids shared-state races).
- Basis of **message-passing** models and distributed systems (MPI).
- Can be **synchronous** (rendezvous) or **asynchronous** (buffered/mailbox).
- Under the hood, message queues in shared-memory systems still need locks/condition variables.

### 4.5 Flow-Control-Based Concepts
- Mechanism to control the **rate/order of execution** between threads and avoid overrunning buffers.
- Includes **producer-consumer** with bounded buffers, **back-pressure**, and **pipelines**.
- Prevents memory blow-up and keeps stages in balance.

### 4.6 Fence
- A **memory fence/barrier instruction** enforces **memory ordering**: no memory operation may be reordered across the fence.
- Needed because processors/compilers may **reorder** loads and stores (relaxed consistency).
- Types (IA-32): `mfence` (full), `lfence` (load), `sfence` (store).
- Ensures data written before the fence is visible before data written after it (message-passing idiom: write data → release fence → set flag → reader acquires).

### 4.7 Barrier
- A **barrier** makes all threads wait until every thread has reached it; then all proceed together.
- Used where a phase of computation must complete on all threads before the next phase begins (e.g., between time steps of a simulation).
- Implemented with atomics/condition variables or hardware support.
- Cost: synchronization overhead; load imbalance makes threads wait.

> 🖼️ **Image to add:** Barrier diagram — threads arrive at the barrier, wait for the last one, then all advance (like a starting gate).

---

## 5. Implementation-Dependent Threading Features

- Beyond standard primitives, APIs offer platform-specific features:
  - **Thread priorities** (may cause **priority inversion**).
  - **Thread affinity** (pin a thread to a core).
  - **Thread-local storage (TLS)** — per-thread private globals.
  - **Interlocked/atomic intrinsics** (compare-and-swap, increment, exchange).
  - **Thread pools/task queues**.
  - **Timed waits** (wait/timeout variants).
- Portability suffers when code depends on these; isolate them behind abstractions.

---

# PART B — Threading APIs (Ch. 5)

## 6. Threading APIs for Microsoft Windows (Win32 / MFC)

### 6.1 Creating threads (Win32)
- **`CreateThread`** — low-level; risky with the C runtime (CRT) because CRT state may not initialize per-thread.
- **`_beginthreadex`** — **preferred** for C/C++ because it initializes CRT per-thread state and returns a handle.
- **MFC `AfxBeginThread`** — wraps `_beginthreadex` for MFC apps.

```c
unsigned __stdcall ThreadFunc(void* p) { /* ... */ return 0; }
HANDLE h = (HANDLE)_beginthreadex(NULL, 0, ThreadFunc, arg, 0, &tid);
WaitForSingleObject(h, INFINITE);
CloseHandle(h);
```

### 6.2 Managing threads
- **`WaitForSingleObject` / `WaitForMultipleObjects`** — wait for thread(s) to finish.
- **`SetThreadPriority` / `GetThreadPriority`** — priority control.
- **`SuspendThread` / `ResumeThread`** — pause/resume (use carefully).
- **`GetCurrentThreadId`**, **`Sleep`**, **`SwitchToThread`**.

### 6.3 Thread synchronization objects
| Object | Purpose |
|---|---|
| **CRITICAL_SECTION** | Lightweight, fast intra-process mutex (not a kernel object) |
| **Mutex** | Kernel object; can be named, cross-process; supports **priority inheritance** (Windows default) |
| **Semaphore** | Counting semaphore |
| **Event** | Signal/wait coordination (auto-reset or manual-reset) |
| **InterlockedXXX** | Atomic operations (no lock): `InterlockedIncrement`, `InterlockedCompareExchange` |
| **WaitForSingleObject** | Wait on any of the above |

- Use **CRITICAL_SECTION** for fast intra-process locking; **Mutex/Event** when you need cross-process or richer semantics.

> 🖼️ **Image to add:** Windows synchronization object family tree (CriticalSection, Mutex, Semaphore, Event).

## 7. Threading APIs for the Microsoft .NET Framework

- Threads run as **managed threads** mapped to OS threads; the CLR manages them.
- **`System.Threading.Thread`** class:
  - `new Thread(new ThreadStart(Method))`
  - `Thread.Start()`, `Thread.Join()`, `Thread.Sleep()`
  - `IsBackground`, `Priority`, `Name`.
- **Thread pools:** `ThreadPool.QueueUserWorkItem(callback)` — reuse threads for short tasks; avoid per-task thread creation cost.
- **Task Parallel Library (TPL):** `Task.Factory.StartNew`, `Parallel.For`, `Parallel.ForEach`, PLINQ (higher-level than raw threads).
- **Synchronization:** `lock` statement (compiles to `Monitor.Enter`/`Exit`), `Monitor`, `Mutex`, `Semaphore`, `ReaderWriterLock(Slim)`, `Interlocked`, and `volatile`.
- **Async/await** for IO-bound concurrency without blocking threads.

```csharp
Thread t = new Thread(() => DoWork());
t.Start();
t.Join();
lock (obj) { shared++; }
```

> 🖼️ **Image to add:** .NET threading object model (Thread, ThreadPool, Task, Monitor, lock).

## 8. POSIX Threads (Pthreads)

A portable standard threading API for Unix/Linux/macOS (and Windows via wrappers).

### 8.1 Creating threads
```c
pthread_t tid;
pthread_create(&tid, NULL, start_routine, arg);
pthread_join(tid, NULL);   // wait for completion
// or pthread_detach(tid) to auto-reclaim on exit
```

### 8.2 Managing threads
- **`pthread_self`**, **`pthread_equal`**, **`pthread_exit`**, **`pthread_cancel`**.
- **`pthread_join`** (blocking) vs **`pthread_detach`** (fire-and-forget).
- **Attributes** (`pthread_attr_t`): stack size, scheduling policy/priority, detached state.

### 8.3 Thread synchronization
| Primitive | Purpose |
|---|---|
| **`pthread_mutex_t`** | Mutual exclusion (`pthread_mutex_lock/unlock`) |
| **`pthread_cond_t`** | Condition variable (`pthread_cond_wait/signal/broadcast`) |
| **`pthread_rwlock_t`** | Reader-writer lock |
| **`pthread_barrier_t`** | Barrier |
| **`pthread_spinlock_t`** | Spinlock |
| **`pthread_sem_*`** (semaphore.h) | Semaphores (POSIX, not strictly pthread) |

- Mutex attributes can set **type**: normal, error-checking, recursive; and protocol (priority inheritance/ceiling — **optional**, often unsupported on Linux).

### 8.4 Signalling
- **Condition variables** signal between threads: `pthread_cond_signal` (one), `pthread_cond_broadcast` (all), always with a mutex and a predicate loop.
- **Signals (UNIX signals)** are a separate, process-level mechanism — not the same as pthread condition signalling. Be careful mixing signals with threads.

### 8.5 Compilation and Linking
- Include `<pthread.h>`; compile and link with **`-pthread`** (GCC/Clang) — e.g. `gcc prog.c -o prog -pthread`.
- `-pthread` both defines `_REENTRANT` and links the pthread library; on some systems you also need `-lpthread`.

```bash
gcc myprog.c -o myprog -pthread
```

> 🖼️ **Image to add:** Pthread lifecycle and synchronization API map (create/join + mutex/cond/barrier).

---

## API Comparison Cheat-Sheet

| Concept | Win32 | .NET | Pthreads |
|---|---|---|---|
| Create thread | `_beginthreadex` | `new Thread(...).Start()` | `pthread_create` |
| Wait/join | `WaitForSingleObject` | `Thread.Join()` | `pthread_join` |
| Mutex | CRITICAL_SECTION / Mutex | `lock` / Monitor / Mutex | `pthread_mutex_t` |
| Cond variable | Event / ConditionVariable | Monitor.Wait/Pulse | `pthread_cond_t` |
| Semaphore | Semaphore | Semaphore(Slim) | `sem_t` |
| Atomic | InterlockedXXX | Interlocked | `__sync`/atomics |
| Thread pool | QueueUserWorkItem | ThreadPool / TPL | (none standard) |

---

## 🧠 How to Remember (Mnemonics & Tips)

- **Deadlock = 4 conditions = "MEHN":** **M**utual exclusion, **H**old-and-wait, **N**o preemption, **E**... → better: **"M-H-N-C"** = **M**utual exclusion, **H**old & wait, **N**o preemption, **C**ircular wait. Break **any one** to prevent.
- **Fix deadlock:** *"Order, or Don't Hold."* → acquire locks in a **global order**, or **try-lock/back-off** (release on failure).
- **Semaphore vs Mutex:** *"Semaphore = counter/gate (can signal); Mutex = key with an owner."*
- **Condition variable rule:** *"Wait in a `while`, signal after changing state, always under the same mutex."*
- **Barrier vs Fence:** *Barrier = **threads** synchronize (wait for each other); Fence = **memory operations** synchronize (stop reordering).* Same word, different layer!
- **Win32:** use **`_beginthreadex`** (underscore = CRT-safe). Choose `CRITICAL_SECTION` for speed, `Mutex` for cross-process.
- **Pthreads:** *"**create → join/detach**; **mutex + cond** for sync; compile with **-pthread**."*
- **.NET:** `lock` = `Monitor` = `Enter/Exit`; prefer `Task`/`ThreadPool` over raw threads.

## ⭐ Likely Exam Questions
1. Define a critical section. How is it protected?
2. State the four conditions for deadlock and explain deadlock prevention.
3. Explain semaphores (binary vs counting) with the P/V operations.
4. Differentiate mutex, spinlock, and reader-writer lock.
5. Explain condition variables with a producer-consumer example.
6. Differentiate a barrier and a memory fence.
7. Compare the Win32, .NET, and POSIX thread creation and synchronization APIs.
8. Write a Pthreads program to create and join threads; how do you compile it?
9. Explain thread pools and when to use them.
10. Explain priority inversion and how priority inheritance/ceiling solve it.
