package ru.itis.inform.ArrayLs;

import java.util.*;

public class ArrayList<T> implements List<T> {
    private int DEFAULT_SIZE = 10;

    private T[] list;
    private int size = 0;

    public ArrayList(int length) {
        this.list = (T[]) new Object[length];
        this.size = 0;
    }

    public ArrayList() {
        this.list = (T[]) new Object[DEFAULT_SIZE];
    }

    public int size() {
        return size;
    }

    public boolean add(T t) {
        if (size < DEFAULT_SIZE) {
            list[size++] = t;
        } else {
            changeCapacity();
            add(t);
        }
        return true;
    }

    //todo
    public boolean remove(Object o) {
        int i = 0, indexer = 0;
        boolean f = true;
        while (f) {
            f = false;
            while (indexer < size) {
                if ((list[i++].equals(o) || f) && i < size) {
                    list[indexer] = list[i];
                    f = true;
                }
                indexer++;
            }
            indexer = 0;
            i = 0;
            if (f) size--;
        }
        if (list[size - 1].equals(o)) {
            size--;
        }
        return true;
    }

    private void changeCapacity() {
        int oldSize = DEFAULT_SIZE;
        DEFAULT_SIZE = (DEFAULT_SIZE * 3) / 2 + 1;
        T[] newList = (T[]) new Object[DEFAULT_SIZE];
        System.arraycopy(list, 0, newList, 0, oldSize);
        list = newList;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object o) {
        for (T t : list) {
            if (t.equals(o)) {
                return true;
            }
        }
        return false;
    }

    //todo
    public Iterator<T> iterator() {
        return null;
    }

    public Object[] toArray() {
        return list;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    public boolean containsAll(Collection<?> c) {
        return false;
    }

    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    public boolean removeAll(Collection<?> c) {
        return false;
    }

    public boolean retainAll(Collection<?> c) {
        return false;
    }

    public void clear() {

    }

    @Override
    public String toString() {
        String s = new String("");
        for (int i = 0; i < size; i++) {
            s = s.concat(list[i] + " ");
        }
        return s;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    public T get(int index) {
        return index < size ? list[index] : null;
    }

    public T set(int index, T element) {
        if (checkIndex(index)) {
            int j = 0;
            size++;
            while (size - index - j > 0) {
                list[size - j] = list[size - j - 1];
                j++;
            }
            list[index] = element;
            return element;
        } else {
            return null;
        }
    }

    private boolean checkIndex(int index) {
        return index >= 0 && index <= size;
    }

    @Override
    public void add(int index, T element) {
        set(index, element);
    }

    public T remove(int index) {
        if (checkIndex(index)) {
            int i = 0;
            size--;
            T elem = list[index];
            while (size - index - i > 0) {
                list[index + i] = list[index + i + 1];
                i++;
            }
            return elem;
        } else {
            return null;
        }
    }

    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        return 0;
    }

    public ListIterator<T> listIterator() {
        return null;
    }

    public ListIterator<T> listIterator(int index) {
        return null;
    }

    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
