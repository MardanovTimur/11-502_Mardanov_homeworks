package ru.itis.inform.Human;

import ru.itis.inform.Human.Human;
import ru.itis.inform.Iterator;
import ru.itis.inform.LinkedListImpl;
import ru.itis.inform.Node;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class HumansReaderWriter {

    public LinkedListImpl<Human> readHumans()
                                                throws FileNotFoundException {

        Scanner sc = new Scanner(new File("C:\\Users\\Тимур\\Desktop\\11-502_Mardanov_homeworks\\HumanSort\\src\\ru\\itis\\inform\\input\\Humans.txt"));

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
        PrintWriter pw = new PrintWriter(new File("C:\\Users\\Тимур\\Desktop\\11-502_Mardanov_homeworks\\HumanSort\\src\\ru\\itis\\inform\\output\\"+fileName+".txt"));

        /*Iterator<Human> iterator = humanLinkedList.iterator();

        while (iterator.hasNext()) {
            pw.print(iterator.peekNext().toString()+" ");
            iterator.next();
        }
*/
        pw.print(humanLinkedList.getFirst().getValue().toString());

        pw.close();

    }
}

