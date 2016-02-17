package ru.itis.inform;


public class Main {
    public static void main(String[] args) {
        GraphMatrixMatrixImpl graph = new GraphMatrixMatrixImpl();

        graph.addVertex();
        graph.addVertex();
        graph.addVertex();
        graph.addVertex();

        graph.addEdgeNonDirection(1, 2, 2);
        graph.addEdgeNonDirection(1, 3, 8);
        graph.addEdgeNonDirection(2, 3, 3);
        graph.addEdge(2,4,9);

        graph.showGraph();

        System.out.println();

        Floyd floyd = new Floyd(graph);

        floyd.runFloid();

        graph.showGraph(floyd.getFloydMatrix());

    }
}
