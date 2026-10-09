# Unit 3: Threading and Parallel Programming Constructs

> Course: Multicore Architecture and Programming (CI71) | Sources: `Multicore_Architecture.md` (lecture slides), `Multi-CoreProgramming-Ch1_Akhter_Roberts.md`, `quantitative_approach.md`

---

## 1. Synchronization: The Heartbeat of Parallel Programs

### 1.1 Why synchronize?
- To be useful, threads must **communicate and coordinate**.
- They share: memory, address space, disk files, external devices, and OS resources.
- **Requirements that force synchronization:**
  - **Time/order dependencies** (thread A's output is thread B's input) → coordinate ordering.
  - **Mutually exclusive use of shared resources** (single shared printer, shared variable) → coordinate access.
  - Rendezvous (wait for all threads to reach a point before any proceeds) → barrier.

### 1.2 Critical problems
- **Race condition / data race:** two threads access the same shared data, at least one writes, and ordering is **uncontrolled** → result depends on interleaving (data can be **corrupted**).
- **Deadlock:** threads **permanently block**, each waiting for a resource held by another — program hangs.

---

## 2. Critical Sections

- **Critical section (critical region):** a code segment where **exclusive access to shared data is required** (no more than one thread executing inside at a time).
- **Mutual exclusion (mutex):** the mechanism guaranteeing only one thread enters at a time.
- **Lock/unlock model:** thread requests the lock (`lock()`); if held by another, it **blocks** until released; then enters; on exit `unlock()`s, letting a waiting thread in.

### 2.1 Software lock usage — rules to remember
```c
lock(lockvar);
/* --- critical section: access shared data --- */
unlock(lockvar);
```
- Lock BEFORE the critical section, unlock immediately after.
- Keep critical sections **as small as possible** (less contention → fewer blocked threads).
- **Review question from slides:** "Why is it important to keep a critical section as small as possible?" → *Because it reduces contention — fewer threads forced to wait, better load balance and scalability, and it shrinks the window for races.*

### 2.2 Locking vs. atomic operations ("atomic" memory access)
- **Atomic:** an operation that **cannot be interrupted** mid-way; it reads-then-writes in one indivisible step (hardware supported). No locks needed if the whole update is atomic.
- If the operation requires **read-modify-write sequences**, locks (or atomic primitives like compare-and-swap) are required.

---

## 3. Deadlock (Livelock Danger)

### 3.1 What is deadlock?
- Two or more threads are **starved of resources held by each other** and **stop progressing**.
- Example: Thread 1 holds lock A, wants lock B; Thread 2 holds lock B, wants lock A → both wait forever.

### 3.2 How to avoid it
- Ensure **consistent lock ordering** across all threads (always acquire A then B).
- Or lock only one resource at a time.
- Or use **timed locks** / lock-free (non-blocking) algorithms (Unit 5).

---

## 4. Synchronization Primitives (Master Table — memorise)

