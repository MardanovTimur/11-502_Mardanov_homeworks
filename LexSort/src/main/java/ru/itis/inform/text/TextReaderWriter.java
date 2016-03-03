package ru.itis.inform.text;

import ru.itis.inform.Iterator;
import ru.itis.inform.LinkedListImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextReaderWriter {

    public LinkedListImpl<String> readHumans(String fileName) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("C:\\Users\\Тимур\\Desktop\\11-502_Mardanov_homeworks\\LexSort\\src\\main\\java\\ru\\itis\\inform\\input\\"+fileName+".txt"));

        LinkedListImpl<String> linkedText = new LinkedListImpl<>();

        String name = sc.nextLine();
        String names[] = name.split("\\ ");

        for (String i : names) {
            linkedText.push(i);
        }
        sc.close();
        return linkedText;
    }

    public void writeHumans(String fileName, LinkedListImpl<String> linkedText) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new File("C:\\Users\\Тимур\\Desktop\\11-502_Mardanov_homeworks\\LexSort\\src\\main\\java\\ru\\itis\\inform\\output\\"+fileName+".txt"));

        Iterator<String> iterator = linkedText.iterator();

        while (iterator.hasNext()) {
            pw.println(iterator.peekNext()+" ");
            iterator.next();
        }
        pw.close();
    }
}

