package ru.itis.inform.models;

import java.sql.Date;

/**
 * Created by Тимур on 02.11.2016.
 */
// Модель коммента
public class Comment {
    private int filmId;
    private String userId;
    private String message;
    private Date date;
    private String login;

    public Comment(int filmId, String userId, String message, String login) {
        this.login = login;
        this.message = message;
        this.userId = userId;
        this.filmId = filmId;
    }

    public String getLogin() {
        return login;
    }

    public Comment(int filmId, String userId, String message, String login, Date date) {
        this.login = login;

        this.filmId = filmId;
        this.userId = userId;
        this.message = message;
        this.date = date;
    }

    public int getFilmId() {
        return filmId;
    }

    public String getUserId() {
        return userId;
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(long timestamp) {
        this.date = new Date(timestamp);
    }

    @Override
    public String toString() {
        return message;
    }
}