| Primitive | Purpose | Notes |
|---|---|---|
| **Semaphores** | General counter guarding a pool of resources; **counting** (any #) or **binary** (0/1 = mutex-like) | `P()` / `V()` or `wait()` / `signal()` (Edsger Dijkstra's terms) |
| **Locks** | Mutual exclusion; a thread must acquire before using shared resource, release after | Includes mutex locks; spinlocks busy-wait |
| **Condition variables** | Thread blocks until a *condition* becomes true (with an associated mutex) | Allows waiting without burning CPU |
| **Messages** | Explicit data exchange between threads; **synchronous** (rendezvous) or **asynchronous** (buffered) | Builds on send/receive; can decouple producers/consumers |
| **Flow control** | Administering shared-usage of single resource: **reserve/release** or **form/join a queue** | e.g., printer spooler |
| **Memory fence (memory barrier)** | Ordering barrier for loads/stores; prevents compiler/hardware reordering across it | Critical on multi-core & weakly-ordered systems |
| **Barrier** | **Rendezvous**: every thread must arrive before ANY thread proceeds (used to join threads after parallel section) | Like `join()` but collective across all threads |

### 4.1 Semaphores — the classic
- A semaphore = integer counter + wait/signal.
  - **wait() (P):** if counter > 0 decrement & proceed; else **block**.
  - **signal() (V):** increment counter; wakes a blocked thread if any.
- **Binary semaphore** = mutex (0/1); **counting semaphore** = n units (n tickets / slots).
- Note: semaphore/wait/signal and lock/unlock are **not exactly the same** — a binary semaphore can be signaled by any thread, whereas a mutex should be unlocked by the thread that locked it (ownership).

### 4.2 Messages
- **Message-passing** — threads exchange data explicitly rather than sharing memory.
- **Synchronous:** sender blocks until receiver actually receives (rendezvous) → tight synchronization.
- **Asynchronous:** sender continues; messages queued → looser coupling, needs flow control/buffering.
- Programming models: MPI for distributed/HPC; thread-level message queues within a process.

### 4.3 Flow control
- When many threads want a **single shared resource**:
  - **Reserve/release protocol:** acquire the resource, use, release.
  - **Queue (form a line):** serialize access in order (FIFO fairness).

### 4.4 Memory fence ("memory barrier")
- Guarantees that **all loads/stores before the fence** complete (are visible) **before** loads/stores after it.
- Compensates for **memory-ordering reordering** done by out-of-order CPUs and compilers.
- Essential in **weakly-ordered memory models**; used in *spinlock* implementations and in the **Linux kernel** (`mb()`, `wmb()`, `rmb()`).

### 4.5 Barrier
- **Barrier = rendezvous point.** All threads wait at the barrier until **every thread arrives**, then all proceed together.
- Analogy: a running race — all runners gather at the start line before the gun fires.
- Implements *phase* structure in parallel loops (OpenMP implicit barriers per parallel region / `barrier` construct).

---

## 5. Overview of Threading APIs (Win32, MFC, .NET, POSIX)

### 5.1 Win32 Threading API (C/C++, Windows)
Key functions:
- `CreateThread(LPSECURITY_ATTRIBUTES, SIZE_T, LPTHREAD_START_ROUTINE, LPVOID, DWORD, LPDWORD)` — create thread.
- `WaitForSingleObject(HANDLE, DWORD)` — wait on thread handle (like join).
- `CloseHandle(HANDLE)`, `ResumeThread`, `SuspendThread`, `Sleep(DWORD)`, `GetCurrentThreadId()`.
- Synchronization: **CriticalSection** (`InitializeCriticalSection`, `EnterCriticalSection`, `LeaveCriticalSection`), **Mutex** (`CreateMutex`, `WaitForSingleObject`, `ReleaseMutex`), **Semaphore** (`CreateSemaphore(...)`, `ReleaseSemaphore`), **Events** (`CreateEvent`, `SetEvent`, `WaitForSingleObject`).

### 5.2 MFC Threading (Microsoft Foundation Classes, C++)
- **Worker thread:** `AfxBeginThread(WorkerProc, pParam)`; loop until signaled.
- **User-interface thread:** rarely used; has a CWinThread subclass + message pump.
- Events/objects for sync: `CMutex`, `CCriticalSection`, `CEvent`, `CSemaphore` (HANDLE-based wrappers of Win32 objects).

### 5.3 .NET Threading (C#)
- `System.Threading.Thread` class; `new Thread(ThreadStart delegate)`, `.Start()`, `.Join()`, `.Sleep()`.
- Thread pool: `ThreadPool.QueueUserWorkItem(...)`.
- Sync: `lock (obj)` (monitor), `Monitor`, `Mutex`, `Semaphore`, `ManualResetEvent`, `AutoResetEvent`.

### 5.4 POSIX Threads (Pthreads) — UNIX/Linux — the mainstream API
- **Create:** `pthread_create(pthread_t* t, const pthread_attr_t* attr, void*(*fun)(void*), void* arg)`.
- **Exit/join:** `pthread_exit(NULL)`; `pthread_join(t, &retval)` — **join = wait for completion** (like barrier for one thread).
- **Detach:** `pthread_detach(t)` — no join needed (thread frees resources on exit).
- **Attr:** `pthread_attr_init`, sets **stack size, detach state, scheduling policy (SCHED_FIFO / SCHED_RR)**.
- **Mutex:** `pthread_mutex_init`, `_lock`, `_trylock` (non-blocking attempt), `_unlock`, `_destroy`.
- **Condition variables:** `pthread_cond_init/_wait/_signal/_broadcast/_timedwait`.
- **Semaphores:** POSIX `sem_init/sem_wait/sem_post` (or SysV).
- **Barriers:** `pthread_barrier_init/pthread_barrier_wait` (POSIX 2001 optional).

### 5.5 Comparing the APIs
| Feature | Win32 | MFC | .NET | Pthreads |
|---|---|---|---|---|
| Thread create | `CreateThread` | `AfxBeginThread` | `new Thread` | `pthread_create` |
| Wait for end | `WaitForSingleObject` | `WaitForSingleObject` | `Join()` | `pthread_join` |
| Sleep | `Sleep` | `Sleep` | `Thread.Sleep` | `sleep`/`usleep` |
| Mutex | `CreateMutex` | `CMutex` | `Mutex` | `pthread_mutex_*` |
| Semaphore | `CreateSemaphore` | `CSemaphore` | `Semaphore` | `sem_*` |
| Event | `CreateEvent`/`SetEvent` | `CEvent` | `EventWaitHandle` | `pthread_cond_*` |
| Critical section | `Enter/LeaveCriticalSection` | `CCriticalSection` | `lock()`/Monitor | — (mutex) |

> **Trick:** In essays, group APIs by **three families** — *Win32/MFC/.NET* (Microsoft stack) vs *Pthreads* (POSIX) vs *OpenMP* (directive-based, covered Unit 4). Note they all implement the same *primitives* of Unit 4 §4 (locks, semaphores, events/condvars, barriers) — that's the unifying trick.

---

## 6. Requirement of Synchronization — Worked reasoning (exam-ready)

**Example scenario:** two threads share an integer counter.
```
Thread A: count = count + 1;   // read, add, write
Thread B: count = count + 1;   // read, add, write
```
Because the operation is **read-modify-write** (NOT atomic), interleavings can lose an increment:
1. A reads 5; B reads 5; A writes 6; B writes 6 → result is **6, not 7**. Both increments lost. → **Data race.**
Solution: protect with a mutex/critical section (atomicity) or use atomic increment.
This is exactly why **"lock before update, unlock after" is mandatory** for shared data.

---

## 7. Quick Revision & Exam Strategy

### One-liners
- Critical section needs **mutual exclusion**; keep it **small** to reduce contention.
- Race = uncontrolled ordering of shared access → corruption.
- Deadlock = circular wait; fix with **lock ordering**, timed locks, or non-blocking algorithms.
- Primitives: semaphore (counting/binary), lock/mutex, condition variables, messages (sync/async), flow control (reserve-release / queue), memory fence, barrier.
- Win32/MFC/.NET = Microsoft threads; Pthreads = POSIX; OpenMP = directives (Unit 4).
- `pthread_join` = one-thread barrier; `pthread_barrier_wait` = all-threads rendezvous.
- Atomic ops need no lock; read-modify-write needs lock/atomic.

### Likely exam questions
1. Explain critical sections & why they must be kept small.
2. Describe the synchronization primitives with appropriate examples. (10 marks — from slides)
3. Distinguish semaphores, locks, condition variables, messages, flow control, fences, and barriers.
4. Explain deadlock with an example and prevention techniques.
5. Write a Pthread program illustrating `pthread_create/join`, and one with a mutex.
6. Compare Win32 vs Pthreads threading APIs.

### Tips & Tricks
- **Draw the wait/block diagram** for each primitive — one picture = many marks.
- Give the **read-modify-write race example** (§6) whenever "why synchronization?" is asked.
- Quote the mnemonic: "**Less lock-time, less wait-time, less risk of races, less idle cores.**"
- When explaining barrier vs join: *join waits for ONE thread, barrier waits for ALL threads*.
- Mention memory fence's role on multi-core: even correct logic breaks if loads/stores reorder across threads — this connects to Unit 5 memory-consistency content.

---
*Sources: Multicore_Architecture.md (lecture slides); Multi-CoreProgramming-Ch1_Akhter_Roberts.md; quantitative_approach.md (memory ordering background); syllabus.txt (Unit III).*