package ru.itis.inform.servlets;

import ru.itis.inform.models.Film;
import ru.itis.inform.models.Genre;
import ru.itis.inform.services.GenreServices;
import ru.itis.inform.services.GenreServicesImpl;
import ru.itis.inform.services.VideoService;
import ru.itis.inform.services.VideoServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Тимур on 16.10.2016.
 */
public class AddFilm extends HttpServlet {
    VideoService videoService = new VideoServiceImpl();
    Film film = null;
    GenreServices genreServices = null;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setAttribute("template","addfilm");
        //req.setAttribute("current_user",req.getSession().getAttribute("current_user"));
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        String name = req.getParameter("name");
        String producers = req.getParameter("producer");
        String studios = req.getParameter("studio");
        String genres = req.getParameter("genres");
        String roles = req.getParameter("roles");
        String description = req.getParameter("description");
        int remark = Integer.parseInt(req.getParameter("remark"));
        String date = req.getParameter("date");


        try {
            film = new Film(name,Integer.parseInt(producers),Integer.parseInt(studios),description,remark,date);
            videoService.addFilm(film);

            genreServices = new GenreServicesImpl();
            List<Integer> genresId = new LinkedList<Integer>();
            for (String genre : genres.split(",")) {
                genresId.add(genreServices.getGenre(genre).getId());
            }

            int filmId = videoService.getId(name);

            //add genres_films
            
        }


    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }
}
