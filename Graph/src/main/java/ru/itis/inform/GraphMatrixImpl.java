package ru.itis.inform;

public class GraphMatrixImpl implements DirectedGraph,Graph {

    public static final int Default_Size = 51;

    private int matrix[][];

    private int maxSize = 0;

    private int verticeCount=0;

    public int getMaxSize() {
        return maxSize;
    }

    public int getVerticeCount() {
        return verticeCount;
    }


    public GraphMatrixImpl() {
        initGraph(Default_Size);
    }

    public GraphMatrixImpl(int value) {
        initGraph(value);
    }

    private void initGraph(int value) {
        this.maxSize = value;
        this.verticeCount = 0;
        this.matrix = new int[maxSize+1][maxSize+1];
    }

    public int getDegreeVertex(int numberVertex) {
        int degree = 0;
        for (int i = 0; i<matrix[numberVertex-1].length; i++) {
            if (matrix[numberVertex-1][i]!=0) {
                degree++;
            }
        }
        return degree;
    }

    public void addVertex() {
        if (this.verticeCount < this.maxSize) {
            this.verticeCount++;
        } else throw new IllegalArgumentException();
    }

     public void addEdgeNonDirection(int vertexA, int vertexB, int weightAB) {
        if (vertexA<=this.verticeCount && vertexB<=this.verticeCount) {
            this.matrix[vertexA-1][vertexB-1] = weightAB;
            this.matrix[vertexB-1][vertexA-1] = weightAB;
        } else throw new IllegalArgumentException();
    }

    public void addEdgeDirection(int vertexA, int vertexB, int weightAB) {
        if (vertexA<=this.verticeCount && vertexB<=this.verticeCount) {
            this.matrix[vertexA-1][vertexB-1] = weightAB;
        } else throw new IllegalArgumentException();
    }

    public void addEdge(int vertexA, int vertexB) {
        if (vertexA<=this.verticeCount && vertexB<=this.verticeCount) {
            this.matrix[vertexA-1][vertexB-1] = 1;
            this.matrix[vertexB-1][vertexA-1] = 1;
        } else throw new IllegalArgumentException();
    }


    public void showGraph() {
        for (int i = 0; i < this.verticeCount; i++) {
            for (int j = 0; j<this.verticeCount; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }


    public void showGraph(int[][] matrix) {
        for (int i = 0; i < this.verticeCount; i++) {
            for (int j = 0; j<this.verticeCount; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public int[][] runFloyd() {

        int d[][] =new int[this.verticeCount][this.verticeCount];

        for (int i = 0; i< this.verticeCount; i++) {
            for (int j = 0; j< this.verticeCount; j++) {
                d[i][j] = matrix[i][j];
            }
        }

        for (int i = 0; i<this.verticeCount; i++){
            for (int j = 0; j<this.verticeCount; j++) {
                for (int k = 0; k < this.verticeCount; k++) {
                    if (d[i][j]>matrix[i][k]+matrix[k][j] && matrix[i][k]!=0 && matrix[k][j]!=0) {
                        d[i][j] = matrix[i][k]+matrix[k][j];
                    }
                }
            }
        }
        return d;
    }

}
