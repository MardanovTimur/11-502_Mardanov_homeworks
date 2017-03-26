package ru.itis.inform.realController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itis.inform.model.User;
import ru.itis.inform.service.UserService;

import java.util.Map;

/**
 * Created by timur on 20.03.17.
 */
@Controller
public class SimpleController {

    @Autowired
    @Qualifier("userService")
    UserService userService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getAllUsers(Map<String, Object> map) {
        map.put("user", userService.getUsersDao().findAll());
        return "all";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addUser(Map<String, Object> map) {
        map.put("user", new User());
        return "addUserController";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUserPost(@ModelAttribute("user") User user, BindingResult bindingResult) {

        userService.getUsersDao().save(user);

        return "redirect:/all";
    }


    @RequestMapping("/")
    public String home() {
        return "redirect:/all";
    }

}
