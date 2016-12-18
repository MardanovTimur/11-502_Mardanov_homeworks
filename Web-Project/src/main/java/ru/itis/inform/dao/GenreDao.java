package ru.itis.inform.dao;

import ru.itis.inform.models.Genre;

import java.util.LinkedList;

/**
 * Created by Тимур on 26.10.2016.
 */
public interface GenreDao {
    //Добавить жанр
    boolean addGenre(Genre genre);

    //Получить модель жанра
    Genre getGenre(String name);

    //Получить список моделей жанра
    LinkedList<Genre> getGenres();

    //Получить модель жанра по айди
    Genre getGenreById(int id);
}
