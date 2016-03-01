package ru.itis.inform.human;

import ru.itis.inform.Iterator;
import ru.itis.inform.LinkedList;
import ru.itis.inform.ArrayList;
import ru.itis.inform.LinkedListImpl;
import ru.itis.inform.Node;

/**
 * Created by Тимур on 25.02.2016.
 */
public class HumansSorter {

    public LinkedListImpl<Human> sort (LinkedListImpl<Human> humanLinkedList) {

        ArrayList<LinkedListImpl<Human>> arrayList = new ArrayList<>();

        Iterator<Human> humanIterator = humanLinkedList.iterator();

        for (int i = 0; i < arrayList.getSize(); i++) {
            LinkedListImpl<Human> current = arrayList.get(i);
            if (current==null)
                arrayList.set(i,new LinkedListImpl());
        }

        while (humanIterator.hasNext()) {

            int currentAge = humanIterator.peekNext().getAge();

            arrayList.get(currentAge).push(humanIterator.peekNext());
            humanIterator.next();
        }


        LinkedListImpl<Human> newHumanLinkedList = new LinkedListImpl<Human>();

        for (int i = 99; i >= 1; i--) {
            if (arrayList.get(i).getFirst() != null) {
                arrayList.get(i - 1).append(arrayList.get(i));
                arrayList.set(i, new LinkedListImpl<Human>());
            }
        }

        return arrayList.get(0);
    }
}
