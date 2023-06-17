cuando una excepcion ocurre dentro de un metodo se crea un objeto, aka. exception object

#### Donde se pueden aplicar las exceptions / Cuando ocurren las exceptions
- Invalid user input
- Device failure
- Loss of network connection
- Physical limitations (out of disk memory)
- Code errors
- Opening an unavailable file

#### Exception Hierarchy

todos las subexceptions como `ClassNotFoundException, IOException, SQLException, RemoteException, RuntimeException, etc.` son subclases "extensions" de la clase `Throwable` 

![exception hierarchy](https://media.geeksforgeeks.org/wp-content/uploads/Exception-in-java1.png)


duda: algunos exceptions son extensiones de otros exceptions y esos exceptions a su vez son extensiones de `Throwable` 
duda: `Throwable` es un implement de la clase `Serializable` y no de un objeto

#### Tipos de exceptions

![types exceptions](https://media.geeksforgeeks.org/wp-content/uploads/20220120111809/Group21-660x330.jpg)

### Built-in Exceptions:
son exceptions que vienen en la libreria de java, se dividen en:

###### Checked Exceptions
son exceptions que el compilador de java obliga a que se capturen, este tipo de exceptions son subclases de `Exception` o subclases directos de `Throwable` y tienen que capturar utilizando `try-catch` o declarando `throws` en el metodo.

###### Uncheked Exceptions
son exceptions que el compilador de java no verifica/captura, este tipo de exceptions sob subclases de la clase `RuntimeException` o `Error` ocurren por un error en la logica del codigo y pueden ser capturadas en el codigo utilizando `try-catch` o declarando `throws` en el metodo.

### User-Defined Exceptions:
son exceptions que los programadores crean para captura un tipo de exception especifico para sus programas.

###### *Example:*
~~~java
// A Class that represents use-defined exception

class MyException extends Exception {
	public MyException(String s)
	{
		// Call constructor of parent Exception
		super(s);
	}
}

// A Class that uses above MyException
public class Main {
	// Driver Program
	public static void main(String args[])
	{
		try {
			// Throw an object of user defined exception
			throw new MyException("GeeksGeeks");
		}
		catch (MyException ex) {
			System.out.println("Caught");

			// Print the message from MyException object
			System.out.println(ex.getMessage());
		}
	}
}
~~~



### Methods to print the Exception information:
- `printStackTrace()` : imprime la informacion de la exception incluyendo el numero de la linea donde se produjo y el nombre de la clase que contiene la exception.
- `toString()` : imprime la informacion de la exception en forma string.
- `getMessage()` : imprime solo la descripcion de la exception.

###### *Example:*

~~~java
//program to print the exception information using printStackTrace() method

import java.io.*;

class GFG {
	public static void main (String[] args) {
		int a=5;
		int b=0;
		try{
			System.out.println(a/b);
		}
		catch(ArithmeticException e){
			/* java.lang.ArithmeticException: / by zero
			at GFG.main(File.java:10) */
			e.printStackTrace();
			/* java.lang.ArithmeticException: / by zero */
			System.out.println(e.toString());
			/* / by zero */
			System.out.println(e.getMessage());
		}
	}
}

~~~



### How does JVM handle an Exception

