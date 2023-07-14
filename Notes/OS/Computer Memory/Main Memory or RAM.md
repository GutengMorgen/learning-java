# RAM
the **RAM** (Random Access Memory) or **Main Memory**, that is responsible for storing the information the computer is working with and the programs it is running.

Main memory consists of a very long list of bytes (groups of 8 [[Bits, Bytes and Words|bits]]). When the computer’s power is on, every byte contains some pattern or other, even those bytes not being used for anything. each byte has an **address** that is used to locate it.

These addresses, like everything a computer works with, are just binary numbers themselves, but **when humans have to deal with these addresses, they are usually displayed as hexadecimal values.**

![figure 1](https://www.maketecheasier.com/assets/uploads/2018/12/hexadecimal-decimal-binary-equivalent-values.png)

The _only_ thing that can be stored at one memory location is eight bits, each with a value of 0 or 1. **The bits at a memory location are called the _contents_ of that location.**

![figure 2](https://programmedlessons.org/Java9/chap03/Figure3-2.gif)

The information that a particular pattern represents depends on its context (how a program is using it.) You cannot look at an arbitrary bit pattern (such as those in the picture) and say what it represents.

The processor can only do two fundamental things with main memory:

- It can write to a byte at a given memory location. The previous bit pattern in that location will be destroyed.
- It can read a byte from a given location. The processor gets the bit pattern stored at that location and the contents of that location are NOT changed.


# Hard Disk
The hard disk of a computer system records bytes on a magnetic surface much like the surface of audio tape. **The recording (writing) and reading of the data is done with a _read/write head_ similar to that used with audio tape.**

The arm moves in and out along a radius of the disk. Since the disk is rotating it will record data in a circular track on the disk. Later on, *to read the data, it must be moved to the right position, then it must wait until the rotating disk brings the data into position.* Just as with audio tape, data can be read without changing it. When new data it recorded, it replaces any data that was previously recorded at that location.

Since the operation of **a hard disk involves mechanical motion (which is much slower than electronic processes), reading and writing data is much slower than with main memory.**


