package ru.itis.inform.dao;

import ru.itis.inform.models.Comment;

import java.util.LinkedList;

/**
 * Created by Тимур on 02.11.2016.
 */
public interface CommentsDao {

    //Добавление комментария к фильму
    void addComment(Comment comment);

    //Удаление комментария со страницы(не нужно)
    void deleteComment(int filmId, String userId);

    //Результсет всех комментариев к странице
    LinkedList<Comment> getComments(int film_id);
}
