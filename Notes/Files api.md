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

### File Object
**In Java, files and directories are represented with one File object**

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

### Watching Files & Directories


### In-Memory File Systems

### How stream works in File api



### Footer
duda: como es la estructura de un file object, diferencias entre un file object y un file class
duda: como funciona internamente stream y buffer para leer y escribir datos

Resources:
- [initialcommit](https://initialcommit.com/blog/java-io-difference-absoluterelative-canonical-path)
- [chortle.ccsu.edu](https://chortle.ccsu.edu/java5/Notes/chap87/ch87_4.html)
- [javatpoint](https://www.javatpoint.com/java-file-class)
- [marcobehler](https://www.marcobehler.com/guides/java-files#_in_memory_file_systems)
- 