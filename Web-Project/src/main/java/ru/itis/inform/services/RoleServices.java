package ru.itis.inform.services;

import ru.itis.inform.models.Role;

import java.util.List;

/**
 * Created by Тимур on 16.10.2016.
 */
public interface RoleServices {
    Role getRole(String name);
    List<Role> getAllRoles();
}
