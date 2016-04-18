package ru.itis.inform;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created by Тимур on 04.04.2016.
 */
public class Main {
    public static void main(String[] argc) throws FileNotFoundException {
        String pack = "inputs";
        PrintWriter time = new PrintWriter(new File("C:\\Users\\Тимур\\Desktop\\11-502_Mardanov_homeworks\\BucketSort\\src\\main\\java\\ru\\itis\\inform\\time.txt"));
        PrintWriter timeNano = new PrintWriter(new File("C:\\Users\\Тимур\\Desktop\\11-502_Mardanov_homeworks\\BucketSort\\src\\main\\java\\ru\\itis\\inform\\timeNano.txt"));
        PrintWriter iterations = new PrintWriter(new File("C:\\Users\\Тимур\\Desktop\\11-502_Mardanov_homeworks\\BucketSort\\src\\main\\java\\ru\\itis\\inform\\iterations.txt"));
        Record.recordIn(pack);
        int[] array;
        for (int i = 1; i < Record.getFileNumbers(); i++) {
            array = Scan.getArrayInFile(pack,i);
            long timeBeforeSorting = System.currentTimeMillis();
            long timeBeforeSortingNano = System.nanoTime();
            array = BucketSort.sort(array);
            Print.print(array,"outputs","output",i);
            long timeAfterSorting = System.currentTimeMillis();
            long timeAfterSortingNano = System.nanoTime();
            time.println((timeAfterSorting-timeBeforeSorting));
            timeNano.println((timeAfterSortingNano-timeAfterSorting));
            iterations.println(BucketSort.getIterations());
        }
        time.close();
        timeNano.close();
        iterations.close();
    }
}
