package ru.itis.inform.servlets;

import ru.itis.inform.models.Film;
import ru.itis.inform.models.Genre;
import ru.itis.inform.models.Role;
import ru.itis.inform.services.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by Тимур on 23.10.2016.
 */
public class Video extends HttpServlet {
    VideoService videoService;
    ProducerService producerService;
    GenresFilmService genresFilmService;
    GenreService genreService;
    RolesFilmService rolesFilmService;
    RoleServices roleServices;
    Film film;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        if (videoService.getFilm(Integer.parseInt(id)) != null) {
            film = videoService.getFilm(Integer.parseInt(id));
            //producer
            req.setAttribute("producer",producerService.getProducer(film.getProducer()).getName());
            //genres
            LinkedList<Integer> genresId = (LinkedList<Integer>)genresFilmService.getGenreIdByFilmId(film.getId());
            LinkedList<Genre> genres = new LinkedList<Genre>();
            if (genresId!=null) {
                for (int genreId :
                        genresId) {
                    genres.addFirst(genreService.getGenreById(genreId));
                }
            }
            req.setAttribute("genres",genres);

            //roles
            LinkedList<Integer> rolesId = (LinkedList<Integer>)rolesFilmService.getRoleIdByFilmId(film.getId());
            LinkedList<Role> roles = new LinkedList<Role>();
            if (rolesId!=null) {
                for (int roleId :
                        rolesId) {
                    roles.addFirst(roleServices.getRoleById(roleId));
                }
            }
            req.setAttribute("roles",roles);

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
        producerService = new ProducerServiceImpl();
        genresFilmService = new GenresFilmServiceImpl();
        genreService = new GenreServiceImpl();
        roleServices = new RoleServicesImpl();
        rolesFilmService = new RolesFilmServiceImpl();
        film = null;
        super.init();
    }
}
