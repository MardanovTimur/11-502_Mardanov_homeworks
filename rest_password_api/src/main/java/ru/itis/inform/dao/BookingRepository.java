package ru.itis.inform.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.inform.model.Booking;

/**
 * Created by Timur Mardanov on 18.05.2017.
 * ITIS
 */
@Repository
@Transactional
public interface BookingRepository extends CrudRepository<Booking, Integer> {

}
