package ru.itis.inform.servlets;

import ru.itis.inform.factories.ServiceFactory;
import ru.itis.inform.messages.Message;
import ru.itis.inform.services.UserService;
import ru.itis.inform.services.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Тимур on 27.10.2016.
 */
public class SignUp extends HttpServlet{
    RequestDispatcher requestDispatcher;
    ServiceFactory serviceFactory;
    Message message;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        requestDispatcher = getServletContext().getRequestDispatcher("/signup.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        String username = req.getParameter("name");
        String login = req.getParameter("username");
        String password = req.getParameter("password");
        String checkPassword = req.getParameter("confirm");
        message = ServiceFactory.getInstance().getUserService().add(username,login,password,checkPassword, false);
        req.setAttribute("username",username);

        req.setAttribute(message.getName(),message.getMessage());
        requestDispatcher = getServletContext().getRequestDispatcher("/signup.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    public void init() throws ServletException {
        requestDispatcher = getServletContext().getRequestDispatcher("/signup.jsp");
    }
}
