package ru.timur.itis.service;

import ru.timur.itis.dto.UserDto;
import ru.timur.itis.model.Data;
import ru.timur.itis.model.User;

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
