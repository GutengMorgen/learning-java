OS Basics

Structure of Operating System

Types of OS

Process Management

CPU Scheduling in OS

Threads in OS

Process Synchronization

Critical Section Problem Solution

Deadlocks & Deadlock Handling Methods

Memory Management

- [Memory Management in Operating System](https://www.geeksforgeeks.org/memory-management-in-operating-system/?ref=lbp)
- [Implementation of Contiguous Memory Management Techniques](https://www.geeksforgeeks.org/implementation-of-contiguous-memory-management-techniques/?ref=lbp)
- [Non-Contiguous Allocation in Operating System](https://www.geeksforgeeks.org/non-contiguous-allocation-in-operating-system/?ref=lbp)
- [Compaction in Operating System](https://www.geeksforgeeks.org/compaction-in-operating-system/?ref=lbp)
- [Best-Fit Allocation in Operating System](https://www.geeksforgeeks.org/best-fit-allocation-in-operating-system/?ref=lbp)
- [Worst-Fit Allocation in Operating Systems](https://www.geeksforgeeks.org/worst-fit-allocation-in-operating-systems/?ref=lbp)
- [First-Fit Allocation in Operating Systems](https://www.geeksforgeeks.org/first-fit-allocation-in-operating-systems/?ref=lbp)
- [Fixed (or static) Partitioning in Operating System](https://www.geeksforgeeks.org/fixed-or-static-partitioning-in-operating-system/?ref=lbp)
- [Variable (or dynamic) Partitioning in Operating System](https://www.geeksforgeeks.org/variable-or-dynamic-partitioning-in-operating-system/?ref=lbp)
- [Paging in Operating System](https://www.geeksforgeeks.org/paging-in-operating-system/?ref=lbp)
- [Segmentation in Operating System](https://www.geeksforgeeks.org/segmentation-in-operating-system/?ref=lbp)
- [Virtual Memory in Operating System](https://www.geeksforgeeks.org/virtual-memory-in-operating-system/?ref=lbp)

Page Replacement Algorithms

Storage Management

OS Interview Questions

OS Quiz and GATE PYQ's

- [Write an Interview Experience](https://write.geeksforgeeks.org/posts-new?interview-experience&ref=GLBIE)
- [Share Your Campus Experience](https://write.geeksforgeeks.org/posts-new?cid=c5e1ac90-9490-440a-a5fa-6180c87ab8ae)
- [Operating System Tutorial](https://www.geeksforgeeks.org/operating-systems/?ref=lbp)

OS Basics

Structure of Operating System

Types of OS

Process Management

CPU Scheduling in OS

Threads in OS

Process Synchronization

Critical Section Problem Solution

Deadlocks & Deadlock Handling Methods

Memory Management

- [Memory Management in Operating System](https://www.geeksforgeeks.org/memory-management-in-operating-system/?ref=lbp)
- [Implementation of Contiguous Memory Management Techniques](https://www.geeksforgeeks.org/implementation-of-contiguous-memory-management-techniques/?ref=lbp)
- [Non-Contiguous Allocation in Operating System](https://www.geeksforgeeks.org/non-contiguous-allocation-in-operating-system/?ref=lbp)
- [Compaction in Operating System](https://www.geeksforgeeks.org/compaction-in-operating-system/?ref=lbp)
- [Best-Fit Allocation in Operating System](https://www.geeksforgeeks.org/best-fit-allocation-in-operating-system/?ref=lbp)
- [Worst-Fit Allocation in Operating Systems](https://www.geeksforgeeks.org/worst-fit-allocation-in-operating-systems/?ref=lbp)
- [First-Fit Allocation in Operating Systems](https://www.geeksforgeeks.org/first-fit-allocation-in-operating-systems/?ref=lbp)
- [Fixed (or static) Partitioning in Operating System](https://www.geeksforgeeks.org/fixed-or-static-partitioning-in-operating-system/?ref=lbp)
- [Variable (or dynamic) Partitioning in Operating System](https://www.geeksforgeeks.org/variable-or-dynamic-partitioning-in-operating-system/?ref=lbp)
- [Paging in Operating System](https://www.geeksforgeeks.org/paging-in-operating-system/?ref=lbp)
- [Segmentation in Operating System](https://www.geeksforgeeks.org/segmentation-in-operating-system/?ref=lbp)
- [Virtual Memory in Operating System](https://www.geeksforgeeks.org/virtual-memory-in-operating-system/?ref=lbp)

Page Replacement Algorithms

Storage Management

OS Interview Questions

OS Quiz and GATE PYQ's

# Memory Management in Operating System

[

![author](https://media.geeksforgeeks.org/auth/avatar.png)

varshachoudhary





](https://www.geeksforgeeks.org/memory-management-in-operating-system/#article-meta-div)

- Read
- Discuss
- Courses
- Practice

The term Memory can be defined as a collection of data in a specific format. It is used to store instructions and process data. The memory comprises a large array or group of words or bytes, each with its own location. The primary motive of a computer system is to execute programs. These programs, along with the information they access, should be in the main memory during execution. The CPU fetches instructions from memory according to the value of the program counter. 

To achieve a degree of multiprogramming and proper utilization of memory, memory management is important. Many memory management methods exist, reflecting various approaches, and the effectiveness of each algorithm depends on the situation.

> Here, we will cover the following memory management topics:                                          
> 
> - What is Main Memory?
> - What is Memory Management?
> - Why memory Management is required?
> - Logical address space and Physical address space
> - Static and dynamic loading
> - Static and dynamic linking
> - Swapping
> - Contiguous Memory allocation
>     - Memory Allocation
>         - First Fit
>         - Best Fit
>         - Worst Fit
>     - Fragmentation
>         - Internal Fragmentation
>         - External Fragmentation
>     - Paging

Now before, we start Memory Management let us know what is main memory.

## What is Main Memory?

The main memory is central to the operation of a Modern Computer. Main Memory is a large array of words or bytes, ranging in size from hundreds of thousands to billions. Main memory is a repository of rapidly available information shared by the CPU and I/O devices. Main memory is the place where programs and information are kept when the processor is effectively utilizing them.  Main memory is associated with the processor, so moving instructions and information into and out of the processor is extremely fast.  Main memory is also known as [RAM (Random Access Memory)](https://www.geeksforgeeks.org/random-access-memory-ram/). This memory is a volatile memory. RAM lost its data when a power interruption occurs.

![Main Memory](https://media.geeksforgeeks.org/wp-content/uploads/20221116104505/1white-660x453.png)

Main Memory

## What is Memory Management?

In a multiprogramming computer, the Operating System resides in a part of memory and the rest is used by multiple processes. The task of subdividing the memory among different processes is called Memory Management. Memory management is a method in the operating system to manage operations between main memory and disk during process execution. The main aim of memory management is to achieve efficient utilization of memory.  

## Why Memory Management is Required?

- Allocate and de-allocate memory before and after process execution.
- To keep track of used memory space by processes.
- To minimize fragmentation issues.
- To proper utilization of main memory.
- To maintain data integrity while executing of process.

Now we are discussing the concept of Logical Address Space and Physical Address Space

## Logical and Physical Address Space

- **Logical Address Space:** An address generated by the CPU is known as a “Logical Address”. It is also known as a Virtual address. Logical address space can be defined as the size of the process. A logical address can be changed.
- **Physical Address Space:** An address seen by the memory unit (i.e the one loaded into the memory address register of the memory) is commonly known as a “Physical Address”. A Physical address is also known as a Real address. The set of all physical addresses corresponding to these logical addresses is known as Physical address space. A physical address is computed by MMU. The run-time mapping from virtual to physical addresses is done by a hardware device Memory Management Unit(MMU). The physical address always remains constant.

## Static and Dynamic Loading

Loading a process into the main memory is done by a loader. There are two different types of loading :

- **Static Loading:** Static Loading is basically loading the entire program into a fixed address. It requires more memory space.
- **Dynamic Loading:** The entire program and all data of a process must be in physical memory for the process to execute. So, the size of a process is limited to the size of physical memory. To gain proper memory utilization, dynamic loading is used. In dynamic loading, a routine is not loaded until it is called. All routines are residing on disk in a relocatable load format. One of the advantages of dynamic loading is that the unused routine is never loaded. This loading is useful when a large amount of code is needed to handle it efficiently.

## Static and Dynamic Linking

To perform a linking task a linker is used. A linker is a program that takes one or more object files generated by a compiler and combines them into a single executable file. 

- **Static Linking:** In [static linking](https://www.geeksforgeeks.org/static-and-dynamic-linking-in-operating-systems/), the linker combines all necessary program modules into a single executable program. So there is no runtime dependency. Some operating systems support only static linking, in which system language libraries are treated like any other object module.
- **Dynamic Linking:** The basic concept of dynamic linking is similar to dynamic loading. In dynamic linking, “Stub” is included for each appropriate library routine reference. A stub is a small piece of code. When the stub is executed, it checks whether the needed routine is already in memory or not. If not available then the program loads the routine into memory.

## Swapping

When a process is executed it must have resided in memory. [Swapping](https://www.geeksforgeeks.org/swapping-in-operating-system/) is a process of swapping a process temporarily into a secondary memory from the main memory, which is fast compared to secondary memory. A swapping allows more processes to be run and can be fit into memory at one time. The main part of swapping is transferred time and the total time is directly proportional to the amount of memory swapped. Swapping is also known as roll-out, or roll because if a higher priority process arrives and wants service, the memory manager can swap out the lower priority process and then load and execute the higher priority process. After finishing higher priority work, the lower priority process swapped back in memory and continued to the execution process.  

![swapping in memory management](https://media.geeksforgeeks.org/wp-content/uploads/20221116104533/2white-660x441.png)

swapping in memory management

### **Memory Management with Monoprogramming (Without Swapping)**

This is the simplest memory management approach the memory is divided into two sections:

- One part of the operating system
- The second part of the user program

|**Fence Register**|   |
|---|---|
|operating system|user program|

- In this approach, the operating system keeps track of the first and last location available for the allocation of the user program
- The operating system is loaded either at the bottom or at top
- Interrupt vectors are often loaded in low memory therefore it makes sense to load the operating system in low memory
- Sharing of data and code does not make much sense in a single process environment
- The Operating system can be protected from user programs with the help of a fence register.

### **Advantages of Memory Management**

- It is a simple management approach

### **Disadvantages of Memory Management**

- It does not support multiprogramming
- Memory is wasted

### **Multiprogramming with Fixed Partitions (Without Swapping)**

- Memory partitions scheme with a fixed number of partitions was introduced to support multiprogramming. this scheme is based on contiguous allocation
- Each partition is a block of contiguous memory
- Memory is partitioned into a fixed number of partition
- Each partition is of fixed size

**Example:** As shown in fig. memory is partitioned into 5 regions the region is reserved for updating the system the remaining four partitions are for the user program

|operating system|
|---|
|p1|
|p2|
|p3|
|p4|

                                                                                                                                                         **Fixed Size Partitioning**

### **Partition Table**

Once partitions are defined operating system keeps track of the status of  memory partitions it is done through a data structure called a partition table

|**Starting Address of Partition**|**Size of Partition**|**Status**|
|---|---|---|
|0k|200k|allocated|
|200k|100k|free|
|300k|150k|free|
|450k|250k|allocated|

                                                                                                                                                        **Sample Partition Table**

### **Logical vs Physical Address**

An address generated by the CPU is commonly referred to as a logical address. the address seen by the memory unit is known as the physical address. The logical address can be mapped to a physical address by hardware with the help of a base register this is known as dynamic relocation of memory reference.

## **Contiguous  Memory Allocation**

The main memory should oblige both the operating system and the different client processes.  Therefore, the allocation of memory becomes an important task in the operating system.  The memory is usually divided into two partitions: one for the resident operating system and one for the user processes. We normally need several user processes to reside in memory simultaneously. Therefore, we need to consider how to allocate available memory to the processes that are in the input queue waiting to be brought into memory. In adjacent memory allotment, each process is contained in a single contiguous segment of memory.  

![Contiguous Memory Allocation](https://media.geeksforgeeks.org/wp-content/uploads/20221116104926/3white.png)

Contiguous Memory Allocation

## Memory Allocation

To gain proper memory utilization, memory allocation must be allocated efficient manner. One of the simplest methods for allocating memory is to divide memory into several fixed-sized partitions and each partition contains exactly one process. Thus, the degree of multiprogramming is obtained by the number of partitions. 

- **Multiple partition allocation:** In this method, a process is selected from the input queue and loaded into the free partition. When the process terminates, the partition becomes available for other processes. 
- **Fixed partition allocation:** In this method, the operating system maintains a table that indicates which parts of memory are available and which are occupied by processes. Initially, all memory is available for user processes and is considered one large block of available memory. This available memory is known as a “Hole”. When the process arrives and needs memory, we search for a hole that is large enough to store this process. If the requirement is fulfilled then we allocate memory to process, otherwise keeping the rest available to satisfy future requests. While allocating a memory sometimes dynamic storage allocation problems occur, which concerns how to satisfy a request of size n from a list of free holes. There are some solutions to this problem:

### **First Fit**

In the [First Fit](https://www.geeksforgeeks.org/first-fit-allocation-in-operating-systems/), the first available free hole fulfil the requirement of the process allocated. 

![First Fit](https://media.geeksforgeeks.org/wp-content/uploads/20200524132212/FIRST-FIT-300x225.png)

First Fit

Here, in this diagram, a 40 KB memory block is the first available free hole that can store process A (size of 25 KB), because the first two blocks did not have sufficient memory space.

### **Best Fit**

In the [Best Fit](https://www.geeksforgeeks.org/best-fit-allocation-in-operating-system/), allocate the smallest hole that is big enough to process requirements. For this, we search the entire list, unless the list is ordered by size. 

![Best Fit](https://media.geeksforgeeks.org/wp-content/uploads/20200524132547/BEST-FIT-300x225.png)

Best Fit

Here in this example, first, we traverse the complete list and find the last hole 25KB is the best suitable hole for Process A(size 25KB). In this method, memory utilization is maximum as compared to other memory allocation techniques.

### **Worst Fit** 

In the [Worst Fit](https://www.geeksforgeeks.org/worst-fit-allocation-in-operating-systems/), allocate the largest available hole to process. This method produces the largest leftover hole. 

![Worst Fit](https://media.geeksforgeeks.org/wp-content/uploads/20200524132634/WORST-FIT-300x225.png)

Worst Fit 

Here in this example, Process A (Size 25 KB) is allocated to the largest available memory block which is 60KB. Inefficient memory utilization is a major issue in the worst fit.

## Fragmentation

[Fragmentation](https://www.geeksforgeeks.org/fragmentation-network-layer/) is defined as when the process is loaded and removed after execution from memory, it creates a small free hole. These holes can not be assigned to new processes because holes are not combined or do not fulfill the memory requirement of the process.  To achieve a degree of multiprogramming, we must reduce the waste of memory or fragmentation problems. In the operating systems two types of fragmentation:

1. **Internal fragmentation:** [Internal fragmentation](https://www.geeksforgeeks.org/difference-between-internal-and-external-fragmentation/) occurs when memory blocks are allocated to the process more than their requested size. Due to this some unused space is left over and creating an internal fragmentation problem.**Example:** Suppose there is a fixed partitioning used for memory allocation and the different sizes of blocks 3MB, 6MB, and 7MB space in memory. Now a new process p4 of size 2MB comes and demands a block of memory. It gets a memory block of 3MB but 1MB block of memory is a waste, and it can not be allocated to other processes too. This is called internal fragmentation.
2. **External fragmentation:** In [External Fragmentation](https://www.geeksforgeeks.org/difference-between-internal-and-external-fragmentation/), we have a free memory block, but we can not assign it to a process because blocks are not contiguous. **Example:** Suppose (consider the above example) three processes p1, p2, and p3 come with sizes 2MB, 4MB, and 7MB respectively. Now they get memory blocks of size 3MB, 6MB, and 7MB allocated respectively. After allocating the process p1 process and the p2 process left 1MB and 2MB. Suppose a new process p4 comes and demands a 3MB block of memory, which is available, but we can not assign it because free memory space is not contiguous.  This is called external fragmentation.

Both the first-fit and best-fit systems for memory allocation are affected by external fragmentation. To overcome the external fragmentation problem Compaction is used. In the compaction technique, all free memory space combines and makes one large block. So, this space can be used by other processes effectively.

Another possible solution to the external fragmentation is to allow the logical address space of the processes to be noncontiguous, thus permitting a process to be allocated physical memory wherever the latter is available.

## Paging

[Paging](https://www.geeksforgeeks.org/paging-in-operating-system/) is a memory management scheme that eliminates the need for a contiguous allocation of physical memory. This scheme permits the physical address space of a process to be non-contiguous.

- **Logical Address or Virtual Address (represented in bits):** An address generated by the CPU
- **Logical Address Space or Virtual Address Space (represented in words or bytes):** The set of all logical addresses generated by a program
- **Physical Address (represented in bits):** An address actually available on a memory unit
- **Physical Address Space (represented in words or bytes):** The set of all physical addresses corresponding to the logical addresses

**Example:**

- If Logical Address = 31 bits, then Logical Address Space = 231 words = 2 G words (1 G = 230)
- If Logical Address Space = 128 M words = 27 * 220 words, then Logical Address = log2 227 = 27 bits
- If Physical Address = 22 bits, then Physical Address Space = 222 words = 4 M words (1 M = 220)
- If Physical Address Space = 16 M words = 24 * 220 words, then Physical Address = log2 224 = 24 bits

The mapping from virtual to physical address is done by the memory management unit (MMU) which is a hardware device and this mapping is known as the paging technique.

- The Physical Address Space is conceptually divided into several fixed-size blocks, called **frames**.
- The Logical Address Space is also split into fixed-size blocks, called **pages**.
- Page Size = Frame Size

Let us consider an example:

- Physical Address = 12 bits, then Physical Address Space = 4 K words
- Logical Address = 13 bits, then Logical Address Space = 8 K words
- Page size = frame size = 1 K words (assumption)

![Paging](https://media.geeksforgeeks.org/wp-content/uploads/paging.jpg)

Paging

The address generated by the CPU is divided into:

- **Page Number(p):** Number of bits required to represent the pages in Logical Address Space or Page number
- **Page Offset(d):** Number of bits required to represent a particular word in a page or page size of Logical Address Space or word number of a page or page offset.

Physical Address is divided into:

- **Frame Number(f):** Number of bits required to represent the frame of Physical Address Space or Frame number frame
- **Frame Offset(d):** Number of bits required to represent a particular word in a frame or frame size of Physical Address Space or word number of a frame or frame offset.

The hardware implementation of the page table can be done by using dedicated registers. But the usage of the register for the page table is satisfactory only if the page table is small. If the page table contains a large number of entries then we can use TLB(translation Look-aside buffer), a special, small, fast look-up hardware cache.

- The TLB is an associative, high-speed memory.
- Each entry in TLB consists of two parts: a tag and a value.
- When this memory is used, then an item is compared with all tags simultaneously. If the item is found, then the corresponding value is returned.

![Page Map Table](https://media.geeksforgeeks.org/wp-content/uploads/paging-2.jpg)

Page Map Table

Main memory access time = m
If page table are kept in main memory,
Effective access time = m(for page table) 
+ m(for particular page in page table)

![TLB Hit and Miss](https://media.geeksforgeeks.org/wp-content/uploads/paging-3.jpg)

TLB Hit and Miss

For more details, must-read [**Paging in Operating System**](https://www.geeksforgeeks.org/paging-in-operating-system/)

  

Last Updated : 17 Apr, 2023

93

Similar Reads

1.[Best Ways for Operating System Memory Management](https://www.geeksforgeeks.org/best-ways-for-operating-system-memory-management/ "Best Ways for Operating System Memory Management")

2.[Operating Systems | Memory Management | Question 1](https://www.geeksforgeeks.org/operating-systems-memory-management-question-1/ "Operating Systems | Memory Management | Question 1")

3.[Operating Systems | Memory Management | Question 2](https://www.geeksforgeeks.org/operating-systems-memory-management-question-2/ "Operating Systems | Memory Management | Question 2")

4.[Operating Systems | Memory Management | Question 10](https://www.geeksforgeeks.org/operating-systems-memory-management-question-3/ "Operating Systems | Memory Management | Question 10")

5.[Operating Systems | Memory Management | Question 4](https://www.geeksforgeeks.org/operating-systems-memory-management-question-4/ "Operating Systems | Memory Management | Question 4")

6.[Operating Systems | Memory Management | Question 5](https://www.geeksforgeeks.org/operating-systems-memory-management-question-5/ "Operating Systems | Memory Management | Question 5")

7.[Operating Systems | Memory Management | Question 6](https://www.geeksforgeeks.org/operating-systems-memory-management-question-6/ "Operating Systems | Memory Management | Question 6")

8.[Operating Systems | Memory Management | Question 10](https://www.geeksforgeeks.org/operating-systems-memory-management-question-7/ "Operating Systems | Memory Management | Question 10")

9.[Operating Systems | Memory Management | Question 8](https://www.geeksforgeeks.org/operating-systems-memory-management-question-8/ "Operating Systems | Memory Management | Question 8")

10.[Operating Systems | Memory Management | Question 9](https://www.geeksforgeeks.org/operating-systems-memory-management-question-9/ "Operating Systems | Memory Management | Question 9")

[Previous](https://www.geeksforgeeks.org/recovery-from-deadlock-in-operating-system/)

[Recovery from Deadlock in Operating System](https://www.geeksforgeeks.org/recovery-from-deadlock-in-operating-system/)

[Next](https://www.geeksforgeeks.org/implementation-of-contiguous-memory-management-techniques/)

[Implementation of Contiguous Memory Management Techniques](https://www.geeksforgeeks.org/implementation-of-contiguous-memory-management-techniques/)

Article Contributed By :

[

![https://media.geeksforgeeks.org/auth/avatar.png](https://media.geeksforgeeks.org/auth/avatar.png)



](https://auth.geeksforgeeks.org/user/varshachoudhary/articles?utm_source=geeksforgeeks&utm_medium=article_author&utm_campaign=auth_user)

[](https://auth.geeksforgeeks.org/user/varshachoudhary/articles?utm_source=geeksforgeeks&utm_medium=article_author&utm_campaign=auth_user)

[](https://auth.geeksforgeeks.org/user/varshachoudhary/articles?utm_source=geeksforgeeks&utm_medium=article_author&utm_campaign=auth_user)[varshachoudhary](https://auth.geeksforgeeks.org/user/varshachoudhary/articles?utm_source=geeksforgeeks&utm_medium=article_author&utm_campaign=auth_user)

[varshachoudhary](https://auth.geeksforgeeks.org/user/varshachoudhary/articles?utm_source=geeksforgeeks&utm_medium=article_author&utm_campaign=auth_user)

 Follow

Vote for difficulty

Current difficulty : [Medium](https://www.geeksforgeeks.org/medium/)

EasyNormalMediumHardExpert

Improved By :

- [ruhelaa48](https://auth.geeksforgeeks.org/user/ruhelaa48)
- [raghulgs33](https://auth.geeksforgeeks.org/user/raghulgs33)
- [kanikajoshi](https://auth.geeksforgeeks.org/user/kanikajoshi)
- [mitalibhola94](https://auth.geeksforgeeks.org/user/mitalibhola94)
- [alshifa2i41d](https://auth.geeksforgeeks.org/user/alshifa2i41d)
- [adityaarxehn](https://auth.geeksforgeeks.org/user/adityaarxehn)

Article Tags :

- [Operating Systems-Memory Management](https://www.geeksforgeeks.org/tag/operating-systems-memory-management/)
- [Operating Systems](https://www.geeksforgeeks.org/category/computer-subject/operating-systems/)

Practice Tags :

- [Operating Systems](https://practice.geeksforgeeks.org/explore?category[]=Operating)

Improve Article

Report Issue

Courses

[

![course-img](https://media.geeksforgeeks.org/img-practice/banner/mastering-system-design-low-level-to-high-level-solutions-thumbnail.webp?v=19548)

79k+ interested Geeks

#### Mastering System Design: From Low-Level to High-Level Solutions

Explore







](https://practice.geeksforgeeks.org/courses/mastering-system-design-low-level-to-high-level-solutions?utm_source=geeksforgeeks&utm_medium=right_sidebar&utm_campaign=course_card)

[

![course-img](https://media.geeksforgeeks.org/img-practice/banner/complete-interview-preparation-thumbnail.webp?v=19548)

826k+ interested Geeks

#### Complete Interview Preparation - Self Paced

Explore







](https://practice.geeksforgeeks.org/courses/complete-interview-preparation?utm_source=geeksforgeeks&utm_medium=right_sidebar&utm_campaign=course_card)

[

![course-img](https://media.geeksforgeeks.org/img-practice/banner/devops-live-thumbnail.webp?v=19548)

26k+ interested Geeks

#### DevOps Engineering - Planning to Production

Explore







](https://practice.geeksforgeeks.org/courses/devops-live?utm_source=geeksforgeeks&utm_medium=right_sidebar&utm_campaign=course_card)

[![geeksforgeeks-footer-logo](https://media.geeksforgeeks.org/auth-dashboard-uploads/gfgFooterLogoDark.png)](https://www.geeksforgeeks.org/)

A-143, 9th Floor, Sovereign Corporate Tower, Sector-136, Noida, Uttar Pradesh - 201305

[feedback@geeksforgeeks.org](mailto:feedback@geeksforgeeks.org)

[

](https://www.facebook.com/geeksforgeeks.org/)[

](https://www.instagram.com/geeks_for_geeks/)[

](https://in.linkedin.com/company/geeksforgeeks)[

](https://twitter.com/geeksforgeeks)[

](https://www.youtube.com/geeksforgeeksvideos)

[![GFG App on Play Store](https://media.geeksforgeeks.org/auth-dashboard-uploads/googleplay-%281%29.png)](https://geeksforgeeksapp.page.link/gfg-app)[![GFG App on App Store](https://media.geeksforgeeks.org/auth-dashboard-uploads/appstore-%281%29.png)](https://geeksforgeeksapp.page.link/gfg-app)

- Company
- [About Us](https://www.geeksforgeeks.org/about/)
- [Legal](https://www.geeksforgeeks.org/legal/)
- [Careers](https://geeksforgeeks.zohorecruit.in/careers)
- [In Media](https://www.geeksforgeeks.org/press-release/)
- [Contact Us](https://www.geeksforgeeks.org/about/contact-us/)
- [Advertise with us](https://www.geeksforgeeks.org/advertise-with-us/)

- Explore
- [Job-A-Thon For Freshers](https://practice.geeksforgeeks.org/contest/megajob-a-thon-hiring-challenge-freshers?utm_source=geeksforgeeks&utm_medium=footer&utm_campaign=megajobathon)
- [Job-A-Thon For Experienced](https://practice.geeksforgeeks.org/contest/mega-job-a-thon-hiring-challenge-for-experience?utm_source=geeksforgeeks&utm_medium=footer&utm_campaign=megajobathon)
- [GfG Weekly Contest](https://practice.geeksforgeeks.org/events/rec/gfg-weekly-coding-contest?utm_source=geeksforgeeks&utm_medium=footer&utm_campaign=gfgweekly)
- [Offline Classes (Delhi/NCR)](https://practice.geeksforgeeks.org/courses/category/all?courseType=offline)
- [DSA in JAVA/C++](https://practice.geeksforgeeks.org/courses/dsa-self-paced?utm_source=geeksforgeeks&utm_medium=footer&utm_campaign=course)
- [Master System Design](https://practice.geeksforgeeks.org/courses/mastering-system-design-low-level-to-high-level-solutions?utm_source=geeksforgeeks&utm_medium=footer&utm_campaign=course)
- [Master CP](https://practice.geeksforgeeks.org/courses/competitive-programming-cp?utm_source=geeksforgeeks&utm_medium=footer&utm_campaign=course)

- [Languages](https://www.geeksforgeeks.org/introduction-to-programming-languages/?ref=footer)
- [Python](https://www.geeksforgeeks.org/python-programming-language/?ref=footer)
- [Java](https://www.geeksforgeeks.org/java/?ref=footer)
- [C++](https://www.geeksforgeeks.org/c-plus-plus/?ref=footer)
- [PHP](https://www.geeksforgeeks.org/php-tutorials/?ref=footer)
- [GoLang](https://www.geeksforgeeks.org/golang/?ref=footer)
- [SQL](https://www.geeksforgeeks.org/sql-tutorial/?ref=footer)
- [R Language](https://www.geeksforgeeks.org/r-tutorial/?ref=footer)
- [Android Tutorial](https://www.geeksforgeeks.org/android-tutorial/?ref=footer)

- [Data Structures](https://www.geeksforgeeks.org/data-structures/?ref=footer)
- [Array](https://www.geeksforgeeks.org/array-data-structure/?ref=footer)
- [String](https://www.geeksforgeeks.org/string-data-structure/?ref=footer)
- [Linked List](https://www.geeksforgeeks.org/data-structures/linked-list/?ref=footer)
- [Stack](https://www.geeksforgeeks.org/stack-data-structure/?ref=footer)
- [Queue](https://www.geeksforgeeks.org/queue-data-structure/?ref=footer)
- [Tree](https://www.geeksforgeeks.org/introduction-to-tree-data-structure-and-algorithm-tutorials/?ref=footer)
- [Graph](https://www.geeksforgeeks.org/graph-data-structure-and-algorithms/?ref=footer)

- [Algorithms](https://www.geeksforgeeks.org/fundamentals-of-algorithms/?ref=footer)
- [Sorting](https://www.geeksforgeeks.org/sorting-algorithms/?ref=footer)
- [Searching](https://www.geeksforgeeks.org/searching-algorithms/?ref=footer)
- [Greedy](https://www.geeksforgeeks.org/greedy-algorithms/?ref=footer)
- [Dynamic Programming](https://www.geeksforgeeks.org/dynamic-programming/?ref=footer)
- [Pattern Searching](https://www.geeksforgeeks.org/algorithms-gq/pattern-searching/?ref=footer)
- [Recursion](https://www.geeksforgeeks.org/introduction-to-recursion-data-structure-and-algorithm-tutorials/?ref=footer)
- [Backtracking](https://www.geeksforgeeks.org/backtracking-algorithms/?ref=footer)

- [Web Development](https://www.geeksforgeeks.org/web-development/?ref=footer)
- [HTML](https://www.geeksforgeeks.org/html/?ref=footer)
- [CSS](https://www.geeksforgeeks.org/css/?ref=footer)
- [JavaScript](https://www.geeksforgeeks.org/learn-javascript-js-roadmap-for-beginners/?ref=footer)
- [Bootstrap](https://www.geeksforgeeks.org/bootstrap/?ref=footer)
- [ReactJS](https://www.geeksforgeeks.org/learn-reactjs/?ref=footer)
- [AngularJS](https://www.geeksforgeeks.org/angularjs/?ref=footer)
- [NodeJS](https://www.geeksforgeeks.org/nodejs/?ref=footer)

- [Computer Science](https://www.geeksforgeeks.org/gate-cs-notes-gq/?ref=footer)
- [GATE CS Notes](https://www.geeksforgeeks.org/gate-cs-notes-gq/?ref=footer)
- [Operating Systems](https://www.geeksforgeeks.org/operating-systems/?ref=footer)
- [Computer Network](https://www.geeksforgeeks.org/computer-network-tutorials/?ref=footer)
- [Database Management System](https://www.geeksforgeeks.org/dbms/?ref=footer)
- [Software Engineering](https://www.geeksforgeeks.org/software-engineering/?ref=footer)
- [Digital Logic Design](https://www.geeksforgeeks.org/digital-electronics-logic-design-tutorials/?ref=footer)
- [Engineering Maths](https://www.geeksforgeeks.org/engineering-mathematics-tutorials/?ref=footer)

- [Python](https://www.geeksforgeeks.org/python-programming-language/?ref=footer)
- [Python Programming Examples](https://www.geeksforgeeks.org/python-programming-examples/?ref=footer)
- [Django Tutorial](https://www.geeksforgeeks.org/django-tutorial/?ref=footer)
- [Python Projects](https://www.geeksforgeeks.org/python-projects-beginner-to-advanced/?ref=footer)
- [Python Tkinter](https://www.geeksforgeeks.org/python-tkinter-tutorial/?ref=footer)
- [OpenCV Python Tutorial](https://www.geeksforgeeks.org/opencv-python-tutorial/?ref=footer)
- [Python Interview Question](https://www.geeksforgeeks.org/python-interview-questions/?ref=footer)

- Data Science & ML
- [Data Science With Python](https://www.geeksforgeeks.org/data-science-tutorial/?ref=footer)
- [Data Science For Beginner](https://www.geeksforgeeks.org/data-science-for-beginners/?ref=footer)
- [Machine Learning Tutorial](https://www.geeksforgeeks.org/machine-learning/?ref=footer)
- [Maths For Machine Learning](https://www.geeksforgeeks.org/machine-learning-mathematics/?ref=footer)
- [Pandas Tutorial](https://www.geeksforgeeks.org/pandas-tutorial/?ref=footer)
- [NumPy Tutorial](https://www.geeksforgeeks.org/numpy-tutorial/?ref=footer)
- [NLP Tutorial](https://www.geeksforgeeks.org/natural-language-processing-nlp-tutorial/?ref=footer)
- [Deep Learning Tutorial](https://www.geeksforgeeks.org/deep-learning-tutorial/?ref=footer)

- [DevOps](https://www.geeksforgeeks.org/devops-tutorial/?ref=footer)
- [Git](https://www.geeksforgeeks.org/git-tutorial/?ref=footer)
- [AWS](https://www.geeksforgeeks.org/aws-tutorial/?ref=footer)
- [Docker](https://www.geeksforgeeks.org/docker-tutorial/?ref=footer)
- [Kubernetes](https://www.geeksforgeeks.org/kubernetes-tutorial/?ref=footer)
- [Azure](https://www.geeksforgeeks.org/microsoft-azure/?ref=footer)
- [GCP](https://www.geeksforgeeks.org/google-cloud-platform-tutorial/?ref=footer)

- [Competitive Programming](https://www.geeksforgeeks.org/competitive-programming-a-complete-guide/?ref=footer)
- [Top DSA for CP](https://www.geeksforgeeks.org/top-algorithms-and-data-structures-for-competitive-programming/?ref=footer)
- [Top 50 Tree Problems](https://www.geeksforgeeks.org/top-50-tree-coding-problems-for-interviews?ref=footer)
- [Top 50 Graph Problems](https://www.geeksforgeeks.org/top-50-graph-coding-problems-for-interviews/?ref=footer)
- [Top 50 Array Problems](https://www.geeksforgeeks.org/top-50-array-coding-problems-for-interviews/?ref=footer)
- [Top 50 String Problems](https://www.geeksforgeeks.org/top-50-string-coding-problems-for-interviews/?ref=footer)
- [Top 50 DP Problems](https://www.geeksforgeeks.org/top-50-dynamic-programming-coding-problems-for-interviews/?ref=footer)
- [Top 15 Websites for CP](https://www.geeksforgeeks.org/top-15-websites-for-coding-challenges-and-competitions/?ref=footer)

- [System Design](https://www.geeksforgeeks.org/system-design-tutorial/?ref=footer)
- [What is System Design](https://www.geeksforgeeks.org/what-is-system-design-learn-system-design/?ref=footer)
- [Monolithic and Distributed SD](https://www.geeksforgeeks.org/analysis-of-monolithic-and-distributed-systems-learn-system-design/?ref=footer)
- [Scalability in SD](https://www.geeksforgeeks.org/what-is-scalability-and-how-to-achieve-it-learn-system-design/?ref=footer)
- [Databases in SD](https://www.geeksforgeeks.org/complete-reference-to-databases-in-designing-systems/?ref=footer)
- [High Level Design or HLD](https://www.geeksforgeeks.org/what-is-high-level-design-learn-system-design/?ref=footer)
- [Low Level Design or LLD](https://www.geeksforgeeks.org/what-is-low-level-design-or-lld-learn-system-design/?ref=footer)
- [Top SD Interview Questions](https://www.geeksforgeeks.org/top-10-system-design-interview-questions-and-answers/?ref=footer)

- [Interview Corner](https://www.geeksforgeeks.org/company-interview-corner/?ref=footer)
- [Company Wise Preparation](https://www.geeksforgeeks.org/company-preparation/?ref=footer)
- [Preparation for SDE](https://www.geeksforgeeks.org/interview-preparation-for-software-developer/?ref=footer)
- [Experienced Interviews](https://www.geeksforgeeks.org/experienced-interview-experiences-company-wise/?ref=footer)
- [Internship Interviews](https://www.geeksforgeeks.org/internship-interview-experiences-company-wise/?ref=footer)
- [Competitive Programming](https://www.geeksforgeeks.org/competitive-programming-a-complete-guide/?ref=footer)
- [Aptitude Preparation](https://www.geeksforgeeks.org/aptitude-questions-and-answers/?ref=footer)

- [GfG School](https://www.geeksforgeeks.org/geeksforgeeks-school/?ref=footer)
- [CBSE Notes for Class 8](https://www.geeksforgeeks.org/cbse-notes-for-class-8/?ref=footer)
- [CBSE Notes for Class 9](https://www.geeksforgeeks.org/cbse-notes-for-class-9/?ref=footer)
- [CBSE Notes for Class 10](https://www.geeksforgeeks.org/cbse-class-10-revision-notes/?ref=footer)
- [CBSE Notes for Class 11](https://www.geeksforgeeks.org/cbse-class-11-revision-notes/?ref=footer)
- [CBSE Notes for Class 12](https://www.geeksforgeeks.org/cbse-class-12-revision-notes/?ref=footer)
- [English Grammar](https://www.geeksforgeeks.org/english-grammar/?ref=footer)

- [Commerce](https://www.geeksforgeeks.org/commerce/?ref=footer)
- [Accountancy](https://www.geeksforgeeks.org/accountancy/?ref=footer)
- [Business Studies](https://www.geeksforgeeks.org/business-studies/?ref=footer)
- [Economics](https://www.geeksforgeeks.org/economics/?ref=footer)
- [Management](https://www.geeksforgeeks.org/management/?ref=footer)
- [Income Tax](https://www.geeksforgeeks.org/income-tax/?ref=footer)
- [Finance](https://www.geeksforgeeks.org/finance/?ref=footer)

- UPSC
- [Polity Notes](https://www.geeksforgeeks.org/important-topics-in-polity-for-upsc/?ref=footer)
- [Geography Notes](https://www.geeksforgeeks.org/important-topics-of-geography-for-upsc/?ref=footer)
- [History Notes](https://www.geeksforgeeks.org/history-notes-for-upsc-exam/?ref=footer)
- [Science and Technology Notes](https://www.geeksforgeeks.org/important-topics-of-science-and-technology-for-upsc/?ref=footer)
- [Economics Notes](https://www.geeksforgeeks.org/indian-economy-notes-upsc/?ref=footer)
- [Important Topics in Ethics](https://www.geeksforgeeks.org/important-topics-in-ethics-for-upsc/?ref=footer)
- [UPSC Previous Year Papers](https://www.geeksforgeeks.org/upsc-previous-year-question-paper-solutions/?ref=footer)

- SSC/ BANKING
- [SSC CGL Syllabus](https://www.geeksforgeeks.org/ssc-cgl-syllabus-2022/?ref=footer)
- [SBI PO Syllabus](https://www.geeksforgeeks.org/sbi-po-syllabus-2023/?ref=footer)
- [SBI Clerk Syllabus](https://www.geeksforgeeks.org/sbi-clerk-syllabus-2022/?ref=footer)
- [IBPS PO Syllabus](https://www.geeksforgeeks.org/syllabus-of-ibps-po-2022/?ref=footer)
- [IBPS Clerk Syllabus](https://www.geeksforgeeks.org/detailed-syllabus-of-ibps-clerk/?ref=footer)
- [Aptitude Questions](https://www.geeksforgeeks.org/aptitude-questions-and-answers/?ref=footer)
- [SSC CGL Practice Papers](https://www.geeksforgeeks.org/ssc-cgl-practice-papers/?ref=footer)

- Write & Earn
- [Write an Article](https://write.geeksforgeeks.org/?ref=footer)
- [Improve an Article](https://www.geeksforgeeks.org/how-to-improve-an-article/)
- [Pick Topics to Write](https://write.geeksforgeeks.org/pick-article/?ref=footer)
- [Write Interview Experience](https://www.geeksforgeeks.org/write-interview-experience/?ref=footer)
- [Internships](https://write.geeksforgeeks.org/internship/?ref=footer)
- [Video Internship](https://script.geeksforgeeks.org/on-boarding/youtube?ref=footer)

[@geeksforgeeks](https://www.geeksforgeeks.org/) , [Some rights reserved](https://www.geeksforgeeks.org/copyright-information/)

![Lightbox](https://media.geeksforgeeks.org/wp-content/uploads/paging-2.jpg)