package ru.itis.inform;

/**
 * Created by ����� on 10.02.2016.
 */
public class RationalNumber {

    private int a;

    private int b;


    public RationalNumber(int a, int b) {
        this.a = a;
        if (b != 0) {
            this.b = b;
        }
    }

    public int getA() {
        return this.a;
    }

    public int getB() {
        return this.b;
    }
}