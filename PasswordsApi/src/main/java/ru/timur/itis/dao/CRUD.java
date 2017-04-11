package ru.timur.itis.dao;

/**
 * Created by timur on 30.03.17.
 */
public interface CRUD<T> {
    T get(int id);
    int saveObject(T object);
    void delete(int id);
    T update(T object);
}
