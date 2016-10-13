package ru.itis.inform.services;

/**
 * Created by Тимур on 13.10.2016.
 */
public interface TokenService {
    void addToken(String id, String token);
    void updateToken(String id, String token);
    void deleteToken(String token);
    String findToken(String token);
}

