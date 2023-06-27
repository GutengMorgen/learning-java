### Java has two file APIs.

- The original `_java.io.File_` API, available since Java 1.0 (1996).
- The newer `_java.nio.file.Path_` API, available since Java 1.7 (2011).

The old file API is used in a ton of older projects, nevertheless, `_java.nio.file.Path_` ([[java.nio.file.File Class]]) does everything `_java.io.File_` can, but generally in a better way and more. A few examples:

- File Features: The new classes support symlinks, proper file attributes and metadata support (think: PosixFileAttributes), ACLs and more.
- Better usage: E.g. when deleting a file, you get an exception with a meaningful error message (no such file, file locked, etc.), instead of a simple boolean saying `_false_`.
- Decoupling: Enabling support for in-memory file systems, which we’ll cover later.

### Atributos clave
- File Object
- File class
- pathname
- pathname absolute and relative
- diff between URL and URI
- write and read files
- Moving, Deleting & Listing Files
- Watching Files & Directories
- In-Memory File Systems

### File Class
The fi rst class that we will discuss is one of the most commonly used in the java.io API, the java.io.File class, or File class for short. The File class is used to read information about existing fi les and directories, list the contents of a directory, and create/delete fi les and directories. An instance of a File class represents the pathname of a particular fi le or directory on the fi le system. The File class cannot read or write data within a fi le, although it can be passed as a reference to many stream classes to read or write data, as you shall see in the next section.


### File Object
**In Java, *files* and *directories* are represented with one File object**

A `File` object **holds** information about a disk file or a disk directory. It does not contain the data that the file holds. **It is an object that holds methods that affect a particular file or directory**.

It works as an interface between a program and the functions of the operating system that do the actual file manipulation.

Different operating systems organize their file system in different ways. By using `File` objects, Java programs can handle files in a uniform manner on all operating systems. Your Java program can invoke a `File` method, and exactly what needs to be done for the particular OS the program is running on will be done.

A `File` object is constructed by a program and used to manipulate a disk file and to get information about it. **When the program finishes, the `File` object is no more**, but the file remains on disk (unless the program deliberately deleted it).

### File Constructors

|Constructor|Description|
|---|---|
|File(File parent, String child)|It creates a new File instance from a parent abstract pathname and a child pathname string.|
|File(String pathname)|It creates a new File instance by converting the given pathname string into an abstract pathname.|
|File(String parent, String child)|It creates a new File instance from a parent pathname string and a child pathname string.|
|File(URI uri)|It creates a new File instance by converting the given file: URI into an abstract pathname.|

### Pathname types
Path names are **relative** or **absolute**:
- **Absolute**: Simply, a path is absolute if it starts with the root element of the file system. In windows, the root element is a drive e.g. C:\, D:\, while in unix it is denoted by “/” character. An absolute path is complete in that no other information is required to locate the file, it usually holds the complete directory list starting from the root node of the file system till reaching the file or directory it denotes.
- **Relative**: It is simply the path needed in order to locate the file from within the current directory of your program. It is not complete and needs to be combined with the current directory path in order to reach the requested file.

Both relative and absolute path names may be used with the `File` constructor.

#### How to get the path of a existen file object
- **getPath()**: This method just returns the path argument which is used when constructing the object. *e.g. relativeFile.getPath() => "/sample-documents/pdf-sample.pdf"*
- **getAbsolutePath()**: This method returns the absolute path of the current file object, a single file existing on a system can have many different paths that refer to it. *e.g. The absolute paths of pdf-sample.pdf are: “D:\sample-documents\pdf-sample.pdf”*
	- Normally, this method returns the “.” and “..” characters, so it’s not efficient for comparing 2 file paths.

- **getCanonicalPath()**: A canonical path is simply a unique absolute path *e.g. the canonical path of pdf-sample.pdf is: “D:\sample-documents\pdf-sample.pdf”*
	- Normally, this method resolves the “.” and “..” characters and return the final path, it’s efficient for comparing 2 file paths.

### Useful Methods

