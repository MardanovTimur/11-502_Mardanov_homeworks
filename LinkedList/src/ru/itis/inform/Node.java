package ru.itis.inform;

/**
 * Created by Тимур on 14.02.2016.
 */
public class Node {

    private int value;

    private Node next;

    public Node(int value) {
        this.value = value;
        this.next =  null;
    }

    public Node getNext() {
        return next;
    }

    public int getValue() {
        return value;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
