package ru.itis.inform.service;

import ru.itis.inform.model.Booking;
import ru.itis.inform.model.Seance;

import java.awt.print.Book;
import java.util.List;

/**
 * Created by Timur Mardanov on 18.05.2017.
 * ITIS
 */
public interface BookingService {
    List<Booking> getBooking(int seanceId);

    List<Booking> findByUserId(int userId);

    List<Booking> findByUserIdAndSeanceId(int userId, int seanceId);
}
