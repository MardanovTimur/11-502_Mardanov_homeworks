package ru.itis.inform.servlets;

import ru.itis.inform.errors.Error;
import ru.itis.inform.messages.Message;
import ru.itis.inform.models.User;
import ru.itis.inform.services.UserService;
import ru.itis.inform.services.UserServiceImpl;
import ru.itis.inform.utils.Hash;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by Тимур on 06.10.2016.
 */
public class Authorization extends HttpServlet {
    HttpSession session;
    RequestDispatcher requestDispatcher;
    Cookie cookie;
    UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        requestDispatcher = getServletContext().getRequestDispatcher("/authorization.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        userService = new UserServiceImpl();

        User currentUser = userService.find(login);

        if (currentUser != null) {
            if (Hash.getMd5Apache(password).equals(currentUser.getPassword())) {
                HttpSession session = req.getSession();

                //Session
                session.setAttribute("current_user", currentUser.getLogin());
                session.setAttribute("current_user_name",currentUser.getName());

                //Cookie
                Cookie cookie = new Cookie("current_user", currentUser.getLogin());
                Cookie cookie_name = new Cookie("current_user_name",currentUser.getName().split(" ")[0]);
                cookie.setMaxAge(24*60*60);
                cookie_name.setMaxAge(24*60*60);
                resp.addCookie(cookie);
                resp.addCookie(cookie_name);

                resp.sendRedirect("/home");
            } else {
                req.setAttribute("incorrect_password", "Incorrect password or login!");
                requestDispatcher = getServletContext().getRequestDispatcher("/authorization.jsp");
                requestDispatcher.forward(req, resp);
            }
        } else {
            req.setAttribute("user_not_find", Error.getMessage());
            requestDispatcher = getServletContext().getRequestDispatcher("/authorization.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
