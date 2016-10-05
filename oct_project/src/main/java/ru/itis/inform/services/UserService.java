package ru.itis.inform.services;

import ru.itis.inform.models.User;

import java.util.List;

/**
 * Created by Тимур on 05.10.2016.
 */
public interface UserService {
    void add(String name, String login, String password, String passwordAgain, boolean is_admin);
    List<User> findAll();
    void delete(String id);
    void find(String id);
    void changeRule(String id);
}