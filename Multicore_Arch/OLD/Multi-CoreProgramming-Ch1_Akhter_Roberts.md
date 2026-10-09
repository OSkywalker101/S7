Multi-Core Programming
Increasing Performance through Software
Multi-threading
Shameem Akhter
Jason Roberts
Intel
PRESS

Copyright © 2006 Intel Corporation. All rights reserved.
ISBN 0-9764832-4-6
No part of this publication may be reproduced, stored in a retrieval system or transmitted in any
form or by any means, electronic, mechanical, photocopying, recording, scanning or otherwise,
except as permitted under Sections 107 or 108 of the 1976 United States Copyright Act, without
either the prior written permission of the Publisher, or authorization through payment of the
appropriate per-copy fee to the Copyright Clearance Center, 222 Rosewood Drive, Danvers,
MA 01923, (978) 750-8400, fax (978) 750-4744. Requests to the Publisher for permission
should be addressed to the Publisher, Intel Press, Intel Corporation, 2111 NE 25th Avenue, JF3-
330, Hillsboro, OR 97124-5961. E-mail: intelpress@intel.com.
This publication is designed to provide accurate and authoritative information in regard to the
subject matter covered. It is sold with the understanding that the publisher is not engaged in
professional services. If professional advice or other expert assistance is required, the services
of a competent professional person should be sought.
Intel Corporation may have patents or pending patent applications, trademarks, copyrights, or
other intellectual property rights that relate to the presented subject matter. The furnishing of
documents and other materials and information does not provide any license, express or
implied, by estoppel or otherwise, to any such patents, trademarks, copyrights, or other
intellectual property rights.
Intel may make changes to specifications, product descriptions, and plans at any time, without
notice.
Fictitious names of companies, products, people, characters, and/or data mentioned herein are
not intended to represent any real individual, company, product, or event.
Intel products are not intended for use in medical, life saving, life sustaining, critical control or
safety systems, or in nuclear facility applications.
Intel, the Intel logo, Celeron, Intel Centrino, Intel NetBurst, Intel Xeon, Itanium, Pentium, MMX,
and VTune are trademarks or registered trademarks of Intel Corporation or its subsidiaries in
the United States and other countries.
†
Other names and brands may be claimed as the property of others.
This book is printed on acid-free paper.
Publisher: Richard Bowles
Editor: David J. Clark
Managing Editor: David B. Spencer
Content Architect: Stuart Goldstein
Text Design & Composition: Interactive Composition Corporation
Graphic Art: Kirsten Foote (illustrations), Ted Cyrek (cover)
Library of Congress Cataloging in Publication Data:
Printed in the United States of America
10 9 8 7 6 5 4 3 2 1
First printing, April 2006

1
Chapter
Introduction
to Multi-Core
Architecture
In 1945, mathematician John von Neumann, with the aid of J. Presper
Eckert and John Mauchly, wrote a memo proposing the creation of an
Electronic Discrete Variable Automatic Computer, more famously known
as the EDVAC. In this paper, von Neumann suggested the stored-program
model of computing. In the von Neumann architecture, a program is a
sequence of instructions stored sequentially in the computer’s memory.
The program’s instructions are executed one after the other in a linear,
single-threaded fashion.
As time went on, advancements in mainframe technology expanded
upon the ideas presented by von Neumann. The 1960s saw the advent of
time-sharing operating systems. Run on large mainframe computers,
these operating systems first introduced the concept of concurrent
program execution. Multiple users could access a single mainframe
computer simultaneously and submit jobs for processing. From the
program’s perspective, it was the only process in the system. The operating
system handled the details of allocating CPU time for each individual
program. At this time, concurrency existed at the process level, and the
job of task switching was left to the systems programmer.
In the early days of personal computing, personal computers, or PCs,
were standalone devices with simple, single-user operating systems. Only
one program would run at a time. User interaction occurred via simple
text based interfaces. Programs followed the standard model of straight-
line instruction execution proposed by the von Neumann architecture.
Over time, however, the exponential growth in computing performance
1

