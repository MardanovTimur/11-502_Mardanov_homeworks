package ru.itis.inform.dao;

/**
 * Created by Тимур on 13.10.2016.
 */
public interface TokenDao {
    //Защита системы
    //Добавление токена айди и самого токена
    void addToken(String id, String token);
    //Обновление токена
    void updateToken(String id, String token);
    //Удаление токена
    void deleteToken(String token);
    //Поиск токена
    String findToken(String token);
}
