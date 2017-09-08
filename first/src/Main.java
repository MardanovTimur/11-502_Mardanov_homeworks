import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src\\in.txt"));
        int k = sc.nextInt();
        sc.nextLine();
        List<String> arrayList = new ArrayList<>();
        while (sc.hasNextLine()) {
            String nextLine = sc.nextLine();
            if (nextLine.length()>=k) {
                arrayList.add(nextLine);
            }
        }
        PrintWriter pw = new PrintWriter(new File("out.txt"));
        while (k>0) {
            k--;
            Collections.sort(arrayList,new StringComparator(k));
            pw.print(k);
            pw.println(arrayList.toString());
            pw.println("//////////////////");
        }
        pw.close();
    }
}
