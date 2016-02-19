package ru.itis.inform.LinkedList;

/**
 * Created by Тимур on 15.02.2016.
 */
public interface ListNode<T> {
    void add(T element);
    void remove(T element);
    void show();
    void push(T element);
}
