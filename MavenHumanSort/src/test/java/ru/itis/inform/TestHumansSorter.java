package ru.itis.inform;

/**
 * Created by Тимур on 04.03.2016.
 */

import ru.itis.inform.human.Human;
import ru.itis.inform.human.HumansReaderWriter;
import ru.itis.inform.human.HumansSorter;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class TestHumansSorter {

    private HumansSorter humansSorter;
    private HumansReaderWriter humansReaderWriter;
    @org.junit.Before
    public void setUp() {
        humansReaderWriter = new HumansReaderWriter();
        humansSorter = new HumansSorter();
    }
    @org.junit.Test
    public void testSorter() throws FileNotFoundException {
        LinkedListImpl<Human> actual = new LinkedListImpl<>();
        actual = humansReaderWriter.readHumans("TestInput");

        actual = humansSorter.sort(actual);
        actual.setCount(4);
        LinkedListImpl<Human> expected = new LinkedListImpl<>();
        expected.push(new Human(19, " Garvord"));
        expected.push(new Human(19, " Sasha"));
        expected.push(new Human(20, " Michael"));
        expected.push(new Human(38, " Andrey"));


        TestHumansReaderWriter testHumansReaderWriter = new TestHumansReaderWriter();
        assertEquals("Error equals",true, testHumansReaderWriter.equalLinkedList(actual,expected));
    }

}