2 Multi-Core Programming
quickly led to more sophisticated computing platforms. Operating system
vendors used the advance in CPU and graphics performance to develop
more sophisticated user environments. Graphical User Interfaces, or GUIs,
became standard and enabled users to start and run multiple programs in
the same user environment. Networking on PCs became pervasive.
This rapid growth came at a price: increased user expectations. Users
expected to be able to send e-mail while listening to streaming audio that
was being delivered via an Internet radio station. Users expected their
computing platform to be quick and responsive. Users expected
applications to start quickly and handle inconvenient background tasks,
such as automatically saving a file with minimal disruption. These
challenges are the problems that face software developers today.
Motivation for Concurrency in Software
Most end users have a simplistic view of complex computer systems.
Consider the following scenario: A traveling businessman has just come
back to his hotel after a long day of presentations. Too exhausted to go out,
he decides to order room service and stay in his room to watch his favorite
baseball team play. Given that he’s on the road, and doesn’t have access to
the game on his TV, he decides to check out the broadcast via the Internet.
His view of the system might be similar to the one shown in Figure 1.1.
Figure 1.1 End User View of Streaming Multimedia Content via the Internet
The user’s expectations are based on conventional broadcast delivery
systems which provide continuous, uninterrupted delivery of content. The
user does not differentiate between streaming the content over the Internet
and delivering the data via a broadcast network. To the user, watching a
baseball game on a laptop seems like a simple, straightforward task.

Chapter 1: Introduction to Multi-Core Architecture 3
The reality is that the implementation of such a system is far more
difficult. From the client side, the PC must be able to download the
streaming video data, decompress/decode it, and draw it on the video
display. In addition, it must handle any streaming audio that accompanies
the video stream and send it to the soundcard. Meanwhile, given the
general purpose nature of the computer, the operating system might be
configured to run a virus scan or some other system tasks periodically.
On the server side, the provider must be able to receive the original
broadcast, encode/compress it in near real-time, and then send it over
the network to potentially hundreds of thousands of clients. A system
designer who is looking to build a computer system capable of streaming
a Web broadcast might look at the system as it’s shown in Figure 1.2.
Figure 1.2 End-to-End Architecture View of Streaming Multimedia Content
over the Internet
Contrast this view of a streaming multimedia delivery service with
the end user’s perspective of the system shown in Figure 1.1. In order to
provide an acceptable end-user experience, system designers must be
able to effectively manage many independent subsystems that operate in
parallel.
Careful inspection of Figure 1.2 shows that the problem of streaming
media content may be broken into a number of disparate parts; each acting

4 Multi-Core Programming
independently1 from one another. This decomposition allows us to break
down each task into a single isolated problem, making the problem much
more manageable.
Concurrency in software is a way to manage the sharing of resources
used at the same time. Concurrency in software is important for several
reasons:
(cid:132) Concurrency allows for the most efficient use of system resources.
Efficient resource utilization is the key to maximizing perform-
ance of computing systems. Unnecessarily creating dependencies
on different components in the system drastically lowers overall
system performance. In the aforementioned streaming media example,
one might naively take this, serial, approach on the client side:
1. Wait for data to arrive on the network
2. Uncompress the data
3. Decode the data
4. Send the decoded data to the video/audio hardware
This approach is highly inefficient. The system is completely idle
while waiting for data to come in from the network. A better
approach would be to stage the work so that while the system is
waiting for the next video frame to come in from the network,
the previous frame is being decoded by the CPU, thereby improving
overall resource utilization.
(cid:132) Many software problems lend themselves to simple concurrent
implementations. Concurrency provides an abstraction for
implementing software algorithms or applications that are naturally
parallel. Consider the implementation of a simple FTP server.
Multiple clients may connect and request different files. A single-
threaded solution would require the application to keep track
of all the different state information for each connection. A
more intuitive implementation would create a separate thread for
each connection. The connection state would be managed by this
separate entity. This multi-threaded approach provides a solution
that is much simpler and easier to maintain.
It’s worth noting here that the terms concurrent and parallel are not
interchangeable in the world of parallel programming. When multiple
1 The term “independently” is used loosely here. Later chapters discuss the managing of
interdependencies that is inherent in multi-threaded programming.

