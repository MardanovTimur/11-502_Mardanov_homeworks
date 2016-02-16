package ru.itis.inform;

/**
 * Created by Тимур on 15.02.2016.
 */
public class Node {
    private Node next;
    private int a;
    private int b;

    public Node(int a, int b) {
        this.next = null;
        if (b!=0) {
            this.a = a;
            this.b = b;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}
