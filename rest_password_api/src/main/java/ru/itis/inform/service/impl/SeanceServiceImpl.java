package ru.itis.inform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.inform.dao.SeanceRepository;
import ru.itis.inform.model.Seance;
import ru.itis.inform.service.SeanceService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Timur Mardanov on 18.05.2017.
 * ITIS
 */
@Service
@Transactional
public class SeanceServiceImpl implements SeanceService {

    @Autowired
    private SeanceRepository seanceRepository;


    @Override
    public List<Seance> findAll() {
        List<Seance> arrayList = seanceRepository.findAll();
        for (Seance seance : arrayList) {
           // seance.getFilm().setSeanceList(null);
        }
        return arrayList;
    }
}
