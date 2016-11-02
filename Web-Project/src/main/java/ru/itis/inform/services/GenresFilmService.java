package ru.itis.inform.services;

import java.util.LinkedList;

/**
 * Created by Тимур on 26.10.2016.
 */
public interface GenresFilmService {
    boolean addGenresOnFilm(String roles, int filmId);
    LinkedList getGenreIdByFilmId(int filmId);
}
