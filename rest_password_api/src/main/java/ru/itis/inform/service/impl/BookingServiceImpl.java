package ru.itis.inform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.inform.dao.BookingRepository;
import ru.itis.inform.service.BookingService;

/**
 * Created by Timur Mardanov on 18.05.2017.
 * ITIS
 */
@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;


}
