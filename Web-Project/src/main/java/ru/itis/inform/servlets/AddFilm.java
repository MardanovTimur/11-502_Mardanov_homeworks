package ru.itis.inform.servlets;

import ru.itis.inform.models.Film;
import ru.itis.inform.services.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by Тимур on 16.10.2016.
 */
public class AddFilm extends HttpServlet {
    VideoService videoService = new VideoServiceImpl();
    Film film = null;
    RoleServices roleServices = null;
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
        RolesFilmService rolesFilmService = new RolesFilmServiceImpl();

        String name = req.getParameter("name");
        String producers = req.getParameter("producer");
        String studios = req.getParameter("studio");
        String genres = req.getParameter("genres");
        String roles = req.getParameter("roles");
        String description = req.getParameter("description");
        int remark = Integer.parseInt(req.getParameter("remark"));
        String dateS = req.getParameter("date");
        System.out.println(dateS);
        //date parse
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long time = 0;
        try {
            Date date = dateFormat.parse(dateS);
            time = date.getTime();
        } catch (ParseException e) {
            req.setAttribute("template","addfilm");
            req.setAttribute("genresError", "Write right date(Example: 01.01.1991)!");
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
            requestDispatcher.forward(req,resp);
            return;
        }
        try {
            film = new Film(name,Integer.parseInt(producers),Integer.parseInt(studios),description,remark);
            film.setDate(time);
        } catch (Exception e) {
            req.setAttribute("template","addfilm");
            req.setAttribute("genresError", "Incorrect form!");
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
            requestDispatcher.forward(req,resp);
            return;
        }
        try {
            videoService.addFilm(film);
            int filmId = videoService.getId(name);
            boolean f = rolesFilmService.addRolesOnFilm(roles,filmId);
            if (!f) {
                videoService.deleteFilm(""+filmId);
                req.setAttribute("template","addfilm");
                req.setAttribute("genresError", "Can't add film with this roles!");
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
                requestDispatcher.forward(req,resp);
                return;
            } else {
                req.setAttribute("template","addfilm");
                req.setAttribute("filmIsAdded","This film is successfully added!");
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
                requestDispatcher.forward(req,resp);
                return;
            }
        } catch (Exception s) {
            s.printStackTrace();
            req.setAttribute("template","addfilm");
            req.setAttribute("genresError", "Can't to add film!");
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
            requestDispatcher.forward(req,resp);
            return;
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }
}
