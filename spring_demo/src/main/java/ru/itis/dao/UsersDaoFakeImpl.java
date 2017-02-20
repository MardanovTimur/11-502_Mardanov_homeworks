package ru.itis.dao;

import ru.itis.models.User;


public class UsersDaoFakeImpl implements UsersDao {
    public User getUser(int id) {
        return new User(1, 23, "Marsel");
    }
}
