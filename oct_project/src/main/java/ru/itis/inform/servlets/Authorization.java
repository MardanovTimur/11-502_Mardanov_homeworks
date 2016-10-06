package ru.itis.inform.servlets;

import ru.itis.inform.services.UserService;
import ru.itis.inform.services.UserServiceImpl;
import ru.itis.inform.utils.Hash;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Тимур on 06.10.2016.
 */
public class Authorization extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/authorization.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        UserService userService = new UserServiceImpl();

        if (userService.find(login)!=null) {
            if (Hash.getMd5Apache(password).equals(userService.find(login).getPassword())) {
                HttpSession session = req.getSession();
                session.setAttribute(login,);
            }
        }
    }
}
