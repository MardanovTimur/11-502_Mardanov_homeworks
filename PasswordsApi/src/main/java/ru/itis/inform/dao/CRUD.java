package ru.itis.inform.dao;

public interface CRUD<T> {
    T get(int id);
    int saveObject(T object);
    void delete(int id);
    T update(T object);
}
