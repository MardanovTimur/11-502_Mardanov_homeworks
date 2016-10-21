package ru.itis.inform.models;

/**
 * Created by Тимур on 19.10.2016.
 */
public class RoleFilm {
    private int filmId;
    private int roleId;

    public RoleFilm(int filmId, int roleId) {
        this.filmId = filmId;
        this.roleId = roleId;
    }

    public int getFilmId() {
        return filmId;
    }

    public int getRoleId() {
        return roleId;
    }
}
