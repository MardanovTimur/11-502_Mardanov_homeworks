package ru.itis.inform.service;

import ru.itis.inform.dto.UserDto;
import ru.itis.inform.model.Data;
import ru.itis.inform.model.User;

import java.util.List;

/**
 * Created by timur on 30.03.17.
 */
public interface UserService {

    List<UserDto> findAll();

    UserDto get(int id);

    int saveObject(User object);

    void delete(int id);

    UserDto update(User object);

    UserDto addData(User user, Data data);

    UserDto findByUsername(String name);

    UserDto getUserByName(String username);

    UserDto addDataForUser(User user, Data data);
}
