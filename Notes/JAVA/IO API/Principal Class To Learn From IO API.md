
## The FileInputStream and FileOutputStream Classes
They are used to read bytes from a file or write bytes to a file, respectively. These classes include constructors that take a File object or String, representing a path to the file.

### Definition
The data in a FileInputStream object is commonly accessed by successive calls to the **read() method until a value of -1 is returned**, indicating that the end of the stream (in this case the end of the file) has been reached. Although less common, you can also choose to stop reading the stream early just by exiting the loop, such as if some search String is found.


## The BufferedInputStream and BufferedOutputStream Classes

Instead of reading the data one byte at a time, we use the underlying read(byte[]) method of BufferedInputStream, which returns the number of bytes read into the provided byte array. The number of bytes read is important for two reasons. First, if the value returned is 0, then we know that we have reached the end of the file and can stop reading from the BufferedInputStream. Second, the last read of the file will likely only partially fill the byte array, since it is unlikely for the file size to be an exact multiple of our buffer array size. For example, if the buffer size is 1,024 bytes and the file size is 1,054 bytes, then the last read will be only 30 bytes. The length value tells us how many of the bytes in the array were actually read from the file. The remaining bytes of the array will be filled with leftover data from the previous read that should be discarded. The data is written into the BufferedOutputStream using the write(byte[],int,int) method, which takes as input a byte array, an offset, and a length value, respectively. The offset value is the number of values to skip before writing characters, and it is often set to 0. The length value is the number of characters from the byte array to write.

### Buffer Size Tuning
We chose a buffer size of 1024 in this example, as this is appropriate for a wide variety of circumstances, although in practice you may see better performance with a larger or smaller buffer size. This would depend on a number of factors including file system block size and CPU hardware. It is also common to choose a power of 2 for the buffer size, since most underlying hardware is structured with file block and cache sizes that are a power of 2. The Buffered classes allow you to specify the buffer size in the constructor. If none is provided, they use a default value, which is a power of 2 in most JVMs. Regardless of which buffer size you choose, the biggest performance increase you will see is moving from nonbuffered to buffered file access. Adjusting the buffer size may improve performance slightly, but unless you are using an extremely small or extremely large buffer size, it is unlikely to have a significant impact.

## The FileReader and FileWriter classes
The FileReader and FileWriter classes, along with their associated buffer classes, are among the most convenient classes in the java.io API, in part because reading and writing text data are among the most common ways that developers interact with files.
The FileReader and FileWriter classes contain other methods that you saw in the stream classes, including close() and flush(), the usage of which is the same.


## The BufferedReader and BufferedWriter Classes
Let’s take a look at a sample program that makes use of both the BufferedReader and BufferedWriter classes using the associated readLine() and write(String) methods. It reads a text file, outputs each line to screen, and writes a copy of the file to disk. Since these classes are buffered, you can expect better performance than if you read/wrote each character one at a time.

###### example:
```java
import java.io.*;
import java.util.*;

public class CopyTextFileSample { 
	public static List readFile(File source) throws IOException { 
		List data = new ArrayList();
		try (BufferedReader reader = new BufferedReader(new FileReader(source))) { 
			String s; 
			while((s = reader.readLine()) != null) 
			{ 
				data.add(s); 
			}
		} 
		return data; 
	}
	
	public static void writeFile(List data, File destination) throws IOException { 
		try (BufferedWriter writer = new BufferedWriter( new FileWriter(destination))) { 
			for(String s: data) { 
				writer.write(s); 
				Working with Streams 425 writer.newLine(); 
			} 
		} 
	}
	
	public static void main(String[] args) throws IOException { 
		File source = new File("Zoo.csv"); 
		File destination = new File("ZooCopy.csv"); 
		List data = readFile(source); 
		for(String record: data) { 
			System.out.println(record); 
		} 
		writeFile(data,destination); 
	} 
}
```



## The ObjectInputStream and ObjectOutputStream Classes
Throughout this book, we have been managing our data model using classes, so it makes sense that we would want to write these objects to disk. The process of converting an in-memory object to a stored data format is referred to as serialization , with the reciprocal process of converting stored data into an object, which is known as deserialization .

