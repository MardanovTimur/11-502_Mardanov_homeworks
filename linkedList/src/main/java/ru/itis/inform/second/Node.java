package ru.itis.inform.second;

/**
 * Created by timur on 14.03.17.
 */
public class Node<T> {
    private T value;
    private Node<T> next;
    private Node<T> previous;

    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }

    public Node(T value, Node<T> next, Node<T> previous) {
        this.value = value;
        this.next = next;
        this.previous = previous;
    }

    public Node() {
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
