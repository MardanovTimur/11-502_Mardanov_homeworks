package ru.itis.inform.LinkedList;

/**
 * Created by Тимур on 19.02.2016.
 */
public class IteratorImpl<T> implements Iterator<T> {
    private Node<T> current;

    public IteratorImpl(Node<T> first) {
        this.current = first;
    }

    public boolean hasNext() {
        return current!=null;
    }

    public T next() {
        T value = current.getValue();
        Node<T> f = this.current;
        this.current = f.getNext();
        return value;
    }


    public T previous() {
        if (current.getPrevious() != null) {
            T value = current.getPrevious().getValue();
            Node<T> f = this.current;
            this.current = f.getPrevious();
            return value;
        } else {
            throw  new IndexOutOfBoundsException();
        }
    }


    public T peekNext() {
        T value = current.getValue();
        return value;
    }

    public T peekPrevious() {
        T value = current.getPrevious().getValue();
        return value;
    }

    public void insert(T element) {
        Node<T> clipboard = new Node<>(element);
        Node<T> f = this.current;



        clipboard.setPrevious(f.getPrevious());
        f.getPrevious().setNext(clipboard);
        clipboard.setNext(f);
        f.setPrevious(clipboard);

        this.current = f.getPrevious();
    }
}
