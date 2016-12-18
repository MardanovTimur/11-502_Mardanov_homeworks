package ru.itis.inform.services;

import ru.itis.inform.dao.VideoStoreDao;
import ru.itis.inform.dao.VideoStoreDaoImpl;
import ru.itis.inform.models.Film;

import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Created by Тимур on 16.10.2016.
 */
public class VideoServiceImpl implements VideoService {
    VideoStoreDao videoStore;

    public VideoServiceImpl() {
        this.videoStore = new VideoStoreDaoImpl();
    }

    public String addFilm(Film film) throws SQLException {
        return videoStore.add(film);
    }

    public void deleteFilm(String id) {
        videoStore.delete(id);
    }

    public int getId(String name) {
        return videoStore.getId(name);
    }

    public LinkedList<Film> getAllFilms() {
        //// STOPSHIP: 21.10.2016 dodelat srochno
        if (videoStore.getAllFilms()!=null)
            return videoStore.getAllFilms();
        else
            return null;
    }

    @Override
    public LinkedList<Film> getSearchFilms(String s) {
        return videoStore.getSearhFilms(s);
    }

    public Film getFilm(int id) {
        return videoStore.getFilm(id);
    }
}
