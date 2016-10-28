package ru.itis.inform.dao;

import ru.itis.inform.models.Role;

import java.util.List;

/**
 * Created by Тимур on 05.10.2016.
 */
public interface RoleDao {
    boolean addRole(Role role);
    Role getRole(String name);
    List<Role> getGenres();
}
