package ru.itis.inform;

/**
 * Created by ����� on 14.02.2016.
 */
public interface LinkedList<T>{
    void add(T element);
    void remove(T element);
    void printList();
    void push(T element);
    int getCount();
    void setCount(int count);
    void append(LinkedListImpl<T> a);
    Node<T> getFirst();
}

