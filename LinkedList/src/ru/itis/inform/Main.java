package ru.itis.inform;

public class Main {

    public static void main(String[] args) {
        LinkedListImpl ls = new LinkedListImpl();

        ls.add(1);
        ls.add(2);
        ls.add(3);
        ls.add(5);
        ls.add(8);

        ls.printList();

        System.out.println();

        ls.remove(3);

        //ls.printList();
        ls.printList();
    }
}
