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
        do {
            if (this.list.getFirst().getNext().getB() + this.list.getFirst().getB() <= this.n) {
                Node node = list.getFirst();

                Node newNode = new Node(node.getNext().getA() + node.getA(), node.getNext().getB() + node.getB());

                newNode.setNext(node.getNext());
                node.setNext(newNode);

                fixCount++;

                list.getFirst().setNext(list.getFirst().getNext());
                } else {
                    index++;
                }
        } while (this.index < fixCount - 1);
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




  /*  private void Shift(int fixCount, RationalNumber mas[], int index) {
       int buffer1 = mas[fixCount-1].getA();
       int buffer2 = mas[fixCount-1].getB();
        for (int i = fixCount-1; i>index+1; i--) {
            mas[i] = new RationalNumber(mas[i-1].getA(), mas[i - 1].getB());
        }
        mas[index+1] = new RationalNumber(buffer1, buffer2);
    }
}*/
}