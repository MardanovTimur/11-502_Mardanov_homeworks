package ru.itis.inform.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created by Тимур on 06.10.2016.
 */
//Хэшировка паролей для юзеров(инф безопасность)
public class Hash {
    public static String getMd5Apache(String password) {
        return DigestUtils.md5Hex(password);
    }
}
