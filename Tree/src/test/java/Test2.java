/**
 * Created by Тимур on 20.04.2016.
 */
import ru.itis.inform.BinaryTree;
import ru.itis.inform.BinaryTreeImpl;
import ru.itis.inform.BlackRedTree;
import ru.itis.inform.BlackRedTreeImpl;

import static org.junit.Assert.*;

public class Test2 {
    private BlackRedTree<String> tree;
    private BinaryTree<Integer> btree;
    @org.junit.Before
    public void setUp() {
        tree = new BlackRedTreeImpl<String>(10,"Rustem");
        btree = new BinaryTreeImpl<Integer>();
    }

    @org.junit.Test
    public void Test() {
        tree.addVertex(13,"Timur");
        tree.addVertex(11,"Maxim");
        tree.addVertex(8,"Sasha");
        tree.addVertex(9, "Michael");
        tree.addVertex(18,"Ashot");
        tree.addVertex(17,"Milisa");
        tree.addVertex(20,"Vovan");
        tree.addVertex(22,"KazahMicka");
        tree.show();
    }
}
