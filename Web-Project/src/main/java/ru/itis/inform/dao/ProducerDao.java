package ru.itis.inform.dao;

import ru.itis.inform.models.Producer;

import java.util.LinkedList;

/**
 * Created by Тимур on 05.10.2016.
 */
public interface ProducerDao {

    //Добавление продюсера
    boolean addProducer(Producer producer);

    //Получение модели продюсера
    Producer getProducer(int id);

    //Получить список всех продюсерров
    LinkedList<Producer> getProducers();

    //Delete producer
    void deleteProducer(int id);
}
