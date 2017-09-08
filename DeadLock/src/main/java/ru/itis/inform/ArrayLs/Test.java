package ru.itis.inform.ArrayLs;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(10);
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("3");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("3");
        list.add("5");
        list.add("3");
        list.add("3");
        list.add("1");
        list.add("1");
        list.add("1");
        list.add("1");
        list.remove("3");
        list.set(0,"3");
        list.set(12,"4");
        list.set(4,"32");
        list.remove(12);
        list.remove(0);

        System.out.println(list.toString());
    }
}
