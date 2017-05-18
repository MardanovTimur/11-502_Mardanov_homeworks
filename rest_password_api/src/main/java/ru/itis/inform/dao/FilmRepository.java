package ru.itis.inform.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.inform.model.Film;

import java.util.List;

/**
 * Created by Timur Mardanov on 18.05.2017.
 * ITIS
 */
@Repository
@Transactional
public interface FilmRepository extends CrudRepository<Film, Integer> {
    List<Film> findAll();

    void deleteByName(String name);

    Film getByName(String name);

    Film getById(Integer id);

}
