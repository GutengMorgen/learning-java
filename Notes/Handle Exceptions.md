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

- try:
- catch:
- finally:
- throw:
- throws:

### How JVM handle the exceptions



