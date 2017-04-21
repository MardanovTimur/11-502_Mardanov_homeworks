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
import ru.timur.itis.dto.UserDto;
import ru.timur.itis.model.Data;
import ru.timur.itis.model.User;
import ru.timur.itis.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * Created by timur on 30.03.17.
 */
@Controller
@CrossOrigin(origins = "http://127.0.0.1:7072", maxAge = 3600)
public class UserController {
    @Autowired
    UsersDao usersDao;

    @Autowired
    UserService userService;

    @Autowired
    HttpServletRequest request;


    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<String> getAllUsers() {
        HttpHeaders httpHeaders = getHeaders();
        ArrayList<UserDto> arrayList = (ArrayList<UserDto>) userService.findAll();
        ObjectMapper objectMapper = new ObjectMapper();
        String listAsJson = null;
        try {
            listAsJson = objectMapper.writeValueAsString(arrayList);
        } catch (JsonProcessingException e) {
            return new ResponseEntity<String>("{\"error\":\"json\"}", httpHeaders, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<String>(listAsJson, httpHeaders, HttpStatus.FOUND);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<String> registration(@RequestBody String userValue) {
        HttpHeaders headers = getHeaders();
        ObjectMapper objectMapper = new ObjectMapper();
        String userAsJSON;
        try {
            User user = objectMapper.readValue(userValue, User.class);
            usersDao.saveObject(user);
            UserDto userDto = new UserDto(user.getId(), user.getName(), user.getUsername());
            userAsJSON = objectMapper.writeValueAsString(userDto);
        } catch (IOException e) {
            return new ResponseEntity<String>("{\"operation\":\"error\"}", headers, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<String>(userAsJSON, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    public ResponseEntity<String> update(@RequestBody String userValue) {
        HttpHeaders headers = getHeaders();
        ObjectMapper objectMapper = new ObjectMapper();
        String userAsJSON;
        try {
            User user = objectMapper.readValue(userValue, User.class);
            UserDto userDto = new UserDto(user.getId(), user.getName(), user.getUsername());
            userAsJSON = objectMapper.writeValueAsString(userDto);
        } catch (IOException e) {
            return new ResponseEntity<String>("{\"operation\":\"error\"}", headers, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<String>(userAsJSON, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/users/{user_id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable("user_id") int userId) {
        HttpHeaders headers = getHeaders();
        ObjectMapper objectMapper = new ObjectMapper();
        String userAsJSON;
        userService.delete(userId);
        return new ResponseEntity<String>("{\"status\":\""+userId+" deleted\"}", headers, HttpStatus.OK);
    }


    @RequestMapping(value = "/users/{username}", method = RequestMethod.GET)
    public ResponseEntity<String> getUserByName(@PathVariable("username") String username, @RequestParam("parameter") String parameter) {
        HttpHeaders httpHeaders = getHeaders();
        if (parameter.equals("username")) {
            String postAsJSON = null;
            UserDto user = userService.findByUsername(username);
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                httpHeaders.set("testHeader", "hello_header");
                postAsJSON = objectMapper.writeValueAsString(user);
            } catch (JsonProcessingException e) {
                throw new EmptyStackException();
            }
            return new ResponseEntity<String>(postAsJSON, httpHeaders, HttpStatus.FOUND);
        } else {
            if (parameter.equals("id")) {
                String postAsJSON = null;
                UserDto user = userService.get(Integer.parseInt(username));
                ObjectMapper objectMapper = new ObjectMapper();
                try {
                    httpHeaders.set("testHeader", "hello_header");
                    postAsJSON = objectMapper.writeValueAsString(user);
                } catch (JsonProcessingException e) {
                    throw new EmptyStackException();
                }
                return new ResponseEntity<String>(postAsJSON, httpHeaders, HttpStatus.FOUND);
            }
        }
        return new ResponseEntity<String>("{\"error\":\"not found\"+}", httpHeaders, HttpStatus.NO_CONTENT);
    }


    @RequestMapping(value = "/users/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestHeader("login") String login, @RequestHeader("password") String password,
                        HttpServletResponse response) {
        User user = usersDao.findByUsername(login);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                request.getSession().setAttribute("user", user);
                response.setHeader("Token", String.valueOf(user.hashCode()));
                return "{\"login\":\"success\"}";
            } else {
                return "{\"login\":\"failed\"}";
            }
        } else {
            return "{\"login\":\"failed\"}";
        }
    }

    public static HttpHeaders getHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Access-Control-Allow-Headers", "x-requested-with, Content-Type, x-requested-with,accept,Origin,Access-Control-Request-Method,Access-Control-Request-Headers");
        httpHeaders.add("Access-Control-Allow-Origin", "*");
        httpHeaders.add("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
        httpHeaders.add("Access-Control-Max-Age", "3600");
        httpHeaders.add("Access-Control-Allow-Headers", "x-requested-with");
        httpHeaders.add("Content-Type", "application/json");
        return httpHeaders;
    }
}