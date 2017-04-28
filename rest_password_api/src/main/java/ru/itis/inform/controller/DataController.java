package ru.itis.inform.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.itis.inform.converter.DataConverter;
import ru.itis.inform.dao.UsersDao;
import ru.itis.inform.dto.DataDto;
import ru.itis.inform.dto.UserDto;
import ru.itis.inform.model.Data;
import ru.itis.inform.model.User;
import ru.itis.inform.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

import static ru.itis.inform.controller.UserController.getHeaders;

/**
 * Created by timur on 05.04.17.
 */
@RestController
@CrossOrigin(origins = "http://127.0.0.1:7072", maxAge = 3600)
public class DataController {

    @Autowired
    UsersDao usersDao;

    @Autowired
    UserService userService;

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
            User user = usersDao.get(userId);
            Data data = objectMapper.readValue(dataValue, Data.class);
            if (user != null) {
                UserDto userDto = userService.addDataForUser(user, data);
                DataDto dataDto = DataConverter.converter(user.getDataList().get(user.getDataList().size() - 1));
                String userData = objectMapper.writeValueAsString(dataDto);
                return new ResponseEntity<String>(userData, headers, HttpStatus.OK);
            } else {
                return new ResponseEntity<String>("{\"status\":\"Data not found\"", headers, HttpStatus.OK);
            }
        } catch (IOException e) {
            return new ResponseEntity<String>("{\"status\":\"Data not found\"", headers, HttpStatus.OK);
        }
    }

}
