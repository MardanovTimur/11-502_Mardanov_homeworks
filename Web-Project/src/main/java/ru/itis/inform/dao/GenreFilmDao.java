package ru.itis.inform.dao;

/**
 * Created by Тимур on 27.10.2016.
 */
public interface GenreFilmDao {
    boolean addGenresOnFilm(int genreId, int filmId);
}