Chapter 1: Introduction to Multi-Core Architecture 5
software threads of execution are running in parallel, it means that the
active threads are running simultaneously on different hardware
resources, or processing elements. Multiple threads may make progress
simultaneously. When multiple software threads of execution are
running concurrently, the execution of the threads is interleaved onto a
single hardware resource. The active threads are ready to execute, but
only one thread may make progress at a given point in time. In order to
have parallelism, you must have concurrency exploiting multiple
hardware resources.
Parallel Computing Platforms
In order to achieve parallel execution in software, hardware must
provide a platform that supports the simultaneous execution of multiple
threads. Generally speaking, computer architectures can be classified by
two different dimensions. The first dimension is the number of
instruction streams that a particular computer architecture may be able
to process at a single point in time. The second dimension is the number
of data streams that can be processed at a single point in time. In this
way, any given computing system can be described in terms of how
instructions and data are processed. This classification system is known
as Flynn’s taxonomy (Flynn, 1972), and is graphically depicted in
Figure 1.3.
Figure 1.3 Flynn’s Taxonomy

6 Multi-Core Programming
| Flynn’s  taxonomy  |     | places  |     | computing  |     | platforms  | in  | one  | of  four  |
| ------------------ | --- | ------- | --- | ---------- | --- | ---------- | --- | ---- | --------- |
categories:
(cid:132)  A single instruction, single data (SISD) machine is a traditional
sequential computer that provides no parallelism in hardware.
Instructions are executed in a serial fashion. Only one data stream
is processed by the CPU during a given clock cycle. Examples of
these platforms include older computers such as the original IBM
| PC,  older  |     | mainframe  | computers,  |     |     | or  many  | of  the  | 8-bit  | home  |
| ----------- | --- | ---------- | ----------- | --- | --- | --------- | -------- | ------ | ----- |
computers such as the Commodore 64 that were popular in the
early 1980s.
(cid:132)  A multiple instruction, single data (MISD) machine is capable of
processing a single data stream using multiple instruction streams
simultaneously. In most cases, multiple instruction streams need
| multiple  | data  | streams  |     | to  be  | useful,  | so  | this  class  | of  | parallel  |
| --------- | ----- | -------- | --- | ------- | -------- | --- | ------------ | --- | --------- |
computer is generally used more as a theoretical model than a
practical, mass-produced computing platform.
| (cid:132)  A  single  | instruction,  |     | multiple     |     | data    | (SIMD)    | machine  | is  | one  in  |
| --------------------- | ------------- | --- | ------------ | --- | ------- | --------- | -------- | --- | -------- |
| which                 | a  single     |     | instruction  |     | stream  | has  the  | ability  | to  | process  |
multiple data streams simultaneously. These machines are useful
in applications such as general digital signal processing, image
processing, and multimedia applications such as audio and video.
Originally, supercomputers known as array processors or vector
| processors  |     | such  | as  the  | Cray-1  |     | provided  | SIMD  | processing  |     |
| ----------- | --- | ----- | -------- | ------- | --- | --------- | ----- | ----------- | --- |
capabilities. Almost all computers today implement some form of
SIMD instruction set. Intel processors implement the MMX™,
Streaming SIMD Extensions (SSE), Streaming SIMD Extensions 2
(SSE2), and Streaming SIMD Extensions 3 (SSE3) instructions that
are capable of processing multiple data elements in a single clock.
| The  multiple  |           | data  | elements    |     | are  stored  | in           | the  | floating  | point    |
| -------------- | --------- | ----- | ----------- | --- | ------------ | ------------ | ---- | --------- | -------- |
| registers.     | PowerPC†  |       | processors  |     | have         | implemented  |      | the       | AltiVec  |
instruction set to provide SIMD support.
(cid:132)  A multiple instruction, multiple data (MIMD) machine is capable
of is executing multiple instruction streams, while working on a
separate and independent data stream. This is the most common
| parallel  | computing  |     | platform  |     | today.  | New  | multi-core  |     | platforms  |
| --------- | ---------- | --- | --------- | --- | ------- | ---- | ----------- | --- | ---------- |
such as the Intel® Core™ Duo processor fall into this category.
Given that modern computing machines are either the SIMD or MIMD
machines, software developers have the ability to exploit data-level and
task level parallelism in software.

