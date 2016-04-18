package ru.itis.inform;

/**
 * Created by Тимур on 13.04.2016.
 */
public class BlackRedTreeImpl<T extends Comparable<T>> implements BlackRedTree<T> {
    private Root<T> root;
    private int height;

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    //True - is RED, False - is Black;


    //Constructor
    public BlackRedTreeImpl(T value) {
        this.root.setValue(value);
        this.root.setColor(false);
    }

    public BlackRedTreeImpl(int height) {
        this.height = height;
    }

    private int heightRoot(Root<T> root) {
        if (root == null) {
            return 0;
        } else {
            return  root.getHeight();
        }
    }

    private void insert(T element) {
        root = put(root,element);
        root.setColor(BLACK);
    }

    private void put(Root<T> root, T value) {

    }

}

