package ru.itis.inform.LinkedList;

/**
 * Created by Тимур on 17.02.2016.
 */
public class RationalNumber<T> {
    private static final int DEFAULT = -1;

    private T a;
    private T b;

    private RationalNumber<T> next;
    private RationalNumber<T> previous;



    public RationalNumber(T a, T b) {
        this.next = null;
        if ((Integer)b != 0) {
            this.a = a;
            this.b = b;
        } else  {
            throw new IllegalArgumentException();
        }
    }

    public void setNext(RationalNumber<T> next) {
        this.next = next;
    }

    public void setPrevious(RationalNumber<T> previous) {
        this.previous = previous;
    }

    public RationalNumber<T> getNext() {
        return next;
    }

    public RationalNumber<T> getPrevious() {
        return previous;
    }

    public T getA() {
        return a;
    }

    public T getB() {
        return b;
    }
}