## The Serializable Interface
In order to serialize objects using the java.io API, the class they belong to must implement the java.io.Serializable interface. The Serializable interface is a tagging or marker interface, which means that it does not have any methods associated with it. Any class can implement the Serializable interface since there are no required methods to implement. 

The purpose of implementing the Serializable interface is to inform any process attempting to serialize the object that you have taken the proper steps to make the object serializable, which involves making sure that the classes of all instance variables within the object are also marked Serializable . Many of the built-in Java classes that you have worked with throughout this book, including the String class, are marked Serializable . This means that many of the simple classes that we have built throughout this book can be marked Serializable without any additional work.


A process attempting to serialize an object will throw a NotSerializableException if the class or one of its contained classes does not properly implement the Serializable interface.

The only limitation is that the data stored in the object will be lost during the serialization process. Besides transient instance variables, static class members will also be ignored during the serialization and deserialization process. This should follow logically, as static class variables do not belong to one particular instance. If you need to store static class information, it will be need to be copied to an instance object and serialized separately.

### why not mark every Class as Serializable?
You might be wondering why we don’t just mark every class with the Serializable interface since there is no cost to doing so. The reason that we do not is that there are some classes that we want to instruct the JVM not to serialize. In particular, process-heavy classes such as the Thread class or any of the Stream classes would be diffi cult, often impossible, to save to persistent storage, since much of their work involves managing JVM processes or resources in real time.

## Serializing and Deserializing Objects
The java.io API provides two stream classes for object serialization and deserialization called ObjectInputStream and ObjectOutputStream. The ObjectOutputStream class includes a method to serialize the object to the stream called void writeObject(Object). If the provided object is not Serializable, or it contains an embedded reference to a class that is not Serializable or not marked transient, a NotSerializableException will be thrown at runtime. For the reciprocal process, the ObjectInputStream class includes a deserialization method that returns an object called readObject(). Notice that the return type of this method is the generic type java.lang.Object, indicating that the object will have to be cast explicitly at runtime to be used.
We now provide a sample program that reads and writes Animal data objects:

###### example:
```java
import java.io.*; 
import java.util.*; 
public class ObjectStreamSample { 
	public static List getAnimals(File dataFile) throws IOException, ClassNotFoundException { 
		List animals = new ArrayList(); 
		try (ObjectInputStream in = new ObjectInputStream( new BufferedInputStream(new FileInputStream(dataFile)))) { 
			while(true) { 
				Object object = in.readObject(); 
				if(object instanceof Animal) animals.add((Animal)object); 
			} 
		} catch (EOFException e) { 
		// File end reached 
		} 
		return animals; 
	} 
	
	public static void createAnimalsFile(List animals, File dataFile) throws IOException { 
		try (ObjectOutputStream out = new ObjectOutputStream( new BufferedOutputStream(new FileOutputStream(dataFile)))) { 
			for(Animal animal: animals) 
				out.writeObject(animal); 
		} 
	} 
	
	public static void main(String[] args) throws IOException, ClassNotFoundException { 
		List animals = new ArrayList(); 
		animals.add(new Animal("Tommy Tiger",5,'T')); 
		animals.add(new Animal("Peter Penguin",8,'P')); 
		File dataFile = new File("animal.data");
		createAnimalsFile(animals,dataFile);
		System.out.println(getAnimals(dataFile)); 
	} 
}
```


From a high-level, the program first creates a list of Animal objects in memory that includes two Animal instances. It then writes the list data into memory to an animal.data file saved in the current working directory. Finally, it reads the data from the file and outputs the following text: 
```
[Animal [name=Tommy Tiger, age=5, type=T], Animal [name=Peter Penguin, age=8, type=P]]
``` 

For performance reasons, we wrap each low-level file stream with a Buffered stream and then chain the result to an Object stream. The createAnimalsFile() method should be somewhat straightforward since we are just iterating over the List object and serializing each Animal object to disk using the writeObject() method. The getAnimals() method is a little more complex, as we must take special care to deserialize the objects from disk. First, we need to check that the object we are reading is actually an instance of the Animal class before explicitly casting it, or else we might get a ClassCastException at runtime. In practice, we may want to throw an exception or log additional details if we encounter a class type that we did not expect.

