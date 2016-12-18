package ru.itis.inform.servlets;

import ru.itis.inform.dao.VideoStoreDao;
import ru.itis.inform.dao.VideoStoreDaoImpl;
import ru.itis.inform.factories.DaoFactory;
import ru.itis.inform.models.*;
import ru.itis.inform.services.*;
import ru.itis.inform.verifiers.Regulars;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

/**
 * Created by Тимур on 17.12.2016.
 */
// Сервлет для удаления фильма
public class UpdateFilm extends HttpServlet {
    private int filmID = -1;
    private User user;
    private HttpSession session;
    private Film film;
    private VideoService videoService;
    private StudioService studioService;
    private RolesFilmService rolesFilmService;
    private RoleServices roleServices;
    private GenreService genreService;
    private GenresFilmService genresFilmService;
    private ProducerService producerService;

    private RequestDispatcher requestDispatcher;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String producer = request.getParameter("producer");
        String studio = request.getParameter("studio");
        String genres = request.getParameter("genres");
        String roles = request.getParameter("roles");
        String description = request.getParameter("description");
        String remark = request.getParameter("remark");
        String url = request.getParameter("url");
        String dateS = request.getParameter("date");
        String quantity = request.getParameter("quantity");
        String price = request.getParameter("price");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long time = 0;

        try {
            Date date = dateFormat.parse(dateS);
            time = date.getTime();
        } catch (ParseException e) {
            request.setAttribute("template", "addfilm");
            request.setAttribute("genresError", "Write right date(Example: 01.01.1991)!");
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
            requestDispatcher.forward(request, response);
            return;
        }



        VideoStoreDao videoStoreDao = new VideoStoreDaoImpl();

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
                request.setAttribute("template", "addfilm");
                request.setAttribute("genresError", "Producer is not found!");
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
                requestDispatcher.forward(request, response);
                return;
            }
        } catch (Exception e) {
            request.setAttribute("template", "addfilm");
            request.setAttribute("genresError", "Producers is not available!");
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
            requestDispatcher.forward(request, response);
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
                request.setAttribute("template", "addfilm");
                request.setAttribute("genresError", "Studio is not found!");
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
                requestDispatcher.forward(request, response);
                return;
            }
        } catch (Exception e) {
            request.setAttribute("template", "addfilm");
            request.setAttribute("genresError", "Studios is not available!");
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
            requestDispatcher.forward(request, response);
            return;
        }
        int rem = 0;
        if (Regulars.isNumber(remark)) {
            if (Integer.parseInt(remark)>=0 && Integer.parseInt(remark)<=10) {
                rem = Integer.parseInt(remark);
            } else {
                request.setAttribute("template", "addfilm");
                request.setAttribute("genresError", "Remark should be >0 and <10!");
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
                requestDispatcher.forward(request, response);
                return;
            }
        } else {
            request.setAttribute("template", "addfilm");
            request.setAttribute("genresError", "Remark should be a number!");
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
            requestDispatcher.forward(request, response);
            return;
        }
        String[] nroles = roles.split(",");
        String[] ngenres = genres.split(",");
        int quant = 0, pric = 0;
        if (!quantity.equals("") && !price.equals("")) {
            boolean f = false, f1 = false;
            if (Regulars.isNumber(quantity)) {
                quant = Integer.parseInt(quantity);
                f = true;
            } else {
                request.setAttribute("template", "addfilm");
                request.setAttribute("genresError", "Incorrect quantity!");
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
                requestDispatcher.forward(request, response);
                return;
            }
            if (Regulars.isNumber(price)) {
                pric = Integer.parseInt(price);
                f1 = true;
            } else {
                request.setAttribute("template", "addfilm");
                request.setAttribute("genresError", "Incorrect price(Set integer format)!");
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
                requestDispatcher.forward(request, response);
                return;
            }
        }


        String s = videoStoreDao.updateFilm(filmID,name,Integer.parseInt(studioId),new java.sql.Date(time),Integer.parseInt(producerId),description,
                rem, url, nroles, ngenres,quant,pric);
        if (s.equals("")) {
            response.sendRedirect("/film?id="+filmID);
        } else {
            request.setAttribute("template", "addfilm");
            request.setAttribute("genresError", s);
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
            requestDispatcher.forward(request, response);
            return;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
        String filmId =  request.getParameter("film_id");
        filmID = Integer.parseInt(filmId);
        session = request.getSession();
        user = (User) session.getAttribute("current_user");
        if (user.getIs_admin()) {
            if (Regulars.isNumber(filmId)) {
                film = videoService.getFilm(Integer.parseInt(filmId));
                request.setAttribute("film_name",film.getName());
                request.setAttribute("film_date",film.getDate());
                request.setAttribute("film_description",film.getDescription());
                request.setAttribute("film_url",film.getImageURL());
                request.setAttribute("film_remark",film.getRemark());
                request.setAttribute("film_producer",producerService.getProducer(film.getProducer()).getName());
                request.setAttribute("film_studio",studioService.getStudioByFilmId(film.getStudio()).getName());
                String genres = "";
                for (int g :(LinkedList<Integer>)genresFilmService.getGenreIdByFilmId(Integer.parseInt(filmId))) {
                    genres += genreService.getGenreById(g).getName()+",";
                }
                request.setAttribute("film_genres",genres);
                String roles = "";
                for (int r :
                        (LinkedList<Integer>)rolesFilmService.getRoleIdByFilmId(Integer.parseInt(filmId))) {
                    roles+=roleServices.getRoleById(r).getName()+",";
                }
                request.setAttribute("film_roles",roles);

                //Now filmexistance

                FilmExistance filmEx = DaoFactory.getInstance().getFilmExistanceDao().getFilmExistance(Integer.parseInt(filmId));
                if (filmEx!=null) {
                    request.setAttribute("film_quantity", filmEx.getQuantity());
                    request.setAttribute("film_price", filmEx.getMoney());
                }
                request.setAttribute("template","addfilm");
                requestDispatcher.forward(request,response);
            } else
                response.sendError(504,"Incorrect film_id");
        }
    }

    @Override
    public void init() throws ServletException {
        videoService = new VideoServiceImpl();
        studioService = new StudioServiceImpl();
        producerService = new ProducerServiceImpl();
        roleServices = new RoleServicesImpl();
        rolesFilmService = new RolesFilmServiceImpl();
        genreService = new GenreServiceImpl();
        genresFilmService = new GenresFilmServiceImpl();
    }
}
