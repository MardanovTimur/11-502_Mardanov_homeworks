package ru.itis.inform;

/**
 * Created by Тимур on 27.03.2016.
 */
public interface BinaryTree<T> {
    void show();
    void insert(T value);
    void showInOrder();
    Queue<T> getLevelRoots(int level);
    Root<T> getRoot();
    boolean treeIsBinary();
    void setFlag(boolean f);
}
