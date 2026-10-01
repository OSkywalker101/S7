# Unit 1: Introduction to Multi-Core Architecture & Overview of Threading

> Course: Multicore Architecture and Programming (CI71) | Text: *Multicore Programming* — Akhter & Roberts (Intel Press, 2006); *Computer Architecture: A Quantitative Approach* — Hennessy & Patterson (4th Ed.) | Sources: `Multi-CoreProgramming-Ch1_Akhter_Roberts.md`, `Multicore_Architecture.md`

---

## 1. Motivation for Concurrency in Software

### 1.1 Why are we here?
Modern CPUs stopped scaling by clock frequency (the "frequency wall" / power wall). To get more performance, chipmakers put **multiple cores on one die** (Moore's Law: transistors double every ~18–24 months — but those transistors are now spent on *more cores/caches*, not higher clocks).

### 1.2 The end-user vs. system-designer view
- **User view:** "streame video, decompress, decode, play audio, scan virus — all at once" — looks like one task.
- **Designer view:** a streaming server must receive → encode → send to hundreds of thousands of clients; the PC must download, decompress, decode, render, and play — **many independent subsystems operating in parallel**.
- The naive **serial** client approach is inefficient: while waiting for network data, the CPU is idle. **Concurrency lets one task run while another waits** → better resource utilization.

### 1.3 Why concurrency matters (three reasons to memorize)
1. **Efficient resource use:** overlap I/O waits with compute (hide latency).
2. **Natural fit:** many problems are inherently parallel (e.g., FTP server handling many clients — one thread per connection is simpler to write than a state-machine juggling all connections).
3. **Responsiveness:** keep the UI responsive while background tasks run.

> **⚠ Concurrency ≠ Parallelism (MUST KNOW):**
> - **Concurrent:** multiple threads are in progress, **interleaved** on one processing element — only one makes progress at a time.
> - **Parallel:** multiple threads **execute simultaneously** on different processing elements.
> - Rule: **"In order to have parallelism, you must have concurrency exploiting multiple hardware resources."** You can be concurrent without being parallel, but not parallel without concurrent threads.

---

## 2. Parallel Computing Platforms — Flynn's Taxonomy

Computers are classified by **instruction streams** and **data streams** (Flynn, 1972):

| Category | Meaning | Suitability / Examples |
|---|---|---|
| **SISD** | Single Instruction, Single Data | Traditional sequential computer (IBM PC, Commodore 64) — no parallelism |
| **MISD** | Multiple Instruction, Single Data | Mostly **theoretical** (rarely built) |
| **SIMD** | Single Instruction, Multiple Data | Data-level parallelism — DSP, image/video processing; Intel MMX/SSE/SSE2/SSE3; PowerPC AltiVec; Cray vector processors |
| **MIMD** | Multiple Instruction, Multiple Data | **Most common parallel platform today** — modern multi-core CPUs (Intel Core Duo), multiprocessors → **task-level parallelism** |

- **SIMD** → software exploits **data-level parallelism** (single op, many data elements in registers).
- **MIMD** → software exploits **task-level parallelism** (many instruction streams on many data streams).

## 3. Parallel Computing in Microprocessors

### 3.1 Instruction-Level Parallelism (ILP)
- **ILP / dynamic (out-of-order) execution:** the CPU reorders instructions to keep execution units busy and eliminate pipeline stalls.
- Goal: execute **>1 instruction per clock** (superscalar).
- ILP is **hardware-level and transparent to software** — the programmer doesn't manage it.

### 3.2 Thread-Level Parallelism (TLP) — the roadmap
As software became more concurrent, hardware evolved:

1. **Time-sliced / preemptive multitasking (OS):** interleaves threads to hide I/O latency — **no true parallel execution**. One instruction stream per processor at a time.
2. **Multiprocessor systems:** true parallel execution (threads on separate CPUs) — but **expensive**.
3. **Simultaneous Multi-Threading (SMT) → Intel Hyper-Threading (HT):** duplicate *architecture state* only; share *execution resources*. Processor appears as multiple **logical processors**.
4. **Multi-core (Chip Multi-Processing, CMP):** multiple complete **execution cores** on one die — true hardware parallelism.

---

## 4. Understanding Threads (Definitions)

- **Thread = basic unit of CPU utilization.** Contains:
  - a **program counter** (current instruction),
  - **CPU architecture state** (registers, interrupt-controller registers),
  - **stack** (per-thread).
- **Process/Program relationship:**
  > Program → one or more Processes → each process → one or more Threads → threads mapped to processors by the OS **scheduler**.
- Every program has **at least one thread** (the main thread), which may spawn others.
- A thread is always in one of **four states:** **ready, running, waiting (blocked), terminated.**

### 4.1 Thread: a basic unit of CPU utilization
To **create a logical processor**, only the *architecture state* needs duplicating; execution units are shared → **SMT**. To go further (multi-core), give each core its *own* execution + architectural resources (may share large on-chip cache).

---

## 5. System View of Threading (3 layers)

1. **User-level threads** — created/manipulated by application software. (On Windows, called **fibers**.) Programmer manages scheduling manually → cooperative threading; the library scheduler decides priorities.
2. **Kernel-level threads** — how the OS implements most threads. OS scheduler maps them; same-process kernel threads can run on **different cores** (better performance).
3. **Hardware threads** — how threads appear to execution resources.

### 5.1 Expert tip — the lifecycle
- **Defining & Preparing:** threads specified by programming environment, encoded by compiler.
- **Operating:** threads created & managed by the OS.
- **Executing:** processor executes the thread instructions.

### 5.2 Flow of threads in an execution environment

### 5.3 Thread ↔ Processor mapping models (MUST KNOW)
| Model | Meaning | Scheduling | Used by |
|---|---|---|---|
| **M:1** (Many-to-One) | Many user-level threads → one kernel thread | Library scheduler; **cooperative multitasking** | Legacy/GUI libs |
| **1:1** (One-to-One) | Each user thread → one kernel thread | OS handles; **preemptive multitasking** | **Linux, Windows 2000/XP** |
| **M:N** | Many user threads → many kernel threads | Flexible multiplexing; best of both | Hybrid systems (older Solaris) |

---

## 6. Threading above the OS, inside the OS, inside the Hardware

### 6.1 Above the OS (application APIs)
- Most common APIs: **OpenMP** (directives, easy) and **explicit low-level libraries** (Pthreads, Windows threads).
- OpenMP requires an OpenMP-capable compiler (C/C++/Fortran) but the **compiler creates & manages threads automatically** (e.g., `#pragma omp parallel` — no `pthread_create` visible).
- Pthreads: you explicitly call `pthread_create()`, point it at the work function, and manage the thread.

**Hello World — OpenMP:**
```c
#include <omp.h>
#include <stdio.h>
int main() {
    #pragma omp parallel
    {
        printf("Hello World... from thread = %d\n", omp_get_thread_num());
    }
}
```

**Hello World — Pthreads:** create one thread per `pthread_create(&t, NULL, PrintHello, NULL);` etc.

### 6.2 Inside the OS
- OS = two partitions: **user-level** (applications) and **kernel-level** (system activities).
- **Kernel** = nucleus of the OS; maintains tables tracking processes & threads.
- OpenMP & Pthreads use **kernel-level threads**.
- **User-level threads (fibers)** require the programmer to build the whole management/scheduling infrastructure.

### 6.3 Inside the Hardware
- Instructions flow: application threads → OS → runtime environment → hardware.
- Parallelism historically = multiple CPU packages; **multi-core = single package, many cores**; **SMT = one core shared among threads** (interleaved at the microarchitectural level).

---

## 7. What Happens When a Thread Is Created

1. Initial thread created at **process initialization**.
2. New threads operate independently **but share the same address space and certain resources** (so they can communicate — and race!).
3. Each thread needs **its own stack** (usually managed by the OS).
4. Thread enters the scheduler's queue of **ready** threads.

---

## 8. Virtualization: VMs and Platforms

### 8.1 Runtime virtualization vs. system virtualization
- **Virtualization:** use computing resources to create the *appearance* of a different set of resources.
- **Runtime virtualization** (e.g., JVM/.NET CLR, OpenMP runtime): provides software-level abstraction; manages threads/GC above the OS.
- **System virtualization:** creates a **complete & independent instance of an OS** (a full virtual machine).

### 8.2 Key terms
- **VMM (Virtual Machine Monitor) = Hypervisor:** the virtualization layer between host system and VMs.
- In a VM, the **guest OS** handles thread creation & scheduling; the **virtual processor** executes the thread's instructions. Each guest OS *thinks* it owns the whole hardware.

---

## 9. Understanding Performance — Speedup, Amdahl's Law, Gustafson's Law

### 9.1 Speedup (definition)
```
            Time(best sequential algorithm)
Speedup(n) = ────────────────────────────────
            Time(parallel implementation, n threads)
```
- Compare the **best serial** algorithm vs. your parallel program with **n** threads.

### 9.2 Amdahl's Law (Gene Amdahl, 1967)
Amdahl: *"program speedup is a function of the fraction of a program that is accelerated and by how much that fraction is accelerated."*

**Basic form:**
```
                   1
Speedup = ─────────────────────
          (1−F) + (F / S_enhanced)
```
Example: speed up half the program by 15% → 1/(0.50+0.50/1.15) = 1/(0.5+0.435) ≈ **1.08** (8% speedup).

**Canonical form (Equation 1.1):**
```
           1
Speedup = ────────
         S + (1−S)/n
```
Where **S** = fraction of time executing the **serial portion** of the parallelized version, **n** = number of cores, and the best sequential algorithm is normalized to 1 time unit.

- n=1 → no speedup (obviously).
- Dual-core, S=0.5 → 1/(0.5+0.5/2) = 1/0.75 ≈ **1.33** (33% speedup).
- 8-core, S=0.5 → ≈ **1.78**.
- **Upper bound (n→∞):** `Speedup = 1/S` — if 10% serial, max speedup = **10** regardless of cores.

> **⚠ Critical corollary (examine it carefully):** *"Decreasing the serialized portion is of greater importance than adding more processor cores."* Doubling cores matters only when the program is **mostly parallelized**.

**Amdahl with threading overhead H(n):**
```
           1
Speedup = ─────────────────
         S + (1−S)/n + H(n)
```
H(n) = OS overhead + inter-thread activities (synchronization, communication). If H(n) is large enough, **speedup < 1** (threading *slows* the program) — common in poorly architected multithreaded apps. → **Minimize threading overhead!**

### 9.3 Amdahl applied to Hyper-Threading
```
                 1
Speedup = ─────────────────────
         S + 0.67·((1−S)/n) + H(n)
```
n = number of **logical** processors. HT threads typically run ~1/3 slower than if each owned the whole core (execution units are shared, so a ~0.67 factor). HT typically gives ~**30%** throughput gain — **NOT** a substitute for multi-core (which approaches 2× for dual-core).

### 9.4 Gustafson's Law (Barsis formulation, scaled speedup, 1988)
**Question Amdahl:** Amdahl assumed the serial algorithm is fixed in size and problem size stays constant as cores grow. In practice:
- More cores ⇒ larger problem handled in the *same time* (often the real-world goal).
- Parallel solutions may be more efficient than the "best serial" (e.g., better cache utilization on each core; different algorithms).

```
Scaled speedup = N + (1 − N)·s
```
where **N** = number of processors, **s** = serial fraction of the *parallel* workload at **fixed runtime**.

- At Sandia, near-**linear** speedups were observed on a 1,024-processor hypercube.
- Gustafson shows speedup **grows linearly** (scales) — realistic for practical multi-core problems; Amdahl captures the **fixed-size** pessimistic case. They are mathematically equivalent given different assumptions (Shi 1996), but Gustafson is more optimistic & useful for scaling workloads.

> **Trick for answers:** Quote both equations; state that *Amdahl assumes fixed problem size + fixed serial fraction; Gustafson assumes the problem scales (runs in same wall-time)*; conclude "for growing workloads, near-linear speedup is achievable."

---

## 10. Hyper-Threading vs. Multi-Core (Differentiation Table — must memorize)

| Aspect | Hyper-Threading (SMT) | Multi-core (CMP) |
|---|---|---|
| Duplication | **Architecture state only** (registers); execution engine **shared** | **Complete execution cores** duplicated |
| Execution | **Interleaved** on shared units — NOT parallel | **Truly parallel** — each thread has its own core |
| Performance | Up to ~30% (latency hiding of idle resources) | Up to ~2× (dual-core) theoretical |
| Dependence on app | Gains only if threads fill idle units (memory-latency-bound apps) | Gains if workload can be partitioned |
| Failure/stall handling | One stalled thread → other takes over all resources (no OS switch) | Each thread independent; **scheduler may run both simultaneously** |
| Cache interference | Shares caches → possible conflicts | Dedicated/shared caches → **false sharing** possible between cores |

**Key quote from the book:** *"HT Technology is not a replacement for multi-core processing since many processing resources, such as the execution units, are shared."*

---

## 11. Multi-threading on Single-Core vs. Multi-Core

| | Single-core | Multi-core |
|---|---|---|
| Thread purpose | **Hide latency** / improve UI responsiveness | **Partition work** to run truly in parallel |
| Progress | One thread at a time (interleaved) | Simultaneous progress |
| Shifter-unit example | One shifter → threads contend | Two cores → two shifters → no contention |
| Performance model | Relies on ILP + straight-line throughput | Relies on workload partitioning |
| **Design trap** | Cache sync not an issue (one cache) | **False sharing** possible; **thread priority assumptions break** (high-priority thread can *also* run simultaneously on another core — code assuming it's alone becomes unstable) |

> **Trick:** For "single-core vs multi-core threading" answers, lead with the **false sharing** and **thread-priority** surprises from Akhter — these are the two differences the textbook highlights.

---

## 12. Quick Revision & Exam Strategy

### One-liners
- Concurrency = interleaving; Parallelism = simultaneous.
- Flynn: SISD, SIMD, MISD, MIMD (modern multi-core = MIMD).
- Thread = PC + architecture state + stack.
- Thread states: ready, running, waiting, terminated.
- Map models: M:1 (cooperative), 1:1 (preemptive; Linux/Win2K/XP), M:N.
- SMT (HT) duplicates state, shares units; CMP duplicates cores.
- Amdahl upper bound = 1/S; corollary → parallelize more code before adding cores.
- Gustafson: scaled speedup = N + (1−N)s → linear.
- Overhead H(n) can make speedup < 1.
- VM: VMM = hypervisor; runtime virtualization vs system virtualization.

### Likely exam questions
1. Differentiate Multi-Core architecture and Hyper-Threading Technology. (from course slides — textbook assignment Q)
2. Differentiate Multi-threading on Single-Core vs Multi-Core platforms.
3. State and prove Amdahl's Law; give the upper-bound formula and its corollary.
4. Compare Amdahl's and Gustafson's Laws with assumptions.
5. Explain Flynn's taxonomy with examples.
6. Explain user-level vs kernel-level threads and the M:1, 1:1, M:N models.
7. What is the thread lifecycle and what happens when a thread is created?
8. Explain system vs runtime virtualization and the role of the hypervisor.

### Tips & Tricks
- **Derive Amdahl from first principles** in exam: start with Speedup = total/(parallel part + serial part) — you'll never forget the formula.
- Always attach a **worked example** (e.g., S=0.2, 4 cores → speedup = 1/(0.2+0.8/4)=1/0.4=2.5).
- When comparing hyper-threading vs multicore, draw the small diagrams of **shared vs. duplicated resources**.
- Give **both** Amdahl & Gustafson even if asked only one — shows breadth; note "equivalent but different assumptions" (Shi 1996).
- Memorize the numbers: HT ≈ +30% ; dual-core ≈ up to 2×; serial 10% → max 10× speedup.

---
*Sources: syllabus.txt (Unit I); Multi-CoreProgramming-Ch1_Akhter_Roberts.md; Multicore_Architecture.md (lecture slides).*