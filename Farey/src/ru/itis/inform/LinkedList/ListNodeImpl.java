package ru.itis.inform.LinkedList;

/**
 * Created by Тимур on 15.02.2016.
 */
public class ListNodeImpl implements ListNode {
    private RationalNumber first;
    private RationalNumber last;

    private int count;

    public RationalNumber getFirst() {
        return this.first;
    }

    public ListNodeImpl() {
        this.first = null;
        this.count = 0;
    }

    //Add first
    public void add(int a, int b) {
        RationalNumber newNode = new RationalNumber(a,b);


        newNode.setPrevious(null);
        if (first == null) {
            this.first = newNode;
        } else {
            newNode.setNext(first);
            first.setPrevious(newNode);
            this.first = newNode;
        }
        this.count++;
    }


    //Insert last element
    public void push(int a, int b) {
        RationalNumber newNode = new RationalNumber(a,b);

        this.last = null;

        if (first == null) {
            this.first = newNode;
            first.setNext(last);
        } else {
            RationalNumber f = first;
            while (f.getNext()!=null) {
                f = f.getNext();
            }
            f.setNext(newNode);
            newNode.setPrevious(f);
        }
        this.count++;
    }



    public void remove(int a, int b) {
        RationalNumber r = first;
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
        RationalNumber f = first;
        while (f!=null) {
            if (f.getNext()!=null)
                System.out.print(f.getA()+"/"+f.getB()+", ");
            else
                System.out.print(f.getA()+"/"+f.getB()+".");
            f = f.getNext();
        }
    }
}