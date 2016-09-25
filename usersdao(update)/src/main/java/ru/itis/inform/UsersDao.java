package ru.itis.inform;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;


public interface UsersDao {
    List findAll() throws FileNotFoundException, SQLException;
    void save(User user) throws FileNotFoundException, SQLException;
    User find(String string, int definition) throws FileNotFoundException, SQLException;
    void closePW();
    void closeSC();
}
