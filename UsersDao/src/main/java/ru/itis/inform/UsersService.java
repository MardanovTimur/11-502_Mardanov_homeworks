package ru.itis.inform;

import java.io.FileNotFoundException;

/**
 * Created by Тимур on 06.09.2016.
 */
public class UsersService {

    UsersDao usersDao = new UsersDaoImpl();

    public UsersService() throws FileNotFoundException {
    }

    public boolean isRegistered(String name) throws FileNotFoundException {
        if (usersDao.find(name,1)!=null) {
            return true;
        } else
            return false;
    }
}
