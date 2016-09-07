package ru.itis.inform.LinkedList;


public class RationalNumber {

    private int a;
    private int b;

    public RationalNumber(int a, int b) {
        if (b != 0) {
            this.a = a;
            this.b = b;
        } else {
            throw new IllegalArgumentException();
        }
    }


    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}
