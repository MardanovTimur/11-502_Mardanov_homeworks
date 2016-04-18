package ru.itis.inform;
public class Deix {

    private final int MAXV = 9999999;
    private final int SIZE;
    private int matrix[][];
    private Massive[] mas;

    public Deix(int size) {
        this.SIZE = size;
        this.matrix = new int[size][size];
        this.mas = new Massive[size];
    }

    public Deix(int[][] matrix) {
        this.matrix = matrix;
        this.SIZE = matrix.length;
        this.mas = new Massive[SIZE];
    }

    public Massive[] getDeix(int numberVertex) {
        if (matrix == null) {
            throw new NullPointerException();
        } else {
            for (int ic = 0; ic < SIZE; ic++) {
                mas[ic] = new Massive();
                mas[ic].setValue(MAXV);
            }
            mas[numberVertex].setValue(0);

            int count = 0;
            int currentPoint = numberVertex;
            int minValue = MAXV;

            while (count < SIZE) {
                minValue = MAXV;
                for (int j = 0; j < SIZE; j++) {
                    if (j != currentPoint && matrix[currentPoint][j] != 0) {
                        if (mas[currentPoint].getValue() + matrix[currentPoint][j] < mas[j].getValue()) {
                            mas[j].setValue(mas[currentPoint].getValue() + matrix[currentPoint][j]);
                        }
                    }
                }
                for (int j = 0; j < SIZE; j++) {
                    if (mas[j].getValue() < minValue && !mas[j].isCheckA()) {
                        minValue = mas[j].getValue();
                        currentPoint = j;
                    }
                }
                mas[currentPoint].setCheckA();
                count++;
            }
        }
    return mas;
}

}


