package ru.itis.inform.servlets;

import ru.itis.inform.models.Producer;
import ru.itis.inform.models.Role;
import ru.itis.inform.services.ProducerService;
import ru.itis.inform.services.ProducerServiceImpl;
import ru.itis.inform.services.RoleServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Тимур on 08.11.2016.
 */
public class AddProducer extends HttpServlet {
    private Producer producer;
    private ProducerService producerService;
    private RequestDispatcher requestDispatcher;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setAttribute("template","addproducer");
        requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("template","addproducer");
        String name = req.getParameter("name");
        producer = new Producer(name);
        boolean f = producerService.addProducer(producer);
        if (f) {
            req.setAttribute("ok","Producer is added!");
            requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
            requestDispatcher.forward(req,resp);
        } else {
            req.setAttribute("no","Producer isn't added!");
            requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
            requestDispatcher.forward(req,resp);
        }
    }

    @Override
    public void init() throws ServletException {
        producerService = new ProducerServiceImpl();
    }
}
