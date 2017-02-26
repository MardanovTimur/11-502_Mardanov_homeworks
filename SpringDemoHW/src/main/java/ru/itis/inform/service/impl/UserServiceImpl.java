package ru.itis.inform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.itis.inform.dao.BookDao;
import ru.itis.inform.dao.UsersDao;
import ru.itis.inform.model.Book;
import ru.itis.inform.model.User;
import ru.itis.inform.service.UserService;

import java.util.List;

/**
 * Created by Тимур on 15.02.2017.
 */
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("jdbc.users.dao")
    private UsersDao usersDao;


    @Autowired
    @Qualifier("hibernate.users.dao")
    private UsersDao usersDaoH;

    @Autowired
    @Qualifier("hibernate.book.dao")
    private BookDao bookDao;

    @Override
    public boolean addFriend(Long fid, Long sid) {
        return usersDaoH.addFriend(fid,sid);
    }

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

    public List<Book> getAllBooks() {
        return bookDao.findAll();
    }
}
