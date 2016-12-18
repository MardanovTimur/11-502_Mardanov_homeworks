package ru.itis.inform.servlets;

import ru.itis.inform.models.Genre;
import ru.itis.inform.models.Role;
import ru.itis.inform.services.RoleServices;
import ru.itis.inform.services.RoleServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Тимур on 25.10.2016.
 */
//Сервлет для добавления роли
public class AddRole extends HttpServlet {
    private Role role;
    private RoleServices roleServices;
    private RequestDispatcher requestDispatcher;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setAttribute("template","addrole");
        List<Role> ll = roleServices.getAllRoles();
        req.setAttribute("genres", ll);
        requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
        requestDispatcher.forward(req,resp);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("template","addrole");
        String name = req.getParameter("name");
        role = new Role(name);
        boolean f = roleServices.addRole(role);
        if (f) {
            resp.sendRedirect("/addrole");
        } else {
            req.setAttribute("no","Role isn't added!");
            requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
            requestDispatcher.forward(req,resp);
            return;
        }
    }

    @Override
    public void init() throws ServletException {
        roleServices = new RoleServicesImpl();
    }
}
