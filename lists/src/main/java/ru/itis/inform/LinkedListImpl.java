package ru.itis.inform;


public class LinkedListImpl<T> implements LinkedList<T> {
    private Node<T> first;
    private Node<T> last;
    private int count;

    public LinkedListImpl() {
        this.first = null;
        this.count = 0;
    }

    public LinkedListImpl(Node<T> first) {
        this.first = first;
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

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
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
            System.out.println(r.getValue() + " ");
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


    public static <T extends Comparable> void toBeMergeSortWithRecursion(LinkedListImpl<T> linkedList, int leftIndex, int rightIndex) {
        if (rightIndex - leftIndex > 0) {
            int left_size = (rightIndex - leftIndex + 1) / 2;
            int right_size = (rightIndex - leftIndex + 1) - left_size;

            int skip = 0;
            Iterator<T> iteratorfirst = linkedList.iterator();

            LinkedListImpl<T> fmerge = new LinkedListImpl<>();

            for (int i = 1; i < leftIndex - 1; i++) {
                iteratorfirst.next();
            }
            for (int i = 1; i <= left_size; i++) {
                fmerge.push(iteratorfirst.next());
            }

            LinkedListImpl<T> smerge = new LinkedListImpl<>();

            for (int i = 1; i <= right_size; i++) {
                smerge.push(iteratorfirst.next());
            }


            toBeMergeSortWithRecursion(linkedList, leftIndex, leftIndex + left_size - 1);
            toBeMergeSortWithRecursion(linkedList, leftIndex + left_size, rightIndex);

            LinkedListImpl<T> sortedMergeList = new LinkedListImpl<>();

            sortedMergeList = merge(fmerge, smerge);

            Node<T> newNode = linkedList.getFirst();

            for (int i = 1; i < leftIndex; i++) {
                newNode = newNode.getNext();
            }

            Node<T> stopshit = sortedMergeList.getFirst();

            for (int i = 1; i <= right_size + left_size; i++) {
                newNode.setValue(stopshit.getValue());
                newNode = newNode.getNext();
                stopshit = stopshit.getNext();
            }
        }

    }

    public static <T extends Comparable> LinkedListImpl<T> toMerge(LinkedListImpl<T> linkedList) {
        ArrayList<LinkedListImpl<T>> arrayList = new ArrayList<LinkedListImpl<T>>();

        for (int i = 0; i <= linkedList.getCount(); i++) {
            arrayList.set(i, new LinkedListImpl<T>());
        }

        Iterator<T> iteratorLink = linkedList.iterator();

        arrayList.get(0).push(iteratorLink.next());
        int i = 1;
        while (iteratorLink.hasNext()) {
            while (arrayList.get(i).getFirst() != null) {
                i++;
            }
            arrayList.get(i).push(iteratorLink.next());
            for (int j = linkedList.getCount() - 1; j > 0; j--) {
                if (arrayList.get(j).getCount() == arrayList.get(j - 1).getCount() && arrayList.get(j - 1).getCount() != 0) {
                    LinkedListImpl<T> tLinkedList = new LinkedListImpl<>();
                    tLinkedList.mergeTwoArrayLists(arrayList,j);
                    i--;

                }
            }
        }

        for (int j = linkedList.getCount() - 1; j > 0; j--) {
            if (arrayList.get(j - 1).getCount() != 0) {
                LinkedListImpl<T> tLinkedList = new LinkedListImpl<>();
                tLinkedList.mergeTwoArrayLists(arrayList,j);
                i--;
            }
        }

        return arrayList.get(0);
    }

    public <T extends Comparable>void mergeTwoArrayLists(ArrayList<LinkedListImpl<T>> arrayList, int j) {
        LinkedListImpl<T> newLinkedList = new LinkedListImpl<>();
        newLinkedList = LinkedListImpl.merge(arrayList.get(j), arrayList.get(j - 1));
        newLinkedList.setCount(arrayList.get(j).getCount() + arrayList.get(j - 1).getCount());
        arrayList.set(j - 1, newLinkedList);
        arrayList.set(j, new LinkedListImpl<T>());
    }


    @SuppressWarnings("unchecked")
    public static <T extends Comparable> LinkedListImpl<T> merge(LinkedListImpl<T> a, LinkedListImpl<T> b) {
        Iterator<T> iteratorA = a.iterator();
        Iterator<T> iteratorB = b.iterator();

        LinkedListImpl<T> result = new LinkedListImpl<>();

        while (iteratorA.hasNext() && iteratorB.hasNext()) {
            int compare = iteratorA.peekNext().compareTo(iteratorB.peekNext());

            switch (compare) {
                case 1: {
                    result.push(iteratorB.peekNext());
                    iteratorB.next();
                    break;
                }

                case -1: {
                    result.push(iteratorA.peekNext());
                    iteratorA.next();
                    break;
                }

                case 0: {
                    result.push(iteratorA.peekNext());
                    result.push(iteratorB.peekNext());
                    iteratorA.next();
                    iteratorB.next();
                    break;
                }
            }
        }

        while (iteratorA.hasNext()) {
            result.push(iteratorA.next());
        }

        while (iteratorB.hasNext()) {
            result.push(iteratorB.next());
        }

        return result;
    }

    @SuppressWarnings("unchecked")
    public void append(LinkedListImpl<T> secondList) {

        if (this.first == null) {
            Node<T> nodeSecondList = secondList.getFirst();

            this.first = nodeSecondList;
            Node<T> r = this.first;
            nodeSecondList = nodeSecondList.getNext();

            appendTwoElements(r, nodeSecondList);

        } else {
            Node<T> r = this.first;

            while (r.getNext() != null)
                r = r.getNext();


            if (secondList != null) {
                Node<T> t = secondList.getFirst();

                appendTwoElements(r, t);
            }

        }
    }

    private void appendTwoElements(Node<T> r, Node<T> tNode) {
        while (tNode != null) {
            r.setNext(tNode);
            tNode.setPrevious(r);
            r = r.getNext();
            tNode = tNode.getNext();
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

        public Node<T> getCurrentNode() {
            return current;
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
