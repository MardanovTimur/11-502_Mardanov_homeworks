package ru.itis.inform.dao;

import ru.itis.inform.models.Genre;

import java.util.List;

/**
 * Created by Тимур on 05.10.2016.
 */
public interface GenreDao {
    Genre getGenre(String name);
    List<Genre> getGenres();
}
