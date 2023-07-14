# Bits
**A bit is a single _on/off_ value. Only these two values are possible.** information is stored as patterns of bits

The implementation of bits is different in [[Main Memory or RAM|main memory]] and [[Memory Hierarchy|secondary memory]], but logically, both types of memory store information represented as bit patterns.

**Information stored in binary form does not change when it is copied from one medium to another.**

# Bytes
One bit of information is so little that usually computer memory is organized into groups of eight bits. Each eight bit group is called a **byte**.

**One byte is about enough memory to hold a single character.** When more than eight bits are required for some data, several of bytes are used. Typically, **four bytes are used to represent integers.**

Often very much more than eight bits are required for data, and thousands, millions, or even billions of bytes are needed. These amounts have names, as seen in the table.

|Name|Number of Bytes|power of 2|
|---|---|---|
|byte|1|20|
|kilobyte|1024|210|
|megabyte|1,048,576|220|
|gigabyte|1,073,741,824|230|
|terabyte|1,099,511,627,776|240|

The table lists the number of **bytes**, not bits. So one K of memory is 1024 bytes (**which happens to be 1024 8 == 8,192 bits**)

# Words
The Word is the smallest unit of the memory. It is the collection of bytes. Every operating system defines different word sizes after analyzing the n-bit address that is inputted to the decoder and the 2 ^ n memory locations that are produced from the decoder.

Data is transferred to and from memory in groups of bits called words. A word can be a group of 8 bits, 16 bits, 32 bits or 64 bits (and growing). •If the word is 8 bits, it is referred to as a byte. The term “byte” is so common in computer science that sometimes a 16-bit word is referred to as a 2-byte word, or a 32-bit word is referred to as a 4-byte word.

To access a word in memory requires an identifier. Although programmers use a name to identify a word (or a collection of words), at the hardware level each word is identified by an address. •The total number of uniquely identifiable locations in memory is called the address space. •For example, a memory with 64 kilobytes (16 address line required) and a word size of 1 byte has an address space that ranges from 0 to 65,535