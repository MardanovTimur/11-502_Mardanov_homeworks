package ru.timur.itis.dao;

import ru.timur.itis.model.Data;

public interface DataDao extends CRUD<Data>{

    Data get(int id);

    int saveObject(Data object);

    void delete(int id);

    Data update(Data object);
}
