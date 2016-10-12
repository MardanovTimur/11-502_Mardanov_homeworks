package ru.itis.inform.servlets;

import jdk.nashorn.internal.ir.RuntimeNode;
import ru.itis.inform.models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by Тимур on 09.10.2016.
 */
public class Index extends HttpServlet {
    RequestDispatcher requestDispatcher;
    HttpSession session = null;
    Cookie cookie;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
