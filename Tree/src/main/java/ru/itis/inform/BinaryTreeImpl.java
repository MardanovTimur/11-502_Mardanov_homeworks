package ru.itis.inform;

import java.util.ArrayList;
import java.util.LinkedList;


public class BinaryTreeImpl<T extends Comparable> implements BinaryTree<T> {

    private Root<T> root;

    private boolean flag = true;

    public BinaryTreeImpl() {
    }

    private <T extends Comparable> Root<T> addRoot(Root<T> root, T value) {
        if (root == null) {
            root = new Root<T>((Integer)value);
        } else {
            int compare = root.compareTo((Integer)value);
            switch (compare) {
                case 1: {
                    root.setRight(addRoot(root.getRight(), value));
                    break;
                }
                case 0: {
                    throw new IllegalArgumentException();
                }
                case -1: {
                    root.setLeft(addRoot(root.getLeft(), value));
                    break;
                }
            }
        }
        return root;
    }

    private void showTree(Root<T> root, int level) {
        if (root != null) {
            showTree(root.getRight(), level + 1);

            for (int i = 0; i < level; i++) {
                System.out.print("  ");
            }
            System.out.println(root.getKey());
            showTree(root.getLeft(), level + 1);

        }
    }

    private void showInOrderRec(Root<T> root) {
        if (root != null) {
            showInOrderRec(root.getLeft());
            System.out.print(root.getValue() + " ");
            showInOrderRec(root.getRight());
        }
    }

    public void show() {
        showTree(this.root, 0);
        System.out.println();
    }

    public void showInOrder() {
        showInOrderRec(this.root);
        System.out.println();
    }

    public void insert(T element) {
        this.root = addRoot(this.root, element);
    }

    public Root<T> getRoot() {
        return root;
    }


    public Queue<T> getLevelRoots(int level) {

        Root<T> root = this.root;

        Root<T> x = new Root<T>();

        Queue<T> q = new Queue<T>();

        if (level == 1) {
            q.enqueue(root);
            return q;
        }

        q.enqueue(root);

        while (!q.empty()) {
            x = q.dequeue();

            if (x.getLeft() != null) {
                q.enqueue(x.getLeft());
            } else {
                q.setiLength(q.getiLength()+1);

            }
            if (x.getRight() != null) {
                q.enqueue(x.getRight());
            } else  {
                q.setiLength(q.getiLength()+1);
            }
            if (Math.pow(2, level-1) == (double) q.getiLength()) {
                return q;
            }
        }
        return null;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean treeIsBinary() {
        rootSearch(root);
        return flag;

    }

    private void rootSearch(Root<T> root) {
        if (root.getRight() != null && root.getLeft() != null)
            if (root.getRight().compareTo((Integer) root.getValue()) == -1 && root.getLeft().compareTo((Integer) root.getValue()) == 1) {
                rootSearch(root.getRight());
                rootSearch(root.getLeft());
                this.flag = true;
            } else
                this.flag = false;
        else {
            if (root.getRight() != null) {
                rootSearch(root.getRight());
            } else if (root.getLeft() != null) {
                rootSearch(root.getLeft());
            } else
                this.flag = false;
        }
    }
}




