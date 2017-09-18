package ru.itis.inform;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ChessLadya {
    //Количество возможных вариантов
    private static int COUNT = 0;
    // (двумерный)Массив представленный как одномерный
    private static boolean[] array, oldArray;
    private static List<Vector> vectors;
    private static int countLadya;
    private static int m, n;

    private ChessLadya(int ladyaCount, int m, int n) {
        this.countLadya = ladyaCount;
        this.m = m;
        this.n = n;
        this.array = new boolean[n * m];
        this.oldArray = new boolean[n * m];
        this.vectors = new ArrayList<Vector>();
    }

    private static boolean[] swap(int i, int j, final boolean[] array) {
        boolean s = array[i];
        array[i] = array[j];
        array[j] = s;
        return array;
    }

    private static boolean checkExpression(boolean[] array) {
        oldArray = array;
        vectors = new ArrayList<Vector>();
        for (int i = 0; i < n * m; i++) {
            if (array[i]) {
                for (Vector v : vectors) {
                    if (v.getX() == i / m || v.getY() == m - i % m)
                        return false;
                }
                vectors.add(new Vector(i / m, i % m));
            }

        }
        COUNT++;
        return true;
    }

    private static boolean checkChangedPositions(boolean[] newArray) {
        return Arrays.equals(array, newArray);
    }

    private static boolean[] generate(int k, boolean[] oldArray) {
        if (k + 1 == (n * m)) {
            if (!checkChangedPositions(oldArray))
                checkExpression(array);
        } else {
            for (int i = k + 1; i < n * m; i++) {
                array = swap(k + 1, i, array);
                array = generate(k + 1, oldArray);
                array = swap(k + 1, i, array);
            }
        }

        return array;
    }

    private static boolean[] setUpLadya(int kol) {
        for (int i = 0; i < m * n - kol; i++) {
            array[i] = false;
            oldArray[i] = false;
        }
        while (kol-- > 0) {
            array[array.length - kol - 1] = true;
            oldArray[array.length - kol - 1] = true;
        }
        return oldArray;
    }

    public static void main(String[] args) {
        new ChessLadya(2, 3, 3);
        oldArray = setUpLadya(countLadya);
        generate(-1, oldArray);
        System.out.println(COUNT);
    }
}

class Vector {
    private int x;
    private int y;

    public Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
