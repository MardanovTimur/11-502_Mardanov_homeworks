package ru.itis.FUCK;


public class Program {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();

        B fromA = a;

        A aFromB = (A)fromA;
    }
}
