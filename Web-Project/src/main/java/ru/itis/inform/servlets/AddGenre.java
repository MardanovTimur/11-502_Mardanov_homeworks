package ru.itis.inform.servlets;

import ru.itis.inform.models.Genre;
import ru.itis.inform.services.GenreService;
import ru.itis.inform.services.GenreServiceImpl;

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
//Сервлет для добавления жанра
public class AddGenre extends HttpServlet {
    private Genre genre;
    private RequestDispatcher requestDispatcher;
    private GenreService genreService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setAttribute("template","addgenre");
        LinkedList<Genre> ll = genreService.getGenres();
        req.setAttribute("genres", ll);
        requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("template","addgenre");
        String name = req.getParameter("name");
        genre = new Genre(name);
        boolean f = genreService.addGenre(genre);
        if (f) {
            resp.sendRedirect("/addgenre");
        } else {
            req.setAttribute("no","Genre isn't added!");
            requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
            requestDispatcher.forward(req,resp);
        }
    }

    @Override
    public void init() throws ServletException {
       genreService = new GenreServiceImpl();
    }
}
