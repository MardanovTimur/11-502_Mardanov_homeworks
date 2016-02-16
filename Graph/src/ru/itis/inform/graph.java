package ru.itis.inform;

/**
 * Created by ����� on 09.02.2016.
 */
public interface graph {
    void addVertex();

    void addEdge(int vertexA, int vertexB, int weightAB);

    void showGraph();

    int[][] getFloid();

    int getVerticeCount();
}
