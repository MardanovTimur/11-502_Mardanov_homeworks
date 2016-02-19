package ru.itis.inform.LinkedList;

/**
 * Created by Тимур on 19.02.2016.
 */
public class IteratorImpl<T> implements Iterator<T> {
    private RationalNumber<T> current;

    public IteratorImpl(RationalNumber<T> first) {
        this.current = first;
    }

    public boolean hasNext() {
        return current!=null;
    }

    public RationalNumber<T> thisIterator(){
        RationalNumber<T> f = this.current;
        return f;
    }

    public RationalNumber<T> next() {
        RationalNumber<T> f = current;

        current = current.getNext();
        return f;
    }


    public RationalNumber<T> previous() {
        if (current.getPrevious() != null) {
            RationalNumber<T> f = current.getPrevious();
            current = current.getPrevious();
            return f;
        } else {
            throw  new IndexOutOfBoundsException();
        }
    }

    public void insert(T a, T b) {
        RationalNumber<T> clipboard = new RationalNumber<>(a, b);
        RationalNumber<T> f = this.current;

        clipboard.setPrevious(f.getPrevious());
        f.getPrevious().setNext(clipboard);
        clipboard.setNext(f);
        f.setPrevious(clipboard);

    }
}