|Modifier and Type|Method|Description|Description 2|
|---|---|---|---|
|static File|createTempFile(String prefix, String suffix)|It creates an empty file in the default temporary-file directory, using the given prefix and suffix to generate its name.|
|boolean|createNewFile()|It atomically creates a new, empty file named by this abstract pathname if and only if a file with this name does not yet exist.|
|boolean|canWrite()|It tests whether the application can modify the file denoted by this abstract pathname.String[]|Returns true if the file exists and can be written; otherwise returns false.!
|boolean|canExecute()|It tests whether the application can execute the file denoted by this abstract pathname.|
|boolean|canRead()|It tests whether the application can read the file denoted by this abstract pathname.|Returns true if the file exists and can be read; otherwise returns false.|
|boolean|isAbsolute()|It tests whether this abstract pathname is absolute.|
|boolean|isDirectory()|It tests whether the file denoted by this abstract pathname is a directory.|Returns true for an existing directory; otherwise returns false.|
|boolean|isFile()|It tests whether the file denoted by this abstract pathname is a normal file.|Returns true for an existing file; otherwise returns false.|
|String|getName()|It returns the name of the file or directory denoted by this abstract pathname.|Returns the file name or directory name.|
|String|getParent()|It returns the pathname string of this abstract pathname's parent, or null if this pathname does not name a parent directory.|
|Path|toPath()|It returns a java.nio.file.Path object constructed from the this abstract path.|
|URI|toURI()|It constructs a file: URI that represents this abstract pathname.|
|File[]|listFiles()|It returns an [array](https://www.javatpoint.com/array-in-java) of abstract pathnames denoting the files in the directory denoted by this abstract pathname|
|long|getFreeSpace()|It returns the number of unallocated bytes in the partition named by this abstract path name.|
|String[]|list(FilenameFilter filter)|It returns an array of strings naming the files and directories in the directory denoted by this abstract pathname that satisfy the specified filter.|Returns an array which lists the files and directories in the directory. If the File is not a directory or there is an I/O error, null is returned.|
|boolean|mkdir()|It creates the directory named by this abstract pathname.|Creates the directory named in this File object. Returns _true_ if successful, otherwise, _false_.|
|boolean|delete()||Deletes the file or directory. Returns _true_ on success; otherwise returns false.|
|boolean|exists()||Returns _true_ if the file exists; otherwise returns false.
|String|getPath()||Returns the path name.|
|long|length()||Returns the length of a file.|


### How to read and write content
In general, there are two ways of working with reading and writing files in Java.

1. **InputStream and OutputStream.**  
    The Stream classes are used for inputting and outputting all types of binary or byte data.
2. **Reader and Writer.**  
    The Reader and Writer classes are used for inputting and outputting characters and strings. Basically, text files.

![io](https://miro.medium.com/v2/resize:fit:720/format:webp/1*KL76PVciQP_5uuqF1XnKgg.png)

**Both InputStream/OutoutStream and Reader/Writer use streams in the background** so...

### How works stream
*The main idea of the stream is to read/write piece by piece*

*Note that the **I/O streams** that we discuss in this chapter are data streams and completely unrelated to the new **Stream API** that you saw in Chapter 4 , “Functional Programming.”* - OCP Oracle

Streams should be conceptually thought of as a long, nearly never-ending “stream of water” with data presented one “wave” at a time.

![[Pasted image 20230624200331.png]]

Each type of stream segments data into a “wave” or “block” in a particular way. For example, **some stream classes read or write data as individual byte values**. Other **stream classes read or write individual characters or strings of characters**. On top of that, **some stream classes read or write groups of bytes or characters at a time, specifically those with the word Buffered in their name.**

*The reasoning behind more high-order streams is for convenience as well as performance.
For example, writing a file one byte at a time is time consuming and slow in practice because the round-trip between the Java application and the file system is relatively expensive. By utilizing a BufferedOutputStream, the Java application can write a large chunk of bytes at a time, reducing the round-trips and drastically improving performance.*

Java provides three **built-in streams**, System.in, System.err, and System.out

#### Byte Streams and Character Streams
Java defines two types of streams: **byte** and **character**.
- **Byte streams** (aka.  Streams) provide a convenient means for handling input and output of **all types of binary or byte data**. Byte streams are used, for example, when reading or writing binary data.
- **Character streams** (aka. Readers/Writes) provide a convenient means for handling input and output of **only character and String data**. They use Unicode and, therefore, can be internationalized.

*At the lowest level, all I/O is still byte-oriented. The character streams simply provide a convenient and efficient means for handling characters.*

###### why use character streams
Because *"... the reader/writer classes, as they are specifically focused on managing character and string data. ..."* - OCP Oracle

#### Input and Output
**Most Input stream classes have a corresponding Output class and vice versa.** For example, the FileOutputStream class writes data that can be read by a FileInputStream.

**If you understand the features of a particular Input or Output stream class, you should naturally know what its complementary class does.**

It follows, then, that most Reader classes have a corresponding Writer class. For example, the FileWriter class writes data that can be read by a FileReader. 

There are exceptions to this rule. For the exam, you should know that PrintWriter has no accompanying PrintReader class. Likewise, the PrintStream class has no corresponding InputStream class. We will discuss these classes later this chapter.

#### The byte stream classes
Byte streams are defined by using two class hierarchies. At the top are two abstract classes: `InputStream` and `OutputStream`. Both define several key methods that the other stream classes implement. Two of the most important are **read( )** and **write( )**, which, respectively, read and write bytes of data. Each has a form that is abstract and must be overridden by derived stream classes.

#### The character stream classes
Character streams are defined by using two class hierarchies. At the top are two abstract classes: `Reader` and `Writer`. **These abstract classes handle Unicode character streams.** Both define several key methods that the other stream classes implement. Two of the most important methods are **read( )** and **write( )**, which read and write characters of data, respectively.


### Low-Level vs. High-Level Streams
It is possible to segment java.io API into **low-level** and **high-level** streams.
- A low-level stream connects directly with the source of the data, such as a file, an array, or a String. Low-level streams process the raw data or resource and are accessed in a direct and unfiltered manner. For example, a FileInputStream is a class that reads file data one byte at a time. 
- A high-level stream is built on top of another stream using wrapping. Wrapping is the process by which an instance is passed to the constructor of another class and operations on the resulting instance are filtered and applied to the original instance.

For example, take a look at the FileWriter and BufferedWriter objects in the following sample code: 
```java
try (BufferedReader bufferedReader = new BufferedReader( new FileReader("zoo-data.txt"))) {
	System.out.println(bufferedReader.readLine()); 
}
```

 In this example, FileReader is the low-level stream reader, whereas BufferedReader is the high-level stream that takes a FileReader as input. 
 
**High-level streams can take other high-level streams as input.** For example, although the following code might seem a little odd at first, the style of wrapping a stream is quite common in practice:
```java
try (ObjectInputStream objectStream = new ObjectInputStream( new BufferedInputStream( new FileInputStream("zoo-data.txt")))) {
	System.out.println(objectStream.readObject());
}
```

In this example, FileInputStream is the low-level stream that interacts directly with the file, which is wrapped by a high-level BufferedInputStream to improve performance. Finally, the entire object is wrapped by a high-level ObjectInputStream, which allows us to filter the data as Java objects.

###### Why use buffers streams when working with Files
The reason that **Buffered streams tend to perform so well in practice is that file systems are geared for sequential disk access.** The more sequential bytes you read at a time, the fewer round-trips between the Java process and the file system, improving the access of your application. For example, accessing 16 sequential bytes is a lot faster than accessing 16 bytes spread across the hard drive.

### Review of java.io Class Properties
- A class with the word InputStream or OutputStream in its name is used for reading or writing binary data, respectively.
- A class with the word Reader or Writer in its name is used for reading or writing character or string data, respectively.
- Most, but not all, input classes have a corresponding output class.
- A low-level stream connects directly with the source of the data.
- A high-level stream is built on top of another stream using wrapping.
- A class with Buffered in its name reads or writes data in groups of bytes or characters and often improves performance in sequential file systems.

When wrapping a stream you can mix and match only types that inherit from the same abstract parent stream.

![[Pasted image 20230624225358.png]]

### Flushing the Stream
When data is written to an OutputStream, the underlying operating system does not necessarily guarantee that the data will make it to the file immediately. In many operating systems, the data may be cached in memory, with a write occurring only after a temporary cache is filled or after some amount of time has passed. If the data is cached in memory and the application terminates unexpectedly, the data would be lost, because it was never written to the file system. To address this, Java provides a flush() method, which requests that all accumulated data be written immediately to disk.
The flush() method helps reduce the amount of data lost if the application terminates unexpectedly. It is not without cost, though. Each time it is used, it may cause a noticeable delay in the application, especially for large files.

### Skipping over Data
The InputStream and Reader classes also include a skip(long) method, which as you might expect skips over a certain number of bytes. It returns a long value, which indicates the number of bytes that were actually skipped. If the return value is zero or negative, such as if the end of the stream was reached, no bytes were skipped. Assume that we have an InputStream instance whose next values are TIGERS. Consider the following code snippet: 
```java
InputStream is = ... System.out.print ((char)is.read()); is.skip(2) is.read(); System.out.print((char)is.read()); System.out.print((char)is.read()); 
```
The code will read one character, T, skip two characters, IG, and then read three more characters, ERS, only the last two of which are printed to the user, which results in the following output. TRS You may notice in this example that calling the skip() operation is equivalent to calling read() and discarding the output. 
For skipping a handful of bytes, there is virtually no difference. On the other hand, **for skipping a large number of bytes, skip() will often be faster, because it will use arrays to read the data.**

### The FileInputStream and FileOutputStream Classes

Read: [[Principal Class To Learn From IO API#The FileInputStream and FileOutputStream Classes|The FileInputStream and FileOutputStream Classes]]


### Diagram of java.io classes
The classes on the left side of the diagram are the abstract parent classes. The classes on the right side with dotted borders are low-level streams, and the ones with solid borders are high-level streams. Note that this diagram does not include all java.io stream classes.

![[Pasted image 20230625052740.png]]

### Footer
duda: como es la estructura de un file object, diferencias entre un file object y un file class
duda: como funciona internamente stream y buffer para leer y escribir datos

Resources:
- [initialcommit](https://initialcommit.com/blog/java-io-difference-absoluterelative-canonical-path)
- [chortle.ccsu.edu](https://chortle.ccsu.edu/java5/Notes/chap87/ch87_4.html)
- [javatpoint](https://www.javatpoint.com/java-file-class)
- [marcobehler](https://www.marcobehler.com/guides/java-files#_in_memory_file_systems)
- [medium](https://beknazarsuranchiyev.medium.com/how-to-work-with-files-in-java-5f5d76012d63)
- 