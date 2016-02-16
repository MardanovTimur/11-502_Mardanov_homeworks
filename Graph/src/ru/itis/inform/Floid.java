package ru.itis.inform;

/**
 * Created by Тимур on 16.02.2016.
 */
public class Floid {
    private int a[][] = new int[51][51];
    private int verticeCount;
    public void setA(int[][] a,int verticeCount) {
        this.a = a;
        this.verticeCount = verticeCount;
    }

    public void show() {
      for (int i = 0; i < this.verticeCount; i++) {
            for (int j = 0; j<this.verticeCount; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
}
