package ru.itis.inform.Human;

import ru.itis.inform.Array.ArrayList;
import ru.itis.inform.LinkedList;
import ru.itis.inform.LinkedListImpl;
import ru.itis.inform.Node;

/**
 * Created by Тимур on 25.02.2016.
 */
public class HumansSorter {
    public LinkedList<Human> sort(LinkedListImpl<Human> humanLinkedList) {
        ArrayList<LinkedListImpl<Human>> arrayList = new ArrayList<>();

        LinkedListImpl<Human> oldhumanLinkedList = humanLinkedList;
        Node<Human> r = oldhumanLinkedList.getFirst();
        while (r != null) {
            int currentAge = r.getValue().getAge();
            arrayList.setIndex(currentAge).add(r.getValue());
            r = r.getNext();
        }
        LinkedListImpl<Human> newHumanLinkedList = new LinkedListImpl<>();
        arrayList.append(newHumanLinkedList);

        return ;
    }
}