EOF Check Methods You may come across code that reads from an InputStream and uses the snippet while(in.available()>0) to check for the end of the stream, rather than checking for an EOFException. The problem with this technique, and the Javadoc does echo this, is that it only tells you the number of blocks that can be read without blocking the next caller. In other words, it can return 0 even if there are more bytes to be read. Therefore, the InputStream available() method should never be used to check for the end of the stream

We conclude our discussion of the Object stream classes by noting that they do support reading and writing null objects. Therefore, it is important to check for null values when reading from a serialized data stream. In our sample application, we rely on the property of the instanceof operator always to return false for null values to skip explicitly needing to check for null values.

## Understanding Object Creation
When you deserialize an object, the constructor of the serialized class is not called. In fact, Java calls the first no-arg constructor for the first nonserializable parent class, skipping the constructors of any serialized class in between. Furthermore, any static variables or default initializations are ignored.

make sure that you understand that the constructor and any default initializations are ignored during the deserialization process.

## The PrintStream and PrintWriter Classes
The PrintStream and PrintWriter classes are high-level stream classes that write formatted representation of Java objects to a text-based output stream.

- the PrintStream class operates on OutputStream instances and writes data as bytes, whereas the PrintWriter class operates on Writer instances and writes data as characters.
	- System.out and System.err are actually PrintStream objects.
- the PrintWriter class even has a constructor that takes an OutputStream as input, allowing you to wrap a PrintWriter class around an OutputStream.

For convenience, both of these classes include constructors that can open and write to files directly.

### About PrintStream
PrintStream inherits OutputStream and PrintWriter inherits from Writer, both support the underlying write() method while providing a slew of print-based methods.

Unlike the underlying write() method, which throws a checked IOException that must be caught in your application, these print-based methods do not throw any checked exceptions. If they did, you would have been required to catch a checked exception anytime you called System.out.println() in your code!
Both classes provide a method, checkError() , that can be used to detect the presence of a problem after attempting to write data to the stream.


#### print()
The most basic of the print-based methods is print() , which is overloaded with all Java primitives as well as String and Object . In general, these methods perform String.valueOf() on the argument and call the underlying stream’s write() method, although they also handle character encoding automatically. valueOf() applied to an object calls the object’s toString() method or returns null if the object is not set.

###### example:
```java
PrintWriter out = new PrintWriter("zoo.log"); out.print(5); // PrintWriter
method out.write(String.valueOf(5)); // Writer method out.print(2.0); //
PrintWriter method out.write(String.valueOf(2.0)); // Writer method Animal
animal = new Animal(); out.print(animal); // PrintWriter method
out.write(animal==null ? "null": animal.toString()); // Writer method
```


#### println()
the println() methods, which are virtually identical to the print() methods, except that they insert a line break after the String value is written. The classes also include a version of println() that takes no arguments, which terminates the current line by writing a line separator.
These methods are especially helpful, as the line break or separator character is JVM dependent. For example, in some systems a line feed symbol, `\n`, signifi es a line break, whereas other systems use a carriage return symbol followed by a line feed symbol, `\r`
`\n`, to signify a line break.

#### format() and printf()
the format() method in PrintStream and PrintWriter takes a String , an optional locale, and a set of arguments, and it writes a formatted String to the stream based on the input. In other words, it is a convenience method for formatting directly to the stream. For convenience the PrintStream and PrintWriter APIs also include a set of printf() methods, which are straight pass-through methods to the format() methods.

For example, although the names of the following two methods differ, their input values, output value, and behavior are identical in Java. They can be used interchangeably: 
```java
public PrintWriter format(String format, Object args. . .) 
public PrintWriter printf(String format, Object args. . .)
```


## Console Class
The Console class (java.io.console) was introduced in Java 6 as a more evolved form of the System.in and System.out stream classes. It is now the recommended technique for interacting with and displaying information to the user in a text-based environment.

The Console class is a singleton, which means that there is only one version of the object available in the JVM. It is created automatically for you by the JVM and accessed by calling the System.console() method. Be aware that this method will return null in environments where text interactions are not supported.

Next, let’s look at our previous sample code rewritten using the Console class:

```java
import java.io.Console; 
public class ConsoleSample { 
	public static void main(String[] args) { 
		Console console = System.console(); 
		if(console != null) { 
			String userInput = console.readLine(); 
			console.writer().println ("You entered the following: "+userInput); 
		} 
	} 
}
```

