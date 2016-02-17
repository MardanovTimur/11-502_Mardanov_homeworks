package ru.itis.inform;


public interface GraphMatrix {
    void addVertex();
    void addEdge(int vertexA, int vertexB, int weightAB);
    void addEdgeNonDirection(int vertexA, int vertexB, int weightAB);

    void showGraph();
    void showGraph(int[][] matrix);

    int getVerticeCount();
    int[][] getMatrix();
}
