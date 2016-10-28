package ru.itis.inform.services;

import ru.itis.inform.dao.StudioDao;
import ru.itis.inform.dao.StudioDaoImpl;
import ru.itis.inform.models.Studio;

import java.util.LinkedList;

/**
 * Created by Тимур on 27.10.2016.
 */
public class StudioServiceImpl implements StudioService {
    private StudioDao studioDao;

    public StudioServiceImpl() {
        this.studioDao = new StudioDaoImpl();
    }

    public boolean addStudio(Studio studio) {
        return false;
    }

    public Studio getStudio(String name) {
        return null;
    }

    public LinkedList<Studio> getAllStudio() {
        return studioDao.getStudios();
    }
}
