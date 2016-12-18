package ru.itis.inform.dao;

import ru.itis.inform.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    //Добавление пользвателя
    void addUser(User user) throws SQLException;
    //Поиск пользователя
    User findUser(String login);
    //Поиск юзера по айди
    User findUserId(String id);
    //Получить модели пользователей по логину
    List<User> findUsers(String login);
    //Удаление пользователя
    void deleteUser(String id);
    //Смена прав для пользователя
    void changeRulesInUser(String id);
    //Добавление аватара
    void addImage(byte[] image, String id);
}
