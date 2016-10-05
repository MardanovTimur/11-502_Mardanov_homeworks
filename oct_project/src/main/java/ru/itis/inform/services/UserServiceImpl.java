package ru.itis.inform.services;

import ru.itis.inform.dao.UserDao;
import ru.itis.inform.dao.UserDaoImpl;
import ru.itis.inform.models.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = null;
    //Подумать над еррорами.
    // FIXME: 06.10.2016
    
    public UserServiceImpl() {
        this.userDao = new UserDaoImpl();
    }

    public void add(String name, String login, String password,String passwordAgain, boolean is_admin) {
        //Check to size (2<x<30)
        if (defaultSize(name) && defaultSize(login) && defaultSize(password) && defaultSize(passwordAgain)) {
            if (password.equals(passwordAgain)) {
                User newUser = null;
                try {
                    newUser = new User(name, login, password, is_admin);
                    // Прописать верифайер на проверку уже существующего юзера в сети
                    // FIXME: 06.10.2016
                    userDao.addUser(newUser);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                //Send error about wrong passwords
                // FIXME: 06.10.2016
            }
        } else {
            //Send error about wrong size words
            // FIXME: 06.10.2016
        }
    }

    public List<User> findAll() {
        return null;
    }

    public void delete(String id) {

    }

    public void find(String id) {

    }

    public void changeRule(String id) {

    }

    private boolean defaultSize(String value) {
        return value.length() >= 2 && value.length() <= 30;
    }
}
