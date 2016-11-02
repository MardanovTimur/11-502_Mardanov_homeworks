package ru.itis.inform.services;

import ru.itis.inform.models.Genre;
import ru.itis.inform.models.Role;

import java.util.List;

/**
 * Created by Тимур on 16.10.2016.
 */
public interface RoleServices {
    boolean addRole(Role role);
    Role getRole(String name);
    List<Role> getAllRoles();

    Role getRoleById(int roleId);
}
