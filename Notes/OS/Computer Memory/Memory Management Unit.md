A memory management unit (MMU) is a computer hardware component that **handles all memory and caching operations associated with the processor**. In other words, the MMU is responsible for all aspects of memory management.

**Memory management at the hardware level.**
Memory management at the hardware level is concerned with the physical components that store data, most notably the [[Memory Hierarchy#RAM|RAM]] chips and CPU [[Memory Hierarchy#Cache|memory caches]]. Most of the management that occurs at the physical level is handled by the memory management unit (MMU), which controls the processor's memory and caching operations. **One of the MMU's most important roles is to translate the logical addresses used by the running processes to the physical addresses on the memory devices.**

The MMU also includes a section of memory that holds a table that matches virtual addresses to physical addresses, called the translation lookaside buffer (TLB).
TLB

# Physical Address
A physical address is the actual address in main memory where data is stored. *It is a location in physical memory such as RAM, ROM, SSD, or hard drive.* **Physical addresses are used by the memory management unit (MMU)** to translate logical addresses into physical addresses.

The translation from logical addresses to physical addresses is performed by the MMU. The MMU uses techniques like paging or segmentation, and a page table or segment table to map logical addresses to physical addresses.

## Physical Address space
the physical address space **refers to the size or capacity of the main memory** in a computer system.

# Logical Address (Virtual Address)
A logical address, also known as a virtual address, **is an address generated by the CPU during program/process execution.** It is the address seen by the process and is relative to the program’s address space.

**The logical address must be mapped to the physical address by MMU before they are used.**

## Logical Address Space
The logical address space represents the total range of logical addresses that a program or process can utilize.
The term Logical Address Space is used for the set of all logical addresses generated by a program’s perspective. The logical address space is **determined by the size of the process or program.**

In other words, **the logical address is a specific address value that identifies a location in the virtual memory**, while **the logical address space defines the entire range of possible addresses that a program or process can use** within its own memory context.

|Parameter|LOGICAL ADDRESS|PHYSICAL ADDRESS|
|---|---|---|
|Address Space|Logical Address Space is set of all logical addresses generated by CPU in reference to a program.|Physical Address is set of all physical addresses mapped to the corresponding logical addresses.|
|Visibility|User can view the logical address of a program.|User can never view physical address of program.|
|Generation|**generated by the CPU**|**Computed by MMU**|
|Editable|Logical address can be change.|Physical address will not change.|

![figure 1](https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fi.pinimg.com%2Foriginals%2F93%2F1e%2F40%2F931e4024c754d456a1e88b98d0066549.png&f=1&nofb=1&ipt=0d5522be2620b053785f58322fa13d74e3e4b7d6edd043ef884a40f67e8aefd6&ipo=images)

# Address Spaces
address space refers to **the range of valid memory addresses available to a program or process.** The number of bytes that can be addressed is determined by the size of the address space, and **each memory address in a system refers to a specific byte of memory**. The size of a byte (8 bits) is fixed and does not change based on the address space of a system.

The size of an address space refers to the total number of unique addresses that can be referenced by a system or process. **The size of an address space is determined by the computer architecture being used and the number of bits used for addressing.**

In the context of physical memory, the address space represents the range of memory addresses that can be accessed by the system. For example, in a 32-bit system, the address space is 2^32, which means there are 2^32 unique memory addresses. **Since each memory address refers to a single byte, the maximum number of bytes that can be addressed in a 32-bit system is also 2^32 bytes.**

# Address Translation


# Resources
- [techtarget](https://www.techtarget.com/whatis/definition/memory-management)
- [techopedia](https://www.techopedia.com/definition/4768/memory-management-unit-mmu)
- [geeksforgeeks](https://www.geeksforgeeks.org/logical-and-physical-address-in-operating-system/)
- [techtarget](https://www.techtarget.com/whatis/definition/memory-management-unit-MMU)
- [javatpoint](https://www.javatpoint.com/os-physical-and-logical-address-space)
- [wikipedia](https://en.wikipedia.org/wiki/Physical_address)
- [runestone](https://runestone.academy/ns/books/published/welcomecs/OperatingSystems/VirtualMemory.html)
- 