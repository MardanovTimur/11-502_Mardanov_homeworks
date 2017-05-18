package ru.itis.inform;

import ru.itis.inform.models.Node;
import sun.net.www.content.text.Generic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Timur Mardanov on 09.05.2017.
 * ITIS
 */
public class Program {

    private boolean type;
    public static Node[][] connectivityMatrix;
    public static int size = 0;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("input"));
        if (scanner.hasNextLine()) {
            size = scanner.nextInt();
        }
        connectivityMatrix = new Node[size][];
        int j = 0;
        while (scanner.hasNextLine()) {
            connectivityMatrix[j] = new Node[size];
            for (int i = 0; i < size; i++) {
                connectivityMatrix[j][i] = new Node<Integer>(j, scanner.nextInt());
            }
            j++;
        }
    }
}
