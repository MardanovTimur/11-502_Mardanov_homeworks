import java.util.Scanner;

/**
 * Created by Тимур on 21.03.2016.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Point point[] = new Point[n];

        for (int i = 0; i< n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            point[i] = new Point(x,y);
        }

        QuickSort quickSort = new QuickSort(point);

        Point ls[];
        ls = quickSort.searchPoints();
        for (int i = 0; i<ls.length; i++) {
            if (ls[i]!=null)
            System.out.println(ls[i].toString()+" ");
        }
    }
}
