package ru.itis.inform;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Timur Mardanov on 09.05.2017.
 * ITIS
 */
public class ProgramWithArrays {

    public static Integer matrix[][];
    public static int size = 0;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("C:\\Users\\alisa\\Desktop\\11-502_Mardanov_homeworks\\SearchInDeepAndConnectivityComponent\\src\\main\\resources\\input"));
        size = sc.nextInt();
        int i = 0;
        matrix = new Integer[size][size];
        while (sc.hasNextLine()) {
            matrix[i] = new Integer[size];
            for (int j = 0; j < size; j++) {
                matrix[i][j] = sc.nextInt();
            }
            i++;
        }

        SearchInDeep<Integer> searchInDeep = new SearchInDeep<>(matrix);

    }
}
