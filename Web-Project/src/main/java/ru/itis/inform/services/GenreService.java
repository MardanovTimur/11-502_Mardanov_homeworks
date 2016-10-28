package ru.itis.inform.services;

import ru.itis.inform.models.Genre;

import java.util.LinkedList;

/**
 * Created by Тимур on 26.10.2016.
 */
public interface GenreService {
    boolean addGenre(Genre genre);
    Genre getGenre(String name);
    LinkedList<Genre> getGenres();
}
