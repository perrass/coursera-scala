# Week1 Parallel Programming

### Intro

What is Parallel Computing

Parallel computing is a type of computation in which many calculations are performed at the same time. The basic principle is that computation can be divided into smaller subproblems, each of which can be solved simultaneously.

Parallel Programming vs. Concurrent Programming

* Parallel Programming uses parallel hardware to execute computation more quickly. Efficiency is its main concern. How to divide problems into subproblems or how to make best of underlying parallel hardware to obtain the optimal speedup. The main concern is speedup
* A concurrent program is a program in which multiple executions may or may not execute the same time. When can a specific execution start, when and how can two concurrent executions exchange information, and how do computations manage access to shared resources (files or database handle) . The main concern is convenience, better responsiveness and maintainability

Parallelism manifests itself at different granularity levels

* bit-level: processing multiple bits of data in parallel
* instruction-level: executing different instructions from the same instruction stream in parallel
* take-level: executing separate instruction streams in parallel

Forms of parallel hardware, the first two will be explained in this course

* multi-core processors
* symmetric multiprocessors
* graphics processing unit
* field-programmable gate arrays
* computer clusters

### Parallelism on JVM

Operation system - software that manages hardware and software resources, and schedules program execution.

Process(进程) - an instance of a program that is executing in the OS.

The same program can be started as a process more than once, or even simultaneously in the same OS.

The operation system multiplexes many different processes and a limited number of CPUs, so that they get **time slices** of execution. This mechanism is called **multitasking**

Two different processes cannot access each other's memory directly - they are isolated (for safety)

Threads(线程) - each process can contain multiple independent concurrency units

* Threads can be started from within the same program, and they share the same memory address space
* Each thread has a program counter and a program stack

Each JVM process starts with a **main thread**, to start additional threads

* Define a `Thread` subclass
* Instantiate a new `Thread` object
* Call start on the `Thread` object