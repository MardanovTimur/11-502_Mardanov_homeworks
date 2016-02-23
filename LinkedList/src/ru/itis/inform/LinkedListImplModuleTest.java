package ru.itis.inform;

/**
 * Created by Тимур on 23.02.2016.
 */

import static org.junit.Assert.*;

public class LinkedListImplModuleTest {
    LinkedListImpl<Integer> linkedList;

    @org.junit.Before
    public void setUp() throws Exception {
        linkedList = new LinkedListImpl<>();
        linkedList.push(1);
        linkedList.push(5);
        linkedList.push(5);
        linkedList.push(2);
        linkedList.add(3);
        linkedList.remove(2);
    }

    @org.junit.Test
    public void test() throws Exception {
        int[] actual = new int[10];
        int[] expected = new int[10];
        expected[0] = 3;
        expected[1] = 1;
        expected[2] = 5;
        expected[3] = 5;


        Iterator<Integer> iterator  = linkedList.iterator();


        for (int i = 0; i<4; i++) {
            actual[i] =iterator.next();
        }

        assertArrayEquals("PleaseFixYourProgram",actual,expected);
    }
}
