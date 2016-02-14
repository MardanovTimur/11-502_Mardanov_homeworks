package ru.itis.inform;

/**
 * Created by Тимур on 14.02.2016.
 */
public class LinkedListImpl implements LinkedList {
    private Node first;
    private int count;

    public LinkedListImpl() {
        this.first = null;
        this.count = 0;
    }

    public void add(int element) {
        Node newNode = new Node(element);
        if (this.first == null) {
            this.first = newNode;
            this.count++;
        } else {
            newNode.setNext(this.first);
            this.first = newNode;
            this.count++;
        }
    }

    public void printList() {
        Node r = this.first;
        while (r!=null) {
            System.out.print(r.getValue()+" ");
            r = r.getNext();
        }

    }

    public void remove(int element) {

    }

}

