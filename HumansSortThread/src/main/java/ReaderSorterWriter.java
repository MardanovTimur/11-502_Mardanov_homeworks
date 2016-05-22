import ru.itis.inform.LinkedListImpl;
import ru.itis.inform.human.Human;
import ru.itis.inform.human.HumansReaderWriter;
import ru.itis.inform.human.HumansSorter;
import java.io.FileNotFoundException;

public class ReaderSorterWriter implements Runnable {
    private String fileName = "";
    private String outFileName = "";
    private HumansReaderWriter humansReaderWriter = new HumansReaderWriter();
    private LinkedListImpl<Human> humanLinkedList = new LinkedListImpl<Human>();
    private HumansSorter humansSorter = new HumansSorter();

    public ReaderSorterWriter(String fileName, String outFileName) {
        this.fileName = fileName;
        this.outFileName = outFileName;
    }

    @Override
    public void run() {
        try {
            this.humanLinkedList = humansReaderWriter.readHumans(this.fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        humanLinkedList = humansSorter.sort(humanLinkedList);

        try {
            humansReaderWriter.writeHumans(this.outFileName, this.humanLinkedList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

