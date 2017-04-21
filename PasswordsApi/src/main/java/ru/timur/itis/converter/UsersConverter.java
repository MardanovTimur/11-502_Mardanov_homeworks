package ru.timur.itis.converter;

import ru.timur.itis.dto.UserDto;
import ru.timur.itis.model.User;

/**
 * Created by alisa on 14.04.2017.
 */
public class UsersConverter {

    public static UserDto convertToUserDto(User user) {
        UserDto userDto = new UserDto(user.getId(), user.getName(), user.getUsername());
        return userDto;
    }


}
