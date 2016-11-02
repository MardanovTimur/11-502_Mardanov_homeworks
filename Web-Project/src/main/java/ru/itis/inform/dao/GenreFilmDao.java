package ru.itis.inform.dao;

import ru.itis.inform.models.Genre;

import java.util.LinkedList;

/**
 * Created by Тимур on 27.10.2016.
 */
public interface GenreFilmDao {
    LinkedList getGenreIdByFilmId(int filmId);
    boolean addGenresOnFilm(int genreId, int filmId);
}
