package ru.itis.inform.LinkedList;

public class FareyLinkedListImpl<T> implements FareyLinkedList<T> {

    private int n;

    private ListNodeImpl<RationalNumber> list;
    private Iterator<RationalNumber>  iterator;

    public void initialize(int n) {
        this.list = new ListNodeImpl<RationalNumber>();
        list.push(new RationalNumber(0,1));
        list.push(new RationalNumber(1,1));
        this.n = n;
        this.iterator = list.iterator();
    }

    public void generate() {
        //Итератор на второй элемент
        iterator.next();
        while (iterator.hasNext()) {
            if (iterator.peekPrevious().getB() + iterator.peekNext().getB() <=this.n) {

                int a = iterator.peekPrevious().getA()+iterator.peekNext().getA();

                int b = iterator.peekPrevious().getB()+iterator.peekNext().getB();

                iterator.insert(new RationalNumber(a,b));
            } else {
                iterator.next();
            }
        }
    }

    public void print() {
        Iterator<RationalNumber> newIterator = list.iterator();
        while (newIterator.hasNext()) {
            System.out.print(newIterator.peekNext().getA()+"/");
            System.out.print(newIterator.peekNext().getB()+" ");
            newIterator.next();
        }

    }

}
