package ru.itis.inform.dao;

import ru.itis.inform.model.Data;

public interface DataDao extends CRUD<Data>{

    Data get(int id);

    int saveObject(Data object);

    void delete(int id);

    Data update(Data object);
}
