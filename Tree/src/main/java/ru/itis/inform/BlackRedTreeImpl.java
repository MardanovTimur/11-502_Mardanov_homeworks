package ru.itis.inform;

import javax.swing.text.DefaultEditorKit;

/**
 * Created by Тимур on 13.04.2016.
 */
public class BlackRedTreeImpl<T extends Comparable<T>> implements BlackRedTree<T> {
    private Root<T> root;
    private int height;
    private Root<T> insertionRoot;

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    //True - is RED, False - is Black;

    //Constructor
    public BlackRedTreeImpl(int key, T value) {
        root = new Root<T>(value, key);
        root.setColor(BLACK);
    }

    public BlackRedTreeImpl(int height) {
        this.height = height;
    }

    private int heightRoot(Root<T> root) {
        if (root == null) {
            return 0;
        } else {
            return root.getHeight();
        }
    }

    private Root<T> insert(Root<T> root, Root<T> rootParent, int key, T value) {
        if (root == null) {
            root = new Root<T>(value, key);
            root.setColor(RED);
            if (rootParent != null) {
                root.setParent(rootParent);
            }
            this.insertionRoot = root;
        } else {
            int compare = root.compareTo(key);
            switch (compare) {
                case 1: {
                    root.setRight(insert(root.getRight(), root, key, value));
                    break;
                }
                case -1: {
                    root.setLeft(insert(root.getLeft(), root, key, value));
                    break;
                }
                case 0: {
                    throw new IllegalArgumentException();
                }
            }
        }
        return root;
    }

    private void LeftRotate(Root<T> root) {

        Root<T> newRoot = root.getRight();

        if (newRoot == null || newRoot.getLeft() == null) {
            return;
        }

        root.setRight(newRoot.getLeft());
        if (newRoot.getLeft() != null) {
            newRoot.getLeft().setParent(root);
        }

        if (root.getParent() != null) {
            if (root == root.getParent().getLeft()) {
                root.getParent().setLeft(newRoot);
                newRoot.setLeft(root);
                root.setParent(newRoot);
                if (newRoot.getLeft() != null) {
                    root = newRoot.getLeft();
                } else
                    root = null;

            } else {
                root.getParent().setRight(newRoot);
                newRoot.setLeft(root);
                root.setParent(newRoot);

                if (newRoot.getLeft() != null) {
                    root = newRoot.getLeft();
                }
            }
        } else {
            Root<T> cloneRoot = root;
            this.root = newRoot;
            this.root.setParent(null);
            this.root.setLeft(cloneRoot);
            cloneRoot.setParent(this.root);
            root = this.root;
        }
    }

    private void RightRotate(Root<T> root) {
        Root<T> newRoot = root.getLeft();

        if (newRoot == null || newRoot.getRight() == null) {
            return;
        }

        root.setLeft(newRoot.getRight());
        if (newRoot.getRight() != null) {
            newRoot.getRight().setParent(root);
        }

        if (root.getParent() != null) {
            if (root == root.getParent().getLeft()) {
                root.getParent().setLeft(newRoot);
                newRoot.setRight(root);
                root.setParent(newRoot);
                if (newRoot.getRight() != null) {
                    root = newRoot.getRight();
                } else
                    root = null;
            } else {
                root.getParent().setRight(newRoot);
                newRoot.setRight(root);
                root.setParent(newRoot);
                if (newRoot.getRight() != null) {
                    root = newRoot.getRight();
                } else
                    root = null;
            }
        } else {
            Root<T> cloneRoot = root;
            this.root = newRoot;
            this.root.setParent(null);
            this.root.setRight(cloneRoot);
            cloneRoot.setParent(this.root);
            root = this.root;
        }
    }

    private Root<T> getGrandPhather(Root<T> root) {
        if (root.getParent() != null) {
            if (root.getParent().getParent() != null) {
                return root.getParent().getParent();
            } else
                return null;
        } else
            return null;
    }

