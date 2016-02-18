package ru.itis.inform;


public class LinkedListImpl<T> implements LinkedList<T> {
    private Node<T> first;
    private int count;

    public LinkedListImpl() {
        this.first = null;
        this.count = 0;
    }

    public void add(T element) {

        Node<T> newNode = new Node<T>(element);

        if (this.first == null) {
            this.first = newNode;
        } else {
            newNode.setNext(this.first);
            first.setPrevious(newNode);
            this.first = newNode;
        }
        this.count++;
    }

    public void push(T element) {
        Node<T> newNode = new Node<>(element);

        if (this.first == null) {
            this.first = newNode;
            this.count++;
        } else {
            Node<T> r = first;
            while (r.getNext() != null) {
                r = r.getNext();
            }
            r.setNext(newNode);
            newNode.setPrevious(r);
        }
    }

    public void printList() {
        Node<T> r = first;
        while (r!=null) {
            System.out.print(r.getValue()+" ");
            r = r.getNext();
        }
    }

    public void remove(T element) {
        Node<T> node = first;

        for(int i = 0; i < count-1; i++) {
            if ((i==0) && (node.getValue() == element)) {
                first = node.getNext();
                count--;
                break;
            }
                else
            if(node.getNext().getValue() == element) {
                node.setNext(node.getNext().getNext());
                count--;
            }
            node = node.getNext();
        }
    }

    public IteratorImpl<T> iterator() {
        return new IteratorImpl<T>(this.first);
    }
}


