package ru.itis.inform.Array;

import ru.itis.inform.Human.Human;
import ru.itis.inform.LinkedList;
import ru.itis.inform.LinkedListImpl;
import ru.itis.inform.Node;

import java.util.Objects;

/**
 * Created by Тимур on 24.02.2016.
 */
public class ArrayList<T> {

    private Object elements[];

    private int count;


    public ArrayList() {
        this.elements = new Object[101];
        this.count = 0;
    }
    @SuppressWarnings("uchecked")
    public T  getIndex(int currentAge)  {
        this.count++;
        if (this.elements[currentAge] == null) {
            this.elements[currentAge] = new LinkedListImpl<>();
        }
        return (T)elements[currentAge];
    }

    @SuppressWarnings("unchecked")
    public T append(LinkedListImpl list) {
        for (int i = 0; i<=100; i++) {

            if (this.elements[i] != null) {

                LinkedListImpl<Human> linkedList = (LinkedListImpl<Human>) elements[i];
                Node<Human> newNode = linkedList.getFirst();

                while (newNode != null) {
                    list.push(newNode.getValue());
                    newNode = newNode.getNext();
                }
            }
        }
        return (T)list;
    }


}