    private Root<T> getUncle(Root<T> root) {
        if (root.getParent() != null) {
            if (root.getParent().getParent() != null) {
                if (root.getParent().getParent().getLeft() == root.getParent()) {
                    return root.getParent().getParent().getRight();
                } else {
                    return root.getParent().getParent().getLeft();
                }
            } else
                return null;
        }
        return null;

    }

    private Root<T> getPhather(Root<T> root) {
        if (root.getParent() != null) {
            return root.getParent();
        } else
            return null;
    }

    private void caseOne(Root<T> root) {
        if (root.getParent() == null) {
            root.setColor(BLACK);
        } else {
            caseTwo(root);
        }
    }

    private void caseTwo(Root<T> root) {
        if (root.getParent() != null) {
            if (root.getParent().isColor() == BLACK) {
                return;
                //It is normaly
            } else
                caseThree(root);
        }
    }

    private void caseThree(Root<T> root) {
        Root<T> uncle = getUncle(root), grand;

        if ((uncle != null) && (uncle.isColor() == RED) && (root.getParent().isColor() == RED)) {
            root.getParent().setColor(BLACK);
            uncle.setColor(BLACK);
            grand = getGrandPhather(root);
            grand.setColor(RED);
            caseOne(grand);
        } else {
            if (root != null && root == root.getParent().getLeft())
                caseFour(root);
            else if (root != null)
                caseFourInversed(root);
        }
    }

    private void caseFourInversed(Root<T> root) {
        Root<T> grandphather = getGrandPhather(root);
        if (grandphather == null) {
            return;
        }
        if (root == root.getParent().getLeft() && root.getParent() == grandphather.getRight()) {
            RightRotate(root.getParent().getParent());
            //root = root.getRight();
        } else if (root == root.getParent().getRight() && root.getParent() == grandphather.getLeft()) {
            LeftRotate(root.getParent().getParent());
            // root = root.getLeft();
        }
        if (root != null && root == root.getParent().getLeft())
            caseFive(root);
        else if (root!=null)
            caseFiveInversed(root);
    }

    private void caseFour(Root<T> root) {
        Root<T> grandphather = getGrandPhather(root);
        if (root == root.getParent().getRight() && root.getParent() == grandphather.getLeft()) {
            RightRotate(root.getParent().getParent());
            //// STOPSHIP: 25.04.2016 repair
            //   root = root.getRight();

        } else if (root == root.getParent().getLeft() && root.getParent() == grandphather.getRight()) {
            LeftRotate(root.getParent().getParent());
            //// STOPSHIP: 25.04.2016 repair
            //   root = root.getLeft();
        }
        if (root != null && root == root.getParent().getLeft())
            caseFive(root);
        else if (root!=null)
            caseFiveInversed(root);
    }

    private void caseFive(Root<T> root) {
        Root<T> grandphather = getGrandPhather(root);
        //// STOPSHIP: 25.04.2016 repair
        root.getRight().setColor(BLACK);
        grandphather.setColor(RED);
        if (root == root.getParent().getLeft() && root.getParent() == grandphather.getLeft()) {
            RightRotate(grandphather);
        } else {
            LeftRotate(grandphather);
        }
    }

    private void caseFiveInversed(Root<T> root) {
        Root<T> grandphather = getGrandPhather(root);
        if (root.getLeft() != null)
            root.getLeft().setColor(BLACK);
        grandphather.setColor(RED);
        if (root == root.getParent().getRight() && root.getParent() == grandphather.getRight()) {
            LeftRotate(grandphather);
        } else {
            RightRotate(grandphather);
        }
    }

    public void addVertex(int key, T value) {
        insert(this.root, null, key, value);
        balanceTree(this.root);
    }

    private void balanceTree(Root<T> root) {
        caseOne(root);
        if (root.getLeft() != null) {
            balanceTree(root.getLeft());
        }
        if (root.getRight() != null) {
            balanceTree(root.getRight());
        }
    }

    public Root<T> getRoot() {
        return root;
    }

    public void show() {
        showTree(this.root, 0);
        System.out.println();
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

}