package ru.itis.inform.LinkedList;

/**
 * Created by Тимур on 19.02.2016.
 */
public interface Iterator<T> {
    boolean hasNext();
    RationalNumber<T> next();
    RationalNumber<T> previous();
    RationalNumber<T> thisIterator();
    void insert(T a, T b);
}
