package ru.itis.inform;

public interface BinaryTree<T> {
    void show();
    void insert(T value);
    void showInOrder();
    Queue<T> getLevelRoots(int level);
    Root<T> getRoot();
    boolean treeIsBinary();
    void setFlag(boolean f);
}
