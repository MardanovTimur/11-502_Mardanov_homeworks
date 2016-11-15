package ru.itis.inform.dao;

import ru.itis.inform.models.FilmExistance;

/**
 * Created by Тимур on 08.11.2016.
 */
public interface FilmExistanceDao {
    void addExistance(int id, int quantity, double price);
    boolean ifExist(int id);
    FilmExistance getFilmExistance(int id);
    void deleteExistance(int id);
    boolean updateExistance(int id, int quantity, int price);
}
