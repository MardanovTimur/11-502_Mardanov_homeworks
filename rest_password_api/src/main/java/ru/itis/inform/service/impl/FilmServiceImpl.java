package ru.itis.inform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.itis.inform.dao.FilmRepository;
import ru.itis.inform.model.Film;
import ru.itis.inform.service.FilmService;

import java.util.List;

/**
 * Created by Timur Mardanov on 18.05.2017.
 * ITIS
 */
@Component
public class FilmServiceImpl implements FilmService {

    @Autowired
    FilmRepository filmRepository;

    public List<Film> getFilms() {
        return filmRepository.findAll();
    }

}
