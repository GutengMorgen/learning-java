Real-world constraints force computer engineers to use multiple different technologies, using each for the kind of thing it is best suited for. These different technologies form the **memory hierarchy** - a series of layers from small and fast to large and slow.

# Types of Memory Hierarchy

- **Primary Memory (Internal Memory):** Primary memory is the computer memory that is directly accessible by Proccessor/CPU. It is comprised of DRAM and provides the actual working space to the processor. It holds the data and instructions that the processor is currently working on.
- **Secondary Memory (External Memory):** The contents of the secondary memory first get transferred to the primary memory and then are accessed by the processor, this is because the processor does not directly interact with the secondary memory.

|Primary memory|Secondary memory|
|---|---|
|Primary memory is temporary.|Secondary memory is permanent.|
|Nature of Parts of Primary memory varies, **RAM- volatile** in nature. **ROM- Non-volatile.**|It’s **always Non-volatile** in nature.|
|Primary memory is also known as Main memory or Internal memory.|Secondary memory is also known as External memory or Auxiliary memory.|
|Examples: RAM, ROM, Cache memory, PROM, EPROM, Registers, etc.|Examples: Hard Disk, Floppy Disk, Magnetic Tapes, etc.|

![figure 2](https://runestone.academy/ns/books/published/welcomecs/_images/Memory-Hierarchy.jpg)

# Memory Hierarchy Design

## Primary Memory (Internal Memory)

Primary memory is situated close to the CPU on the computer motherboard. **It helps and enables the Central Processing Unit to read data from primary memory instantaneously.** It is utilised to store the data that the CPU needs immediately so that there is not necessity to wait for it to be delivered.

### CPU
#### Register
The small memory location on the CPU itself. *Because the memory is right on the CPU*, and because of the way it is engineered, *it provides basically instant access to the information it contains.* **At any time, only the most important set of information (current instruction and a few pieces of data) is in the registers.**

#### Cache
*It maintains a copy of parts of main memory, allowing quicker access to some information.* **Cache memory is designed to minimize the time it takes to access data by providing the CPU** with quick access to frequently used data... the cache doesn’t really exist… we always request information from main memory (RAM). *The cache just makes it so that sometimes those memory requests come back extra fast.*

### RAM
Main Memory (aka. RAM | Volatile | Physical Memory)
It generally runs significantly slower than the CPU - oftentimes hundreds of times slower.
Main memory is used to store data and instructions that are currently in use by the CPU.

There are two types of Main Memory: **SRAM and DRAM**. They are both volatile memories used as primary storage on embedded systems. **But each has its place in microcontroller design.** The main difference between them comes from their speed/cost tradeoffs.

#### SRAM
SRAM (Static Random Access Memory) It stores the binary information in flip flops and information remains valid until power is supplied. **It has a faster access time and is used in implementing cache memory.**
**Approximately 4 times faster** than the DRAM and it needs more transistors per bit of data

#### DRAM
DRAM (Dinamyc Random Access Memory) The **data stored in this RAM needs to be refreshed every few milliseconds or else it will end up being erased**. Yes even if the power is being applied continuously the data still needs to be refreshed. This action is taken care of by a special device named **DRAM controllers.** *It contains more memory cells per unit area as compared to SRAM.*

### ROM
The main characteristic of this device is the fact that **the data is written onto the device as it gets manufactured** and it is impossible to change them. This is done by designing the chip in such a manner so that it already contains the necessary data.

#### PROM
**Programming Read-Only Memory** is manufactured in an empty state and then programmed later using a PROM programmer or burner. It is different from ROM in that, **ROM is programmed during the manufacturing process** and these are programmable chips, the main characteristic being it can **only be programmed one time**.
 
#### EPROM
**Erasable Programmable Read-Only Memory** Data stored in an EPROM can be erased and reprogrammed. Erasing an EPROM includes removing it from the computer and exposing it to ultraviolet light before re-burning it. These chips usually **have a small glass window on top and if you expose them to direct sunlight that will erase the chip’s data.** They can then be programmed again with fresh data.

#### EEPROM
**Electrically Erasable Programmable Read-Only Memory**. These chips can be **erased and reprogrammed using electricity** as opposed to exposing them to UV rays as EPROMs.

## Secondary Memory (Internal Memory)

Secondary memory is the general term for things like solid-state drives, hard drives, CD drives, flash drives, etc… that can store information long term. **Not only can they retain information without power, they also generally provide better density** - you can store more information in less space and with less cost. Unfortunately, they are all slower than main memory. *Information stored in secondary memory must be loaded into main memory (RAM) before the processor can access it* - when you wait for a program to start up, **a big part of what you are waiting on is the needed information to be transferred from a slower hard drive to the fast RAM** that the processor can talk to.

### Magnetic Disk
Magnetic Disks are simply circular plates that are fabricated with either a metal or a plastic or a magnetized material. **The Magnetic disks work at a high speed inside the computer and these are frequently used.**

### Magnetic Tape
Magnetic Tape is simply a magnetic recording device that is covered with a plastic film. **It is generally used for the backup of data.** In the case of a magnetic tape, the access time for a computer is a little slower and therefore, it requires some amount of time for accessing the strip.

![figure 3](https://www.includehelp.com/operating-systems/images/memory.jpg)

![figure 4](https://image.slidesharecdn.com/functionofmemory-4to5-130326085843-phpapp02/75/function-of-memory4to5-9-2048.jpg?cb=1669149609)

# System-Supported Memory Standards   
According to the memory Hierarchy, the system-supported memory standards are defined below:

|Level|1|2|3|4|
|---|---|---|---|---|
|**Name**|Register|Cache|Main Memory|Secondary Memory|
|**Size**|<1 KB|less than 16 MB|<16GB|>100 GB|
|**Implementation**|Multi-ports|On-chip/SRAM|DRAM (capacitor memory)|Magnetic|
|**Access Time**|0.25ns to 0.5ns|0.5 to 25ns|80ns  to 250ns|50 lakh ns|
|**Bandwidth**|20000 to 1 lakh MB|5000 to 15000|1000 to 5000|20 to 150|
|**Managed by**|Compiler|Hardware|Operating System|Operating System|
|**Backing Mechanism**|From cache|from Main Memory|from Secondary Memory|from ie|

# Resources
- [Runestone](https://runestone.academy/ns/books/published/welcomecs/ComputerArchitecture/MemoryHeirarchy.html)
- [geeksforgeeks](https://www.geeksforgeeks.org/difference-between-primary-and-secondary-memory/)
- [geeksforgeeks 2](https://www.geeksforgeeks.org/memory-hierarchy-design-and-its-characteristics/)
- [embeddedinventor](https://embeddedinventor.com/8-types-of-memory-every-embedded-engineer-should-know-about/)
- [geeksforgeeks 3](https://www.geeksforgeeks.org/levels-of-memory-in-operating-system/)
- [smartzworld](https://www.smartzworld.com/notes/computer-architecture-and-organization-pdf-notes-cao-pdf/)
- [slideshare](https://www.slideshare.net/myrajendra/function-of-memory4to5)
- [slideshare 2](https://www.slideshare.net/krishnabharati940/krishna-44058149#)
- 