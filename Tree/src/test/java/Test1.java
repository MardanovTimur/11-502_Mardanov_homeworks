/**
 * Created by Тимур on 24.03.2016.
 */
import ru.itis.inform.BinaryTree;
import ru.itis.inform.BinaryTreeImpl;
import ru.itis.inform.Queue;
import ru.itis.inform.Root;

public class Test1 {
    private BinaryTree<Integer> root;
    private BinaryTree<Integer> expected;

    @org.junit.Before
    public void setUp() {
        root = new BinaryTreeImpl<Integer>();
        expected = new BinaryTreeImpl<Integer>();
    }

    @org.junit.Test
    public void Test1() {
        root.insert(7);
        root.insert(3);
        root.insert(19);
        root.insert(4);
        root.insert(2);
        root.insert(20);

        root.getRoot().getLeft().setValue(8);

        rootSearch(this.root.getRoot());

        expected = new int[4];
    }

    public boolean rootSearch(Root<Integer> root) {
        if (root!=null) {
            if (root.getRight()!=null && root.getLeft()!=null && root.getRight().compareTo(root.getLeft())==-1) {
                rootSearch(root.getRight());
            }
        }
    }
}
