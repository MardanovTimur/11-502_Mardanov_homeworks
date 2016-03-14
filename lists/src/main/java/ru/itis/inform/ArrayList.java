package ru.itis.inform;

/**
 * Created by Тимур on 24.02.2016.
 */
public class ArrayList<T> {

    private Object elements[];

    private int count;
    private int size = 0;
    private static int DEFAULT_SIZE = 101;

    public ArrayList() {
        initialize(DEFAULT_SIZE);
        this.count = 0;
    }

    public ArrayList(int size) {
        initialize(size);
        this.count = 0;
    }


    private void initialize(int size) {
        this.elements = new Object[size];
        this.size = size;
    }


    @SuppressWarnings("uchecked")
    public T  get(int index)  {
        this.count++;
        if (index<=size)
            return (T)elements[index];
        else
            throw new IllegalArgumentException();
    }

    public void set(int index, T element) {
        this.elements[index] = element;
    }

    public int getSize() {
        return size;
    }

}