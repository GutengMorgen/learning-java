package com.example;

public class exceptions {

    public static class MyException extends Exception {
        public MyException(String s) {
            super(s);
        }
    }

    public static class MyClass {
        public static void main(String[] args) {
            try {
                throw new MyException("nigger");
            } catch (MyException ex) {
                // System.out.println(ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

}
