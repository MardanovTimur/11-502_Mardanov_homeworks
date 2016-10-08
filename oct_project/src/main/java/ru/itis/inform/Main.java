package ru.itis.inform;

import ru.itis.inform.utils.Hash;

/**
 * Created by Тимур on 07.10.2016.
 */
public class Main {
    public static void main(String[] args) {
        String password = "admin";
        System.out.println(Hash.getMd5Apache(password));
    }
}
