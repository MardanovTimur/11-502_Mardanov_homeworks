package ru.itis.inform.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.inform.model.Seance;

import java.util.List;

/**
 * Created by Timur Mardanov on 18.05.2017.
 * ITIS
 */
@Repository
@Transactional
public interface SeanceRepository extends CrudRepository<Seance, Integer>{
    List<Seance> findAll();
}

