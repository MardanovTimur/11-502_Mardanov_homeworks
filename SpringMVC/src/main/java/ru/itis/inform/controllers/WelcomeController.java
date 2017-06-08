package ru.itis.inform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Timur Mardanov on 07.06.2017.
 * ITIS
 */
@Controller
@RequestMapping(value = "/welcome")
public class WelcomeController {

    @RequestMapping(name = "",method = RequestMethod.GET)
    public ModelAndView printWelcome(ModelMap model) {
        ModelAndView modelAndView = new ModelAndView("welcome");
        model.addAttribute("message", "Spring 3 MVC - Hello World");
        List<String> list = new ArrayList<String>();
        list.add("sadasd");
        list.add("sdadasd");
        model.addAttribute("list", list);
        modelAndView.addAllObjects(model);
        return modelAndView;

    }
}
