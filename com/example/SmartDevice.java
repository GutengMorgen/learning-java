package com.example;

public class SmartDevice {

    String marca, modelo, color;

    public SmartDevice() {
    }

    public SmartDevice(String marca, String modelo, String color) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
    }

    public static class SmartPhone extends SmartDevice {
        String system;
        int ram;

        public SmartPhone() {
            super();
        }

        public SmartPhone(String marca, String modelo, String color, String system, int ram) {
            super(marca, modelo, color);

            this.system = system;
            this.ram = ram;
        }
    }

    public static class SmartWatch extends SmartDevice {

        String conectividad;
        double pulgadas;

        public SmartWatch() {
            super();
        }

        public SmartWatch(String marca, String modelo, String color, String conectividad, double pulgadas) {
            super(marca, modelo, color);

            this.conectividad = conectividad;
            this.pulgadas = pulgadas;
        }

    }

    public static void main(String[] args) {
        SmartPhone smartPhone = new SmartPhone("Samsung", "S10", "Azul", "Android", 9);

        SmartWatch smartWatch = new SmartWatch("Xiaomi", "Mi Band 6", "Negro", "Bluetooth", 3.54);

        System.out.println("El smartphone es: " + smartPhone + "\nEl smartwatch es: " + smartWatch);
    }
}
