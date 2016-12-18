package ru.itis.inform.services;

import java.util.LinkedList;

/**
 * Created by Тимур on 19.10.2016.
 */
//Все это сервисы с управлениями ДАО

public interface RolesFilmService {
    boolean addRolesOnFilm(String roles, int filmId);
    LinkedList getRoleIdByFilmId(int id);
}
