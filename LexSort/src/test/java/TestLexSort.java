/**
 * Created by Тимур on 02.03.2016.
 */
import ru.itis.inform.Iterator;
import ru.itis.inform.LinkedListImpl;
import ru.itis.inform.text.TextLexSorter;

import static org.junit.Assert.*;


public class TestLexSort {
    TextLexSorter textLexSorter;

    @org.junit.Before
    public void setUp() {
        this.textLexSorter = new TextLexSorter();
    }
    @org.junit.Test
    public void test1() {
        LinkedListImpl<String> actual = new LinkedListImpl<>();
        LinkedListImpl<String> expected = new LinkedListImpl<>();

        actual.push("DOTA");
        actual.push("CSKA");
        actual.push("REAT");
        actual.push("NBAS");
        actual.push("FAST");

        expected.push("CSKA");
        expected.push("DOTA");
        expected.push("FAST");
        expected.push("NBAS");
        expected.push("REAT");

        actual =  textLexSorter.sort(actual);

        boolean f = true;
        assertEquals("Error",f, equalsLinkedLists(actual,expected));

    }

    public boolean equalsLinkedLists(LinkedListImpl<String> actual, LinkedListImpl<String> expected) {
        int increment = 0;
        if (5 == expected.getCount()) {
            Iterator<String> actualIt = actual.iterator();
            Iterator<String> expectedIt = expected.iterator();
            while (expectedIt.hasNext()) {
                if (actualIt.peekNext().equals(expectedIt.peekNext())) {
                    actualIt.next();
                    expectedIt.next();
                    increment++;
                } else {
                    actualIt.next();
                    expectedIt.next();
                }
            }
            return expected.getCount()==increment;
        } else return false;
    }
}
