sources: 
- [Core Java Programming](https://www.techguruspeaks.com/home/core-java-programming/java-exception-handling/)
- [Exceptions in Java](https://www.geeksforgeeks.org/exceptions-in-java/)
- [Flow control in try catch finally in Java](https://www.geeksforgeeks.org/flow-control-in-try-catch-finally-in-java/)

Una excepción es un evento o condición anormal que ocurre durante la ejecución de un programa e interrumpe el flujo normal de ejecución. [Explanations of common Java exceptions](https://rymden.nu/exceptions.html)

### Exception Hierarchy

Todo tipo de excepciones son subclases de **java.lang.Throwable** que a su vez es una subclase de **java.lang.Object**, las excepciones de `Thowable` se dividen en dos ramas: **java.lang.Exception** y **java.lang.Error**

![figure 1.1](https://miro.medium.com/v2/resize:fit:720/format:webp/1*_jXNZuPLKMTQ5IKjBzb8jA.png)

![figure 1.2](https://www3.ntu.edu.sg/home/ehchua/programming/java/images/Exception_Classes.png)

##### *java.lang.Exception*
Todas las excepciones de esta clase *deberian* ser capturadas por los programadores, ademas esta clase tambien puede ser usada para crear excepciones personalizadas.

##### *java.lang.Error*
Estas clase contiene **errores internos del sistema** como LinkageError, VirtualMachineError, etc.

### Types of exceptions
Las excepciones tambien se pueden categorizar en dos tipos: **Checked Exceptions** y **Unchecked Exceptions**

##### *Checked Exceptions*
El compilador comprobará que hemos capturado la excepcion. Checked Exceptions obliga a los programadores a lidiar con la excepción que puede lanzar la API, ya sea usando `catch` o reenviándola hacia afuera con `throws`.

##### *Uncheked Exceptions*
En este tipo entran las excepciones de la clase **java.lang.Error** y de la subclase **java.lang.RuntimeException** (de la clase **java.lang.Exception**) 

#### Show information about the Exception
para imprimir o mostrar informacion sobre las excepciones se pueden usar los siguientes metodos:
- `printStackTrace()` : imprime la informacion de la exception incluyendo el numero de la linea donde se produjo y el nombre de la clase que contiene la exception.
- `toString()` : imprime la informacion de la exception en forma string.
- `getMessage()` : imprime solo la descripcion de la exception.

### Handle Exceptions with keywords

hay cinco [keywords](_Keywords) para capturar/manejar las excepciones:

- try: se usa para contener el codigo que podria causar una excepcion o resultado inesperado
- catch: se usa para ejecutar codigo si se produjo una excepcion
- finally: se ejecuta siempre
- throw: se usa para declarar explicitamente una excepcion (normalmente excepciones de tipo unchecked)
- throws: se usa como extension de un metodo para declarar excepciones dentro de el

#### Consideraciones
algunas consideraciones al usar las keywords de manipulaciones de excepciones:

##### Nested try-catch
se puede usar un try-catch block dentro de un bloque try block

##### Multiple catch block
un try block puede tener varios catch blocks, se usa obtener mas informacion del tipo de excepcion que es (como saber la clase de excepcion que la contiene) o para capturar los diferentes tipos de excepciones que pueda lanzar el codigo dentro del try block

**Importante**: cuando se use multiples catch blocks se debe poner primero las subclases y luego las clases de cualquier tipo de excepcion, ya que el compilador encontrara el primer catch block una vez que se produjo una excepcion y si el primer catch block es una clase o superclase, entonces la excepcion sera capturada por ese catch block y los demas catch block no se ejecutaran:

~~~java
public void DemoTryMultiCache1() {  
	int i , j ;  
	j = 0;  
	try {  
		i = 90 / j;// can cause exception (Expected ArithmeticException)
	}  
	catch (Exception e ) {  
		System. _out_ .println(e );  
	}  
	catch (ArithmeticException e ) { // Compiletime Error: Unreachable catch block for ArithmeticException. It is already handled by the catch block for Exception  
		System. _out_ .println(e .getMessage());  
	}  
}
~~~

Esta es la forma correcta:

~~~java
public void DemoTryMultiCache1() {  
	int i , j ;
	j = 0;
	try {  
		i = 90 / j;// can cause exception (Expected ArithmeticException)
	}  
	catch (ArithmeticException e ) { // output: java.lang.ArithmeticException: divide by zero
		System. _out_ .println(e );  
	}  
	catch (Exception e ) {
		System. _out_ .println(e .getMessage());  
	}  
}
~~~

Tambien se puede evitar crear varios catch blocks para administrar los tipos de excepciones, otra forma de hacerlo es usando el simbolo `|` dentro de los parentecis de un catch block (*en este caso no importa el orden en el que se coloquen las subclases o clases de excepciones*):

~~~java
try {
	  //some code
}
catch (ArithmeticException | ArrayIndexOutOfBoundsException | NullPointerException e) {
	System.out.println("Exception : " + e);
}
~~~

##### Finally block
Este keyword siempre se ejecutara una vez el try-catch se halla competado, ademas el finally block tambien se puede ejecutar si no existe un catch block y tambien se ejecutara si el try o catch block contiene un return, *ya que tiene mayor prioridad*.

Algunos aspectos importantes del finally block:
- For each try block there can be zero or more catch blocks, but only one finally block.  
- The catch blocks and finally block must always appear in conjunction with a try block. 
- A try block must be followed by either at least one catch block or one finally block.

**4.**  The order of exception handlers in catch block must be from the most specific exception.

##### Throw y Throws
El keyword **throw** se puede usar para declarar explicitamente excepciones de los 2 tipos (checked y uncheked) aunque comunmente se utiliza mas en el tipo uncheked:

~~~java
throw new ArithmeticException(); //using constructor: Throwable()
// OR
throw new ArithmeticException("Something went wrong!!"); //using constructor: Throwable(String message)
~~~

Por otro lado el keyword **throws** se usa para declarar varias excepciones solo del tipo **checked**.

~~~java
public void methodD() throws XxxException, YyyException {
   ...
   
   // XxxException occurs
   if ( ... ){
      // construct an XxxException object and throw to JVM
      throw new XxxException("XxxException was executed");
   }
   // YyyException occurs
   else if ( ... ){
	   // construct an YyyException object and throw to JVM
      throw new YyyException("YyyException was executed");   
   }
}
~~~

**Importante**: cuando se **throw** y **throws** para declarar explicitamente excepciones *solo* se permitiran excepciones que son subclases o clases directas de **Thorwable** y no user-defined exceptions o custom exceptions.

### Methods to print the Exception information:
- `printStackTrace()` : imprime la informacion de la exception incluyendo el numero de la linea donde se produjo y el nombre de la clase que contiene la exception.
- `toString()` : imprime la informacion de la exception en forma string.
- `getMessage()` : imprime solo la descripcion de la exception.

### How JVM handle the exceptions
Estos son los procesos generales que hace el JVM cuando ocurre una excepcion:

- Se crea el Call Stack: *El call stack es una estructura de datos en la que se registran las llamadas a los métodos en la pila de ejecución del programa. Cada vez que se realiza una llamada a un método, se agrega una entrada en la parte superior de la pila de llamadas, y cuando se completa la ejecución del método, se elimina esa entrada de la pila. Cuando se produce una excepción, el JVM detiene la ejecución normal del programa y busca de un capturador que pueda manejar la excepción. Durante este proceso de búsqueda, el JVM utiliza la información almacenada en el call stack para determinar qué métodos se han llamado y en qué orden.*
- Busca un capturador para la excepcion: El JVM comenzará a ejecutarse desde la parte superior del call stack. Si el método tiene una excepción, JVM comprueba si el método está manejando esa excepción o no, si el metodo lo hace, entonces se *creara un objecto (aka Exception Object) que contiene toda la informacion de la excepcion recopilada del call stack*. Si el metodo no contiene un capturador apropiado entonces JVM termina y elimina el metodo del call satck
- Propagación de la excepción: Ahora JVM comprueba el método de llamada si ha manejado la excepción o no. Si no, entonces también termina el método de llamada. Este proceso continúa, y si **main()** (que es el ultimo metodo en el call stack) tampoco maneja la excepción, la JVM termina y elimina la entrada **main()** de la pila.
- Default Exception Handling: El responsable de capturar/manejar la excepcion ahora es de JVM, para hacerlo creara un Default Exception Handler que a su vez *creara un objecto (aka Exception Object) que contiene toda la informacion de la excepcion recopilada del call stack*, luego la imprimira en la consola y terminara el programa.

![exception propagation](https://miro.medium.com/v2/resize:fit:1400/format:webp/1*uUPVEjDhW-lfmmMdPMt-8w.png)

Resources: [beginnersbook](https://beginnersbook.com/2022/09/exception-propagation-in-java-with-examples/) [javatpoint](https://www.javatpoint.com/exception-propagation) [interviewnoodle](https://interviewnoodle.com/exception-in-java-89a0b41e0c45) [techguruspeaks](https://www.techguruspeaks.com/exception-propagation-in-java/) 

### Chained Exceptions

Chained Exceptions es una forma de encadenar/relacionar una excepcion con otra, e.j se pude usar para que una excepcion describa la causa de otra excepcion. Esto es útil cuando se desea propagar información sobre la causa original de una excepción.

Métodos de clase Throwable que admiten excepciones encadenadas en java :

1. `getCause()` method : Este método devuelve la causa real de una excepción, si no la hay devuelve null.
2. `initCause(Throwable cause)` method : Este método establece la causa de la excepción de llamada.

Por ejemplo, considere una situación en la que un método arroja una ArithmeticException debido a un intento de dividir por cero, pero la causa real de la excepción fue un error de E/S que causó que el divisor fuera cero. El método arrojará solo ArithmeticException a la persona que llama. Por lo tanto, la persona que llama no llegaría a conocer la causa real de la excepción. La excepción encadenada se usa en este tipo de situaciones. Constructores De clase Throwable Que admiten excepciones encadenadas en java :

~~~java
// Java program to demonstrate working of chained exceptions
public class ExceptionHandling {
	public static void main(String[] args) {
		try {
			// Creating an exception
			NumberFormatException ex = new NumberFormatException("Exception");

			// Setting a cause of the exception
			ex.initCause(new NullPointerException( "This is actual cause of the exception"));

			// Throwing an exception with cause.
			throw ex;
		}
		catch(NumberFormatException ex) {
			// displaying the exception
			System.out.println(ex);

			// Getting the actual cause of the exception
			System.out.println(ex.getCause());
		}
	}
}

~~~

Las excepciones encadenadas, también conocidas como excepciones anidadas, le permiten asociar una causa con una excepción en Java. Esto es útil cuando desea propagar información sobre la causa original de una excepción.

more information: [geeksforgeeks](https://www.geeksforgeeks.org/chained-exceptions-java/) [docs.oracle](https://docs.oracle.com/javase/tutorial/essential/exceptions/chained.html) [techguruspeaks](https://www.techguruspeaks.com/chained-exceptions/)

### Java throws with method overriding

idk

more information: [javatpoint](https://www.javatpoint.com/exception-handling-with-method-overriding) [techguruspeaks](https://www.techguruspeaks.com/java-throws-with-method-overriding/) [geeksforgeeks](https://www.geeksforgeeks.org/exception-handling-with-method-overriding-in-java/) 

### try-with-resources
El try-with-resources es una declaración introducida en Java 7 que permite declarar y utilizar recursos en un bloque try con la garantía de que los recursos se cerrarán al finalizar la ejecución del bloque. Un recurso es un objeto que debe cerrarse una vez que el programa ha terminado de usarlo, como por ejemplo un archivo o una conexión a un socket.

Para utilizar el try-with-resources, se deben seguir los siguientes pasos:

1. Declarar el recurso dentro de los paréntesis después de la palabra clave try.
2. Utilizar el recurso dentro del bloque try.
3. No es necesario cerrar explícitamente el recurso dentro del bloque try, ya que esto se hará automáticamente al finalizar la ejecución del bloque.

Aquí tienes un ejemplo que muestra cómo utilizar el try-with-resources para leer la primera línea de un archivo:

~~~java
static String readFirstLineFromFile(String path) throws IOException {
    try (FileReader fr = new FileReader(path);
         BufferedReader br = new BufferedReader(fr)) {
        return br.readLine();
    }
}
~~~

En este ejemplo, se declaran dos recursos, `FileReader` y `BufferedReader`, dentro del bloque try-with-resources. Estos recursos se cerrarán automáticamente al finalizar la ejecución del bloque, incluso si se produce una excepción.

Antes de Java 7, era necesario utilizar un bloque finally para asegurarse de que los recursos se cerraran, incluso en caso de excepciones. Sin embargo, el uso del try-with-resources simplifica el código y garantiza que los recursos se cierren correctamente, incluso en caso de excepciones.

more info: [docs.oracle](https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html) [geeksforgeeks](https://www.geeksforgeeks.org/try-with-resources-feature-in-java/) 
