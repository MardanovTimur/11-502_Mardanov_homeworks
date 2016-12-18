package ru.itis.inform.services;

import ru.itis.inform.dao.UserDao;
import ru.itis.inform.dao.UserDaoImpl;
import ru.itis.inform.errors.Error;
import ru.itis.inform.messages.Message;
import ru.itis.inform.models.User;
import ru.itis.inform.utils.Hash;
import ru.itis.inform.verifiers.UserVerify;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    private Error error = null;
    private Message message = null;

    public UserServiceImpl() {
    }
    public Message add(String name, String login, String password, String passwordAgain, boolean is_admin) {
        message = null;
        //Check to size (2<x<30)
        if (defaultSize(name) && defaultSize(login) && defaultSize(password) && defaultSize(passwordAgain)) {
            if (password.equals(passwordAgain)) {
                User newUser = null;
                try {
                    password = Hash.getMd5Apache(password);
                    newUser = new User(name, login, password, is_admin);
                    if (UserVerify.checkUserInBD(userDao, login) == null) {
                        userDao.addUser(newUser);
                        message = new Message("user_registration", " is registered.");
                        return message;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                message = new Message("wrong_password", "Passwords isn't equals!");
                return message;
            }
        } else {
            message = new Message("wrong_size","Wrong word size.");
            return message;
        }
        return null;
    }

    public List<User> findAll() {
        return null;
    }

    public void delete(String id) {

    }

    public User find(String login) {
        error = null;
        message = null;
        if (userDao.findUser(login)==null) {
            error = new Error("user_not_found", "User not found");
            return null;
        } else {
            message = new Message("user", "User is found");
            return userDao.findUser(login);
        }
    }

    public User findId(String id) {
        error = null;
        message = null;
        if (userDao.findUserId(id)==null) {
            error = new Error("user_not_found", "User not found!");
            return null;
        } else {
            message = new Message("user", "User is found!");
            return userDao.findUserId(id);
        }
    }

    public void changeRule(String id) {

    }

    public void addImage(byte[] image, String id) {
        userDao.addImage(image,id);
    }

    private boolean defaultSize(String value) {
        return (value.length() >= 2 && value.length() <= 30);
    }
}
