package ru.itis.inform.servlets;

import jdk.nashorn.internal.ir.RuntimeNode;
import ru.itis.inform.JDBC.JDBCUsersImpl;
import ru.itis.inform.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Тимур on 27.09.2016.
 */
public class StudentAddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/studentsAddForm.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String passwordA = req.getParameter("passwordAgain");
        String id = req.getParameter("id");
        String city = req.getParameter("city");
        int year = Integer.parseInt(req.getParameter("year"));
        User user = null;
        try {
            if (password.equals(passwordA)) {
                user = new User(name, id, password, year, city);
            } else {
                req.setAttribute("error","Password is incorrect!");
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/studentsAddForm.jsp");
                requestDispatcher.forward(req,resp);
            }
        } catch (Exception e) {
            System.out.println("Cannot create user");
        }

        JDBCUsersImpl jdbcUsers = new JDBCUsersImpl();
        if (user != null) {
            try {
                jdbcUsers.save(user);
                resp.sendRedirect("/students/");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            resp.sendError(518, "User!!!!!!!!");
        }
    }
}
