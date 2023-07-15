# Techniques

## Contiguous memory allocation
Also know as Single contiguous allocation

In this technique, memory is allotted in a continuous way to the processes. It has two types: fixed partition scheme and variable partition scheme

### Fixed partition scheme
In this technique, *the main memory is divided into partitions of equal or different sizes.* **The operating system always resides in the first partition while the other partitions can be used to store user processes.** The memory is assigned to the processes in contiguous way.

In the fixed partition scheme, **memory is divided into fixed number of partitions.** 

**Fixed means number of partitions are fixed in the memory.** In the fixed partition, in every partition only one process will be accommodated. 

Degree of multi-programming is restricted by number of partitions in the memory. **Maximum size of the process is restricted by maximum size of the partition.** Every partition is associated with the _limit registers_.

- The partitions cannot overlap.
- A process must be contiguously present in a partition for the execution.

- **Limit Registers:** It has two limit:
	- **Lower Limit:** Starting address of the partition.
	- **Upper Limit:** Ending address of the partition.

![figure 2](https://media.geeksforgeeks.org/wp-content/uploads/20200413104221/pp216.png)

#### Internal Fragmentation

If the size of the process is lesser then the total size of the partition then some size of the partition get wasted and remain unused. This is wastage of the memory and called internal fragmentation.

As shown in the image below, the 4 MB partition is used to load only 3 MB process and the remaining 1 MB got wasted.

#### External Fragmentation

The total unused space of various partitions cannot be used to load the processes even though there is space available but not in the contiguous form.

As shown in the image below, the remaining 1 MB space of each partition cannot be used as a unit to store a 4 MB process. Despite of the fact that the sufficient space is available to load the process, process will not be loaded.

#### Limitation on the size of the process

If the process size is larger than the size of maximum sized partition then that process cannot be loaded into the memory. Therefore, a limitation can be imposed on the process size that is it cannot be larger than the size of the largest partition.

#### Degree of multiprogramming is less

By Degree of multi programming, we simply mean the maximum number of processes that can be loaded into the memory at the same time. In fixed partitioning, the degree of multiprogramming is fixed and very less due to the fact that the size of the partition cannot be varied according to the size of processes.

![figure 3](https://static.javatpoint.com/operating-system/images/os-fixed-partitioning.png)

[geeksforgeeks](https://www.geeksforgeeks.org/fixed-or-static-partitioning-in-operating-system/) [javatpoint](https://www.javatpoint.com/os-fixed-partitioning) 

### Variable partition scheme
In this technique, **the partition size is not declared initially. It is declared at the time of process loading.**

**The first partition is reserved for the operating system.** The remaining space is divided into parts. **The size of each partition will be equal to the size of the process.** The partition size varies according to the need of the process so that the internal fragmentation can be avoided.

![figure 4](https://static.javatpoint.com/operating-system/images/os-dynamic-partitioning.png)


In the variable partition scheme, **initially memory will be single continuous free block.** 

**Whenever the request by the process arrives, accordingly partition will be made in the memory.** If the smaller processes keep on coming then the larger partitions will be made into smaller partitions.

![figure 3](https://media.geeksforgeeks.org/wp-content/uploads/20200413104252/pp312.png)

#### Advantages
##### No Internal Fragmentation
The partitions in dynamic partitioning are created according to the need of the process, so there will not be any internal fragmentation.

##### No Limitation on the size of the process
In Fixed partitioning, the process with the size greater than the size of the largest partition could not be executed due to the lack of sufficient contiguous memory. *In Dynamic partitioning, the process size can't be restricted since the partition size is decided according to the process size.*

##### Degree of multiprogramming is dynamic
Due to the absence of internal fragmentation, *there will not be any unused space in the partition hence more processes can be loaded in the memory at the same time.*

#### Disadvantages
##### External Fragmentation
Absence of internal fragmentation doesn't mean that there will not be external fragmentation.

Let's consider three processes P1 (1 MB) and P2 (3 MB) and P3 (1 MB) are being loaded in the respective partitions of the main memory.

After some time **P1 and P3 got completed and their assigned space is freed**. Now there are two unused partitions (1 MB and 1 MB) available in the main memory but **they cannot be used to load a 2 MB process in the memory** since **they are not contiguously** located.

The rule says that the process must be contiguously present in the main memory to get executed. We need to change this rule to avoid external fragmentation.

  
![os Dynamic Partitioning External Fragmentation](https://static.javatpoint.com/operating-system/images/os-dynamic-partitioning-external-fragmentation.png)  

##### Complex Memory Allocation
In Fixed partitioning, the list of partitions is made once and will never change but **in dynamic partitioning, the allocation and deallocation** is very complex since the partition size **will be varied every time when it is assigned to a new process.** 

**OS has to keep track of all the partitions.**

Due to the fact that the allocation and deallocation are done very frequently in dynamic memory allocation and the partition size will be changed at each time, it is going to be very difficult for OS to manage everything.


[javatpoint](https://www.javatpoint.com/os-dynamic-partitioning)

### Frist Fit
In the first available free hole fulfil the requirement of the process allocated.

### Best Fit
In the Best Fit, allocate the smallest hole that is big enough to process requirements. For this, we search the entire list, unless the list is ordered by size.

### Worst Fit
In the [Worst Fit](https://www.geeksforgeeks.org/worst-fit-allocation-in-operating-systems/), allocate the largest available hole to process. This method produces the largest leftover hole.

### Next Fit

## No-Contiguous memory allocation

### Paging
[Paging](https://www.geeksforgeeks.org/paging-in-operating-system/) is a memory management scheme that eliminates the need for a contiguous allocation of physical memory. This scheme permits the physical address space of a process to be non-contiguous.

### Page Tables
 a page table is a data structure used by a virtual memory system in an operating system to store the mapping between virtual addresses and physical addresses. It plays a crucial role in the virtual address translation process, allowing the operating system to access the correct data in memory. Page tables are used in paging, a memory management technique that improves memory utilization, enables memory allocation on demand, and facilitates memory protection and sharing. However, paging can also lead to external fragmentation and involves overhead in maintaining the page table and translating addresses.

### Page Replacement Algorithms
#### First in First out
This is the simplest page replacement algorithm. In this algorithm, the operating system keeps track of all pages in the memory in a queue, the oldest page is in the front of the queue. When a page needs to be replaced page in the front of the queue is selected for removal.

#### Optimal Page replacement
In this algorithm, pages are replaced which would not be used for the longest duration of time in the future.

#### **Least Recently Used**
In this algorithm, page will be replaced which is least recently used.

#### **Most Recently Used (MRU)**
In this algorithm, page will be replaced which has been used recently. Belady’s anomaly can occur in this algorithm.

### Multilevel paging
In multilevel paging whatever may be levels of paging, all the page tables will be stored in the main memory. So it requires more than one memory access to get the physical address of the page frame. One access for each level is needed. Each page table entry **except** the last level page table entry contains the base address of the next level page table.

### Inverted paging
An alternate approach is to use the **Inverted Page Table** structure that consists of a one-page table entry for every frame of the main memory. So the number of page table entries in the Inverted Page Table reduces to the number of frames in physical memory and a single page table is used to represent the paging information of all the processes. Through the inverted page table, the overhead of storing an individual page table for every process gets eliminated and only a fixed portion of memory is required to store the paging information of all the processes together. This technique is called inverted paging as the indexing is done with respect to the frame number instead of the logical page number. Each entry in the page table contains the following fields.

### Segmentation
A process is divided into Segments. The chunks that a program is divided into which are not necessarily all of the same sizes are called segments. Segmentation gives the user’s view of the process which paging does not give. Here the user’s view is mapped to physical memory. There are types of segmentation:

1. **Virtual memory segmentation –** Each process is divided into a number of segments, but the segmentation is not done all at once. This segmentation may or may not take place at run time of the program.
2. **Simple segmentation –** Each process is divided into a number of segments, all of which are loaded into memory at run time, though not necessarily contiguously.

There is no simple relationship between logical addresses and physical addresses in segmentation. A table stores the information about all such segments and is called Segment Table.

### Segmented paging
Segmented paging is a memory management technique that combines segmentation and paging to leverage the benefits of both approaches [[0]](https://www.javatpoint.com/os-segmented-paging). In segmented paging, the main memory is divided into variable-sized segments, which are further divided into fixed-sized pages [[0]](https://www.javatpoint.com/os-segmented-paging).

The advantages of segmented paging include the reduction of memory usage and simplified memory allocation [[2]](https://www.baeldung.com/cs/segmented-paging-vs-paged-segmentation). Since segmented paging allocates fixed-size pages, it avoids external fragmentation and simplifies memory allocation [[2]](https://www.baeldung.com/cs/segmented-paging-vs-paged-segmentation). Additionally, the segment table has only one entry corresponding to one actual segment, reducing the size of the segment table [[2]](https://www.baeldung.com/cs/segmented-paging-vs-paged-segmentation).

# Resources
- [geeksforgeeks](https://www.geeksforgeeks.org/segmentation-in-operating-system/)
- [geekforgeeks](https://www.geeksforgeeks.org/page-replacement-algorithms-in-operating-systems/)
- [geeksforgeeks](https://www.geeksforgeeks.org/multilevel-paging-in-operating-system/)
- [geeksforgeeks](https://www.geeksforgeeks.org/inverted-page-table-in-operating-system/)
- [javatpoint](https://www.javatpoint.com/os-compaction)
- [javatpoint](https://www.javatpoint.com/operating-system)
- 