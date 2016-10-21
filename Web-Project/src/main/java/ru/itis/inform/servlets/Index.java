package ru.itis.inform.servlets;

import jdk.nashorn.internal.ir.RuntimeNode;
import ru.itis.inform.models.Film;
import ru.itis.inform.models.User;
import ru.itis.inform.services.VideoService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by Тимур on 09.10.2016.
 */
public class Index extends HttpServlet {
    RequestDispatcher requestDispatcher;
    HttpSession session;
    VideoService videoService;
    Cookie cookie;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        //Working on user admin - not admin
        /*session = req.getSession();
        req.setAttribute("current_user", session.getAttribute("current_user"));
        */
        req.setAttribute("template", "films");

        LinkedList<Film> films = new LinkedList<Film>();
        if (videoService.getAllFilms() != null)
            films = videoService.getAllFilms();
        else
            films = null;

        req.setAttribute("films", films);

        requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
