package ru.itis.inform.second;

import ru.itis.inform.List;

/**
 * Created by timur on 14.03.17.
 */
public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.addAfter(2);
        list.addAfter(3);
        list.addAfter(5);

        LinkedList<Integer> alist = new LinkedList<Integer>();
        alist.addAfter(1);
        alist.addAfter(2);
        alist.addAfter(4);

        list.merge(alist);
        //list.remove(5);
        //System.out.println(list.has(4));
    }
}
