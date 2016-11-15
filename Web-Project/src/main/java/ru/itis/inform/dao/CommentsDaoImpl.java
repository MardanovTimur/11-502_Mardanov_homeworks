package ru.itis.inform.dao;

import ru.itis.inform.models.Comment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Created by Тимур on 02.11.2016.
 */
public class CommentsDaoImpl implements CommentsDao {
    public void addComment(Comment comment) {
        if (JDBConnection.getInstance().getConnection()!=null && comment!=null) {
            String request = "INSERT INTO comments (film_id, user_id, comment, comment_data, user_login) VALUES (?,?,?,?,?)";
            try {
                JDBConnection.statement = JDBConnection.getInstance().getConnection().prepareStatement(request);
                JDBConnection.statement.setInt(1,comment.getFilmId());
                JDBConnection.statement.setString(2,comment.getUserId());
                JDBConnection.statement.setString(3,comment.getMessage());
                JDBConnection.statement.setDate(4,comment.getDate());
                JDBConnection.statement.setString(5, comment.getLogin());
                JDBConnection.getInstance().getStatement().executeUpdate();
            } catch (SQLException s) {
                s.printStackTrace();
            }
        }
    }

    public void deleteComment(int filmId, String userId) {

    }

    public LinkedList<Comment> getComments(int film_id) {
        if (JDBConnection.getInstance().getConnection()!=null && film_id!=0) {
            String request = "SELECT * FROM comments WHERE film_id = ?";
            try{
                JDBConnection.statement = JDBConnection.getInstance().getConnection().prepareStatement(request);
                JDBConnection.statement.setInt(1,film_id);
                ResultSet resultSet = JDBConnection.getInstance().getStatement().executeQuery();
                LinkedList<Comment> comments = new LinkedList<Comment>();
                while (resultSet.next()) {
                    comments.addFirst(new Comment(resultSet.getInt("film_id"),resultSet.getString("user_id"),resultSet.getString("comment"),resultSet.getString("user_login"),resultSet.getDate("comment_data")));
                }
                return comments;
            } catch (SQLException s) {
                s.printStackTrace();
            } catch (NullPointerException b){
                throw b;
            }
        }
        return null;
    }
}
