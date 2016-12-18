package ru.itis.inform.services;

import ru.itis.inform.models.Film;

import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Created by Тимур on 16.10.2016.
 */
//Все это сервисы с управлениями ДАО

public interface VideoService {
   String addFilm(Film film) throws SQLException;
    void deleteFilm(String id);
    int getId(String name);
    Film getFilm(int id);
    LinkedList<Film> getAllFilms();
    LinkedList<Film> getSearchFilms(String search);
}
