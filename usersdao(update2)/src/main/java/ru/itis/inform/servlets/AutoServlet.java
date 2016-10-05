package ru.itis.inform.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import ru.itis.inform.services.AutoService;

public class AutoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        AutoService autoService = new AutoService();

        List autoList = null;
        try {
            autoList = autoService.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("autos", autoList);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/auto.jsp");
        dispatcher.forward(req,resp);
    }
}
