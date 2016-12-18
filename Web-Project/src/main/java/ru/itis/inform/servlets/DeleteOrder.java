package ru.itis.inform.servlets;

import ru.itis.inform.factories.DaoFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Тимур on 10.12.2016.
 */
// Удаление заказа
public class DeleteOrder extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        String userId = req.getParameter("userId");
        String filmId = req.getParameter("filmId");
        String quantity = req.getParameter("quantity");
        boolean f = DaoFactory.getInstance().getBuyDao().giveUp(Integer.parseInt(userId),Integer.parseInt(filmId), Integer.parseInt(quantity));
        if (f){
            resp.sendRedirect("/orders");
        } else {
            resp.sendError(404, "Please write correct data! LOL");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
