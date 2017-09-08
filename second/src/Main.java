import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Main {

    private static List<History> historyList;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src\\in.txt"));
        historyList = new ArrayList<>();
        PrintWriter pw = new PrintWriter(new File("src\\out.txt"));
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            String[] splittedString = s.split(" ");
            List<Integer> bufferList = new LinkedList<>();
            for (int i = 1; i < splittedString.length; i++) {
                bufferList.add(Integer.valueOf(splittedString[i]));
            }
            historyList.add(new History(splittedString[0], bufferList));
            historyList.get(historyList.size()-1).calculateAverageScore();
            pw.println(historyList.get(historyList.size()-1).toString());
        }
        pw.close();
    }
}
