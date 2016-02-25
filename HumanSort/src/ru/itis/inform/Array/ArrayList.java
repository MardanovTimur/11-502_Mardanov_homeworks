package ru.itis.inform.Array;

import ru.itis.inform.Human.Human;
import ru.itis.inform.LinkedListImpl;
import ru.itis.inform.Node;

/**
 * Created by Тимур on 24.02.2016.
 */
public class ArrayList<T> {

    private T elements[];
    private int count;

    public ArrayList(T[] elements) {
        for (int i = 0; i<=100; i++)
        this.elements[i] = new T();
    }

    public T getIndex(int currentAge) {
        this.count++;
        elements[currentAge] = new ;
        return elements[currentAge];
    }

    public T append(LinkedListImpl list) {
        for (int i = 0; i<=100; i++) {
            if (elements[i] != null) {
                LinkedListImpl<T> newLinkedList = new LinkedListImpl<>();

                newLinkedList = (LinkedListImpl<T>) elements[i];
                Node<T> newNode = newLinkedList.getFirst();

                while (newNode != null) {
                    list.push(newNode);
                    newNode = newNode.getNext();
                }
            }
        }
        return (T)list;
    }


}