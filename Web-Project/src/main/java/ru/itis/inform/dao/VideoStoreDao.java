package ru.itis.inform.dao;

import ru.itis.inform.models.Film;

/**
 * Created by Тимур on 05.10.2016.
 */
public interface VideoStoreDao {
    void add(Film film);
    int getId(String name);
    void delete(String id);
}
