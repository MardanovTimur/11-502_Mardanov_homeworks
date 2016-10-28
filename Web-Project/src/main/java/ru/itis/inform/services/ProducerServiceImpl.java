package ru.itis.inform.services;

import ru.itis.inform.dao.ProducerDao;
import ru.itis.inform.dao.ProducerDaoImpl;
import ru.itis.inform.models.Producer;

import java.util.LinkedList;

/**
 * Created by Тимур on 27.10.2016.
 */
public class ProducerServiceImpl implements ProducerService {
    private ProducerDao producerDao;

    public ProducerServiceImpl() {
        this.producerDao = new ProducerDaoImpl();
    }

    public boolean addProducer(Producer producer) {
        return false;
    }

    public Producer getProducer(String name) {
        return null;
    }

    public LinkedList<Producer> getAllProducers() {
        return producerDao.getProducers();
    }
}
