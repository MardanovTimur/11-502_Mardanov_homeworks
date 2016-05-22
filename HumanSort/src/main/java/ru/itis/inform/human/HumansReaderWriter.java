package ru.itis.inform.human;

import ru.itis.inform.Iterator;
import ru.itis.inform.LinkedListImpl;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class HumansReaderWriter {

    public LinkedListImpl<Human> readHumans(String fileName)
                                                throws FileNotFoundException {

        Scanner sc = new Scanner(new File("C:\\Users\\Тимур\\Desktop\\11-502_Mardanov_homeworks\\HumanSort\\src\\main\\java\\ru\\itis\\inform\\input\\"+fileName+".txt"));

        LinkedListImpl<Human> humanLinkedList = new LinkedListImpl<>();

        Human human;

        while (sc.hasNext()) {

            int age = sc.nextInt();
            String name = sc.nextLine();

            human = new Human(age, name);

            humanLinkedList.push(human);
        }
        sc.close();
        return humanLinkedList;
    }

    public void writeHumans(String fileName, LinkedListImpl<Human> humanLinkedList) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new File("C:\\Users\\Тимур\\Desktop\\11-502_Mardanov_homeworks\\HumanSort\\src\\main\\java\\ru\\itis\\inform\\output\\"+fileName+".txt"));

        Iterator<Human> iterator = humanLinkedList.iterator();

        while (iterator.hasNext()) {
            pw.println(iterator.peekNext().toString()+" ");
            iterator.next();
        }



        pw.close();

    }
}

