package ru.itis.inform.dao;

import java.util.LinkedList;

/**
 * Created by Тимур on 19.10.2016.
 */
public interface RoleFilmDao {
    //Получить список моделей роль-фильм по фильму (связь много ко многому)
    LinkedList getRoleIdByFilmId(int filmId);

    // Добавить модель роль-фильм по айди роли и айди фильма
    boolean addRolesOnFilm(int roleId, int filmId);
}
