package ru.itis.inform.dao;

import ru.itis.inform.models.FilmExistance;

/**
 * Created by Тимур on 08.11.2016.
 */
public interface FilmExistanceDao {
    //Добавление фильма в библиотеку(витрину) с суммой количеством и ценой
    void addExistance(int id, int quantity, int price);

    //Если фильм доступен в витрине (тру-фолс)
    boolean ifExist(int id);

    //Взять модель зависимости(фильм в библиотеке)
    FilmExistance getFilmExistance(int id);

    //Удалить зависимость
    void deleteExistance(int id);

    //Обновить колич зависимости
    boolean updateExistance(int id, int quantity);
}
