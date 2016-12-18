package ru.itis.inform.servlets;

import ru.itis.inform.factories.DaoFactory;
import ru.itis.inform.models.*;
import ru.itis.inform.models.Buy;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedList;

// Сервлет с товарами
public class Orders extends HttpServlet {
    private LinkedList<Buy> buys;
    private LinkedList<BuyMod> buyMods;
    private User user;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setAttribute("template","orders");
        HttpSession session = req.getSession();

        user =(User)session.getAttribute("current_user");

        if (user.getIs_admin()) {
            req.setAttribute("buysAdmin",DaoFactory.getInstance().getBuyDao().getBuysExceptAdmin());
        } else {
            buys = DaoFactory.getInstance().getBuyDao().getBuys(user.getId());
            req.setAttribute("buys",buys);
        }

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    public void init() throws ServletException {
        DaoFactory.getInstance().getBuyDao();
    }
}
