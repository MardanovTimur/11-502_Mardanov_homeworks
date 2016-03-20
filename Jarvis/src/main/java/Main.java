import ru.itis.inform.LinkedListImpl;
import ru.itis.inform.Node;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Тимур on 18.03.2016.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Point> points = new LinkedList<Point>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            double x = sc.nextInt();
            double y = sc.nextInt();
            points.addLast(new Point(x, y));
        }

        Cover cover = new Cover(points);

        points = cover.search();

        for (int i = 0; i < points.size(); i++) {
            System.out.println((i+1)+": " + points.get(i).getXY());
        }

    }
}
