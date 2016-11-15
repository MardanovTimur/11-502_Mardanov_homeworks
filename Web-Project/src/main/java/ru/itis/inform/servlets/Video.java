package ru.itis.inform.servlets;

import ru.itis.inform.factories.DaoFactory;
import ru.itis.inform.factories.ServiceFactory;
import ru.itis.inform.models.*;
import ru.itis.inform.services.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    HttpSession session;
    RequestDispatcher requestDispatcher;

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
            req.setAttribute("comments",DaoFactory.getInstance().getCommentsDao().getComments(Integer.parseInt(id)));
            requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
            requestDispatcher.forward(req,resp);
            return;
        } else {
            resp.sendError(404);
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = req.getParameter("textMessage");

        String filmId = req.getParameter("id");

        session = req.getSession();

        if (session.getAttribute("current_user")==null) {
            req.setAttribute("guest","Please SignIn before leave a comment!");
            resp.sendRedirect("/login");
        } else {
            String userId = "" + ((User) session.getAttribute("current_user")).getId();
            String login = ""+((User)session.getAttribute("current_user")).getLogin();

            //Date
            try {
                Comment comment = new Comment(Integer.parseInt(filmId), userId, message,login);
                long time = System.currentTimeMillis();
                comment.setDate(time);

                DaoFactory.getInstance().getCommentsDao().addComment(comment);

                req.setAttribute("film", film);
                req.setAttribute("template", "film");
                resp.sendRedirect("/film?id=" + filmId);
                return;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
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
