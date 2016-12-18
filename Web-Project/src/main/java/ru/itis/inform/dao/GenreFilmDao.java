package ru.itis.inform.dao;

import ru.itis.inform.models.Genre;

import java.util.LinkedList;

/**
 * Created by Тимур on 27.10.2016.
 */
public interface GenreFilmDao {
    //Получить список моделей жанр-фильм по айди фильма.
    LinkedList getGenreIdByFilmId(int filmId);

    //Добавить фильм-жанр зависимость много к многому.
    boolean addGenresOnFilm(int genreId, int filmId);
}
