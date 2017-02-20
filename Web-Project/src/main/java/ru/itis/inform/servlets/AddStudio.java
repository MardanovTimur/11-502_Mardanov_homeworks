package ru.itis.inform.servlets;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.inform.config.SpringConfig;
import ru.itis.inform.models.Genre;
import ru.itis.inform.models.Studio;
import ru.itis.inform.services.GenreServiceImpl;
import ru.itis.inform.services.StudioService;
import ru.itis.inform.services.StudioServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by Тимур on 10.12.2016.
 */
//Сервлет для добавления студии

public class AddStudio extends HttpServlet {
    private Studio studio;
    private RequestDispatcher requestDispatcher;
    private StudioService studioService;
    private ApplicationContext beanFactory;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setAttribute("template","addstudio");
        this.studioService = beanFactory.getBean(StudioService.class);
        LinkedList<Studio> ll = studioService.getAllStudio();
        req.setAttribute("genres", ll);
        requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("template","addstudio");
        String name = req.getParameter("name");
        studio = new Studio(name);
        this.studioService = beanFactory.getBean(StudioService.class);
        boolean f = studioService.addStudio(studio);
        if (f) {
            resp.sendRedirect("/addstudio");
        } else {
            req.setAttribute("no","Studio isn't added!");
            requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
            requestDispatcher.forward(req,resp);
        }
    }

    @Override
    public void init() throws ServletException {
        beanFactory = new AnnotationConfigApplicationContext(SpringConfig.class);
    }
}
