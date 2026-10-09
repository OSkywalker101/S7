# Unit II — Fundamental Concepts of Parallel Programming

> Source: Akhter & Roberts, *Multi-Core Programming* (Intel Press, 2006) — Ch. 3
> Place the matching textbook figures from the PDF where marked "🖼️".

---

## 1. Designing for Threads

The central activity of parallel programming is **decomposition** — breaking work into pieces that can run concurrently.

- **First step:** find the *concurrency* in the problem before writing code.
- **Goal:** choose a decomposition that (a) exposes enough parallelism, (b) keeps synchronization/communication low, and (c) balances load across threads.
- Good designs favor:
  - **Thread-private** and **read-only shared** data (cheap, no sync).
  - Minimizing the need for locks and communication.
- "**Program is a pipeline**" mindset: identify independent work vs dependent work.

### Key rule
> *Parallel programming for performance is about finding the zone between too little and too much synchronization.*
> Too little → wrong answers (races). Too much → slow answers (serialization).

---

## 2. Task Decomposition (Functional / Control Decomposition)

- Divide the **work (functions/operations)** into independent tasks; each thread executes a different task on the same or related data.
- Also called **functional decomposition** or **control decomposition**.
- **Best when:** the algorithm naturally splits into distinct operations (e.g., tasks in a pipeline, independent subroutines).
- **Example:** a program with distinct stages — read → compute → write — each handled by a thread (pipeline).
- **Advantages:** maps nicely to independent operations; natural for producer/consumer.
- **Disadvantages:** number of tasks may be fixed and small (limits scalability); load balancing can be poor; often needs queues/messages between tasks.

> 🖼️ **Image to add:** Task/functional decomposition diagram — one dataset flowing through different task boxes.

---

## 3. Data Decomposition (Data Parallelism)

- Divide the **data** into chunks; each thread runs the **same** code on a different chunk.
- Also called **data parallelism**.
- **Best when:** same operation applies to many data elements (loops over arrays/matrices).
- **Example:** apply a filter to each half of an image on two threads.
- **Advantages:** scales with data size; simple and regular; maps to loops (OpenMP-friendly).
- **Disadvantages:** needs the operation be independent per element; boundary/edge effects; false sharing if chunks share cache lines.

### Types of data distribution
- **Block (contiguous) partition:** each thread gets a contiguous chunk.
- **Cyclic (round-robin) partition:** elements assigned in rotation (good load balancing).
- **Block-cyclic:** combination of the two.

> 🖼️ **Image to add:** Image split into regions, each region processed by a different thread.

---

## 4. Data Flow Decomposition

- Decompose based on **data dependencies and flow** through the program (a directed graph of operations).
- Exploits **pipelining**: data flows through stages; different stages process different data simultaneously.
- **Goal:** overlap producer and consumer; when one stage's output feeds the next, run them concurrently on different data items.
- **Best when:** there is a clear stream of data through sequential stages.
- **Challenges:** stage imbalance (slowest stage limits throughput), buffers, back-pressure.

> 🖼️ **Image to add:** Data-flow graph / assembly-line diagram of stages with buffers between them.

---

## 5. Implications of Different Decompositions

| Decomposition | Partition unit | Communication | Scalability | Best fit |
|---|---|---|---|---|
| **Task/Functional** | Operations | Messages/queues between tasks | Limited by #tasks | Independent operations, pipelines |
| **Data** | Data chunks | Little (if independent) | High (scales with data) | Loops over arrays/images |
| **Data-Flow** | Stages | Buffers between stages | Medium (bottleneck stage) | Streaming/pipelined processing |

- The chosen decomposition determines **where synchronization is needed** and **how much communication overhead** exists.
- Mismatch ⇒ either **races** (too little sync) or **convoying/serialization** (too much sync).

---

## 6. Challenges You'll Face

1. **Finding concurrency** — recognizing independent work in an inherently sequential-looking algorithm.
2. **Load balancing** — making sure all threads finish at roughly the same time.
3. **Synchronization overhead** — locks, barriers, atomics cost performance.
4. **Data dependencies / loop-carried dependencies** — prevent parallelization of some loops.
5. **Race conditions & deadlocks** — correctness hazards.
6. **Data sharing overhead / false sharing** — cache-line contention.
7. **Scalability limits** — Amdahl's serial fraction.
8. **Debugging non-determinism** — bugs appear intermittently.
9. **Task granularity** — too fine ⇒ overhead; too coarse ⇒ poor balance.
10. **Algorithmic changes** — sometimes the parallel algorithm must be different from the sequential one.

---

## 7. Parallel Programming Patterns

Reusable design structures for parallel programs:

| Pattern | Idea |
|---|---|
| **Task parallelism / division of labor** | Split distinct operations among threads |
| **Divide and conquer** | Recursively split problem, solve sub-problems, merge |
| **Pipeline (producer-consumer)** | Stages process a stream; overlap stages |
| **Geometric / domain decomposition** | Split a data domain into regions |
| **Manager–worker (master–worker)** | A manager hands tasks to a pool of workers |
| **Task queue / thread pool** | Fixed workers pull tasks from a shared queue |
| **Fork–join** | Spawn parallel tasks, then join/merge results |

**Tips:** patterns help you reuse proven decompositions; combine them (e.g., geometric decomposition + manager/worker).