Chapter 1: Introduction to Multi-Core Architecture 7
Parallel Computing in Microprocessors
In 1965, Gordon Moore observed that the number of transistors available
to semiconductor manufacturers would double approximately every 18
to 24 months. Now known as Moore’s law, this observation has guided
computer designers for the past 40 years. Many people mistakenly think
of Moore’s law as a predictor of CPU clock frequency, and it’s not really
hard to understand why. The most commonly used metric in measuring
computing performance is CPU clock frequency. Over the past 40 years,
CPU clock speed has tended to follow Moore’s law. It’s an important
distinction to make, however, as taking this view of Moore’s law
imposes unnecessary limits on a silicon designer. While improving
straight-line instruction throughput and clock speeds are goals worth
striving for, computer architects can take advantage of these extra
transistors in less obvious ways.
For example, in an effort to make the most efficient use of processor
resources, computer architects have used instruction-level parallelization
techniques to improve processor performance. Instruction-level parallelism
(ILP), also known as dynamic, or out-of-order execution, gives the CPU the
ability to reorder instructions in an optimal way to eliminate pipeline stalls.
The goal of ILP is to increase the number of instructions that are executed
by the processor on a single clock cycle2. In order for this technique to be
effective, multiple, independent instructions must execute. In the case of
in-order program execution, dependencies between instructions may limit
the number of instructions available for execution, reducing the amount of
parallel execution that may take place. An alternative approach that
attempts to keep the processor’s execution units full is to reorder the
instructions so that independent instructions execute simultaneously. In
this case, instructions are executed out of program order. This dynamic
instruction scheduling is done by the processor itself. You will learn much
more about these techniques in a later chapter, but for now what is
important to understand is that this parallelism occurs at the hardware level
and is transparent to the software developer.
As software has evolved, applications have become increasingly
capable of running multiple tasks simultaneously. Server applications
today often consist of multiple threads or processes. In order to support
this thread-level parallelism, several approaches, both in software and
hardware, have been adopted.
2 A processor that is capable of executing multiple instructions in a single clock cycle is known as a
super-scalar processor.

8 Multi-Core Programming
One approach to address the increasingly concurrent nature of modern
software involves using a preemptive, or time-sliced, multitasking operating
system. Time-slice multi-threading allows developers to hide latencies
associated with I/O by interleaving the execution of multiple threads. This
model does not allow for parallel execution. Only one instruction stream
can run on a processor at a single point in time.
Another approach to address thread-level parallelism is to increase
the number of physical processors in the computer. Multiprocessor
systems allow true parallel execution; multiple threads or processes run
simultaneously on multiple processors. The tradeoff made in this case is
increasing the overall system cost.
As computer architects looked at ways that processor architectures
could adapt to thread-level parallelism, they realized that in many cases,
the resources of a modern processor were underutilized. In order to
consider this solution, you must first more formally consider what a
thread of execution in a program is. A thread can be defined as a basic
unit of CPU utilization. It contains a program counter that points to the
current instruction in the stream. It contains CPU state information for
the current thread. It also contains other resources such as a stack.
A physical processor is made up of a number of different resources,
including the architecture state—the general purpose CPU registers and
interrupt controller registers, caches, buses, execution units, and branch
prediction logic. However, in order to define a thread, only the
architecture state is required. A logical processor can thus be created by
duplicating this architecture space. The execution resources are then
shared among the different logical processors. This technique is known
as simultaneous multi-threading, or SMT. Intel’s implementation of SMT
is known as Hyper-Threading Technology, or HT Technology. HT
Technology makes a single processor appear, from software’s
perspective, as multiple logical processors. This allows operating systems
and applications to schedule multiple threads to logical processors as
they would on multiprocessor systems. From a microarchitecture
perspective, instructions from logical processors are persistent and
execute simultaneously on shared execution resources. In other words,
multiple threads can be scheduled, but since the execution resources are
shared, it’s up to the microarchitecture to determine how and when to
interleave the execution of the two threads. When one thread stalls,
another thread is allowed to make progress. These stall events include
handling cache misses and branch mispredictions.
The next logical step from simultaneous multi-threading is the multi-core
processor. Multi-core processors use chip multiprocessing (CMP). Rather

