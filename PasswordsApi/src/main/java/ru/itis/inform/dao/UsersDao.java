package ru.itis.inform.dao;

import ru.itis.inform.dto.UserDto;
import ru.itis.inform.model.Data;
import ru.itis.inform.model.User;

import java.util.List;

public interface UsersDao extends CRUD<User>{

    User getUserByName(String name);

    User get(int id);

    int saveObject(User object);

    void delete(int id);

    User update(User object);

    User addData(User user, Data data);

    User findByUsername(String name);

    List<UserDto> findAll();
}
