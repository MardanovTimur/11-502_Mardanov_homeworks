package ru.itis.inform.servlets;

import org.apache.commons.codec.binary.StringUtils;
import ru.itis.inform.dao.*;
import ru.itis.inform.dao.Remarks;
import ru.itis.inform.factories.DaoFactory;
import ru.itis.inform.factories.ServiceFactory;
import ru.itis.inform.models.*;
import ru.itis.inform.services.*;
import ru.itis.inform.verifiers.IsNumber;

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
//Сервлет для фильма определенного с комментами и оценкой
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
        session = req.getSession();
        User user = (User) session.getAttribute("current_user");
        if (user!=null) {
            req.setAttribute("us_id", user.getId());
        }
        if (user != null && user.getIs_admin()) {
            req.setAttribute("deleteKey", true);
        }

        if (videoService.getFilm(Integer.parseInt(id)) != null) {
            film = videoService.getFilm(Integer.parseInt(id));
            //producer
            req.setAttribute("producer", producerService.getProducer(film.getProducer()).getName());
            //genres
            LinkedList<Integer> genresId = (LinkedList<Integer>) genresFilmService.getGenreIdByFilmId(film.getId());
            LinkedList<Genre> genres = new LinkedList<Genre>();
            if (genresId != null) {
                for (int genreId :
                        genresId) {
                    genres.addFirst(genreService.getGenreById(genreId));
                }
            }
            req.setAttribute("genres", genres);

            //roles
            LinkedList<Integer> rolesId = (LinkedList<Integer>) rolesFilmService.getRoleIdByFilmId(film.getId());
            LinkedList<Role> roles = new LinkedList<Role>();
            if (rolesId != null) {
                for (int roleId :
                        rolesId) {
                    roles.addFirst(roleServices.getRoleById(roleId));
                }
            }
            req.setAttribute("roles", roles);

            req.setAttribute("film", film);
            String filmText = film.getDescription();
            String htmlFilmText = "";
            while (filmText.length() % 70 != 0) {
                filmText += " ";
            }
            int filmTextSize = filmText.length();
            for (int i = 0; i < filmTextSize / 70; i++) {
                try {
                    htmlFilmText += filmText.substring(0, 70);
                    if (htmlFilmText.charAt(htmlFilmText.length() - 1) != ' ') {
                        htmlFilmText += "-";
                    }
                    htmlFilmText += "<br>";
                    filmText = filmText.substring(70);
                } catch (Exception e) {
                }
            }
            FilmExistance filmExistance = DaoFactory.getInstance().getFilmExistanceDao().getFilmExistance(Integer.parseInt(id));
            if (filmExistance != null) {
                req.setAttribute("orders", filmExistance.getQuantity());
                req.setAttribute("cost", filmExistance.getMoney());
            }
            req.setAttribute("text_film", htmlFilmText);
            req.setAttribute("template", "film");
            req.setAttribute("comments", DaoFactory.getInstance().getCommentsDao().getComments(Integer.parseInt(id)));
            requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
            requestDispatcher.forward(req, resp);
            return;
        } else {
            resp.sendError(404);
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("template", "film");
        String remark = req.getParameter("remark");
        boolean f = true;
        if (remark != null) {
            if (!IsNumber.isNumber(remark)) {
                f = false;
            }
            if (!f) {
                req.setAttribute("err_rem", "Please write a correct remark (0-10)");
                resp.sendRedirect("/film?id=" + req.getParameter("id"));
            } else {
                String film_id = req.getParameter("id");
                session = req.getSession();
                User user = (User) session.getAttribute("current_user");
                if (user!=null) {
                    Remarks remarks = new Remarks();
                    remarks.update(Integer.parseInt(film_id), user.getId(), Integer.parseInt(remark));
                    req.setAttribute("err_rem", "Well done!");
                    resp.sendRedirect("/film?id=" + film_id);
                } else {
                    resp.sendRedirect("/login");
                }

            }
        } else

        {

            String message = req.getParameter("textMessage");

            String filmId = req.getParameter("id");

            session = req.getSession();

            if (session.getAttribute("current_user") == null) {
                req.setAttribute("guest", "Please SignIn before leave a comment!");
                resp.sendRedirect("/login");
            } else {
                String userId = "" + ((User) session.getAttribute("current_user")).getId();
                String login = "" + ((User) session.getAttribute("current_user")).getLogin();

                //Date
                try {
                    Comment comment = new Comment(Integer.parseInt(filmId), userId, message, login);
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
