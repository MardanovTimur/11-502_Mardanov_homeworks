package ru.itis.inform.LinkedList;

/**
 * Created by Тимур on 17.02.2016.
 */
public class RationalNumber {
    private static final int DEFAULT = -1;

    private int a;
    private int b;

    private RationalNumber next;
    private RationalNumber previous;



    public RationalNumber(int a, int b) {
        this.next = null;
        if (b!=0) {
            this.a = a;
            this.b = b;
        } else  {
            throw new IllegalArgumentException();
        }
    }

    public void setNext(RationalNumber next) {
        this.next = next;
    }

    public void setPrevious(RationalNumber previous) {
        this.previous = previous;
    }

    public RationalNumber getNext() {
        return next;
    }

    public RationalNumber getPrevious() {
        return previous;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}
