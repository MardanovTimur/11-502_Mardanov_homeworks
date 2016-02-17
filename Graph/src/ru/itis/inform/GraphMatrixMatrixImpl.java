package ru.itis.inform;

public class GraphMatrixMatrixImpl implements GraphMatrix {

    public static final int Default_Size = 51;

    private int matrix[][];

    private int maxSize = 0;

    private int verticeCount;

    public GraphMatrixMatrixImpl() {
        initGraph(Default_Size);
    }

    public GraphMatrixMatrixImpl(int value) {
        initGraph(value);
    }

    private void initGraph(int value) {
        this.maxSize = value;
        this.verticeCount = 0;
        this.matrix = new int[maxSize+1][maxSize+1];
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public int getVerticeCount() {
        return this.verticeCount;
    }

    @Override
    public void addVertex() {
        if (this.verticeCount < this.maxSize) {
            this.verticeCount++;
        } else throw new IllegalArgumentException();
    }

    @Override
    public void addEdgeNonDirection(int vertexA, int vertexB, int weightAB) {
        if (vertexA<this.verticeCount+1 && vertexB<this.verticeCount+1) {
            this.matrix[vertexA-1][vertexB-1] = weightAB;
        } else throw new IllegalArgumentException();
    }
    @Override
    public void addEdge(int vertexA, int vertexB, int weightAB) {
        if (vertexA<this.verticeCount+1 && vertexB<this.verticeCount+1) {
            this.matrix[vertexA-1][vertexB-1] = weightAB;
            this.matrix[vertexB-1][vertexA-1] = weightAB;
        } else throw new IllegalArgumentException();
    }

    @Override
    public void showGraph() {
        for (int i = 0; i < this.verticeCount; i++) {
            for (int j = 0; j<this.verticeCount; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    @Override
    public void showGraph(int[][] matrix) {
        for (int i = 0; i < this.verticeCount; i++) {
            for (int j = 0; j<this.verticeCount; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }


}
