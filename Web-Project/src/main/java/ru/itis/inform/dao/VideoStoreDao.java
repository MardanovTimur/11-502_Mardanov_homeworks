package ru.itis.inform.dao;

import ru.itis.inform.models.Film;

import java.sql.Date;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Created by Тимур on 05.10.2016.
 */
public interface VideoStoreDao {
    //Добавление фильма через модель + используется триггерная функция
    String add(Film film) throws SQLException;
    //Получить айди по имени фильма
    int getId(String name);
    //Удалить фильм
    void delete(String id);
    //Получить список всех фильмов
    LinkedList<Film> getAllFilms();
    //Получить фильм по айди
    Film getFilm(int id);
    //Обновление фильма + 1 хранимка + триггерная функция
    String updateFilm(int nid, String nname , int  nstudio , Date nyear , int nproducer , String ndescription , int nremark , String nurl ,  String[] nroles, String[] ngenres , int nquantity , int nprice);
    //Search films
    LinkedList<Film> getSearhFilms(String s);
}
