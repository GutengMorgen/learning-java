package com.example;

import java.io.*;
import java.util.*;

public class task7 {

    public static class TextoReves {

        public static void main(String[] args) {
            String texto;
            Scanner scanner = new Scanner(System.in);

            System.out.println("Introduce un texto:");
            texto = scanner.nextLine();
            scanner.close();

            StringBuilder reves = new StringBuilder(texto);
            texto = reves.reverse().toString();

            System.out.println(texto);
        }
    }

    public static class ArrayUnidemensional {

        public static void main(String[] args) {
            String palabras[] = { "Hola", "Mundo" };

            for (String palabra : palabras) {
                System.out.println(palabra);
            }

        }
    }

    public static class ArrayBidimensional {

        public static void main(String[] args) {
            Integer[][] numeros = {
                    { 1, 2, 3 },
                    { 4, 5, 6 }
            };

            for (int i = 0; i < numeros.length; i++) {

                for (int j = 0; j < numeros[i].length; j++) {

                    System.out.println("Fila: " + (i + 1) + " | Columna: " + (j + 1) +
                            "\nEl valor es: " + numeros[i][j] + "\n");
                }
            }
        }

    }

    public static class vector {

        public static void main(String[] args) {
            Vector<Integer> vector = new Vector<Integer>();
            // Vector<E> vector = new Vector();

            vector.add(1);
            vector.add(2);
            vector.add(3);
            vector.add(4);

            System.out.println("Vector antes de borrar: " + vector);

            vector.remove(2);
            vector.remove(1);

            System.out.println("Vector despues de borrar: " + vector + " -> Eliminados el 2 y 3");
        }
    }

    /*
     * Cada vez que se excede la capacidad actual del Vector, se crea un nuevo
     * arreglo interno con una capacidad mayor y
     * se copian todos los elementos del arreglo anterior al nuevo.
     * Este proceso de redimensionamiento y copiado de elementos es muy costoso.
     */

    public static class ArrayListString {
        public static void main(String[] args) {
            LinkedList<String> linkedlist = new LinkedList<String>();
            ArrayList<String> lista = new ArrayList<String>();

            lista.add("Elemento 1");
            lista.add("Elemento 2");
            lista.add("Elemento 3");
            lista.add("Elemento 4");

            for (int i = 0; i < lista.size(); i++) {
                linkedlist.add(i, lista.get(i));
            }

            System.out.println("Elementos del Array:");
            for (String elementos : lista) {
                System.out.print(elementos + " ");
            }

            System.out.println("\n\nElementos de la LinkedList:");
            for (String elementos : linkedlist) {
                System.out.print(elementos + " ");
            }
        }
    }

    public static class ArrayListInt {
        public static void main(String[] args) {
            ArrayList<Integer> lista = new ArrayList<Integer>();

            for (int i = 1; i < 11; i++) {
                lista.add(i);

                for (int num = 0; num < lista.size(); num++) {

                    if (lista.get(num) % 2 == 0)
                        lista.remove(num);
                }
            }

            System.out.println(lista);
        }
    }

    public static class DividePorCero {

        static int dividir(int x, int y) throws ArithmeticException {
            return x / y;
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Indica los numeros entero que quieres dividir: ");
            System.out.print("Numero 1: ");
            int x = scanner.nextInt();
            System.out.print("Numero 2: ");
            int y = scanner.nextInt();
            scanner.close();
            try {
                System.out.println("Resultado: " + dividir(x, y));
            } catch (ArithmeticException e) {
                System.out.println("No es posible dividir los numeros");
            }
        }
    }

    /**
     * copiarContenido
     */
    public static class copiarContenido {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Introduce el fichero de origen: ");
            String fileIn = scanner.nextLine();
            System.out.println("Introduce el fichero de destino: ");
            String fileOut = scanner.nextLine();
            copiar(fileIn, fileOut);
            scanner.close();
        }

        private static void copiar(String file_in, String file_out) {
            try {
                InputStream in = new FileInputStream(file_in);
                byte[] datos = in.readAllBytes();
                in.close();

                PrintStream out = new PrintStream(file_in);
                out.write(datos);
                out.close();
            } catch (Exception e) {
                System.out.println("Excepcion: " + e.getMessage());
            }
        }

        public static class program {

            public static void main(String[] args) {
                InputStream inputStream = System.in;
                PrintStream printStream = System.out;

                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                    List<String> names = new ArrayList<>();

                    printStream.println("Ingresa los nombres (ingresa 'fin' para terminar):");

                    // Leer nombres hasta que se ingrese "fin"
                    String input;
                    while (!(input = reader.readLine()).equalsIgnoreCase("fin")) {
                        names.add(input);
                    }

                    // Imprimir los nombres en orden inverso
                    Collections.reverse(names);
                    printStream.println("Nombres en orden inverso:");
                    for (String name : names) {
                        printStream.println(name);
                    }
                } catch (IOException e) {
                    printStream.println("Error al leer los nombres: " + e.getMessage());
                }
            }
        }
    }
}