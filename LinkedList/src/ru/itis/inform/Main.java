package ru.itis.inform;

public class Main {

    public static void main(String[] args) {
        LinkedListImpl<Integer> list = new LinkedListImpl<Integer>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(8);
        list.push(10);

        Iterator<Integer> iterator = list.iterator();

        iterator.next();
        iterator.insert(3);
        iterator.insert(4);
        iterator.next();
        System.out.println(iterator.previous());
        iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next()+" ");
        }

        //System.out.println(iterator.previous());

        //Output: 8 5 3 2 1 10


    }
}
