package ru.itis.inform;


public class LinkedListImpl<T> implements LinkedList<T> {
    private Node<T> first;
    private Node<T> last;
    private int count;

    public LinkedListImpl() {
        this.first = null;
        this.count = 0;
    }

    public void add(T element) {

        Node<T> newNode = new Node<T>(element);

        this.last = null;

        if (this.first == null) {
            this.first = newNode;
            this.first.setNext(last);
        } else {
            newNode.setNext(this.first);
            first.setPrevious(newNode);
            this.first = newNode;
        }
        this.count++;
    }

    public void push(T element) {
        Node<T> newNode = new Node<>(element);

        if (this.first == null) {
            this.first = newNode;
            first.setNext(last);
            last.setNext(first);
            this.count++;
        } else {
            Node<T> r = first;
            while (r.getNext() != null) {
                r = r.getNext();
            }
            r.setNext(newNode);
            newNode.setPrevious(r);
            newNode.setNext(last);
        }
    }

    public void printList() {
        Node<T> r = first;
        while (r != null) {
            System.out.print(r.getValue() + " ");
            r = r.getNext();
        }
    }

    public void remove(T element) {
        Node<T> node = first;

        for (int i = 0; i < count - 1; i++) {
            if ((i == 0) && (node.getValue() == element)) {
                first = node.getNext();
                count--;
                break;
            } else if (node.getNext().getValue() == element) {
                node.setNext(node.getNext().getNext());
                count--;
            }
            node = node.getNext();
        }
    }


    public IteratorImpl<T> iterator() {
        return new IteratorImpl<T>(this.first);
    }

    public class IteratorImpl<T> implements Iterator<T> {

        private Node<T> current;

        public IteratorImpl(Node<T> first) {
            this.current = first;
        }

        @Override
        public boolean hasNext() {
            return current.getNext() != null;
        }

        public T peekNext() {
            return current.getValue();
        }

        public T peekPrevious() {
            return current.getPrevious().getValue();
        }

        @Override
        public T next() {
            T value = current.getValue();
            Node<T> f = current;
            this.current = f.getNext();
            return value;
        }

        @Override
        public T previous() {
            if (current.getPrevious() != null) {
                Node<T> f = this.current;
                T value = f.getPrevious().getValue();
                this.current = f.getPrevious();
                return value;
            } else {
                throw new IndexOutOfBoundsException();
            }
        }

        public void insert(T element) {
            Node<T> f = this.current;
            Node<T> insertNode = new Node<>(element);

            insertNode.setPrevious(f.getPrevious());
            insertNode.setNext(f);
            f.getPrevious().setNext(insertNode);
            f.setPrevious(insertNode);

            current = f.getPrevious();
        }


    }
}


