package ru.itis.inform;

public interface Iterator<T> {
    boolean hasNext();
    Node<T> getCurrentNode();
    T next();
    T peekNext();
    T peekPrevious();
    T previous();
    void insert(T element);
}
