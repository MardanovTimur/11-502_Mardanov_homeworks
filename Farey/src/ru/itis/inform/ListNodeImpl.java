package ru.itis.inform;

/**
 * Created by Тимур on 15.02.2016.
 */
public class ListNodeImpl implements ListNode {
    private Node first;
    private int count;

    public ListNodeImpl() {
        this.first = null;
        this.count = 0;
    }

    public Node getFirst() {
        return this.first;
    }

    public void add(int a, int b) {
        Node newNode = new Node(a,b);
        if (this.first == null) {
            this.first = newNode;
            this.count++;
        } else {
            newNode.setNext(first);
            this.first = newNode;
            this.count++;
        }
    }


    public void remove(int a, int b) {
        Node r = first;
        for (int i = 0; i< this.count-1; i++) {
            if (r.getNext().getA() == a && r.getNext().getB() == b) {
                r.setNext(r.getNext().getNext());
                break;
            } else
                if (i==0 && r.getA() == a && r.getB() == b) {
                    r.setNext(r.getNext());
                }
            r = r.getNext();
        }
    }

    public void show() {
        Node f = first;
        while (f!=null) {
            if (f.getNext()!=null)
                System.out.print(f.getA()+"/"+f.getB()+", ");
            else
                System.out.print(f.getA()+"/"+f.getB()+".");
            f = f.getNext();
        }
    }
}