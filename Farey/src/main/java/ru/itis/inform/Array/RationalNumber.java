package ru.itis.inform.Array;

/**
 * Created by Тимур on 17.02.2016.
 */
public class RationalNumber {
    private int a;
    private int b;
    private static final int DEFAULT = -1;

    public RationalNumber(int a, int b) {
        if (b != 0) {
            this.a = a;
            this.b = b;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public RationalNumber() {
        this.a = DEFAULT;
        this.b = DEFAULT;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}
