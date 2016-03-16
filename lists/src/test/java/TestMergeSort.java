/**
 * Created by Тимур on 15.03.2016.
 */

import static org.junit.Assert.*;

import ru.itis.inform.LinkedList;
import ru.itis.inform.LinkedListImpl;

public class TestMergeSort {
    LinkedListImpl<Integer> actual;
    LinkedListImpl<Integer> actual1;

    @org.junit.Before
    public void setUp() {
        actual = new LinkedListImpl<>();
        actual1 = new LinkedListImpl<>();
    }

    @org.junit.Test
    public void TestMerge() {
        actual.push(2);
        actual.push(5);
        actual.push(6);
        actual1.push(1);
        actual.push(50);
        actual = LinkedListImpl.merge(actual, actual1);


        LinkedListImpl<Integer> expected = new LinkedListImpl<>();
        expected.push(1);
        expected.push(2);
        expected.push(5);
        expected.push(6);
        expected.push(50);

        assertEquals("Error", LinkedListImpl.equalsLists(actual, expected), true);
    }

    @org.junit.Test
    public void TestMergeSort() {
        actual.push(3);
        actual.push(2);
        actual.push(10);

        LinkedListImpl<Integer> expected = new LinkedListImpl<>();
        expected.push(2);
        expected.push(3);
        expected.push(10);

        actual = LinkedListImpl.toMerge(actual);

        assertEquals("Error", LinkedListImpl.equalsLists(actual, expected), true);
    }
}
