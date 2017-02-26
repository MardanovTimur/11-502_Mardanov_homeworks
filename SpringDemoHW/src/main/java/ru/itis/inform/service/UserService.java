package ru.itis.inform.service;

import ru.itis.inform.model.Book;
import ru.itis.inform.model.User;

import java.util.List;

/**
 * Created by Тимур on 15.02.2017.
 */
public interface UserService {

    boolean addFriend(Long fid, Long sid);

    boolean isRegistered(String name);

    List<Book> getAllBooks();
}