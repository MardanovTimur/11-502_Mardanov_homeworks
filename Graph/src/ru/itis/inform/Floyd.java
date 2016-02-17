package ru.itis.inform;

public class Floyd {

    private int a[][] = new int[50][50];

    private int verticeCount;

    public Floyd(GraphMatrixMatrixImpl graph) {
        this.a = graph.getMatrix();
        this.verticeCount = graph.getVerticeCount();
    }

    public void runFloid() {
        this.a = getMatrixFloid();
    }

    private int[][] getMatrixFloid() {

        int d[][] =new int[this.verticeCount+1][this.verticeCount+1];

        for (int i = 0; i< this.verticeCount; i++) {
            for (int j = 0; j< this.verticeCount; j++) {
                d[i][j] = a[i][j];
            }
        }

        for (int i = 0; i<this.verticeCount; i++){
            for (int j = 0; j<this.verticeCount; j++) {
                for (int k = 0; k < this.verticeCount; k++) {
                    if (d[i][j]>a[i][k]+a[k][j] && a[i][k]!=0 && a[k][j]!=0) {
                        d[i][j] = a[i][k]+a[k][j];
                    }
                }
            }
        }
        return d;
    }

    public int[][] getFloydMatrix() {
        return a;
    }
}
