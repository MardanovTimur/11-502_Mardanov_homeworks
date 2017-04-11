package ru.timur.itis.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.timur.itis.model.Data;
import ru.timur.itis.model.User;

import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * Created by timur on 30.03.17.
 */
public interface UsersDao extends CRUD<User>{

    User getUserByName(String name);

    User get(int id);

    int saveObject(User object);

    void delete(int id);

    User update(User object);

    User addData(User user, Data data);

    User findByUsername(String name);

    List<User> findAll();
}
