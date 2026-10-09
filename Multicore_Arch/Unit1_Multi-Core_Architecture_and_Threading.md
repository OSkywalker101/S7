# Unit I — Introduction to Multi-Core Architecture & System Overview of Threading

> Source: Akhter & Roberts, *Multi-Core Programming* (Intel Press, 2006) — Ch. 1 & 2
> Textbook figures referenced below are from the same book; place the matching image from the PDF where marked.

---

## 1. Motivation for Concurrency in Software

- For decades software got faster "for free" because CPU clock speeds kept rising (Moore's Law).
- That free ride ended: clock frequency scaling hit **power and heat walls** (power ~ frequency × voltage²; heat removal limits).
- The industry shifted from making **one faster core** to putting **multiple cores on one chip**.
- **Key consequence:** software must be explicitly written to exploit concurrency, otherwise extra cores sit idle. Hardware parallelism only pays off if the *software* is parallel.
- Benefits targeted: higher throughput, better responsiveness, and resource utilization.

**Why frequency scaling stopped (exam favorite):**
1. Power consumption / heat dissipation.
2. Diminishing returns of deeper pipelining and instruction-level parallelism (ILP).
3. Memory latency not improving at the same rate → "memory wall".

---

## 2. Parallel Computing Platforms

Three broad eras/forms of parallel hardware:

| Platform | Description |
|---|---|
| **Symmetric Multiprocessing (SMP)** | Multiple separate CPUs on a motherboard sharing one main memory (bus-based). Limited by bus contention. |
| **Chip Multiprocessor (CMP) / Multi-Core** | Multiple cores on a single die sharing on-chip caches; faster inter-core communication. |
| **Clusters / Distributed systems** | Many independent machines connected by a network; message passing (MPI). |

- **SMP:** uniform memory access, shared memory, symmetric (all CPUs equal).
- **NUMA (Non-Uniform Memory Access):** memory access time depends on which core accesses which memory bank (common in large multi-socket systems).
- **Hardware thread** = the unit the OS schedules; a core may expose 1 or more hardware threads.

> 🖼️ **Image to add:** Diagram comparing SMP (multiple chips → shared bus → memory) vs CMP (multiple cores on one die → shared L2/L3).

---

## 3. Parallel Computing in Microprocessors

Parallelism is extracted at several levels inside a modern microprocessor:

1. **Instruction-Level Parallelism (ILP):** superscalar issue, out-of-order execution, pipelining.
2. **Thread-Level Parallelism (TLP):** multiple hardware threads (Hyper-Threading / SMT).
3. **Core-Level Parallelism:** multiple physical cores (CMP).
4. **Data-Level Parallelism (DLP):** SIMD (MMX/SSE/AVX) operating on vectors.

- ILP has practical limits (dependencies, branch prediction, decode width). TLP and CMP scale better.
- **Explicit parallelism** (software threads) is needed beyond what the compiler/hardware can auto-extract.

> 🖼️ **Image to add:** Layered diagram showing ILP → TLP → DLP → CMP as increasing levels of parallelism.

---

## 4. Multi-Core vs Hyper-Threading Technology (HT / SMT)

| Aspect | Hyper-Threading (SMT) | Multi-Core (CMP) |
|---|---|---|
| Physical execution resources | **Shared** — one core, duplicated architectural state | **Duplicated** — two or more full cores |
| Duplicated state | Register state, program counter, some buffers | Registers + execution units + (often) L1 |
| Nature of speedup | "Thread-level parallelism" filling idle pipeline slots | True parallel execution of instructions |
| Typical gain | ~15–30% (workload dependent) | Up to ~2× for two cores (ideal) |
| Cost | Very cheap (few extra transistors) | More transistors/area/power |

- HT exposes **two logical processors per physical core** to the OS.
- HT helps most when threads stall (memory stalls, branch mispredicts) so the other thread fills the gaps.
- **Key exam line:** HT is *not* the same as multi-core — HT shares execution units; multi-core has independent ones.
- A dual-core chip with HT can appear to the OS as **four logical processors**.

> 🖼️ **Image to add:** Side-by-side diagram: 1 core with HT (2 logical CPUs sharing execution units) vs dual-core (2 independent cores).

---

## 5. Multi-Threading on Single-Core vs Multi-Core Platforms

- **Single-core + time slicing:** OS rapidly switches between threads. Threads give *concurrency* (interleaved) but **not true parallelism**. Context switch has overhead.
- **Single-core + HT:** some true overlap by filling pipeline bubbles, still sharing one core's resources.
- **Multi-core:** threads run **simultaneously on different cores** = true parallelism; scaling improves but introduces **cache coherence, false sharing, contention** issues.
- **Concurrency vs Parallelism:**
  - *Concurrency* = dealing with many things at once (structure).
  - *Parallelism* = doing many things at once (execution).

> 🖼️ **Image to add:** Timeline diagrams — time-slicing on 1 core vs simultaneous lanes on 4 cores.

---

## 6. Understanding Performance

### Speedup
$$\text{Speedup}(n) = \frac{T_{1}}{T_{n}}$$
where \(T_1\) = time on 1 processor, \(T_n\) = time on \(n\) processors.

### Efficiency
$$\text{Efficiency} = \frac{\text{Speedup}(n)}{n}$$

### Amdahl's Law (strong scaling — fixed problem size)
If a fraction \(f\) of the work is **parallelizable** and \((1-f)\) is **serial**:

$$\text{Speedup}(n) = \frac{1}{(1-f) + \frac{f}{n}}$$

- As \(n \to \infty\), Speedup \(\to \dfrac{1}{1-f}\) (the **serial bottleneck**).
- **Example:** f = 0.95 (95% parallel) → max speedup = 1/0.05 = **20×**, no matter how many cores.
- **Lesson:** the serial portion dominates the ceiling. Reduce serial code before adding cores.

> 🖼️ **Image to add:** Amdahl's Law curve — speedup vs number of processors flattening to the serial asymptote.

### Gustafson's Law (weak scaling — problem size grows with processors)
$$\text{Scaled Speedup}(n) = n - \alpha(n-1) = (1-\alpha) \cdot n + \alpha$$
where \(\alpha\) = serial fraction.
- Assumes problem size grows with the machine; the serial part stays roughly constant while parallel work scales.
- **Lesson:** large machines are best used for **larger problems**, not just the same problem faster. Amdahl is pessimistic; Gustafson is optimistic.

### Comparison
| | Amdahl | Gustafson |
|---|---|---|
| Problem size | Fixed | Grows with n |
| Scaling type | Strong | Weak |
| Viewpoint | Latency/response | Throughput |
| Outlook | Pessimistic ceiling | Near-linear speedup |

> 🖼️ **Image to add:** Chart comparing Amdahl (flattening) vs Gustafson (near-linear) speedup.

---

## 7. System Overview of Threading

### 7.1 Defining Threads
- A **thread** is an independent flow of control within a process: its own **program counter, stack, and register set**, but **shares** the process's code, data, and OS resources (files, address space).
- **Process** = thread + its own address space (heavyweight).
- **Thread** = lightweight; creation and context-switch cheaper than a process.

### 7.2 System View of Threads
- Threads are scheduled entities. Each thread has states: **ready, running, blocked/waiting, terminated**.
- Because threads of one process share memory, **synchronization is required** to prevent races.

### 7.3 Threading Above the Operating System
- **User-level threads:** managed by a library in user space; OS sees one process. Fast switching, but a blocking call blocks all threads and they can't use multiple cores simultaneously from the OS's view.
- **Advantage:** no kernel involvement per switch. **Disadvantage:** no true parallelism, and one blocking syscall stalls the whole process.

### 7.4 Threads Inside the OS
- **Kernel-level threads:** OS is aware of each thread and schedules them individually onto hardware threads.
- Blocking one thread doesn't block others; the OS can run threads on different cores.
- Cost: system calls for create/synchronize; kernel data structures per thread.

### 7.5 Threads Inside the Hardware
- The CPU supports multiple **hardware threads** via multiple cores and/or SMT.
- The OS maps software threads → hardware threads. More software threads than hardware threads ⇒ time slicing.
- Optimal: match the number of **runnable** threads to hardware threads.

### 7.6 What Happens When a Thread Is Created
1. Runtime/library allocates a **stack** and **thread control block** (TCB).
2. Registers and program counter are initialized for the thread's start routine.
3. Thread is placed in the **ready queue**.
4. Scheduler dispatches it onto a hardware thread when resources free up.
5. On completion, resources are reclaimed and the process is notified (join).

> 🖼️ **Image to add:** "Lifecycle of a thread" state diagram (New → Ready → Running → Blocked → Terminated).

### 7.7 Application Programming Models and Threading
Common models to structure parallel code:
- **Task decomposition** (function/control parallel) — split *what work* is done.
- **Data decomposition** (data parallel) — split *the data*, apply same operation.
- **Data-flow decomposition** — split based on data dependencies/pipeline stages.
- **Manager/worker (thread pool)** — a master distributes tasks to workers.
- **Pipeline / producer-consumer** — stages process data in sequence.
- **Peer / geometric decomposition** — divide a domain into chunks.

### 7.8 Virtual Environment: VMs and Platforms
- **Virtual Machine (VM):** software emulation of a computer; guest OS runs on a hypervisor above real hardware.
- Allows multiple OS environments on one physical machine; useful for isolation, consolidation, testing.
- **Threading inside a VM** still maps onto hardware threads but the hypervisor adds a scheduling layer.

### 7.9 Runtime Virtualization
- Virtualizes at the **language/runtime layer** instead of the hardware layer.
- Examples: **Java Virtual Machine (JVM)**, **.NET CLR** — bytecode executed by a managed runtime; threads are runtime-managed and mapped to OS threads.
- Benefits: portability, safety, garbage collection; cost: runtime overhead and less direct control.

### 7.10 System Virtualization
- **Full system virtualization:** hypervisor presents virtual hardware; guest OS is unmodified.
- **Type 1 (bare-metal)** vs **Type 2 (hosted)** hypervisors.
- **Paravirtualization:** guest OS is modified to make hypercalls (cooperative virtualization).
- Contrast: *system virtualization* virtualizes the whole machine; *runtime virtualization* virtualizes the execution environment.

> 🖼️ **Image to add:** Stack diagram: Hardware → Hypervisor → Guest OS → Runtime (JVM/CLR) → Application/Threads.

---

## Key Terms Quick Reference

| Term | Meaning |
|---|---|
| Core | Independent processing unit on a die |
| Hardware thread | Scheduling unit exposed to OS (core or SMT lane) |
| Software thread | OS/library-managed thread |
| SMT / HT | Two logical CPUs per core sharing execution units |
| CMP | Chip Multiprocessor = multi-core |
| SMP | Symmetric Multiprocessor, shared bus memory |
| NUMA | Non-uniform memory access latency |
| ILP / TLP / DLP | Instruction / Thread / Data Level Parallelism |

---

## 🧠 How to Remember (Mnemonics & Tips)

- **Amdahl vs Gustafson:** “**A**mdahl = **A**symptote (fixed problem, ceiling); **G**ustafson = **G**rows the problem (near-linear).”
- **Amdahl formula memory hook:** *“One over [serial + parallel/n].”* The serial term is the wall.
- **HT vs Multi-core:** *“HT shares the engine, multi-core has its own engine.”*
- **Threads = PC + stack + registers, shared address space.** (Mind the shared memory → need locks.)
- **User vs kernel threads:** *“User threads are cheap but blind; kernel threads are visible but costly.”*
- **Amdahl = latency question (‘finish sooner?’), Gustafson = throughput question (‘do more work?’).**
- **Speedup max (Amdahl):** memorize \(1/(1-f)\). If 90% parallel ⇒ 10× max; 95% ⇒ 20×.

## ⭐ Likely Exam Questions
1. Define a thread. Differentiate threads vs processes.
2. Differentiate multi-core from Hyper-Threading with a diagram.
3. State and explain Amdahl's Law; compute max speedup for a given serial fraction.
4. Compare Amdahl's Law and Gustafson's Law.
5. Explain user-level vs kernel-level threads.
6. What happens when a thread is created? Illustrate the thread lifecycle.
7. Explain runtime virtualization vs system virtualization.
