package ru.itis.inform;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Тимур on 30.03.2016.
 */
public class MatrixCode {
    private final int sizeM;
    private final int sizeX;
    private final int sizeY;
    private LinkedList<Element> matrixLinkedList;

    public MatrixCode(int size) {
        this.sizeM = size;
        this.sizeX = (int) Math.pow(size, 0.5);
        this.sizeY = sizeX;
        matrixLinkedList = new LinkedList<Element>();
    }

    public MatrixCode(int[][] matrix) {
        int indexY = matrix[0].length;
        int indexX = matrix.length;

        this.sizeX = indexX;
        this.sizeY = indexY;

        this.sizeM = indexX * indexY;
        matrixLinkedList = new LinkedList<Element>();

        for (int i = 0; i < indexX; i++) {
            for (int j = 0; j < indexY; j++) {
                matrixLinkedList.addLast(new Element(matrix[i][j], i, j));
            }
        }
    }

    public int[][] decode() {
        int[][] matrixDecode = new int[sizeX][sizeY];
        int d = 0;
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                matrixDecode[i][j] = matrixLinkedList.get(d).getValue();
                d++;
            }
        }
        return matrixDecode;
    }

    public void insert(int i, int j, int value) {
        if (i <= sizeX && j <= sizeY) {
            int index = (i) * (sizeY) + j;
            this.matrixLinkedList.get(index).setValue(value);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public ArrayList<Element> minList() {
        ArrayList<Element> arrayList = new ArrayList<Element>();

        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if (i == 0) {
                    arrayList.add(j, matrixLinkedList.get(j));
                } else if (arrayList.get(j).getValue() > matrixLinkedList.get((i) * (sizeY) + j).getValue()) {
                    arrayList.set(j, matrixLinkedList.get((i) * (sizeY) + j));
                }
            }
        }
        return arrayList;
    }

    public int sumDiag() {
        int summ = 0;
        int dindex = -1;
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                dindex++;
                if (i == j || i == sizeY - 1 - j) {
                    summ += matrixLinkedList.get(dindex).getValue();
                }
            }
        }
        return summ;
    }

    public void delete(int i, int j) {
        insert(i, j, 0);
    }

    public void show() {
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                System.out.print(matrixLinkedList.get(i * sizeY + j).getValue() + ", ");
            }
            System.out.println();
        }
    }

    public void transp() {
        for (int i = 0; i < sizeX - 1; i++) {
            for (int j = i + 1; j < sizeY; j++) {
                Element element = new Element(matrixLinkedList.get((i) * sizeY + j).getValue(), i, j);
                matrixLinkedList.set((i) * sizeY + j, matrixLinkedList.get((j) * sizeY + i));
                matrixLinkedList.set((j) * sizeY + i, element);
            }
        }
    }

    public void sumCols(int j1, int j2) {
        int[] a = new int[sizeX];
        for (int i = 0; i < sizeX; i++) {
            a[i] += matrixLinkedList.get(i * sizeY + j1).getValue() + matrixLinkedList.get(i * sizeY + j2).getValue();
        }
        for (int i = 0; i < sizeX; i++) {
            matrixLinkedList.get(i * sizeX + j1).setValue(a[i]);
        }
    }

    public int getSizeM() {
        return sizeM;
    }
}