Chapter 1: Introduction to Multi-Core Architecture 9
than just reuse select processor resources in a single-core processor,
processor manufacturers take advantage of improvements in manufacturing
technology to implement two or more “execution cores” within a single
processor. These cores are essentially two individual processors on a single
die. Execution cores have their own set of execution and architectural
resources. Depending on design, these processors may or may not share a
large on-chip cache. In addition, these individual cores may be combined
with SMT; effectively increasing the number of logical processors by twice
the number of execution cores. The different processor architectures are
highlighted in Figure 1.4.
A) Single Core B) Multiprocessor
C) Hyper-Threading Technology D) Multi-core
E) Multi-core with Shared Cache
F) Multi-core with Hyper-Threading Technology
Figure 1.4 Simple Comparison of Single-core, Multi-processor, and Multi-Core
Architectures

10 Multi-Core Programming
Differentiating Multi-Core Architectures from Hyper-Threading Technology
With HT Technology, parts of the one processor are shared between threads,
while other parts are duplicated between them. One of the most important
shared resources is the actual execution engine. This engine works on both
threads at the same time by executing instructions for one thread on
resources that the other thread is not using. When both threads are running,
HT Technology literally interleaves the instructions in the execution pipeline.
Which instructions are inserted when depends wholly on what execution
resources of the processor are available at execution time. Moreover, if one
thread is tied up reading a large data file from disk or waiting for the user to
type on the keyboard, the other thread takes over all the processor
resources—without the operating system switching tasks—until the first
thread is ready to resume processing. In this way, each thread receives the
maximum available resources and the processor is kept as busy as possible.
An example of a thread running on a HT Technology enabled CPU is shown
in Figure 1.5.
Figure 1.5 Two Threads Executing on a Processor with Hyper-Threading
Technology
HT Technology achieves performance gains through latency hiding.
Fundamentally, a single execution core is shared among multiple threads.
Therefore, thread execution is not parallel. As a result, performance results
vary based on application and hardware platform. With HT Technology, in
certain applications, it is possible to attain, on average, a 30-percent increase
in processor throughput. In other words, in certain cases, the
processor can perform 1.3 times the number of executed instructions
that it could if it were running only one thread. To see a performance
improvement, applications must make good use of threaded
programming models and of the capabilities of Hyper-Threading
Technology.

Chapter 1: Introduction to Multi-Core Architecture 11
The performance benefits of HT Technology depend on how much
latency hiding can occur in your application. In some applications,
developers may have minimized or effectively eliminated memory
latencies through cache optimizations. In this case, optimizing for HT
Technology may not yield any performance gains.
On the other hand, multi-core processors embed two or more
independent execution cores into a single processor package. By providing
multiple execution cores, each sequence of instructions, or thread, has a
hardware execution environment entirely to itself. This enables each thread
run in a truly parallel manner. An example of two threads running on a
dual-core processor is shown in Figure 1.6. Compare this with the HT
Technology example provided in Figure 1.5, and note that a dual-core
processor provides true parallel execution of each thread.
Figure 1.6 Two Threads on a Dual-Core Processor with each Thread Running
Independently
It should be noted that HT Technology does not attempt to deliver
multi-core performance, which can theoretically be close to a 100-percent,
or 2x improvement in performance for a dual-core system. HT Technology
is more of a facility in which the programmer may be able to use idle CPU
resources in order to accomplish more work. When combined with multi-
core technology, HT Technology can provide powerful optimization
opportunities, increasing system throughput substantially.
Multi-threading on Single-Core versus Multi-Core Platforms
At this point, many readers may be asking themselves what all the
commotion is about. The concept of multiple threads in a single process
space has been around for decades. Most modern applications use
threads in one fashion or another today. As a result, many developers are

