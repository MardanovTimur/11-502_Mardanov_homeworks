package ru.itis.inform.services;

import ru.itis.inform.dao.GenreDao;
import ru.itis.inform.dao.GenreDaoImpl;
import ru.itis.inform.models.Genre;

import java.util.List;

/**
 * Created by Тимур on 16.10.2016.
 */
public class GenreServicesImpl implements GenreServices {
    private GenreDao genreDao;

    public GenreServicesImpl() {
        genreDao = new GenreDaoImpl();
    }

    public Genre getGenre(String name) {
       return genreDao.getGenre(name);
    }

    public List<Genre> getAllGenres(){
        return null;
    }
}
