package com.stuff;

// import java.util.*;
import java.io.*;
import java.util.ArrayList;

class reader {
    static String line = "";
    static String splitBy = ";";

    public static void main(String[] args) {
        readCSV();
    }

    private static void readCSV() {
        // File pathFile = new File("com\\stuff\\content.csv");

        // Scanner sc = new Scanner(pathFile);
        // sc.useDelimiter(",");

        // while (sc.hasNext()) {
        // System.out.println(sc.next());
        // }

        // sc.close();
        // String[] actualValues;
        // ArrayList

        try (BufferedReader buffer = new BufferedReader(new FileReader("com\\stuff\\content.csv"))) {
            while ((line = buffer.readLine()) != null) {
                String[] currency = line.split(splitBy);
                System.out.println(currency[0].trim());
                // actualValues.
                // if (currency[0] == "usd") {
                // System.out.println(currency[1]);
                // } else {
                // System.out.println("efafe");
                // }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}