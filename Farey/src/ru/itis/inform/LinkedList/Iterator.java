package ru.itis.inform.LinkedList;

/**
 * Created by Тимур on 19.02.2016.
 */
public interface Iterator<T> {
    boolean hasNext();

    T next();

    T previous();

    T peekNext();

    T peekPrevious();

    void insert(T element);

    int getCount();
}
