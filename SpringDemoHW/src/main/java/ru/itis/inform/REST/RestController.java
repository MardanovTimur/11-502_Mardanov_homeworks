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
    public String allUsers(Map<String, Object> map){
        map.put("user",userService.getUsersDao().findAll());
        return "all";
    }

    @JsonIgnore
    @RequestMapping(value ="/users/{user-id}", method = RequestMethod.GET)
    public String smthUser(@PathVariable("user-id") int userId, @RequestParam("action") String action, Map<String, Object> map) {
        if (action.equals("books")) {
            List<Book> books = userService.getUsersDao().find((long) userId).getBooks();
            map.put("user", userService.getUsersDao().find((long) userId));
            map.put("books", books);
            ObjectMapper objectMapper = new ObjectMapper();
            String postAsJSON = null;
            try {
                postAsJSON = objectMapper.writeValueAsString(books);
                System.out.println(postAsJSON);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return "userBooks";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public void addPost(@RequestBody String userValue) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            User user = objectMapper.readValue(userValue, User.class);
            System.out.println(user.getName());
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }

    }

}
