package ru.itis.inform.dao;

import ru.itis.inform.models.Comment;

import java.util.LinkedList;

/**
 * Created by Тимур on 02.11.2016.
 */
public interface CommentsDao {
    void addComment(Comment comment);
    void deleteComment(int filmId, String userId);
    LinkedList<Comment> getComments(int film_id);
}
