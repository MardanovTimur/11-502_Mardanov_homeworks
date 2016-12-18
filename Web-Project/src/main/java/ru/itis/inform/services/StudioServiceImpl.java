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

    @Override
    public Studio getStudioByFilmId(int id) {
        return studioDao.getStudioByFilmId(id);
    }

    public boolean addStudio(Studio studio) {
       return studioDao.addStudio(studio);
    }

    public Studio getStudio(String name) {
       return studioDao.getStudio(name);
    }

    public LinkedList<Studio> getAllStudio() {
        return studioDao.getStudios();
    }
}
