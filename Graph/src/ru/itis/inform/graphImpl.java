package ru.itis.inform;

import ru.itis.inform.graph;

/**
 * Created by ����� on 09.02.2016.
 */
public class graphImpl implements graph {

    public static final int Default_Size = 51;

    private int directionValue;

    private int matrix[][];

    private int maxSize = 0;

    private int verticeCount;

    public graphImpl() {
        initGraph(Default_Size);
    }

    public graphImpl(int value) {
        initGraph(value);
    }

    private void initGraph(int value) {
        this.maxSize = value;
        this.verticeCount = 0;
        this.matrix = new int[maxSize+1][maxSize+1];
    }

    public int getVerticeCount() {
        return verticeCount;
    }

    @Override
    public void addVertex() {
        if (this.verticeCount < this.maxSize) {
            this.verticeCount++;
        } else throw new IllegalArgumentException();
    }

    @Override
    public void addEdge(int vertexA, int vertexB, int weightAB) {
        if (vertexA<this.verticeCount+1 && vertexB<this.verticeCount+1) {
            this.directionValue++;
            this.matrix[vertexA-1][vertexB-1] = weightAB;
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


    public int[][] getFloid() {

        int d[][] =new int[this.verticeCount+1][this.verticeCount+1];

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
