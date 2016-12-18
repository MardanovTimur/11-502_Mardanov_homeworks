package ru.itis.inform.servlets;

import ru.itis.inform.dao.VideoStoreDao;
import ru.itis.inform.dao.VideoStoreDaoImpl;
import ru.itis.inform.factories.DaoFactory;
import ru.itis.inform.factories.ServiceFactory;
import ru.itis.inform.services.VideoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Тимур on 10.12.2016.
 */
//Сервлет для удаления фильма
public class DeleteFilm extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String film_id = req.getParameter("film_id");
        VideoStoreDao videoStoreDao = new VideoStoreDaoImpl();
        videoStoreDao.delete(film_id);
        resp.sendRedirect("/");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
