package ru.itis.inform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.inform.dao.BookingRepository;
import ru.itis.inform.dao.UsersDao;
import ru.itis.inform.model.Booking;
import ru.itis.inform.model.Seance;
import ru.itis.inform.model.User;
import ru.itis.inform.service.BookingService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Created by Timur Mardanov on 18.05.2017.
 * ITIS
 */
@RestController
public class BookingController {

    @Autowired
    public BookingService bokingService;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    private UsersDao usersDao;

    @RequestMapping(value = "/booking/{seance_id}", method = RequestMethod.GET)
    public ResponseEntity<List<Booking>> getBooking(@PathVariable("seance_id") int seanceId, @RequestParam(name = "for") String param) {
        if (param.equals("yourself")) {
            return new ResponseEntity<List<Booking>>(bokingService.getBooking(seanceId), UserController.getHeaders(), HttpStatus.OK);
        } else
            return new ResponseEntity<List<Booking>>(bokingService.getBooking(seanceId), UserController.getHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/booking/{seance_id}", method = RequestMethod.POST)
    public ResponseEntity<String> addBooking(@PathVariable("seance_id") int seanceId, @RequestBody List<Booking> list) {
        Iterator<Booking> iterator = list.iterator();
        String filmKeys = "";
        while (iterator.hasNext()) {
            Booking booking = iterator.next();
            booking.setKey(booking.hashCode());
            User user = usersDao.findByToken(booking.getUser().getToken());
            booking.setUser(user);
            bookingRepository.save(booking);
            filmKeys = filmKeys.concat(booking.getKey()+ " ");
        }
        return new ResponseEntity<String>(filmKeys,null, HttpStatus.OK);
    }

}
