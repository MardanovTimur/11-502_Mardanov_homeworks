import ru.itis.inform.LinkedListImpl;
import ru.itis.inform.human.Human;
import ru.itis.inform.human.HumansReaderWriter;
import ru.itis.inform.human.HumansSorter;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Sort {

    public static void main(String[] args) throws FileNotFoundException {
        ReaderSorterWriter a = new ReaderSorterWriter("input1", "output1");
        ReaderSorterWriter b = new ReaderSorterWriter("input2", "output2");
        ReaderSorterWriter c = new ReaderSorterWriter("input3", "output3");
        ReaderSorterWriter d = new ReaderSorterWriter("input4", "output4");

        Thread threadA = new Thread(a);
        Thread threadB = new Thread(b);
        Thread threadC = new Thread(c);
        Thread threadD = new Thread(d);

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
        if (threadA.isAlive() || threadB.isAlive() || threadC.isAlive() || threadD.isAlive())
            try {
                threadA.join();
                threadB.join();
                threadC.join();
                threadD.join();
            } catch (InterruptedException e) {}


        sortAllFiles();
    }

    public static void sortAllFiles() throws FileNotFoundException {
        ru.itis.inform.ArrayList<LinkedListImpl<Human>> arrayList = new ru.itis.inform.ArrayList<LinkedListImpl<Human>>();
        HumansReaderWriter humansReaderWriter = new HumansReaderWriter();
        LinkedListImpl<Human> linkedList = new LinkedListImpl<Human>();
        HumansSorter humansSorter = new HumansSorter();
        arrayList.set(0, new LinkedListImpl<Human>());
        for (int i = 1; i <= 4; i++) {
            if (arrayList.get(i) == null)
                arrayList.set(i, new LinkedListImpl<Human>());
            linkedList = humansReaderWriter.readHumans("input" + i);
            arrayList.set(i, linkedList);
        }
        for (int i = 4; i >= 1; i--) {
            if (arrayList.get(i - 1) != null)
                arrayList.get(i - 1).append(arrayList.get(i));
        }

        arrayList.set(1, humansSorter.sort(arrayList.get(1)));

        humansReaderWriter.writeHumans("outputAll", arrayList.get(1));

    }
}