12 Multi-Core Programming
already familiar with the concept of threading, and have probably
worked on applications that have multiple threads. There are however,
certain important considerations developers should be aware of when
writing applications targeting multi-core processors:
(cid:132) Optimal application performance on multi-core architectures will
be achieved by effectively using threads to partition software
workloads. Many applications today use threads as a tool to improve
user responsiveness on single-core platforms. Rather than blocking
the user interface (UI) on a time consuming database query or disk
access, an application will spawn a thread to process the user’s
request. This allows the scheduler to individually schedule the main
control loop task that receives UI events as well as the data
processing task that is running the database query. In this model,
developers rely on straight-line instruction throughput improvements
to improve application performance.
This is the significant limitation of multi-threading on single-core
processors. Since single-core processors are really only able to
interleave instruction streams, but not execute them simultaneously,
the overall performance gains of a multi-threaded application on
single-core architectures are limited. On these platforms, threads are
generally seen as a useful programming abstraction for hiding latency.
This performance restriction is removed on multi-core architectures.
On multi-core platforms, threads do not have to wait for any one
resource. Instead, threads run independently on separate cores. As an
example, consider two threads that both wanted to execute a shift
operation. If a core only had one “shifter unit” they could not run in
parallel. On two cores, there would be two “shifter units,” and each
thread could run without contending for the same resource.
Multi-core platforms allow developers to optimize applications by
intelligently partitioning different workloads on different processor
cores. Application code can be optimized to use multiple processor
resources, resulting in faster application performance.
(cid:132) Multi-threaded applications running on multi-core platforms have
different design considerations than do multi-threaded applications
running on single-core platforms. On single-core platforms,
assumptions may be made by the developer to simplify writing and
debugging a multi-threaded application. These assumptions may not be
valid on multi-core platforms. Two areas that highlight these differences
are memory caching and thread priority.

Chapter 1: Introduction to Multi-Core Architecture 13
In the case of memory caching, each processor core may have its
own cache.3 At any point in time, the cache on one processor core
may be out of sync with the cache on the other processor core. To
help illustrate the types of problems that may occur, consider the
following example. Assume two threads are running on a dual-core
processor. Thread 1 runs on core 1 and thread 2 runs on core 2. The
threads are reading and writing to neighboring memory locations.
Since cache memory works on the principle of locality, the data
values, while independent, may be stored in the same cache line. As a
result, the memory system may mark the cache line as invalid, even
though the data that the thread is interested in hasn’t changed. This
problem is known as false sharing. On a single-core platform, there
is only one cache shared between threads; therefore, cache
synchronization is not an issue.
Thread priorities can also result in different behavior on single-core
versus multi-core platforms. For example, consider an application
that has two threads of differing priorities. In an attempt to improve
performance, the developer assumes that the higher priority thread
will always run without interference from the lower priority thread.
On a single-core platform, this may be valid, as the operating system’s
scheduler will not yield the CPU to the lower priority thread.
However, on multi-core platforms, the scheduler may schedule both
threads on separate cores. Therefore, both threads may run
simultaneously. If the developer had optimized the code to assume
that the higher priority thread would always run without interference
from the lower priority thread, the code would be unstable on multi-
core and multi-processor systems.
One goal of this book is to help developers correctly utilize the number
of processor cores they have available.
Understanding Performance
At this point one may wonder—how do I measure the performance
benefit of parallel programming? Intuition tells us that if we can
subdivide disparate tasks and process them simultaneously, we’re likely
3 Multi-core CPU architectures can be designed in a variety of ways: some multi-core CPUs will share the
on-chip cache between execution units; some will provide a dedicated cache for each execution core;
and others will take a hybrid approach, where the cache is subdivided into layers that are dedicated to a
particular execution core and other layers that are shared by all execution cores. For the purposes of
this section, we assume a multi-core architecture with a dedicated cache for each core.

14 Multi-Core Programming
to see significant performance improvements. In the case where the tasks
are completely independent, the performance benefit is obvious, but
most cases are not so simple. How does one quantitatively determine the
performance benefit of parallel programming? One metric is to compare
the elapsed run time of the best sequential algorithm versus the elapsed
run time of the parallel program. This ratio is known as the speedup and
characterizes how much faster a program runs when parallelized.
Timebest_sequential_algorithm
Speedup(nt)=
Timeparallel_implementation (nt )
Speedup is defined in terms of the number of physical threads (n)
t
used in the parallel implementation.
Amdahl’s Law
Given the previous definition of speedup, is there a way to determine the
theoretical limit on the performance benefit of increasing the number of
processor cores, and hence physical threads, in an application? When
examining this question, one generally starts with the work done by
Gene Amdahl in 1967. His rule, known as Amdahl’s Law, examines the
maximum theoretical performance benefit of a parallel solution relative
to the best case performance of a serial solution.
Amdahl started with the intuitively clear statement that program
speedup is a function of the fraction of a program that is accelerated and
by how much that fraction is accelerated.
1
Speedup=
(1−FractionEnhanced)+(FractionEnhanced/SpeedupEnhanced)
So, if you could speed up half the program by 15 percent, you’d get:
Speedup=1/((1−.50)+(.50/1.15))=1/(.50+.43)=1.08
This result is a speed increase of 8 percent, which is what you’d expect.
If half of the program is improved 15 percent, then the whole program is
improved by half that amount.
Amdahl then went on to explain how this equation works out if you
make substitutions for fractions that are parallelized and those that are
run serially, as shown in Equation 1.1.

