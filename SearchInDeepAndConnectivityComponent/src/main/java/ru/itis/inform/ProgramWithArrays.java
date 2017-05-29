package ru.itis.inform;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Timur Mardanov on 09.05.2017.
 * ITIS
 */
public class ProgramWithArrays {

    public static int matrix[][];
    public static int size = 0;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("C:\\Users\\alisa\\Desktop\\11-502_Mardanov_homeworks\\SearchInDeepAndConnectivityComponent\\src\\main\\resources\\input"));
        size = sc.nextInt();
        int i = 0;
        matrix = new int[size][size];
        while (sc.hasNextLine()) {
            matrix[i] = new int[size];
            for (int j = 0; j < size; j++) {
                matrix[i][j] = sc.nextInt();
            }
            i++;
        }

        SearchInDeep searchInDeep = new SearchInDeep(matrix);

    }
}
