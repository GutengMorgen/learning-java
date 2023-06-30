package com.testing;

public class ds {
    public static void main(String[] args) {
        System.out.println(fact(15)); // 20 return negative number
    }

    private static int fact(int number) {

        if (number >= 1)
            return number * fact(number - 1);
        else
            return 1;
    }
}
