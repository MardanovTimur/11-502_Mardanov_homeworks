package ru.itis.inform.services;

import ru.itis.inform.JDBC.JDBCUsersImpl;

import java.io.FileNotFoundException;


public class UsersService extends JDBCUsersImpl {

    public UsersService() throws FileNotFoundException {
    }
/*
    public void addUser(User user) throws FileNotFoundException, SQLException {
        usersDao.save(user);
    }

    public boolean isRegistered(String name) throws FileNotFoundException, SQLException {
        if (usersDao.find(name,1)!=null) {
            return true;
        } else
            return false;
    }

    public List findAll() throws FileNotFoundException, SQLException {
        return usersDao.findAll();
    }

    public void close(){
        usersDao.closePW();
        usersDao.closeSC();
    }*/
}
