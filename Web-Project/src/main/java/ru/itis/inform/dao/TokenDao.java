package ru.itis.inform.dao;

/**
 * Created by Тимур on 13.10.2016.
 */
public interface TokenDao {
    void addToken(String id, String token);
    void updateToken(String id, String token);
    void deleteToken(String token);
    String findToken(String token);
}
