package ru.itis.inform.services;

import ru.itis.inform.dao.GenreFilmDao;
import ru.itis.inform.dao.GenreFilmDaoImpl;
import ru.itis.inform.models.Genre;
import ru.itis.inform.models.GenreFilm;

import java.util.LinkedList;

/**
 * Created by Тимур on 26.10.2016.
 */
public class GenresFilmServiceImpl implements GenresFilmService {
    GenreFilmDao genreFilmDao = new GenreFilmDaoImpl();
    public boolean addGenresOnFilm(String roles, int filmId) {
        GenreService genreServices = new GenreServiceImpl();
        LinkedList<GenreFilm> genreFilms = new LinkedList<GenreFilm>();
        System.out.println("GenreFilmServiceImpl" + roles);
        String[] genreAllSplitted = roles.split(",");
        for (String genre : genreAllSplitted) {
            try {
                GenreFilm genreFilm = new GenreFilm(filmId, genreServices.getGenre(genre).getId());
                genreFilms.add(genreFilm);
            } catch (NullPointerException e) {
                return false;
            }
        }
        GenreFilmDao genreFilmDao = new GenreFilmDaoImpl();
        for (int i = 0; i < genreFilms.size(); i++) {
            boolean f = genreFilmDao.addGenresOnFilm(genreFilms.get(i).getGenreId(), genreFilms.get(i).getFilmId());
            if (!f) {
                return false;
            }
        }
        return true;
    }

    public LinkedList getGenreIdByFilmId(int filmId) {
        return genreFilmDao.getGenreIdByFilmId(filmId);
    }
}

