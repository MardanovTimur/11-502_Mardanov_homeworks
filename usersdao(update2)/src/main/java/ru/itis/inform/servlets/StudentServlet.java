package ru.itis.inform.servlets;

import ru.itis.inform.services.UsersService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class StudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        //UsersService usersService = new UsersService();
        UsersService usersService = new UsersService();

        List userList = null;
        try {
            userList = usersService.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.setAttribute("users", userList);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/students.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
