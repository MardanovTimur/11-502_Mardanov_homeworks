package ru.itis.inform.servlets;

import com.sun.deploy.security.SessionCertStore;
import ru.itis.inform.factories.DaoFactory;
import ru.itis.inform.factories.ServiceFactory;
import ru.itis.inform.models.FilmExistance;
import ru.itis.inform.models.User;
import ru.itis.inform.services.VideoService;
import ru.itis.inform.services.VideoServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;

/**
 * Created by Тимур on 11.11.2016.
 */
public class Buy extends HttpServlet {
    private RequestDispatcher requestDispatcher;
    private FilmExistance filmExistance = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        String idFilm = req.getParameter("film_id");
        VideoService videoService = new VideoServiceImpl();
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("current_user");
        int filmId = -1;
        if (user == null) {
            resp.sendRedirect("/login");
        } else {
            int userId = user.getId();
            try {
                filmId = Integer.parseInt(idFilm);
            } catch (Exception e) {
                resp.sendRedirect("/home");
            }
            if (DaoFactory.getInstance().getFilmExistanceDao().ifExist(filmId)) {
                filmExistance = DaoFactory.getInstance().getFilmExistanceDao().getFilmExistance(filmId);
                requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
                req.setAttribute("template", "buy");
                req.setAttribute("filmId", filmId);
                req.setAttribute("film_name", videoService.getFilm(filmId).getName());
                req.setAttribute("quantity", filmExistance.getQuantity());
                req.setAttribute("price", filmExistance.getMoney());
                requestDispatcher.forward(req, resp);
            } else {
                req.setAttribute("film_name", videoService.getFilm(filmId).getName());
                req.setAttribute("template", "filmIsNotAvailable");
                requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
                requestDispatcher.forward(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        int idFilm = Integer.parseInt(req.getParameter("id"));
        String card = req.getParameter("card");
        String quant = req.getParameter("quantity");
        //smth actions about that

        //add in buy sqlmodel relate


    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
