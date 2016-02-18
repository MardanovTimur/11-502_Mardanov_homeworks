package ru.itis.inform;

/**
 * Created by Тимур on 18.02.2016.
 */
public class IteratorImpl<T> implements Iterator<T> {
    private Node<T> current;

    public IteratorImpl(Node<T> first) {
        this.current = first;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public T next(){
        T value = current.getValue();
        this.current = current.getNext();
        return value;
    }
    @Override
    public T previous() {
        if (current.getPrevious()!=null) {
            T value = current.getPrevious().getValue();
            this.current = current.getPrevious();
            return  value;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void Insert(T element) {

    }

}
