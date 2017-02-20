package ru.itis.inform.servlets;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.inform.config.SpringConfig;
import ru.itis.inform.errors.Error;
import ru.itis.inform.messages.Message;
import ru.itis.inform.models.User;
import ru.itis.inform.services.TokenService;
import ru.itis.inform.services.TokenServiceImpl;
import ru.itis.inform.services.UserService;
import ru.itis.inform.services.UserServiceImpl;
import ru.itis.inform.utils.Hash;
import ru.itis.inform.utils.Token;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Тимур on 06.10.2016.
 */
//Сервлет авторизации
public class Authorization extends HttpServlet {
    HttpSession session;
    RequestDispatcher requestDispatcher;
    Cookie cookie;
    UserService userService;
    TokenService tokenService;
    ApplicationContext beansF;

    @Override
    public void init() throws ServletException {
        beansF = new AnnotationConfigApplicationContext(SpringConfig.class);
    }

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
        String checkCookie = req.getParameter("cookie");
        userService = beansF.getBean(UserService.class);

        User currentUser = userService.find(login);

        if (currentUser != null) {
            if (Hash.getMd5Apache(password).equals(currentUser.getPassword())) {
                HttpSession session = req.getSession();

                //Session
                session.setAttribute("current_user", currentUser);
                if (checkCookie != null && checkCookie.equals("true")) {
                    //Cookie
                    String token = Token.getToken();
                    Cookie cookie = new Cookie("current_user", token);
                    cookie.setMaxAge(30 * 24 * 60 * 60);
                    resp.addCookie(cookie);
                    tokenService = new TokenServiceImpl();
                    tokenService.addToken("" + currentUser.getId(), token);
                }
                resp.sendRedirect("/home");
            } else {
                req.setAttribute("incorrect_password", "Incorrect password!");
                req.setAttribute("login", login);
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
