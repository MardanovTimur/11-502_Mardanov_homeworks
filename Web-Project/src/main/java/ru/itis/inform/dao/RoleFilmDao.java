package ru.itis.inform.dao;

import java.util.LinkedList;

/**
 * Created by Тимур on 19.10.2016.
 */
public interface RoleFilmDao {
    LinkedList getRoleIdByFilmId(int filmId);
    boolean addRolesOnFilm(int roleId, int filmId);
}
