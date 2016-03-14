package ru.itis.inform;

/**
 * Created by Тимур on 24.02.2016.
 */
public class Node<T> {
    Node<T> next;
    Node<T> previous;
    T value;

    public Node(T value) {
        this.value = value;
        this.next = null;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getNext() {
        return next;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

}
