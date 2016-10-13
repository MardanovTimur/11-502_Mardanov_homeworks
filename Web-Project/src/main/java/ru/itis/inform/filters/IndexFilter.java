package ru.itis.inform.filters;

import ru.itis.inform.models.User;
import ru.itis.inform.services.TokenService;
import ru.itis.inform.services.TokenServiceImpl;
import ru.itis.inform.services.UserService;
import ru.itis.inform.services.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Тимур on 12.10.2016.
 */
public class IndexFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Object sessionAtribute = ((HttpServletRequest) servletRequest).getSession().getAttribute("current_user");
        Cookie[] cookies = ((HttpServletRequest) servletRequest).getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("current_user")) {
                    TokenService tokenService = new TokenServiceImpl();
                    String student_id = tokenService.findToken(cookie.getValue());
                    UserService userService = new UserServiceImpl();
                    User user = userService.findId(student_id);

                    if (user != null) {
                        System.out.println(user.getName());
                        ((HttpServletRequest) servletRequest).getSession().setAttribute("current_user", user);
                        filterChain.doFilter(servletRequest, servletResponse);
                    }
                }
            }
        }

        if (sessionAtribute == null) {
            ((HttpServletResponse) servletResponse).sendRedirect("/login");
        }
    }

    public void destroy() {

    }
}
