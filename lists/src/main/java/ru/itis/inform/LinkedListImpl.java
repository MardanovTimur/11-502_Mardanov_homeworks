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
        } else {
            Node<T> r = first;
            while (r.getNext() != null) {
                r = r.getNext();
            }
            r.setNext(newNode);
            newNode.setPrevious(r);
            newNode.setNext(last);
        }
        this.count++;
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
        boolean flag = true;
        for (int i = 0; i < count - 1; i++) {
            if ((i == 0) && (node.getValue() == element) && (flag)) {
                first = node.getNext();
                count--;
                flag = false;
                break;
            } else if ((node.getNext().getValue() == element) && (flag)) {
                node.setNext(node.getNext().getNext());
                count--;
                flag = false;
            }
            node = node.getNext();
        }
        if (flag && (node.getValue() == element)) {
            node = null;
            flag = false;
        }

        if (flag) {
            throw new NullPointerException();
        }
    }

    @SuppressWarnings("unchecked")
    public void append(LinkedListImpl<T> secondList) {

        if (this.first == null) {
            Node<T> nodeSecondList = secondList.getFirst();

            this.first = nodeSecondList;
            Node<T> r = this.first;
            nodeSecondList = nodeSecondList.getNext();

            while (nodeSecondList != null) {
                r.setNext(nodeSecondList);
                nodeSecondList.setPrevious(r);
                r = r.getNext();
                nodeSecondList = nodeSecondList.getNext();
            }

        } else {
            Node<T> r  = this.first;

            while (r.getNext() != null)
                r = r.getNext();

            Node<T> t = secondList.getFirst();

            while (t!=null) {
                r.setNext(t);
                t.setPrevious(r);
                r = r.getNext();
                t = t.getNext();
            }
        }
    }

    public Node<T> getFirst() {
        return first;
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
            return current != null;
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
