package ru.timur.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.timur.itis.dao.DataDao;
import ru.timur.itis.dao.UsersDao;
import ru.timur.itis.model.Data;
import ru.timur.itis.model.User;
import ru.timur.itis.service.UserService;

import java.util.List;

/**
 * Created by timur on 30.03.17.
 */
@Component
public class UserServiceImpl implements UserService {
    @Autowired
    UsersDao usersDao;
    @Autowired
    DataDao dataDao;

    @Override
    public List<User> findAll() {
        return usersDao.findAll();
    }

    @Override
    public User get(int id) {
        return usersDao.get(id);
    }

    @Override
    public int saveObject(User object) {
        return usersDao.saveObject(object);
    }

    @Override
    public void delete(int id) {
        usersDao.delete(id);
    }

    @Override
    public User update(User object) {
        return usersDao.update(object);
    }

    @Override
    public User addData(User user, Data data) {
        return usersDao.addData(user,data);
    }


    @Override
    public User findByUsername(String name) {
        return usersDao.findByUsername(name);
    }

    public User getUserByName(String username) {
        return usersDao.getUserByName(username);
    }

    public User addDataForUser(User user, Data data) {
        user.getDataList().add(data);
        data.setUser(user);
        dataDao.saveObject(data);
        usersDao.update(user);
        return user;
    }
}
