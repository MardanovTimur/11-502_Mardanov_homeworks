package ru.itis.inform;


public interface BlackRedTree<T extends Comparable<T>>  {
    void addVertex(int key, T value);
    Root<T> getRoot();
    void show();
}
