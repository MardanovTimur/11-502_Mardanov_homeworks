package ru.itis.inform.services;

import ru.itis.inform.models.Genre;

import java.util.List;

/**
 * Created by Тимур on 16.10.2016.
 */
public interface GenreServices {
    Genre getGenre(String name);
    List<Genre> getAllGenres();
}
