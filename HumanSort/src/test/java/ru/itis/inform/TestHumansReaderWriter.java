package ru.itis.inform;


import ru.itis.inform.human.Human;
import ru.itis.inform.human.HumansReaderWriter;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class TestHumansReaderWriter {
    private HumansReaderWriter humansReaderWriter;

    @org.junit.Before

    public void setUp() {
        this.humansReaderWriter = new HumansReaderWriter();
    }

    @org.junit.Test
    public void testReadHumans() throws FileNotFoundException {
        LinkedListImpl<Human> actual;
        actual = humansReaderWriter.readHumans("TestInput");

        LinkedListImpl<Human> expected = new LinkedListImpl<>();

        expected.push(new Human(38, " Andrey"));
        expected.push(new Human(20, " Michael"));
        expected.push(new Human(19, " Garvord"));
        expected.push(new Human(19, " Sasha"));

        assertEquals("Error from read class", true, equalLinkedList(actual,expected));
    }

    public boolean equalLinkedList(LinkedListImpl first, LinkedListImpl second) {
        int increment = 0;
        if (first.getCount() == second.getCount()) {
            Iterator firstIt = first.iterator();
            Iterator secondIt = second.iterator();

            while (firstIt.hasNext()) {
                if (firstIt.peekNext().toString().equals(secondIt.peekNext().toString())) {
                    increment++;
                    firstIt.next();
                    secondIt.next();
                } else {
                    return false;
                }
            }
        } else
           return false;
        return increment==first.getCount();
    }

}
