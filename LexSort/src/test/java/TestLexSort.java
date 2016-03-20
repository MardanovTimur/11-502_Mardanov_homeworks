/**
 * Created by Тимур on 02.03.2016.
 */
import org.junit.Assert;
import ru.itis.inform.Iterator;
import ru.itis.inform.LinkedListImpl;
import ru.itis.inform.text.TextLexSorter;
import ru.itis.inform.text.TextReaderWriter;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;


public class TestLexSort {
    TextLexSorter textLexSorter;
    TextReaderWriter textReaderWriter;
    @org.junit.Before
    public void setUp() {
        this.textLexSorter = new TextLexSorter();
        this.textReaderWriter = new TextReaderWriter();
    }
    @org.junit.Test
    public void testSortInLexSorter() {
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
        actual.setCount(5);

        boolean f = true;
        assertEquals("Error lexSort",f, LinkedListImpl.equalsLists(actual,expected));

    }
    @org.junit.Test
    public void testReaderWriter() throws FileNotFoundException {
        LinkedListImpl<String> actual =  new LinkedListImpl<>();
        actual = textReaderWriter.readHumans("TestInput");

        LinkedListImpl<String> expected = new LinkedListImpl<String>();
        expected.push("FAST");
        expected.push("FEAR");

        assertEquals("Error on writable file",true, equalsLinkedLists(expected,actual));

    }

    public boolean equalsLinkedLists(LinkedListImpl<String> actual, LinkedListImpl<String> expected) {
        int increment = 0;
        if (actual.getCount() == expected.getCount()) {
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
