package ru.itis.inform.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.inform.model.Booking;
import ru.itis.inform.model.Seance;

import java.util.List;

/**
 * Created by Timur Mardanov on 18.05.2017.
 * ITIS
 */
@Repository
@Transactional
public interface BookingRepository extends CrudRepository<Booking, Integer> {

    List<Booking> findBySeanceId(int id);

    List<Booking> findByUserId(int id);

    List<Booking> findByUserIdAndSeanceId(int userId, int seanceId);
}
