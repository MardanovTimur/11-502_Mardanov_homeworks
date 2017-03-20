package ru.itis.inform.second;

import ru.itis.inform.List;

/**
 * Created by timur on 14.03.17.
 */
public class LinkedList<T> implements List<T> {

    private Node<T> root;
    boolean rootIsEmpty;
    private int size;

    public LinkedList() {
        this.size = 0;
        this.rootIsEmpty = true;
    }

    public void add(T element) {
        if (rootIsEmpty) {
            this.root = new Node<T>(element, null, null);
            rootIsEmpty = false;
        } else {
            Node<T> newNode = new Node<T>(element, root);
            root.setPrevious(newNode);
            root = newNode;
        }
        size++;
    }

    public void addAfter(T element) {
        if (rootIsEmpty) {
            this.root = new Node<T>(element, null, null);
            rootIsEmpty = false;
        } else {
            Node<T> node = root;
            while (node.getNext() != null) {
                node = node.getNext();
            }
            Node<T> newNode = new Node<T>(element, null, node);
            node.setNext(newNode);
        }
        size++;
    }

    public void remove(T element) {
        if (rootIsEmpty) {
            System.out.println("Root is empty");
        } else {
            Node<T> node = root;
            if (root.getValue() == element) {
                root = root.getNext();
            } else {
                while (!(node.getNext().getValue() == (element)) && node.getNext() != null) {
                    node = node.getNext();
                }
                Node<T> oldNode = node.getNext().getNext();
                node.setNext(oldNode);
                if (oldNode!=null)
                    oldNode.setPrevious(node);
            }
            size--;
        }
    }

    public T get(int i) {
        Node<T> node = root;
        int counter = 0;
        while (counter < i && counter < size - 1) {
            node = node.getNext();
            counter++;
        }
        if (i > size - 1) {
            System.out.println("Exception!!! i havent many pieces:)");
            return null;
        } else {
            return node.getValue();
        }
    }

    public boolean has(T element) {
        if (rootIsEmpty) {
            System.out.println("Root is empty");
        } else {
            Node<T> node = root;
            if (root.getValue() == element) {
                return true;
            } else {
                while (node.getNext() != null) {
                    node = node.getNext();
                    if (node.getValue() == element) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Node<T> getRoot() {
        return root;
    }

    public void merge(LinkedList<T> list) {
        Node<T> node = root;
        if (rootIsEmpty) {
            root = list.getRoot();
        } else {
            while (node.getNext() != null) {
                node = node.getNext();
            }
            node.setNext(list.getRoot());
            list.getRoot().setPrevious(node);
        }
    }

    public boolean isRootIsEmpty() {
        return rootIsEmpty;
    }

    public int size() {
        return size;
    }
}
