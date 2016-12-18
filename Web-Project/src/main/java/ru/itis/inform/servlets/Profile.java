package ru.itis.inform.servlets;

import ru.itis.inform.factories.ServiceFactory;
import ru.itis.inform.models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Тимур on 04.11.2016.
 */
//Профиль пользователя
public class Profile extends HttpServlet {
    private RequestDispatcher requestDispatcher;
    private HttpSession session;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        session = req.getSession();
        User user = (User)session.getAttribute("current_user");
        if (user != null) {
            req.setAttribute("template", "profile");
            User userProfile = ServiceFactory.getInstance().getUserService().findId(id);
            req.setAttribute("name", userProfile.getName());
            req.setAttribute("admin", userProfile.getIs_admin());
            req.setAttribute("login", userProfile.getLogin());
            requestDispatcher.forward(req, resp);
            return;
        } else {
            req.setAttribute("guest","Please, Sign in!");
            requestDispatcher = getServletContext().getRequestDispatcher("/login");
            requestDispatcher.forward(req,resp);
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    public void init() throws ServletException {
        requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
    }
}
