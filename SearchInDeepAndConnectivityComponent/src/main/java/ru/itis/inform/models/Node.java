package ru.itis.inform.models;

import java.util.List;

/**
 * Created by Timur Mardanov on 09.05.2017.
 * ITIS
 */
public class Node<T> {
    private int key;
    private T value;
    private List<Node> list;

    public Node(int key, T value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
