package ru.itis.inform.servlets;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.inform.config.SpringConfig;
import ru.itis.inform.dao.*;
import ru.itis.inform.verifiers.Regulars;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Тимур on 18.12.2016.
 */
public class Delete extends HttpServlet {
    ApplicationContext beanF;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        String genreId = req.getParameter("genre_id");
        String producerId = req.getParameter("producer_id");
        String roleId = req.getParameter("role_id");
        String studioId = req.getParameter("studio_id");

        if (genreId != null) {
            if (Regulars.isNumber(genreId)) {
                int id = Integer.parseInt(genreId);
                GenreDao genreDao = new GenreDaoImpl();
                genreDao.deleteGenre(id);
                resp.sendRedirect("/addgenre");
            } else {
                resp.sendError(404, "Incorrect parameter!");
            }
        }
        if (producerId != null) {
            if (Regulars.isNumber(producerId)) {
                int id = Integer.parseInt(producerId);
                ProducerDao producerDao = new ProducerDaoImpl();
                producerDao.deleteProducer(id);
                resp.sendRedirect("/addproducer");
            } else {
                resp.sendError(404, "Incorrect parameter!");
            }
        }
        if (roleId != null) {
            if (Regulars.isNumber(roleId)) {
                int id = Integer.parseInt(roleId);
                RoleDao roleDao = new RoleDaoImpl();
                roleDao.deleteRole(id);
                resp.sendRedirect("/addrole");
            } else {
                resp.sendError(404, "Incorrect parameter!");
            }
        }
        if (studioId != null) {
            if (Regulars.isNumber(studioId)) {
                int id = Integer.parseInt(studioId);
                StudioDao studioDao = beanF.getBean(StudioDao.class);
                studioDao.deleteStudio(id);
                resp.sendRedirect("/addstudio");
            } else {
                resp.sendError(404, "Incorrect parameter!");
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    public void init() throws ServletException {
        super.init();
        beanF = new AnnotationConfigApplicationContext(SpringConfig.class);
    }
}
