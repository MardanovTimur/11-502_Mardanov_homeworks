package ru.itis.inform.servlets;

import ru.itis.inform.services.TokenService;
import ru.itis.inform.services.TokenServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//Выход и очистка куков если дюд зашёл с куками
public class Logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();

        for (Cookie cookie: cookies
                ) {
            if (cookie.getName().equals("current_user")) {
                String current_token = cookie.getValue();
                cookie.setValue("");
                cookie.setPath("/");
                cookie.setMaxAge(0);
                TokenService tokenService = new TokenServiceImpl();
                if (tokenService.findToken(current_token)!=null) {
                    tokenService.deleteToken(current_token);
                }
                resp.addCookie(cookie);
            }
        }
        req.getSession().invalidate();
        resp.sendRedirect("/home");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
