sources: 
- [Core Java Programming](https://www.techguruspeaks.com/home/core-java-programming/java-exception-handling/)
- [Exceptions in Java](https://www.geeksforgeeks.org/exceptions-in-java/)
- [Flow control in try catch finally in Java](https://www.geeksforgeeks.org/flow-control-in-try-catch-finally-in-java/)
cuando una excepcion ocurre dentro de un metodo se crea un objeto, aka. exception object

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
Estos son algunos paso que sigue el compilador o JVM cuando ocurre una excepcion:

- crea un objeto con toda la informacion de la excepcion, aka exceptions object
- usa el call stack para encontrar un metodo apropiado que capture la excepcion
- da el excepcion object a ese metodo para ejecutarlo, si no encuentra un metodo que capture la excepcion entonces se ejecuta el default exception handling del JVM para capturar la excepcion y terminar el programa.

