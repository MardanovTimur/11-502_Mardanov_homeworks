package ru.itis.inform.dao;

import ru.itis.inform.model.User;

import java.util.List;

/**
 * Created by Тимур on 15.02.2017.
 */
public interface UsersDao extends BaseDao<User>{
    List<User> findByAge(int age);
}
