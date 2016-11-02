package ru.itis.inform.services;

import ru.itis.inform.dao.GenreDao;
import ru.itis.inform.dao.GenreDaoImpl;
import ru.itis.inform.models.Genre;

import java.util.LinkedList;

/**
 * Created by Тимур on 26.10.2016.
 */
public class GenreServiceImpl implements GenreService {
    private GenreDao genreDao;
    public GenreServiceImpl() {
        genreDao = new GenreDaoImpl();
    }

    public boolean addGenre(Genre genre) {
        return genreDao.addGenre(genre);
    }

    public Genre getGenre(String name) {
        return genreDao.getGenre(name);
    }

    public LinkedList<Genre> getGenres() {
        return genreDao.getGenres();
    }

    public Genre getGenreById(int id) {
       return genreDao.getGenreById(id);
    }
}
