package ru.itis.inform;

import ru.itis.inform.Array.*;
import ru.itis.inform.LinkedList.*;

public class Main {

    public static void main(String[] args) {
        FareyArrayImpl A = new FareyArrayImpl();
        A.generate(17);
        A.print();

        System.out.println();

        FareyLinkedListImpl L = new FareyLinkedListImpl();
        L.Generate(17);
        L.Print();
    }

}
