package ru.itis.inform;

/**
 * Created by Тимур on 30.03.2016.
 */
public class Node<T> {
    private Node<T> next;
    private Node<T> previous;
    private int indexX;
    private int indexY;
    private T value;

    public Node (T value, int indexX, int indexY) {
        this.value = value;
        this.next = null;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {

        return value;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public Node<T> getPrevious() {

        return previous;
    }

    public Node<T> getNext() {
        return next;

    }
}
