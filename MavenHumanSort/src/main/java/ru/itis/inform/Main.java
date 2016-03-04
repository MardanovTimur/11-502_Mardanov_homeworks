package ru.itis.inform;


import ru.itis.inform.human.*;

import java.io.FileNotFoundException;


public class Main  {

    public static void main(String[] args ) throws FileNotFoundException  {
        HumansReaderWriter humansReaderWriter = new HumansReaderWriter();

        LinkedListImpl<Human> c = humansReaderWriter.readHumans("Humans");

        HumansSorter humansSorter = new HumansSorter();

        c = humansSorter.sort(c);


        humansReaderWriter.writeHumans("HumansOut",c);

    }
}
