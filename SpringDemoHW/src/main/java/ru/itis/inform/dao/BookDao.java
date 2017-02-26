package ru.itis.inform.dao;

import ru.itis.inform.model.Book;

import java.util.List;

/**
 * Created by Тимур on 22.02.2017.
 */
public interface BookDao extends BaseDao<Book> {
    List<Book> getAllBooksByUserId(Long id);
}
