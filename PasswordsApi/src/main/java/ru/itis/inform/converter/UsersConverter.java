package ru.itis.inform.converter;

import ru.itis.inform.dto.UserDto;
import ru.itis.inform.model.User;

/**
 * Created by alisa on 14.04.2017.
 */
public class UsersConverter {

    public static UserDto convertToUserDto(User user) {
        UserDto userDto = new UserDto(user.getId(), user.getName(), user.getUsername());
        return userDto;
    }


}
