package ru.itis.inform;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Created by Тимур on 06.09.2016.
 */
public interface UsersDao  {
    List<User> findAll() throws FileNotFoundException;
    void save(User user) throws FileNotFoundException;
    User find(String string, int definition) throws FileNotFoundException;
    void closePW();
    void closeSC();
}
