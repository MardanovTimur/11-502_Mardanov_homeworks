package ru.itis.inform.servlets;

import ru.itis.inform.errors.Error;
import ru.itis.inform.messages.Message;
import ru.itis.inform.models.User;
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
    HttpSession session;
    RequestDispatcher requestDispatcher;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        session = req.getSession();
        User current_user = (User) session.getAttribute("user");
        if (current_user != null) {
            resp.sendRedirect("/");
        } else {
            requestDispatcher = getServletContext().getRequestDispatcher("/authorization.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        UserService userService = new UserServiceImpl();

        User current_user = userService.find(login);

        if (current_user != null) {
            if (Hash.getMd5Apache(password).equals(current_user.getPassword())) {
                HttpSession session = req.getSession();
                session.setAttribute("user", current_user);
                resp.sendRedirect("/");
            } else {
                req.setAttribute("incorrect_password", "Incorrect password or login!");
                requestDispatcher = getServletContext().getRequestDispatcher("/authorization.jsp");
                requestDispatcher.forward(req, resp);
            }
        } else {
            req.setAttribute(Error.getName(), Error.getMessage());
            requestDispatcher = getServletContext().getRequestDispatcher("/authorization.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
