package ru.itis.inform;

import ru.itis.inform.graph;
import ru.itis.inform.graphImpl;

/**
 * Created by Тимур on 09.02.2016.
 */
public class Main {
    public static void main(String[] args) {
        graph g = new graphImpl();

        g.addVertex();
        g.addVertex();
        g.addVertex();
        g.addVertex();

        g.addEdge(3, 1, 300);
        g.addEdge(1, 3, 300);
        g.addEdge(1, 2, 2);
        g.addEdge(2, 1, 2);
        g.addEdge(3, 2, 3);
        g.addEdge(2, 3, 3);



        g.showGraph();
        System.out.println();
        int a[][] = new int[100][100];

        a = g.getFloid();

        for (int i = 1; i<=3; i++) {
            for (int j = 1; j<=3; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
}
