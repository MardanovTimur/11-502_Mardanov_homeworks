package ru.itis.inform.Human;

import ru.itis.inform.Array.ArrayList;
import ru.itis.inform.LinkedList;
import ru.itis.inform.LinkedListImpl;
import ru.itis.inform.Node;

/**
 * Created by Тимур on 25.02.2016.
 */
public class HumansSorter {

    public LinkedListImpl<Human> sort(LinkedListImpl<Human> humanLinkedList) {

        ArrayList<LinkedListImpl<Human>> arrayList = new ArrayList<>();

        Node<Human> r = humanLinkedList.getFirst();

        while (r != null) {
            int currentAge = r.getValue().getAge();

            arrayList.getIndex(currentAge).push(r.getValue());

            r = r.getNext();
        }
        LinkedListImpl<Human> newHumanLinkedList = new LinkedListImpl<Human>();

        newHumanLinkedList = arrayList.append(newHumanLinkedList);

        return newHumanLinkedList;
    }
}
