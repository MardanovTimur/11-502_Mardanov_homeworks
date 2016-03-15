/**
 * Created by Тимур on 15.03.2016.
 */
import static org.junit.Assert.*;
import  ru.itis.inform.LinkedList;
import ru.itis.inform.LinkedListImpl;

public class TestMergeSort {
    LinkedListImpl<Integer> actual;
    @org.junit.Before
    public void setUp() {
        actual = new LinkedListImpl<>();
    }

    @org.junit.Test
    public void Test1() {
        actual.push(3);
        actual.push(2);

        LinkedListImpl<Integer> expected = new LinkedListImpl<>();
        expected.push(2);
        expected.push(3);

        actual = LinkedListImpl.toMerge(actual);

        assertEquals(actual,expected);
    }

}
