package ru.itis.inform;

/**
 * Created by Тимур on 18.02.2016.
 */
public interface Iterator<T> {
    boolean hasNext();
    T next();
    T previous();
    void Insert(T element);
}
