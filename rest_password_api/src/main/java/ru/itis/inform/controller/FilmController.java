package ru.itis.inform.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.inform.model.Film;
import ru.itis.inform.service.impl.FilmServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static ru.itis.inform.controller.UserController.getHeaders;

/**
 * Created by Timur Mardanov on 18.05.2017.
 * ITIS
 */
@RestController
@CrossOrigin(origins = "http://127.0.0.1:7072", maxAge = 3600)
public class FilmController {

    @Autowired
    FilmServiceImpl filmService;

    @RequestMapping(value = "/films", method = RequestMethod.GET)
    public ResponseEntity<List<Film>> getAllFilms() {
        HttpHeaders httpHeaders = getHeaders();
        ArrayList<Film> arrayList = (ArrayList<Film>) filmService.getFilms();
        ObjectMapper objectMapper = new ObjectMapper();
        String listAsJson = null;
        try {
            listAsJson = objectMapper.writeValueAsString(arrayList);
        } catch (JsonProcessingException e) {
            return new ResponseEntity<List<Film>>(null, httpHeaders, HttpStatus.OK);
        }
        return new ResponseEntity<List<Film>>(arrayList, httpHeaders, HttpStatus.OK);
    }


}
