package ru.itis.inform.servlets;

import ru.itis.inform.models.Film;
import ru.itis.inform.services.VideoService;
import ru.itis.inform.services.VideoServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Тимур on 23.10.2016.
 */
public class Video extends HttpServlet {
    VideoService videoService;
    Film film;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (videoService.getFilm(Integer.parseInt(id)) != null) {
            film = videoService.getFilm(Integer.parseInt(id));
            req.setAttribute("film",film);
            req.setAttribute("template","film");
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
            requestDispatcher.forward(req,resp);
            return;
        } else {
            resp.sendError(404);
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    public void init() throws ServletException {
        videoService = new VideoServiceImpl();
        film = null;
        super.init();
    }
}
