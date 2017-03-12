package ru.itis.inform.servlets;

import org.springframework.context.ApplicationContext;
import ru.itis.inform.model.Book;
import ru.itis.inform.model.User;
import ru.itis.inform.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Тимур on 09.03.2017.
 */
public class AddModel extends HttpServlet {
    private UserService userService;
    private RequestDispatcher requestDispatcher;
    private String name;
    private Integer age;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        requestDispatcher = getServletContext().getRequestDispatcher("/addUser.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        name = req.getParameter("name");
        age = Integer.valueOf(req.getParameter("age"));
        User user = new User();
        user.setName(name);
        user.setAge(age);
        Book book = new Book();
        book.setName("War and Live");
        book.setUser(user);
        user.setBook(book);
        user.setFriends(new ArrayList<User>());
        userService.getUsersDao().save(user);
        resp.sendRedirect("/all");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        ApplicationContext applicationContext = (ApplicationContext) servletConfig.getServletContext().getAttribute("context");
        userService = (UserService) applicationContext.getBean("userService");
    }
}
