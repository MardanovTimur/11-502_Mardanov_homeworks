package ru.itis.inform;

import ru.itis.inform.simple.LinkedList;


/**
 * Created by timur on 14.03.17.
 */
public interface List<T> {
    void add(T element);
    void addAfter(T element);
    void remove(T element);
    T get(int i);
    boolean has(T element);
}