Chapter 1: Introduction to Multi-Core Architecture 15
Equation 1.1 Amdahl’s Law
1
Speedup =
S+(1−S)/n
In this equation, S is the time spent executing the serial portion of the
parallelized version and n is the number of processor cores. Note that the
numerator in the equation assumes that the program takes 1 unit of time
to execute the best sequential algorithm.
If you substitute 1 for the number of processor cores, you see that no
speedup is realized. If you have a dual-core platform doing half the work,
the result is:
1 / (0.5S + 0.5S/2) = 1/0.75S = 1.33
or a 33-percent speed-up, because the run time, as given by the
denominator, is 75 percent of the original run time. For an 8-core
processor, the speedup is:
1 / (0.5S + 0.5S/8) = 1/0.75S = 1.78
Setting n = ∞ in Equation 1.1, and assuming that the best sequential
algorithm takes 1 unit of time yields Equation 1.2.
Equation 1.2 Upper Bound of an Application with S Time Spent in Sequential
Code
1
Speedup =
S
As stated in this manner, Amdahl assumes that the addition of processor
cores is perfectly scalable. As such, this statement of the law shows the
maximum benefit a program can expect from parallelizing some portion
of the code is limited by the serial portion of the code. For example,
according Amdahl’s law, if 10 percent of your application is spent in serial
code, the maximum speedup that can be obtained is 10x, regardless of the
number of processor cores.
It is important to note that endlessly increasing the processor cores only
affects the parallel portion of the denominator. So, if a program is only 10-
percent parallelized, the maximum theoretical benefit is that the program
can run in 90 percent of the sequential time.

16 Multi-Core Programming
Given this outcome, you can see the first corollary of Amdahl’s
law: decreasing the serialized portion by increasing the parallelized
portion is of greater importance than adding more processor cores. For
example, if you have a program that is 30-percent parallelized running on
a dual-core system, doubling the number of processor cores reduces run
time from 85 percent of the serial time to 77.5 percent, whereas
doubling the amount of parallelized code reduces run time from 85
percent to 70 percent. This is illustrated in Figure 1.7. Only when a
program is mostly parallelized does adding more processors help more
than parallelizing the remaining code. And, as you saw previously, you
have hard limits on how much code can be serialized and on how many
additional processor cores actually make a difference in performance.
Performance benefit of doubling Performance benefit of doubling
the number of processor cores the amount of parallelism in code
Note: The advantage gained by writing parallel code
Figure 1.7 Theoretical Performance Comparison between Increasing Number
of CPU Cores versus Increasing Concurrency in Implementation
To make Amdahl’s Law reflect the reality of multi-core systems, rather
than the theoretical maximum, system overhead from adding threads
should be included:
1
Speedup =
S+(1−S)/n+H(n)
where H(n) = overhead, and again, we assume that the best serial
algorithm runs in one time unit. Note that this overhead is not linear on a
good parallel machine.

Chapter 1: Introduction to Multi-Core Architecture 17
This overhead consists of two portions: the actual operating system
overhead and inter-thread activities, such as synchronization and other forms
of communication between threads. Notice that if the overhead is big
enough, it offsets the benefits of the parallelized portion. In fact, if the
overhead is large enough, the speedup ration can ultimately have a value of
less than 1, implying that threading has actually slowed performance when
compared to the single-threaded solution. This is very common in poorly
architected multi-threaded applications. The important implication is that
the overhead introduced by threading must be kept to a minimum. For this
reason, most of this book is dedicated to keeping the cost of threading as
low as possible.
Amdahl’s Law Applied to Hyper-Threading Technology
The previous section demonstrated Amdahl’s law as it applies to multi-
processor and multi-core systems. Hyper-Threading Technology
imposes an additional factor on how you apply Amdahl’s Law to your
code. On processors enabled with HT Technology, the fact that certain
processor resources are shared between the different threads of
execution has a direct effect on the maximum performance benefit of
threading an application.
Given the interleaved execution environment provided by HT
Technology, it’s important to develop a form of Amdahl’s law that works
for HT Technology. Assume that your application experiences a
performance gain of around 30 percent when run on a processor with
HT Technology enabled. That is, performance improves by 30 percent
over the time required for a single processor to run both threads. If you
were using a quad-core platform, with each processor completely
dedicated to the thread it was running, the number could, in theory,
be up to 4x. That is, the second, third, and fourth processor core
could give a 300-percent boost to program throughput. In practice it’s
not quite 300 percent, due to overhead and code that cannot be
parallelized, and the performance benefits will vary based on the
application.
Inside the processor enabled with HT Technology, each thread is
running more slowly than it would if it had the whole processor to itself.
HT Technology is not a replacement for multi-core processing since
many processing resources, such as the execution units, are shared. The
slowdown varies from application to application. As example, assume
each thread runs approximately one-third slower than it would if it

