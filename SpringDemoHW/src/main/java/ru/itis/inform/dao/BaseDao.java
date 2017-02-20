package ru.itis.inform.dao;

import java.util.List;

/**
 * Created by Тимур on 15.02.2017.
 */
public interface BaseDao<Model> {

    Long save(Model model);

    void update(Model model);

    Model find(Long id);

    void delete(Long id);

    List<Model> findAll();
}
