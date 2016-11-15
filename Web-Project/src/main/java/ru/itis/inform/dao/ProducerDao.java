package ru.itis.inform.dao;

import ru.itis.inform.models.Producer;

import java.util.LinkedList;

/**
 * Created by Тимур on 05.10.2016.
 */
public interface ProducerDao {
    boolean addProducer(Producer producer);
    Producer getProducer(int id);
    LinkedList<Producer> getProducers();
}
