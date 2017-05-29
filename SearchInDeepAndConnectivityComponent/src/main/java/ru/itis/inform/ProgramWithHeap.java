package ru.itis.inform;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Timur Mardanov on 19.05.2017.
 * ITIS
 */
public class ProgramWithHeap {
    public static int matrix[][];
    public static int size = 0;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("C:\\Users\\alisa\\Desktop\\11-502_Mardanov_homeworks\\SearchInDeepAndConnectivityComponent\\src\\main\\resources\\heapInput"));
        size = sc.nextInt();
        int i = 0;
        sc.nextLine();
        matrix = new int[size][];
        while (sc.hasNextLine()) {
            int[] max = new int[size-1];
            int j = 0;
            String[] s = sc.nextLine().split(" ");
            for (int is=0; is<s.length; is++) {
                max[is] = Integer.valueOf(s[is]);
            }
            matrix[i] = new int[s.length];
            for (int m = 0;  m<s.length; m++) {
                matrix[i][m] = max[m];
            }
            i++;
        }

        SearchInDeep searchInDeep = new SearchInDeep(matrix);

    }
}