18 Multi-Core Programming
owned the entire processor. Amending Amdahl’s Law to fit HT
Technology, then, you get:
1
Speedup =
HTT S+0.67((1−S)/n)+H(n)
where n = number of logical processors.
This equation represents the typical speed-up for programs running
on processor cores with HT Technology performance. The value of H(n)
is determined empirically and varies from application to application.
Growing Returns: Gustafson’s Law
Based on Amdahl’s work, the viability of massive parallelism was
questioned for a number of years. Then, in the late 1980s, at the Sandia
National Lab, impressive linear speedups in three practical applications
were observed on a 1,024-processor hypercube. The results (Gustafson
1988) demonstrated that near linear speedup was possible in many
practical cases, even when Amdahl’s Law predicted otherwise.
Built into Amdahl’s Law are several assumptions that may not hold true
in real-world implementations. First, Amdahl’s Law assumes that the best
performing serial algorithm is strictly limited by the availability of CPU
cycles. This may not be the case. A multi-core processor may implement a
separate cache on each core. Thus, more of the problem’s data set may be
stored in cache, reducing memory latency. The second flaw is that
Amdahl’s Law assumes that the serial algorithm is the best possible
solution for a given problem. However, some problems lend themselves to
a more efficient parallel solution. The number of computational steps may
be significantly less in the parallel implementation.
Perhaps the biggest weakness, however, is the assumption that
Amdahl’s Law makes about the problem size. Amdahl’s Law assumes that
as the number of processor cores increases, the problem size stays the
same. In most cases, this is not valid. Generally speaking, when given
more computing resources, the problem generally grows to meet the
resources available. In fact, it is more often the case that the run time of
the application is constant.
Based on the work at Sandia, an alternative formulation for speedup,
referred to as scaled speedup was developed by E. Barsis.
Scaled speedup = N + (1 − N)*s
where N = is the number of processor cores and s is the ratio of the time
spent in the serial port of the program versus the total execution time.

Chapter 1: Introduction to Multi-Core Architecture 19
Scaled speedup is commonly referred to as Gustafson’s Law. From this
equation, one can see that the speedup in this case is linear.
Gustafson’s Law has been shown to be equivalent to Amdahl’s Law
(Shi 1996). However, Gustafson’s Law offers a much more realistic look
at the potential of parallel computing on multi-core processors.
Key Points
This chapter demonstrated the inherent concurrent nature of many
software applications and introduced the basic need for parallelism in
hardware. An overview of the different techniques for achieving parallel
execution was discussed. Finally, the chapter examined techniques for
estimating the performance benefits of using proper multi-threading
techniques. The key points to keep in mind are:
(cid:132) Concurrency refers to the notion of multiple threads in progress
at the same time. This is often achieved on sequential processors
through interleaving.
(cid:132) Parallelism refers to the concept of multiple threads executing
simultaneously.
(cid:132) Modern software applications often consist of multiple processes
or threads that can be executed in parallel.
(cid:132) Most modern computing platforms are multiple instruction,
multiple data (MIMD) machines. These machines allow
programmers to process multiple instruction and data streams
simultaneously.
(cid:132) In practice, Amdahl’s Law does not accurately reflect the benefit
of increasing the number of processor cores on a given platform.
Linear speedup is achievable by expanding the problem size with
the number of processor cores.