### Using java.nio.file.File class
When working with files or paths, you will likely be using the `_java.nio.file.Files_` class. It contains a ton of common & useful static methods, that operate on files and directories.

#### How to check if a file exists

```java
Path path = Path.of("c:\\dev\\licenses\\windows\\readme.txt");
boolean exists = Files.exists(path);
System.out.println("exists = " + exists);
```

Checks if a file or directory exists. Also lets you specify additional parameters, to define how symlinks are handled, i.e. followed (default) or not.

Output:

```
exists = true
```

#### How to get the last modified date of a file

```java
Path path = Path.of("c:\\dev\\licenses\\windows\\readme.txt");
FileTime lastModifiedTime = Files.getLastModifiedTime(path);
System.out.println("lastModifiedTime = " + lastModifiedTime);
```

Self-explanatory. Returns the last date your file was modified as a `_FileTime_` object.
Output:

```
lastModifiedTime = 2020-05-20T08:41:30.905176Z
```

#### How to compare files (Java12+)

```java
Path path = Path.of("c:\\dev\\licenses\\windows\\readme.txt");
long mismatchIndex = Files.mismatch(path, Paths.get("c:\\dev\\whatever.txt"));
System.out.println("mismatch = " + mismatchIndex);
```

Available since Java 12. It compares the sizes and bytes of two files and returns the position of the first (byte) mismatch. Or, -1L if there was no mismatch.

Hence, if you are comparing two completely different files, you’ll get this as console output: the very first byte already didn’t match, hence the mismatch is _position zero_.
Output:

```
mismatch = 0
```

#### How to get the owner of a file

```java
Path path = Path.of("c:\\dev\\licenses\\windows\\readme.txt");
UserPrincipal owner = Files.getOwner(path);
System.out.println("owner = " + owner);
```

Self explanatory. Returns the owner of a file or directory as `_UserPrincipal_` (which extends from `_Principal_`). On Windows, this will be a WindowsUserPrincipal, which contains the user’s account name (shown below), as well as his `_sid_`, his unique security identifier on your Windows machine.
Output:

```
owner = DESKTOP-168M0IF\marco_local (User)
```

#### How to create temp files

```java
Path tempFile1 = Files.createTempFile("somePrefixOrNull", ".jpg");
System.out.println("tempFile1 = " + tempFile1);

Path tempFile2 = Files.createTempFile(path.getParent(), "somePrefixOrNull", ".jpg");
System.out.println("tempFile2 = " + tempFile2);

Path tmpDirectory = Files.createTempDirectory("prefix");
System.out.println("tmpDirectory = " + tmpDirectory);
```

Let’s break this down.

```java
Path tempFile1 = Files.createTempFile("somePrefixOrNull", ".jpg");
System.out.println("tempFile1 = " + tempFile1);
```

When creating temp files, you can specify a prefix (first param) and a suffix (second param). Both can be null.

The prefix will be prefixed (duh!) to the temp file name, the suffix is essentially the file extension, and if you leave it out a default extension of ".tmp" will be used.

