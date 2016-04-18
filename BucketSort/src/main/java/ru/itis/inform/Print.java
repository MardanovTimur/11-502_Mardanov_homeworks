package ru.itis.inform;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created by Тимур on 07.04.2016.
 */
public class Print {
    public static void print(int[] a,String pack,String file, int numberFile) throws FileNotFoundException {
        File fl = new File("C:\\Users\\Тимур\\Desktop\\11-502_Mardanov_homeworks\\BucketSort\\src\\main\\java\\ru\\itis\\inform\\"+pack);
        fl.mkdirs();
        fl.mkdir();
        PrintWriter pw = new PrintWriter(new File(fl.getPath()+"\\"+file+numberFile+".txt"));
        for (int i = 0; i < Record.getNumberInArray(numberFile); i++) {
            pw.print(a[i]+" ");
        }
        pw.close();
    }
}