### reader() and writer()
The Console class provides access to an instance of Reader and PrintWriter using the methods reader() and writer(), respectively.
These reader() and writer() methods are the most general ones in the Console class, and they are used by developers who need raw access to the user input and output stream or who may be in the process of migrating away from System.in.

### format() and printf()
For outputting data to the user, you can use the PrintWriter writer() object or use the convenience format(String,Object...) method directly. The format() method takes a String format and list of arguments, and it behaves in the exact same manner as String.

Note that the Console class defines only one format() method, and it does not define a format() method that takes a locale variable. In this manner, it uses the default system locale to establish the formatter.
Of course, you could always use a custom locale by retrieving the Writer object and passing your own locale instance, such as in the following example: 

```java
Console console = System.console();
console.writer().format(new Locale("fr", "CA"),"Hello World");
```

### flush()
**The flush() method forces any buffered output to be written immediately.** It is recommended that you call the flush() method prior to calling any readLine() or readPassword() methods in order to ensure that no data is pending during the read. Failure to do so could result in a user prompt for input with no preceding text, as the text prior to the prompt may still be in a buffer.

### readLine()
The basic readLine() method retrieves a single line of text from the user, and the user presses the Enter key to terminate it.

###### example:
The following sample application reads information from the user and writes it back to the screen:

```java
import java.io.*; 
public class ConsoleReadInputSample { 
	public static void main(String[] args) throws NumberFormatException, IOException { 
		Console console = System.console(); 
		if(console == null) { 
			throw new RuntimeException("Console not available"); 
		} 
		else { 
		console.writer().print("How excited are you about your trip today? "); 
		console.flush(); 
		String excitementAnswer = console.readLine(); 
		String name = console.readLine(“Please enter your name: “); 
		Integer age = null; 
		console.writer().print("What is your age? "); 
		console.flush(); BufferedReader reader = new BufferedReader(console.reader()); 
		String value = reader.readLine(); 
		age = Integer.valueOf(value); 
		console.writer().println(); 
		console.format("Your name is "+name); 
		console.writer().println(); 
		console.format("Your age is "+age); 
		console.printf("Your excitement level is: "+excitementAnswer); 
		} 
	} 
}
```

The example includes multiple ways to read input from the user including the console.readLine() method, as well as creating a BufferedReader out of the console.read() object. The information is printed back to the user via a variety of different writer methods available in the Console class.



### readPassword()
The readPassword() method is similar to the readLine() method, except that echoing is disabled. By disabling echoing, the user does not see the text they are typing, meaning that their password is secure if someone happens to be looking at their screen. 

Also like the readLine() method, the Console class offers an overloaded version of the readPassword() method with the signature readPassword(String format, Object... args) used for displaying a formatted prompt to the user prior to accepting text. 
Unlike the readLine() method, though, the readPassword() method returns an array of characters instead of a String.

###### example:
The last sample application that we will present retrieves two passwords from the user and verifies that they are correct:
```java
import java.io.*; 
import java.util.Arrays; 
public class PasswordCompareSample { 
	public static void main(String[] args) throws NumberFormatException, IOException { 
		Console console = System.console(); 
		if(console == null) { 
			throw new RuntimeException("Console not available"); 
		} 
		else { 
			char[] password = console.readPassword("Enter your password: "); 
			console.format("Enter your password again: "); 
			console.flush(); char[] verify = console.readPassword(); 
			boolean match = Arrays.equals(password,verify);
			for(int i=0; i<password.length; i++) {
				password[i]='x';
			}
			for(int i=0; i<verify.length; i++) { 
				verify[i]='x'; 
			} 
			console.format("Your password was "+(match ? "correct": "incorrect"));
		} 
	} 
}
```

You can see that this sample application uses both overloaded versions of the console. readPassword() method. For security reasons, we immediately clear the character arrays that store the password as soon as they are no longer needed in the application. Note that you could also use Array.fill(password,'x') to wipe an array’s data.


## Footer

duda: como funciona internamente fileinputstream
duda: com funciona internamente bufferinputstream
duda: como funciona internamente serializable
duda: serialVersionUID