The file will be created in the [default temporary-file directory](https://stackoverflow.com/questions/1924136/environment-variable-to-control-java-io-tmpdir).

```java
Path tempFile2 = Files.createTempFile(path.getParent(), "somePrefixOrNull", ".jpg");
System.out.println("tempFile2 = " + tempFile2);
```

Instead of the default temp directory, you can also specify your own directory where you want the temp file to be created.

```java
Path tmpDirectory = Files.createTempDirectory("prefix");
System.out.println("tmpDirectory = " + tmpDirectory);
```

In addition to files, you can also create temp directories. As you don’t need the suffix parameter when creating dirs, you only have to choice of specifying a prefix parameter.

When running the code snippet from above, you’ll get the following (or similar) output:

```
tempFile1 = C:\Users\marco\AppData\Local\Temp\somePrefixOrNull8747488053128491901.jpg
tempFile2 = c:\dev\licenses\windows\somePrefixOrNull11086918945318459411.jpg
tmpDirectory = C:\Users\marco\AppData\Local\Temp\prefix9583768274092262832
```

**Note**: Temp files, contrary to popular belief, **do not** delete themselves. You have to make sure to explicitly delete them, when creating them in unit tests or when running in production.

### How to create files and directories

You’ve seen how to create temp files, and it’s the very same thing with normal files and directories. You’ll just call different methods:

```java
Path newDirectory = Files.createDirectories(path.getParent().resolve("some/new/dir"));
System.out.println("newDirectory = " + newDirectory);

Path newFile = Files.createFile(newDirectory.resolve("emptyFile.txt"));
System.out.println("newFile = " + newFile);
```

Some people are confused by this: The `_.resolve_` call does not create the file, it merely returns a _reference_ to the (child) file you are about to create.

When running the code snippet from above, you’ll get the following (or similar) output:

```java
newDirectory = c:\dev\licenses\windows\some\new\dir
newFile = c:\dev\licenses\windows\some\new\dir\emptyFile.txt
```

#### How to get the Posix permissions of a file

If you are running your Java program on a Unix-like system (including Linux and MacOS), you can get a file’s Posix permissions. Think: "-rw-rw-rw-" or "-rwxrwxrwx" etc.

```java
Path path = Path.of("c:\\dev\\licenses\\windows\\readme.txt");
try {
    Set<PosixFilePermission> permissions = Files.getPosixFilePermissions(path);
    System.out.println("permissions = " + permissions);
} catch (UnsupportedOperationException e) {
    System.err.println("Looks like you're not running on a posix file system");
}
```

Running this on Linux or MacOS, you would get this kind of output:

```
OWNER_WRITE
OWNER_READ
GROUP_WRITE
OTHERS_READ
...
```

### Moving, Deleting & Listing Files

There are a couple of things you need to watch out for, when moving or deleting files. Let’s see some code:

#### How to move files

```java
Path utfFile = Files.createTempFile("some", ".txt");

try {
    Files.move(utfFile, Path.of("c:\\dev"));  // this is wrong!
} catch (FileAlreadyExistsException e) {
    // welp, that din't work!
}
```

There is a `_Files.move_` method, but it _does not_ move a file to a designated directory (which you might expect).

- test.jpg → c:\temp does not work.
- test.jpg → c:\temp\test.jpg works.

```java
Files.move(utfFile, Path.of("c:\\dev").resolve(utfFile.getFileName().toString()));
```

So, you don’t move files to folders, but you "move" them to their full new path, including the filename and extension.

#### File Move Options

```java
Path utfFile2 = Files.createTempFile("some", ".txt");
Files.move(utfFile2, Path.of("c:\\dev").resolve(utfFile.getFileName().toString()), StandardCopyOption.REPLACE_EXISTING);

Path utfFile3 = Files.createTempFile("some", ".txt");
Files.move(utfFile3, Path.of("c:\\dev").resolve(utfFile.getFileName().toString()), StandardCopyOption.ATOMIC_MOVE);
```

When moving files, you can also specify how you want to move to happen, depending on the capabilities of the underlying file system.

- By default, if the target file already exists, a `_FileAlreadyExistsException_` will be thrown.
- If you specify the `_StandardCopyOption.REPLACE_EXISTING_` option, the target file will be overwritten.
- If you specify the `_StandardCopyOption.ATOMIC_MOVE_` option, you can move a file into a directory and be guaranteed that any process watching the directory accesses a complete file and not just a partial file.

#### How to delete files

Deleting files and folders is an area, where the Java Path API falls short a tiny bit. Let’s see why:

```java
try {
    Files.delete(tmpDir);
} catch (DirectoryNotEmptyException e) {
    e.printStackTrace();
}
```

There is the `_Files.delete_` method, which allows you to delete files and directories, but directories only if they are empty.

There is unfortunately no flag to purge a non-empty directory, and you’ll simply get a `_DirectoryNotEmptyException_`.

#### How to delete non-empty directories

There are some 3rd-party helper libraries to work around this, but if you want to use a plain Java version to delete a non-empty directory tree, this is what you’ll want to do:

```java
try (Stream<Path> walk = Files.walk(tmpDir)) {
    walk.sorted(Comparator.reverseOrder()).forEach(path -> {
        try {
            Files.delete(path);
        } catch (IOException e) {
            // something could not be deleted..
            e.printStackTrace();
        }
    });
}
```

`_Files.walk_` will walk a file tree depth-first, starting with the directory you specify. The `_reverseOrder_` comparator will make sure that you delete all children, before deleting the actual directory.

Unfortunately, you’ll also need to catch the IOException, when using `_Files.delete_` inside the `_forEach_` consumer. A whole lot of code for deleting a non-empty directory, isn’t it?

Which brings us to the topic of listing files:

#### How to list files in the same directory

There are various ways how you can list all files in a given directory. If you only want to list files on the same levels as the directory (not recursively deeper), you can use these two methods:

```java
try (var files = Files.list(tmpDirectory)) {
    files.forEach(System.out::println);
}

try (var files = Files.newDirectoryStream(tmpDirectory, "*.txt")) {
    files.forEach(System.out::println);
}
```

Note, that `_newDirectoryStream_` (as opposed to `_Files.list_`) does not return a `_java.util.stream.Stream_`. Instead, it returns a `_DirectoryStream_`, which is a class that got introduced in Java 1.7, before the release of the Streams API in Java 8.

It does, however, allow you to specify a `_glob_` pattern (like *.txt), which does the job for simple listings, and is maybe a bit easier to read than fumbling with real Streams and the corresponding _filter_ methods.

Also note, that the streams returned by both methods must also be closed (e.g. with a try-with-resources statement), otherwise the JVM will keep the file handle on the directory open, which (on Windows) effectively locks it.

#### How to list files recursively

If you want to recursively list all files of a file tree, you’ll need to employ the method we used for deleting directories: `_Files.walk_`.

```java
try (var files = Files.walk(tmpDirectory)) {
    files.forEach(System.out::println);
}
```

Note, that the stream returned by `_Files.walk_` must also be closed (e.g. with a try-with-resources statement), otherwise the JVM will keep the file handle on the directory open, which (on Windows) effectively locks it.