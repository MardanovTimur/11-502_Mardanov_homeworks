package ru.itis.inform.service;

import ru.itis.inform.model.Seance;

import java.util.List;

/**
 * Created by Timur Mardanov on 18.05.2017.
 * ITIS
 */
public interface SeanceService {
   List<Seance> findAll();
}
