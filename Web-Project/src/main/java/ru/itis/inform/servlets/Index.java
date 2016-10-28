package ru.itis.inform.servlets;

import jdk.nashorn.internal.ir.RuntimeNode;
import ru.itis.inform.models.Film;
import ru.itis.inform.models.User;
import ru.itis.inform.services.VideoService;
import ru.itis.inform.services.VideoServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by Тимур on 09.10.2016.
 */
public class Index extends HttpServlet {
    private RequestDispatcher requestDispatcher;
    private HttpSession session;
    private VideoService videoService;
    private Cookie cookie;
    private LinkedList<Film> films;
    private static final int default_number = 1;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setAttribute("template", "films");

        if (videoService.getAllFilms() != null) {

            //View films
            films = videoService.getAllFilms();
            req.setAttribute("films", films);

            //Film columns
            String current_number = req.getParameter("current_number");
            if (current_number != null) {
                if (current_number.equals("1")) {
                    req.setAttribute("current_number","" + default_number);
                } else if (current_number.equals("fin")) {
                    req.setAttribute("current_number",""+ ((films.size() / 10) + 1));
                } else
                    req.setAttribute("current_number", ""+current_number);
                requestDispatcher.forward(req, resp);
                return;
            } else {
                req.setAttribute("current_number", ""+default_number);
                requestDispatcher.forward(req, resp);
                return;
            }
        } else {
            System.out.println("Null films!");
        }

        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    public void init() throws ServletException {
        videoService = new VideoServiceImpl();
        requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
    }
}
