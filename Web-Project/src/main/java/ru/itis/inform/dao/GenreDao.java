package ru.itis.inform.dao;

import ru.itis.inform.models.Genre;

import java.util.LinkedList;

/**
 * Created by Тимур on 26.10.2016.
 */
public interface GenreDao {
    boolean addGenre(Genre genre);
    Genre getGenre(String name);
    LinkedList<Genre> getGenres();
    Genre getGenreById(int id);
}
