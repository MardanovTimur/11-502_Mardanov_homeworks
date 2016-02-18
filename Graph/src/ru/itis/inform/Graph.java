package ru.itis.inform;

/**
 * Created by Тимур on 18.02.2016.
 */
public interface Graph {
    void addVertex();
    void addEdgeNonDirection(int vertexA, int vertexB, int weightAB);

    void showGraph();
    void showGraph(int[][] matrix);

    int[][] runFloyd();
}
