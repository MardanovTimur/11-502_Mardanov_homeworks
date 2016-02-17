package ru.itis.inform.LinkedList;

public class FareyLinkedListImpl implements FareyLinkedList {

    private int n;

    private int fixCount;
    private int index;
    private ListNodeImpl list;

    public void Generate(int n) {

        Initialize();

        this.n = n;

        RationalNumber node = list.getFirst();

        do {
            if (node.getNext().getB() + node.getB() <= this.n) {

                RationalNumber newNode = new RationalNumber(node.getNext().getA() + node.getA(), node.getNext().getB() + node.getB());


                newNode.setNext(node.getNext());
                node.setNext(newNode);

            } else {
                node = node.getNext();
                index++;
            }
        } while (node.getNext() != null);
    }

    private void Initialize() {
        this.list = new ListNodeImpl();
        this.list.push(0, 1);
        this.list.push(1, 1);
    }

    public void Print() {
        list.show();
    }
}