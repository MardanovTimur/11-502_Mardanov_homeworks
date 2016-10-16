package ru.itis.inform.servlets;

import ru.itis.inform.services.VideoService;
import ru.itis.inform.services.VideoServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Тимур on 16.10.2016.
 */
public class AddFilm extends HttpServlet {
    VideoService videoService = new VideoServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setAttribute("template","addfilm");
        //req.setAttribute("current_user",req.getSession().getAttribute("current_user"));
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        String name = req.getParameter("name");
        String producer = req.getParameter("producer");
        String studio = req.getParameter("studio");
        String date = req.getParameter("date");
        String description = req.getParameter("description");
        int remark = Integer.parseInt(req.getParameter("remark"));


    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }
}
