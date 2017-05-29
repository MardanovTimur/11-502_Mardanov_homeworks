package ru.itis.inform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.inform.dao.UsersDao;
import ru.itis.inform.model.Booking;
import ru.itis.inform.model.Film;
import ru.itis.inform.model.Seance;
import ru.itis.inform.model.User;
import ru.itis.inform.service.BookingService;
import ru.itis.inform.service.SeanceService;
import ru.itis.inform.service.UserService;

import java.util.Iterator;
import java.util.List;

import static ru.itis.inform.controller.UserController.getHeaders;

/**
 * Created by Timur Mardanov on 18.05.2017.
 * ITIS
 */
@RestController
public class SeanceController {

    @Autowired
    private SeanceService seanceService;
    @Autowired
    private BookingService bookingService;

    @Autowired
    private UsersDao usersDao;

    @RequestMapping(value = "/seances", method = RequestMethod.GET)
    public ResponseEntity<List<Seance>> getSeances(){

        return new ResponseEntity<List<Seance>>(seanceService.findAll(), getHeaders(), HttpStatus.OK);
    }


    @RequestMapping(value = "/seances/my", method = RequestMethod.POST)
    public ResponseEntity<List<Booking>> getMySeances(@RequestBody String token) {
        User user = usersDao.findByToken(token);
        System.out.println(user.getToken());
        List<Booking> bookings = bookingService.findByUserId(user.getId());
        Iterator<Booking> book = bookings.iterator();
        while (book.hasNext()) {
            Booking booking = book.next();
            //booking.getSeance().getFilm().setSeanceList(null);
            booking.getUser().setBookingList(null);
            booking.getUser().setDataList(null);
        }
        return new ResponseEntity<List<Booking>>(bookings, getHeaders(), HttpStatus.OK);
    }
}
