package ru.itis.inform.filters;


import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Cookie[] cookies = ((HttpServletRequest) servletRequest).getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("current_user_name")) {
                    ((HttpServletRequest) servletRequest).getSession().setAttribute("current_user_name", cookie.getValue());
                }
            }
        }
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("current_user")) {
                    ((HttpServletRequest) servletRequest).getSession().setAttribute("current_user", cookie.getValue());
                    ((HttpServletResponse) servletResponse).sendRedirect("/home");
                }
            }
        }
        if (((HttpServletRequest) servletRequest).getSession().getAttribute("current_user") == null) {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    public void destroy() {

    }
}
