package ru.itis.inform.servlets;

import ru.itis.inform.models.Role;
import ru.itis.inform.services.RoleServices;
import ru.itis.inform.services.RoleServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Тимур on 25.10.2016.
 */
public class AddRole extends HttpServlet {
    private Role role;
    private RoleServices roleServices;
    private RequestDispatcher requestDispatcher;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setAttribute("template","addrole");
        requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("template","addrole");
        String name = req.getParameter("name");
        role = new Role(name);
        boolean f = roleServices.addRole(role);
        if (f) {
            req.setAttribute("ok","Role is added!");
            requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
            requestDispatcher.forward(req,resp);
        } else {
            req.setAttribute("no","Role isn't added!");
            requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
            requestDispatcher.forward(req,resp);
        }
    }

    @Override
    public void init() throws ServletException {
        roleServices = new RoleServicesImpl();
    }
}
