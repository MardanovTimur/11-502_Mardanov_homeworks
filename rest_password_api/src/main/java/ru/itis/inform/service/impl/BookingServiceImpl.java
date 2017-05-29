package ru.itis.inform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.inform.dao.BookingRepository;
import ru.itis.inform.model.Booking;
import ru.itis.inform.model.Seance;
import ru.itis.inform.service.BookingService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Timur Mardanov on 18.05.2017.
 * ITIS
 */
@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;


    @Override
    public List<Booking> getBooking(int seanceId) {
        if (bookingRepository.findBySeanceId(seanceId)!=null) {
            List<Booking> bookings = bookingRepository.findBySeanceId(seanceId);
            for (Booking b : bookings) {
                b.setUser(null);
                b.setSeance(null);
            }
            return bookings;
        }
        return null;
    }

    @Override
    public List<Booking> findByUserId(int userId) {
        return bookingRepository.findByUserId(userId);
    }

    @Override
    public List<Booking> findByUserIdAndSeanceId(int userId, int seanceId) {
        return bookingRepository.findByUserIdAndSeanceId(userId, seanceId);
    }
}
