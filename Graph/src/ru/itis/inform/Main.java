package ru.itis.inform;

import ru.itis.inform.graph;
import ru.itis.inform.graphImpl;

/**
 * Created by ����� on 09.02.2016.
 */
public class Main {
    public static void main(String[] args) {
        graph g = new graphImpl();

        g.addVertex();
        g.addVertex();
        g.addVertex();


        g.addEdge(1, 2, 2);

        g.addEdge(1, 3, 9);

        g.addEdge(2, 3, 3);

        g.showGraph();

        System.out.println();

        Floid floid = new Floid();

        floid.setA(g.getFloid(),g.getVerticeCount());

        floid.show();

    }
}
