package ru.itis.inform.simple;

import ru.itis.inform.List;

/**
 * Created by timur on 14.03.17.
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<Integer>();
        list.addAfter(2);
        list.addAfter(3);
        list.addAfter(5);
        //list.remove(5);
        System.out.println(list.has(4));
    }
}
