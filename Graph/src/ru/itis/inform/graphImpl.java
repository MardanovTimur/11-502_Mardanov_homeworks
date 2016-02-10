package ru.itis.inform;

import ru.itis.inform.graph;

/**
 * Created by Тимур on 09.02.2016.
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


    @Override
    public void addVertex() {
        if (this.verticeCount < this.maxSize) {
            this.verticeCount++;
            this.matrix[0][this.verticeCount] = this.verticeCount-1;
            this.matrix[this.verticeCount][0] = this.verticeCount-1;
        } else throw new IllegalArgumentException();
    }

    @Override
    public void addEdge(int vertexA, int vertexB, int weightAB) {
        if (vertexA<this.verticeCount && vertexB<this.verticeCount) {
            this.directionValue++;
            this.matrix[vertexA][vertexB] = weightAB;
        } else throw new IllegalArgumentException();
    }

    @Override
    public void showGraph() {
        for (int i = 0; i <= this.verticeCount; i++) {
            for (int j = 0; j<=this.verticeCount; j++) {
                if (i == 0 && j == 0)
                    System.out.println("*");
                else
                    System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
