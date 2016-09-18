package ru.itis.inform;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class StudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        UsersService usersService = new UsersService();
        List<User> userList = usersService.findAll();

        //req.getSession().setAttribute("User",userList.get(0).getName());

        req.setAttribute("users", userList);
        //System.out.print(userList.get(0).getName());
        //usersService.close();
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/students.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
