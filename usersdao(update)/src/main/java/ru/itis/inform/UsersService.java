package ru.itis.inform;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;


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
