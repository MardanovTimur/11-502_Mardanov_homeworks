package ru.itis.inform.services;

import ru.itis.inform.messages.Message;
import ru.itis.inform.models.User;

import java.util.List;

/**
 * Created by Тимур on 05.10.2016.
 */
public interface UserService {
    Message add(String name, String login, String password, String passwordAgain, boolean is_admin);
    List<User> findAll();
    void delete(String id);
    User find(String login);
    User findId(String id);
    void changeRule(String id);
    void addImage(byte[] image, String id);
}