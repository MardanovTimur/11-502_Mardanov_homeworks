package ru.itis.inform;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Created by Тимур on 06.09.2016.
 */
public class UsersService {

    UsersDao usersDao;

    public UsersService() throws FileNotFoundException {
        this.usersDao =  new UsersDaoImpl();
    }

    public void addUser(User user) throws FileNotFoundException {
        usersDao.save(user);
    }

    public boolean isRegistered(String name) throws FileNotFoundException {
        if (usersDao.find(name,1)!=null) {
            return true;
        } else
            return false;
    }

    public List<User> findAll() throws FileNotFoundException {
        return usersDao.findAll();
    }

    public void close(){
        usersDao.closePW();
        usersDao.closeSC();
    }
}
