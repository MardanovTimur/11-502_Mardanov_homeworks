package ru.itis.inform.service;

import ru.itis.inform.dao.UsersDao;
import ru.itis.inform.model.Book;
import ru.itis.inform.model.User;

import java.util.List;

/**
 * Created by Тимур on 15.02.2017.
 */
public interface UserService {

    Long save(User user);

    boolean addFriend(Long fid, Long sid);

    boolean isRegistered(String name);

    UsersDao getUsersDao();

    List<Book> getAllBooks();
}