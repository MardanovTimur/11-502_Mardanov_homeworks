package ru.timur.itis.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.timur.itis.dao.UsersDao;
import ru.timur.itis.model.Data;
import ru.timur.itis.model.User;
import ru.timur.itis.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.EmptyStackException;
import java.util.List;

import static ru.timur.itis.controller.UserController.getHeaders;

/**
 * Created by timur on 05.04.17.
 */
@Controller
public class DataController {

    @Autowired
    UsersDao usersDao;

    @Autowired
    UserService userService;

    @Autowired
    HttpServletRequest request;

    @RequestMapping(value = "/users/{user-id}/data", method = RequestMethod.GET)
    public ResponseEntity<String> getUserData(@PathVariable("user-id") int userId) {
        String postAsJSON = null;
        HttpHeaders headers = getHeaders();
        List<Data> data = usersDao.get(userId).getDataList();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            postAsJSON = objectMapper.writeValueAsString(data);
            return new ResponseEntity<String>(postAsJSON, headers, HttpStatus.FOUND);
        } catch (JsonProcessingException e) {
            return new ResponseEntity<String>("\"status\":\"not found\"", headers, HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/users/{user-id}/data", method = RequestMethod.POST)
    public ResponseEntity<String> saveDataForUser(@PathVariable("user-id") int userId, @RequestBody String dataValue) {
        HttpHeaders headers = getHeaders();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            User user = userService.get(userId);
            Data data = objectMapper.readValue(dataValue, Data.class);
            if (user != null) {
                user = userService.addDataForUser(user, data);
                String userData = objectMapper.writeValueAsString(user.getDataList().get(user.getDataList().size() - 1));
                return new ResponseEntity<String>(userData, headers, HttpStatus.OK);
            } else {
                return new ResponseEntity<String>("{\"status\":\"User not found\"", headers, HttpStatus.OK);
            }
        } catch (IOException e) {
            return new ResponseEntity<String>("{\"status\":\"User not found\"", headers, HttpStatus.OK);
        }
    }

}
