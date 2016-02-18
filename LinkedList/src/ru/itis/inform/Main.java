package ru.itis.inform;

public class Main {

    public static void main(String[] args) {
        LinkedListImpl<Integer> list = new LinkedListImpl<Integer>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(8);

        IteratorImpl<Integer> iterator = list.iterator();

        //list.printList();

        System.out.println();



        //ls.printList();
        //ls.printList();
    }
}
