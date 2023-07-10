**Package** in [Java](https://www.geeksforgeeks.org/java/) is a mechanism to encapsulate a group of classes, sub packages and interfaces.

**How packages work?**

Package names and directory structure are closely related. For example if a package name is _college.staff.cse_, then there are three directories, _college_, _staff_ and _cse_ such that _cse_ is present in _staff_ and _staff_ is present inside _college_. Also, the directory _college_ is accessible through [CLASSPATH](https://en.wikipedia.org/wiki/Classpath_(Java)) variable, i.e., path of parent directory of college is present in CLASSPATH. The idea is to make sure that classes are easy to locate.  
**Package naming conventions :** Packages are named in reverse order of domain names, i.e., org.geeksforgeeks.practice. For example, in a college, the recommended convention is college.tech.cse, college.tech.ee, college.art.history, etc.

**Adding a class to a Package :** We can add more classes to a created package by using package name at the top of the program and saving it in the package directory. We need a new **java** file to define a public class, otherwise we can add the new class to an existing **.java** file and recompile it.

**Subpackages:** Packages that are inside another package are the **subpackages**. These are not imported by default, they have to imported explicitly. Also, members of a subpackage have no access privileges, i.e., they are considered as different package for protected and default access specifiers.  

**Accessing classes inside a package**

Consider following two statements :

// import the Vector class from util package.
import java.util.vector; 

// import all the classes from util package
import java.util.*; 

- First Statement is used to import **Vector** class from **util** package which is contained inside **java**.
- Second statement imports all the classes from **util** package.

// All the classes and interfaces of this package
// will be accessible but not subpackages.
import package.*;

// Only mentioned class of this package will be accessible.
import package.classname;

// Class name is generally used when two packages have the same
// class name. For example in below code both packages have
// date class so using a fully qualified name to avoid conflict
import java.util.Date;
import my.package.Date;


**Types of packages:**  
![packages](https://media.geeksforgeeks.org/wp-content/uploads/java-types-of-packages.jpg)

**Built-in Packages**  
These packages consist of a large number of classes which are a part of Java **API**.Some of the commonly used built-in packages are:  
1) **java.lang:** Contains language support classes(e.g classed which defines primitive data types, math operations). This package is automatically imported.  
2)  **java.io:** Contains classed for supporting input / output operations.  
3)  **java.util:** Contains utility classes which implement data structures like Linked List, Dictionary and support ; for Date / Time operations.  
4)  **java.applet:** Contains classes for creating Applets.  
5)  **java.awt:** Contain classes for implementing the components for graphical user interfaces (like button , ;menus etc).  
6)  **java.net:** Contain classes for supporting networking operations.

**User-defined packages**  
These are the packages that are defined by the user. First we create a directory **myPackage** (name should be same as the name of the package). Then create the **MyClass** inside the directory with the first statement being the **package names**.


**Using Static Import**

Static import is a feature introduced in **Java** programming language ( versions 5 and above ) that allows members ( fields and methods ) defined in a class as public **static** to be used in Java code without specifying the class in which the field is defined.  
Following program demonstrates **static import** :

```java
// Note static keyword after import.
import static java.lang.System.*;

class StaticImportDemo
{
public static void main(String args[])
{	
		// We don't need to use 'System.out'
		// as imported using static.
		out.println("GeeksforGeeks");
}
}

```

**Handling name conflicts**

The only time we need to pay attention to packages is when we have a name conflict . For example both, java.util and java.sql packages have a class named Date. So if we import both packages in program as follows:

import java.util.*;
import java.sql.*;

//And then use Date class, then we will get a compile-time error :

Date today ; //ERROR-- java.util.Date or java.sql.Date?

The compiler will not be able to figure out which Date class do we want. This problem can be solved by using a specific import statement:

import java.util.Date;
import java.sql.*;

If we need both Date classes then, we need to use a full package name every time we declare a new object of that class.  
For Example:

java.util.Date deadLine = new java.util.Date();
java.sql.Date today = new java.sql.Date();

**Important points:**

1. Every class is part of some package.
2. If no package is specified, the classes in the file goes into a special unnamed package (the same unnamed package for all files).
3. All classes/interfaces in a file are part of the same package. Multiple files can specify the same package name.
4. If package name is specified, the file must be in a subdirectory called name (i.e., the directory name must match the package name).
5. We can access public classes in another (named) package using: **package-name.class-name**

