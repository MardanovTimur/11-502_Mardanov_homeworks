package ru.itis.inform;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Тимур on 06.04.2016.
 */
public class Scan {

    private static int numberInArray;

    public static int[] getArrayInFile(String pack, int numberFile) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("C:\\Users\\Тимур\\Desktop\\11-502_Mardanov_homeworks\\BucketSort\\src\\main\\java\\ru\\itis\\inform\\" + pack + "\\" + "input" + numberFile+".txt"));
        int iterator = 0;
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        while (sc.hasNext()) {
            linkedList.addLast(sc.nextInt());
            iterator++;
        }
        int[] a = new int[iterator];

        for (int i = 0; i < iterator; i++) {
            a[i] = linkedList.get(i);
        }

        numberInArray = iterator;
        return a;
    }

    public static int getNumberInArray() {
        return numberInArray;
    }
}
