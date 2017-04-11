package ru.itis.inform.REST;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.itis.inform.model.Book;
import ru.itis.inform.model.User;
import ru.itis.inform.service.UserService;

import java.io.IOException;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Map;

/**
 * Created by timur on 26.03.17.
 */
@Controller
public class RestController {
    @Autowired
    UserService userService;




    @RequestMapping(value = "/users/all", method = RequestMethod.GET)
    public String allUsers(Map<String, Object> map) {
        map.put("user", userService.getUsersDao().findAll());
           return "all";
    }

    @JsonIgnore
    @RequestMapping(value = "/users/{user-id}", method = RequestMethod.GET)
    @ResponseBody
    public String smthUser(@PathVariable("user-id") int userId, @RequestParam("action") String action){
        String postAsJSON = null;
        if (action.equals("books")) {
            List<Book> books = userService.getUsersDao().find((long) userId).getBooks();
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                postAsJSON = objectMapper.writeValueAsString(books);
            } catch (JsonProcessingException e) {
                throw new EmptyStackException();
            }
        }
        return "{\"books\": " + postAsJSON + "}";
    }

    @RequestMapping(value = "users/add", method = RequestMethod.POST)
    public void addPost(@RequestBody String userValue) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            User user = objectMapper.readValue(userValue, User.class);
            userService.save(user);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }

    }

}
