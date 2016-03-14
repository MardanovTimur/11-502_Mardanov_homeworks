package ru.itis.inform;


import ru.itis.inform.human.*;

import java.io.FileNotFoundException;


public class Main  {

    public static void main(String[] args ) throws FileNotFoundException   {
        HumansReaderWriter humansReaderWriter = new HumansReaderWriter();

        LinkedListImpl<Human> c = humansReaderWriter.readHumans("Humans");
        LinkedListImpl<Human> d = humansReaderWriter.readHumans("Humans2");
        HumansSorter humansSorter = new HumansSorter();

        c.append(d);
        c.setCount(c.getCount() + d.getCount());

        c = LinkedListImpl.toMerge(c);

        c.printList();

        c = humansSorter.sort(c);
        d = humansSorter.sort(d);

        LinkedListImpl<Human> result = new LinkedListImpl<>();

        humansReaderWriter.writeHumans("HumansOut",c);
        humansReaderWriter.writeHumans("HumansOut2",d);

        result = LinkedListImpl.merge(c,d);

        humansReaderWriter.writeHumans("resMerge",result);
    }
}
