package ru.itis.inform.LinkedList;

public class FareyLinkedListImpl<T> implements FareyLinkedList<T> {

    private int n;

    private ListNodeImpl<Integer> list;
    private Iterator<Integer>  iterator;

    public void initialize(T n) {
        this.list = new ListNodeImpl<Integer>();
        list.push(0, 1);
        list.push(1, 1);
        this.n = (Integer)n;
        this.iterator = list.iterator();
    }

    public void generate() {
        while (iterator.hasNext()) {
            if (iterator.thisIterator().getB() + iterator.next().getB() <=this.n) {

                iterator.previous();

                int a = iterator.next().getA()+iterator.next().getA();
                iterator.previous();
                iterator.previous();
                int b = iterator.next().getB()+iterator.next().getB();
                iterator.previous();
                iterator.insert(a,b);

                iterator.previous();
            }
        }
    }

    public void print() {
    this.iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getA()+"/");
            iterator.previous();
            System.out.println(iterator.next().getB()+" ");
        }
    }

}
