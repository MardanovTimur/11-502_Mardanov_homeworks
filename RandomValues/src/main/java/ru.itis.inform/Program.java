package ru.itis.inform;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * Created by Timur Mardanov on 20.05.2017.
 * ITIS
 */
public class Program {
    public static final int SIZE = 5000;

    public static final boolean isHeap = true;

    public static void main(String[] args) throws IOException, InterruptedException {
        File file = new File("input.txt");
        if (!file.exists()) {
            file.createNewFile();
        }

        int[][] a = new int[5000][5000];
        Random random = new Random();
        PrintWriter pw = new PrintWriter(file);
        for (int i = 0; i < SIZE; i++) {
            for (int j = i; j < SIZE; j++) {
                if (i != j) {
                    a[i][j] = random.nextInt(2);
                    a[j][i] = a[i][j];
                } else {
                    a[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                pw.print(a[i][j]);
                if (j != SIZE - 1) {
                    pw.print(" ");
                }
            }
            pw.flush();
            pw.println();
        }
        pw.close();

        if (isHeap) {
            File heapFile = new File("hinput.txt");
            PrintWriter printWriter = new PrintWriter(heapFile);
            int heapSize = 0;
            for (int i = 0; i < SIZE; i++) {
                for (int j = i + 1; j < SIZE; j++) {
                    if (a[i][j] != 0) {
                        heapSize++;
                        printWriter.println((i + 1) + " " + (j + 1));
                    }
                }
            }
            printWriter.print(heapSize);
            printWriter.close();
        }


    }
}
