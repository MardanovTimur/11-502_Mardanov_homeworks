package ru.itis.inform;


public class Main {
    public static void main(String[] args) {
        DirectedGraph graph = new GraphMatrixImpl();

        graph.addVertex();
        graph.addVertex();
        graph.addVertex();
        graph.addVertex();


        graph.addEdgeDirection(1,2,5);
        graph.addEdgeDirection(1,4,10);
        graph.addEdgeDirection(2,4,3);
        graph.addEdgeDirection(3,4,7);

        graph.showGraph();

        System.out.println();

        int[][] t = graph.runFloyd();
        graph.showGraph(t);

        System.out.println("-------------------------------------------");


        Graph graphO = new GraphMatrixImpl();

        graphO.addVertex();
        graphO.addVertex();
        graphO.addVertex();

        graphO.addEdgeNonDirection(1,2,3);
        graphO.addEdgeNonDirection(2,3,5);
        graphO.addEdgeNonDirection(1,3,9);

        graphO.showGraph();

        System.out.println();

        graphO.showGraph(graphO.runFloyd());


    }
}
