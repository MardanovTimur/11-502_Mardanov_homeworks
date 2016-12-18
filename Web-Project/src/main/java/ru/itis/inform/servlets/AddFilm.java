package ru.itis.inform.servlets;

import ru.itis.inform.factories.DaoFactory;
import ru.itis.inform.models.Film;
import ru.itis.inform.models.Producer;
import ru.itis.inform.models.Studio;
import ru.itis.inform.services.*;
import ru.itis.inform.verifiers.Regulars;

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
import java.util.LinkedList;


/**
 * Created by Тимур on 16.10.2016.
 */
// Сервлет для добавления фильма
public class AddFilm extends HttpServlet {
    private VideoService videoService = new VideoServiceImpl();
    private GenreService genreService;
    private GenresFilmService genresFilmService;
    private Film film = null;
    private RoleServices roleServices = null;
    private ProducerService producerService;
    private StudioService studioService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setAttribute("template", "addfilm");
        //req.setAttribute("current_user",req.getSession().getAttribute("current_user"));
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
        requestDispatcher.forward(req, resp);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RolesFilmService rolesFilmService = new RolesFilmServiceImpl();

        String name = req.getParameter("name");
        String producer = req.getParameter("producer");
        String studio = req.getParameter("studio");
        String genres = req.getParameter("genres");
        String roles = req.getParameter("roles");
        String description = req.getParameter("description");
        String remark = req.getParameter("remark");
        String url = req.getParameter("url");
        String dateS = req.getParameter("date");
        String quantity = req.getParameter("quantity");
        String price = req.getParameter("price");


        //date parse
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long time = 0;

        //date exception
        try {
            Date date = dateFormat.parse(dateS);
            time = date.getTime();
        } catch (ParseException e) {
            req.setAttribute("template", "addfilm");
            req.setAttribute("genresError", "Write right date(Example: 01.01.1991)!");
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
            requestDispatcher.forward(req, resp);
            return;
        }

        String producerId = "";
        try {
            LinkedList<Producer> producerLinkedList = producerService.getAllProducers();
            for (Producer prod : producerLinkedList) {
                if (prod.getName().equals(producer)) {
                    producerId = "" + prod.getId();
                    break;
                }
            }
            if (producerId.equals("")) {
                req.setAttribute("template", "addfilm");
                req.setAttribute("genresError", "Producer is not found!");
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
                requestDispatcher.forward(req, resp);
                return;
            }
        } catch (Exception e) {
            req.setAttribute("template", "addfilm");
            req.setAttribute("genresError", "Producers is not available!");
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
            requestDispatcher.forward(req, resp);
            return;
        }

        String studioId = "";
        try {
            LinkedList<Studio> studioLinkedList = studioService.getAllStudio();
            for (Studio stud : studioLinkedList) {
                if (stud.getName().equals(studio)) {
                    studioId = "" + stud.getId();
                    break;
                }
            }
            if (studioId.equals("")) {
                req.setAttribute("template", "addfilm");
                req.setAttribute("genresError", "Studio is not found!");
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
                requestDispatcher.forward(req, resp);
                return;
            }
        } catch (Exception e) {
            req.setAttribute("template", "addfilm");
            req.setAttribute("genresError", "Studios is not available!");
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
            requestDispatcher.forward(req, resp);
            return;
        }

        //genre exception
        try {
            if (Regulars.isNumber(producerId) && Regulars.isNumber(studioId) && Regulars.isNumber(remark)) {
                film = new Film(name, Integer.parseInt(producerId), Integer.parseInt(studioId), description, Integer.parseInt(remark), url);
                film.setDate(time);
            } else {
                req.setAttribute("template", "addfilm");
                req.setAttribute("genresError", "Incorrect remark!");
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
                requestDispatcher.forward(req, resp);
                return;
            }
        } catch (Exception e) {
            req.setAttribute("template", "addfilm");
            req.setAttribute("genresError", "Incorrect form!");
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
            requestDispatcher.forward(req, resp);
            return;
        }
        String message;
        try {
            message = videoService.addFilm(film);
            int filmId = -1;
            if (message.equals("Запрос не вернул результатов.")) {
                filmId = videoService.getId(name);
            }

            if (filmId != -1) {
                boolean rolesOnFilm = rolesFilmService.addRolesOnFilm(roles, filmId);
                boolean genresOnFilm = genresFilmService.addGenresOnFilm(genres, filmId);
                if (!rolesOnFilm) {
                    videoService.deleteFilm("" + filmId);
                    req.setAttribute("template", "addfilm");
                    req.setAttribute("genresError", message + "<br>" + "Can't add video with this roles!");
                    RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
                    requestDispatcher.forward(req, resp);
                    return;
                } else if (!genresOnFilm) {
                    videoService.deleteFilm("" + filmId);
                    req.setAttribute("template", "addfilm");
                    req.setAttribute("genresError", message + "<br>" + "Can't add video with this genres!");
                    RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
                    requestDispatcher.forward(req, resp);
                    return;
                } else {
                    if (!quantity.equals("") && !price.equals("")) {
                        int quant, pric;
                        boolean f = false, f1 = false;
                        if (Regulars.isNumber(quantity)) {
                            quant = Integer.parseInt(quantity);
                            f = true;
                        } else {
                            videoService.deleteFilm("" + filmId);
                            req.setAttribute("template", "addfilm");
                            req.setAttribute("genresError", message + "<br>" + "Incorrect quantity!");
                            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
                            requestDispatcher.forward(req, resp);
                            return;
                        }
                        if (Regulars.isNumber(price)) {
                            pric = Integer.parseInt(price);
                            f1 = true;
                        } else {
                            videoService.deleteFilm("" + filmId);
                            req.setAttribute("template", "addfilm");
                            req.setAttribute("genresError", message + "<br>" + "Incorrect price(Set integer format)!");
                            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
                            requestDispatcher.forward(req, resp);
                            return;
                        }
                        if (f && f1) {
                            DaoFactory.getInstance().getFilmExistanceDao().addExistance(filmId, quant, pric);
                        }
                    }
                    req.setAttribute("template", "addfilm");
                    req.setAttribute("filmIsAdded", "This video is successfully added!");
                    RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
                    requestDispatcher.forward(req, resp);
                    return;
                }

            } else {
                req.setAttribute("template", "addfilm");
                req.setAttribute("genresError", message);
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
                requestDispatcher.forward(req, resp);
                return;
            }
        } catch (
                Exception s
                )

        {

            s.printStackTrace();
            req.setAttribute("template", "addfilm");
            req.setAttribute("genresError", "Can't to add video!");
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
            requestDispatcher.forward(req, resp);
            return;
        }

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    public void init() throws ServletException {
        genreService = new GenreServiceImpl();
        genresFilmService = new GenresFilmServiceImpl();
        producerService = new ProducerServiceImpl();
        studioService = new StudioServiceImpl();
    }
}
