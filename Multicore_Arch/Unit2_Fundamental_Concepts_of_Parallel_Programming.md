# Unit 2: Fundamental Concepts of Parallel Programming

> Course: Multicore Architecture and Programming (CI71) | Source: `Multicore_Architecture.md` (lecture slides), `Multi-CoreProgramming-Ch1_Akhter_Roberts.md`

---

## 1. Core Idea: From Linear to Parallel Thinking

### 1.1 The mindset shift
- Traditional programming = **sequential execution** — one instruction after another.
- Parallel programming = **identify activities that can be executed simultaneously** and organize threads to do them.
- The task centers on **design, development, and deployment of threads** within an application + **coordination among threads**.

### 1.2 See programs as tasks with dependencies
- View a program as a **set of tasks with dependencies between them**.
- **Decomposition** = breaking the program into individual (logical) tasks and identifying the dependencies.
- Only after decomposition can you decide what can run in parallel.

---

## 2. Designing for Threads: Choosing the Right Decomposition

A problem may be decomposed in several ways:
1. **By task** (functions/operations — task decomposition)
2. **By data** (the data items each thread works on — data decomposition / data-level parallelism)
3. **By data flow** (how data flows between tasks — data-flow decomposition)

### 2.1 Task Decomposition
- Split the program by the **functions it performs**.
- Individual tasks are catalogued; if two can run concurrently, the developer schedules them so.
- **Example — gardening:** one gardener mows the lawn while another weeds — two *different* functions in parallel (with coordination so the weeder isn't in the line of mowing!).
- **Programming analogy:** different functions/threads of a program each do different work.

### 2.2 Data Decomposition (Data-Level Parallelism)
- Split the work **by the data** each thread operates on; many threads do **the same kind of work** on **different data**.
- **Example — spreadsheet:** rather than one thread recalculating all cells, use *n* threads each computing **1/n-th** of the cells.
- **Gardening analogy:** both gardeners mow *half* the lawn, then both weed *half* the beds.
- **Choice factors:** if the work area is too small to split, task decomposition wins; the right choice depends on problem constraints.

### 2.3 Data-Flow Decomposition
- The critical issue is **how data flows between tasks**, not what each task does.
- **Producer/Consumer pattern:** output of one task (producer) becomes input of another (consumer). The consumer **cannot start** until the producer has produced enough.
- **Gardening analogy:** one gardener prepares tools (gas in mower, cleaned shears) — no real gardening can occur until that step is mostly done; then both can work in parallel.
- **Programming example:** file read → processing pipeline. The processing step cannot begin until the read has progressed/completed.

> **⚠ Key performance insight:** a badly implemented producer/consumer can cause a thread to sit idle while another works — this **violates the load-balancing objective** of keeping all threads busy. A performance-sensitive design must avoid situations where threads idle waiting on related threads.

---

## 3. Implications of Different Decompositions

- Different decompositions give **different benefits**.
- Threading for **performance** is the most common motivation; **choosing the decomposition itself is the harder problem**.
- The choice is often **dictated by the problem domain**; sometimes it requires careful analysis of the constituent activities.
- **Takeaway:** determine the right decomposition by *planning, timing, evaluating, and testing* — not guessing.

### Comparison summary (memorize)

| Method | Break by | Threads do | Example | Best when |
|---|---|---|---|---|
| Task decomposition | Functions/tasks | Different work | Mow + weed | Independent tasks (embarrassingly parallel) |
| Data decomposition | Data items | Same work, diff. data | 1/n spreadsheet cells | Large homogeneous data with repeated ops |
| Data-flow decomposition | Data dependencies | Producer → consumer | File read → process | Pipelines, streaming, stage dependencies |

---

## 4. Challenges You'll Face (the "Big Four" — memorise)

Managing simultaneous activities forces you to confront **four types of problems**:

1. **Synchronization** — coordinating two or more threads (e.g., one thread waits for another to finish a task before continuing). Ordering of updates to shared data.
2. **Communication** — bandwidth & latency issues when threads exchange data.
3. **Load balancing** — distributing work across threads so each does roughly the same amount of work.
4. **Scalability** — making efficient use of *more* threads when running on more-capable systems (will code using 4 cores scale properly to 8?). The hope: linear scaling with cores; obstacles: serial portions, overhead, contention.

> **Mnemonic — "SCLS":** **S**ynchronization, **C**ommunication, **L**oad balance, **S**calability. ("Every Parallel Program Solves SCLS.")

Each must be handled carefully to maximize performance. Later units deal with synchronization primitives (Unit 3), OpenMP scheduling keys to load-balancing (Unit 4), and Unit 5 the failure modes (deadlock, false sharing, etc.).

---

## 5. Parallel Programming Patterns

### 5.1 What are patterns?
- **Design patterns for parallel programming** — a "cookbook" that guides programmers systematically to peak parallel performance.
- Provide a **common vocabulary** for the programming community.

### 5.2 Common patterns (memorize the family)

| Pattern | Description | Decomposition used |
|---|---|---|
| **Task-level parallelism** | Decompose into independent tasks. Fits **embarrassingly parallel** problems (no dependencies among threads) | Task |
| **Divide and Conquer** | Recursively split problem into sub-problems, solve independently, combine | Task/Data |
| **Geometric Decomposition** | Domain (data) partitioned into sub-domains, processed in parallel; neighbors may need boundary exchange | Data |
| **Pipeline** | Series of stages; data flows through stages like an assembly line | Data-flow |
| **Wavefront** | Computation proceeds along "fronts" of dependencies (anti-diagonals) | Data-flow |

- **"Embarrassingly parallel"** = trivially parallel — no communication between tasks → easiest win.
- **"Tightly coupled" problems** require lots of interaction between parallel tasks (opposite of embarrassingly parallel).

> **Trick:** When asked "which pattern fits my problem?" use the rule: *independent chunks → task/data; stage-dependent → pipeline; dependency front → wavefront; recursive independent subproblems → divide-and-conquer.*

---

## 6. A Motivating Problem: Error Diffusion

### 6.1 What is it?
- A technique for **displaying continuous-tone (multi-level) digital images** on devices with a **limited color/tone range** (e.g., binary printers).
- **Floyd–Steinberg algorithm (1975)** — the classic dithering method.
- Analysis of the algorithm is used in the book as a worked example of parallel decomposition.

### 6.2 Analysis of the serial (error-diffusion) algorithm
- The error from quantizing each pixel is **diffused to neighbors** (right and down).
- Because pixel values depend on errors propagated from *previous* pixels, the scan is fundamentally **serial along the scan direction**.

### 6.3 Parallel / alternate approaches
- **Parallel error diffusion:** restructure to process pixels with **independent regions**, compensating boundary errors; often breaks into a **wavefront pattern** over image rows.
- **Other alternatives:** ordered/blue-noise dithering, threshold arrays, or error diffusion variants designed for parallelism (e.g., stripe-based with boundary-error handling).
- **Lesson from the example:** problems that *appear* serial may, through a simple transformation, be adapted to a parallel implementation.

> **Trick:** Highlight the meta-lesson — *"many problems that appear to be serial may, through a simple transformation, be adapted to a parallel implementation."* This appears verbatim in the slides — good to quote in essays on designing for threads.

---

## 7. Key Points to Keep in Mind (Exam Summary)

1. Decompositions fall into three categories: **task, data, data-flow.**
2. **Task-level parallelism** partitions work between threads based on tasks.
3. **Data decomposition** breaks down tasks based on the *data* the threads work on.
4. **Data-flow decomposition** breaks down the problem in terms of how data flows between tasks.
5. Most parallel programming problems fall into one of several well-known **patterns**.
6. The constraints of **synchronization, communication, load balancing, and scalability** must be dealt with to extract maximum benefit.
7. Many **seemingly-serial** problems can be made parallel via a simple transformation.

---

## 8. Quick Revision & Exam Strategy

### Likely exam questions
1. Define and illustrate the three forms of decomposition (task, data, data-flow). (10 marks)
2. Explain the four challenges (SCLS) in parallel programming with examples.
3. Describe parallel programming patterns: task-level, divide-and-conquer, geometric, pipeline, wavefront.
4. Analyse the error-diffusion problem — why is it serial, and how can it be parallelized?
5. Describe the producer–consumer (data-flow) decomposition and its performance pitfalls.

### Tips & Tricks
- Use the **gardening analogy** (mow/weed for task vs. data; prepare-tools for data-flow) — it's directly from the textbook/slides and examiners recognize it.
- Draw the **decomposition comparison table** (§3) in short-answer questions — instant structure.
- For "patterns" questions, always mention *embarrassingly parallel* and *tightly coupled* as the two extremes.
- Practice a numeric/descriptive rendition of the **wavefront** pattern for the error-diffusion connection (row-by-row dependency), and state that it is a *data-flow* pattern.
- Tie Unit 2 to Unit 1: the choice of decomposition directly affects speedup/load balance — mention Amdahl's serial fraction when discussing why decomposition choice matters.

---
*Sources: Multicore_Architecture.md (lecture slides); Multi-CoreProgramming-Ch1_Akhter_Roberts.md; syllabus.txt (Unit II).*