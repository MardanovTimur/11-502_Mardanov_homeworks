package ru.itis.inform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.inform.dao.SeanceRepository;
import ru.itis.inform.service.SeanceService;

/**
 * Created by Timur Mardanov on 18.05.2017.
 * ITIS
 */
@Service
@Transactional
public class SeanceServiceImpl implements SeanceService {

    @Autowired
    private SeanceRepository seanceRepository;


}
