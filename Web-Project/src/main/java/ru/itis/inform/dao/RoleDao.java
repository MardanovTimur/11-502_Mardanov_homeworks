package ru.itis.inform.dao;

import ru.itis.inform.models.Role;

import java.util.List;

/**
 * Created by Тимур on 05.10.2016.
 */
public interface RoleDao {
    // Добавить роль
    boolean addRole(Role role);
    //Получить модель роли
    Role getRole(String name);
    //Получить список всех ролей
    List<Role> getGenres();
    // Получить модель роли по айди
    Role getRoleById(int id);
    //Delete role
    void deleteRole(int id);
}
