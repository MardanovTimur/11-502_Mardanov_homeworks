package ru.itis.inform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.inform.dao.UsersDao;
import ru.itis.inform.model.User;
import ru.itis.inform.service.UserService;

import java.util.List;

/**
 * Created by Тимур on 15.02.2017.
 */
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersDao usersDao;

    public boolean isRegistered(String name) {
        List<User> users = usersDao.findAll();
        for (User a :
                users) {
            if (a.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
