/**
 * Created by Тимур on 24.03.2016.
 */

import ru.itis.inform.BinaryTree;
import ru.itis.inform.BinaryTreeImpl;
import static org.junit.Assert.*;
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

        root.getRoot().getLeft().setValue(3);

        assertEquals("IsNotBinary",true,root.treeIsBinary());
        root.setFlag(true);
    }

    @org.junit.Test
    public void Test2() {
        root.insert(7);
        root.insert(3);
        root.insert(19);
        root.insert(4);
        root.insert(2);
        root.insert(20);

        Queue<Integer> queue;

        queue = root.getLevelRoots(1);
        int levelSum = queue.summQueue();
        boolean flag = true;
        int i = 2;
        while (queue!=null && flag) {
            queue = root.getLevelRoots(i);
            if (queue != null) {
                if (!(levelSum - queue.summQueue() < 0)) {
                    flag = false;
                } else {
                    levelSum = queue.summQueue();
                }
                i++;
            }
        }

        assertEquals("It's not true!",true,flag);
    }


}