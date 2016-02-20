package ru.itis.inform.LinkedList;


import static org.junit.Assert.*;

public class FareyIterModuleTest {
    private FareyLinkedListImpl<RationalNumber> fareyLinkedList;

    @org.junit.Before
    public void setUp() throws Exception {
        this.fareyLinkedList = new FareyLinkedListImpl<>();
    }

    @org.junit.Test
    public void test() throws Exception {
        boolean boolExpected = true;
        fareyLinkedList.initialize(5);
        fareyLinkedList.generate();

        ListNodeImpl<RationalNumber> expected = new ListNodeImpl<>();

        //0/1 1/5 1/4 1/3 2/5 1/2 3/5 2/3 3/4 4/5 1/1

        expected.push(new RationalNumber(0, 1));
        expected.push(new RationalNumber(1, 5));
        expected.push(new RationalNumber(1, 4));
        expected.push(new RationalNumber(1, 3));
        expected.push(new RationalNumber(2, 5));
        expected.push(new RationalNumber(1, 2));
        expected.push(new RationalNumber(3, 5));
        expected.push(new RationalNumber(2, 3));
        expected.push(new RationalNumber(3, 4));
        expected.push(new RationalNumber(4, 5));
        expected.push(new RationalNumber(1, 1));

        ListNodeImpl<RationalNumber> actual = fareyLinkedList.getList();


        assertEquals(equalsList(actual, expected), true);
    }

    public boolean equalsList(ListNodeImpl<RationalNumber> actual, ListNodeImpl<RationalNumber> expected) {
        int count = 0;


        Iterator<RationalNumber> iteratorActual = actual.iterator();

        Iterator<RationalNumber> iteratorExpected = expected.iterator();

        while (iteratorActual.hasNext() && iteratorExpected.hasNext()) {
            if (iteratorActual.peekNext().getA() == iteratorExpected.peekNext().getA() && iteratorActual.peekNext().getB() == iteratorExpected.peekNext().getB()) {
                iteratorActual.next();
                iteratorExpected.next();
            } else
                return false;
        }
        return true;
    }


}
