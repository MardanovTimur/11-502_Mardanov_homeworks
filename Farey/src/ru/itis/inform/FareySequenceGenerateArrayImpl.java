package ru.itis.inform;

public class FareySequenceGenerateArrayImpl implements FareySequenceGenerateArray {

    private int n;

    private int fixCount;
    private int index;
    private ListNodeImpl list;

    public void Generate(int n) {

        Initialize();

        this.n = n;
        this.fixCount = 2;
        boolean isEmpty = true;
        Node node = list.getFirst();
        do {


                if (node.getNext().getB() + node.getB() <= this.n) {

                Node newNode = new Node(node.getNext().getA() + node.getA(), node.getNext().getB() + node.getB());

                    //Перессылка на следующий элемент
                newNode.setNext(node.getNext());
                node.setNext(newNode);

                } else {
                    node = node.getNext();
                    index++;
                }
        } while (node.getNext() != null);
    }
    public void Print() {
       list.show();
    }

    private void Initialize() {
        this.list = new ListNodeImpl();
        this.list.add(0, 1);
        this.list.add(1, 1);
        //list.show();
    }
}