package ru.itis.inform;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created by Тимур on 06.04.2016.
 */
public class Record {

    private static int fileNumbers;
    private static int numberInArray[] =  new int[300];

    public static void delete(String path) throws FileNotFoundException
    {
        File file = new File("C:\\Users\\Тимур\\Desktop\\11-502_Mardanov_homeworks\\BucketSort\\src\\main\\java\\ru\\itis\\inform\\"+path);

        file.delete();

    }

    public static int getFileNumbers() {
        return fileNumbers;
    }

    public static void recordIn(String pack) throws FileNotFoundException {
        PrintWriter[] pw = new PrintWriter[300];
        String path = "input";
        File file =  new File("C:\\Users\\Тимур\\Desktop\\11-502_Mardanov_homeworks\\BucketSort\\src\\main\\java\\ru\\itis\\inform\\"+pack);
        file.mkdir();
        file.mkdirs();
        int f = 100;
        int iterator = 0;
        while (f < 10000) {
            pw[iterator] = new PrintWriter(new File(file.getPath()+"\\"+ path + iterator + ".txt"));

            for (int i = 0; i < f; i++) {
                pw[iterator].print((int) (Math.random() * f));
                pw[iterator].print(" ");
            }
            numberInArray[iterator] = f;
            pw[iterator].close();

            f = (int) (Math.random() * 100 + f);

            iterator++;
        }

        fileNumbers = iterator;

    }

    public static int getNumberInArray(int i) {
        return numberInArray[i];
    }
}
