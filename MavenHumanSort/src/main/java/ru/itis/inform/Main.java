package ru.itis.inform;

import ru.itis.inform.Human.*;
import ru.itis.inform.Array.*;
import java.io.FileNotFoundException;


public class Main  {

    public static void main(String[] args) throws FileNotFoundException, Exception {
        HumansReaderWriter humansReaderWriter = new HumansReaderWriter();

        LinkedListImpl<Human> c = humansReaderWriter.readHumans();

        HumansSorter humansSorter = new HumansSorter();

        c = humansSorter.sort(c);

        humansReaderWriter.writeHumans("HumansOut",c);

    }
}
