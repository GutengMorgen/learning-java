package com.example;

import java.util.Scanner;

public class example2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce un precio: ");
        int precio = scanner.nextInt();

        double iva = precio * 0.21;
        double suma = precio + iva;

        System.out.println("El resultado del precio con IVA es: " + suma);

        scanner.close();
    }
}