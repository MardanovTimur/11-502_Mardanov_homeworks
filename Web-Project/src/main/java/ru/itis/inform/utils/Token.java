package ru.itis.inform.utils;

import java.security.SecureRandom;

/**
 * Created by Тимур on 10.10.2016.
 */
// Использование токенов для юзера
public class Token {
    private String string = null;

    public static String getToken() {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[20];
        random.nextBytes(bytes);
        String token = bytes.toString();
        return token;
    }



}
