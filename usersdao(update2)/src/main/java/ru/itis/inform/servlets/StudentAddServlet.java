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
import java.io.PrintWriter;
import java.sql.SQLException;

public class StudentAddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.setContentType("text/html;charset=utf-8");
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/studentsAddForm.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String passwordA = req.getParameter("passwordAgain");
        String city = req.getParameter("city");
        String year = req.getParameter("year");
        User user = null;
        try {
            if (password.equals(passwordA) && password.length() != 0) {
                try {
                    user = new User(name, password, Integer.parseInt(year), city);
                    String id = String.valueOf(user.hashCode());
                    user.setId(id);
                    req.setAttribute("user_id", user.getId());
                } catch (Exception e) {
                    req.setAttribute("error_fail_user", "Type the correct your form!");
                    RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/studentsAddForm.jsp");
                    requestDispatcher.forward(req, resp);
                }
            } else {
                req.setAttribute("error", "Password is incorrect!");
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/studentsAddForm.jsp");
                requestDispatcher.forward(req, resp);
            }
        } catch (Exception e) {
            System.out.println("Cannot create user");
        }

        JDBCUsersImpl jdbcUsers = new JDBCUsersImpl();
        if (user != null) {
            try {
                jdbcUsers.save(user);
                System.out.println("ADD STUDENT SUCCESSFULLY!, user ID:" + user.getId());
                resp.getWriter().println(""+user.getId());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            resp.sendError(518, "Send form user is null!");
        }
    }
}