> 🖼️ **Image to add:** Palette of common parallel patterns (fork-join, pipeline, divide-and-conquer, master-worker).

---

## 8. A Motivating Problem: Error Diffusion

**Error diffusion** — a technique for converting a gray/continuous-tone image to black-and-white (halftoning) while preserving perceived tone.

- Process pixels left-to-right, top-to-bottom.
- Quantize each pixel to black or white.
- Compute the **quantization error** (difference between original and chosen value).
- **Diffuse (spread) the error** to neighboring not-yet-processed pixels (e.g., right, below, below-right, below-left with weights).
- This makes each output pixel depend on previously processed pixels ⇒ inherently sequential.

### Sequential pseudocode
```c
for each row y:
  for each column x:
     old = pixel[y][x];
     new = (old < threshold) ? BLACK : WHITE;
     err = old - new;
     pixel[y][x] = new;
     pixel[y][x+1]   += err * 7/16;
     pixel[y+1][x-1] += err * 3/16;
     pixel[y+1][x]   += err * 5/16;
     pixel[y+1][x+1] += err * 1/16;
```

> 🖼️ **Image to add:** Figure showing error-diffusion kernel — a pixel's error distributed to 4 neighbors with 7/16, 3/16, 5/16, 1/16 weights.

---

## 9. Analysis of the Error Diffusion Algorithm

### Dependencies
- Each pixel depends on: itself, the pixel to its left (same row), and the three pixels in the row above (above-left, above, above-right).
- This is a **loop-carried / data dependency** — a wavefront of dependency moving diagonally.

### Why simple parallelization is hard
- You **cannot** split the rows arbitrarily: row y depends on row y-1 *and* the running error from the left.
- Splitting columns arbitrarily breaks because errors cross the boundary.

### Dependency structure insight
- The dependency "wavefront" is **diagonal**: a pixel (x, y) depends on (x-1, y) and (x-1±1, y-1) etc.
- Pixels along an **anti-diagonal** (where x + y = constant) are independent of each other and can be computed in parallel!

> 🖼️ **Image to add:** Dependency graph showing the diagonal wavefront of independent pixels in error diffusion.

---

## 10. Alternate Approach: Parallel Error Diffusion

### Approach A — Diagonal / wavefront parallelism
- Compute pixels on the **same anti-diagonal** simultaneously (they don't depend on each other).
- Threads proceed diagonal by diagonal; a **barrier** between diagonals ensures dependencies are satisfied.
- Pros: preserves exact output. Cons: limited parallelism (one diagonal at a time), barrier overhead, poor scalability for small images.

### Approach B — Row-block partitioning with boundary error
- Split the image into horizontal strips; each thread handles a strip.
- To handle dependencies across strip boundaries, give each thread a **duplicate/overlap region** (a few rows) so it can generate the needed context.
- Pros: high parallelism. Cons: redundant computation at boundaries; slight differences possible.

### Approach C — Approximate / independent-block error diffusion
- Process blocks independently, discarding cross-block error.
- Pros: embarrassingly parallel. Cons: visible seams/artifacts.

> 🖼️ **Image to add:** Diagonals processed in parallel (wavefront) and/or image split into strips with overlap.

---

## 11. Other Alternatives

- **Distribute only every Nth row / interleaved rows** so errors still propagate correctly with overlap.
- **Run the sequential algorithm for the first few rows**, then start parallelizing once enough "history" exists.
- **Change the algorithm** to remove the dependency (e.g., use an order-independent dithering such as ordered/Bayer dithering) — a common and important theme in parallelization: *sometimes you change the algorithm rather than fight the dependency.*
- **Pipeline** the image: while one region is being diffused, another thread prepares/quantizes the next.

> 🖼️ **Image to add:** "Change the algorithm" comparison — error diffusion vs ordered/Bayer dithering (independent per pixel).

---

## Key Takeaways

1. Decompose first: task, data, or data-flow.
2. Match threads to the natural parallelism; don't hard-code counts.
3. The error-diffusion example teaches: **dependencies limit parallelism**, but you can restructure (wavefront), overlap, or change the algorithm.
4. Balance granularity and synchronization — the "sweet spot" between correctness and speed.

---

## 🧠 How to Remember (Mnemonics & Tips)

- **Three decompositions = T-D-D:** "**T**ask (what), **D**ata (which), **D**ata-flow (order)."
- **Task = "who does what"**, **Data = "who owns which data"**, **Data-flow = "who comes next."**
- **Error diffusion dependency = "diagonal wavefront."** Picture a wave traveling diagonally — only one diagonal is ready at a time.
- **Parallelization trick bag:** *Wavefront (diagonal) · Overlap/duplicate boundaries · Change the algorithm.*
- **Too little sync = wrong; too much sync = slow.** Memorize this one-liner.
- **Granularity rule:** too fine → overhead; too coarse → imbalance.

## ⭐ Likely Exam Questions
1. Explain task, data, and data-flow decomposition with examples.
2. Compare the implications of different decompositions.
3. What challenges arise in parallel programming? (List and explain.)
4. Describe the error-diffusion problem and why it is hard to parallelize.
5. Explain the diagonal/wavefront approach to parallel error diffusion.
6. What are alternative ways to parallelize or restructure error diffusion?
7. List common parallel programming patterns.
