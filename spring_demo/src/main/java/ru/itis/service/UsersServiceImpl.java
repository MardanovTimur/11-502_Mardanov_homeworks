package ru.itis.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.itis.dao.UsersDao;
import ru.itis.dao.UsersDaoFakeImpl;

public class UsersServiceImpl implements UsersService {

    private UsersDao usersDao;

    public UsersServiceImpl(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    public String getNameOfUser(int userId) {
        return usersDao.getUser(userId).getName();
    }
}
