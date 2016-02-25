package ru.itis.inform;

import ru.itis.inform.Human.Human;
import ru.itis.inform.Human.HumansReaderWriter;
import ru.itis.inform.Human.HumansSorter;

import java.io.FileNotFoundException;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        HumansReaderWriter humansReaderWriter = new HumansReaderWriter();

        LinkedListImpl<Human> c = humansReaderWriter.readHumans();

        HumansSorter humansSorter = new HumansSorter();

        c = humansSorter.sort(c);

        humansReaderWriter.writeHumans("HumansOut",c);



        /*
        Iterator<Human> iterator = c.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.peekNext());
            iterator.next();
        }
        */
    }
}
