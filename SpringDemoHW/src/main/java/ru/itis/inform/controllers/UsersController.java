package ru.itis.inform.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import ru.itis.inform.model.User;
import ru.itis.inform.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Created by timur on 13.03.17.
 */
public class UsersController implements Controller {

    @Autowired
    UserService userService;

    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        Iterator iterator = userService.getUsersDao().findAll().iterator();
        Map<String,User> userHashMap = new HashMap<String, User>();
        while (iterator.hasNext()) {
            userHashMap.put("user", (User) iterator.next());
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("All");
        modelAndView.addObject("user",  userHashMap);
        return modelAndView;
    }
}
