package ru.itis.inform.services;

import ru.itis.inform.dao.VideoStoreDao;
import ru.itis.inform.dao.VideoStoreDaoImpl;
import ru.itis.inform.models.Film;
import ru.itis.inform.models.VideoStore;

/**
 * Created by Тимур on 16.10.2016.
 */
public class VideoServiceImpl implements VideoService {
    VideoStoreDao videoStore;

    public VideoServiceImpl() {
        this.videoStore = new VideoStoreDaoImpl();
    }

    public void addFilm(Film film) {
        videoStore.add(film);
    }

    public void deleteFilm(String id) {
        videoStore.delete(id);
    }

    public int getId(String name) {
        return videoStore.getId(name);
    }
}
