package ru.itis.inform.services;

import ru.itis.inform.models.Film;

/**
 * Created by Тимур on 16.10.2016.
 */
public interface VideoService {
    void addFilm(Film film);
    void deleteFilm(String id);
    int getId(String name);
}
