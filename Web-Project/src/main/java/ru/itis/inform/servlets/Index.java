package ru.itis.inform.servlets;

import jdk.nashorn.internal.ir.RuntimeNode;
import ru.itis.inform.models.Film;
import ru.itis.inform.models.User;
import ru.itis.inform.services.VideoService;
import ru.itis.inform.services.VideoServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Тимур on 09.10.2016.
 */
// Главная страница с фильмами и проч
public class Index extends HttpServlet {
    private RequestDispatcher requestDispatcher;
    private HttpSession session;
    private VideoService videoService;
    private Cookie cookie;
    private LinkedList<Film> films;
    private static final int default_number = 1;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setAttribute("template", "films");
        String search = req.getParameter("search");
        if (videoService.getAllFilms() != null) {

            //View films
            if (search != null)
                if (search.equals("")) {
                    films = videoService.getAllFilms();
                } else {
                    films = videoService.getSearchFilms(search);
                    req.setAttribute("search",search);
                }
            else {
                films = videoService.getAllFilms();
            }
            req.setAttribute("filmsAll", films);
            ArrayList<Film> sendArrayList = new ArrayList<Film>();

            //Film columns
            String current_number = req.getParameter("current_number");
            if (current_number != null) {
                if (current_number.equals("1")) {
                    req.setAttribute("current_number", "" + default_number);
                    for (int i = 0; i < 9; i++) {
                        try {
                            sendArrayList.add(i, films.get(i));
                        } catch (IndexOutOfBoundsException e) {

                        }
                    }
                } else if (current_number.equals("fin")) {
                    req.setAttribute("current_number", "" + ((films.size() / 9) + 1));
                    for (int i = 0; i < 9; i++) {
                        try {
                            current_number = "" + (films.size() / 9 + 1);
                            sendArrayList.add(i, films.get((films.size() / 9) * 9 + i));
                        } catch (IndexOutOfBoundsException e) {

                        }
                    }
                } else
                    for (int i = 0; i < 9; i++) {
                        try {
                            sendArrayList.add(i, films.get((Integer.parseInt(current_number) - 1) * 9 + i));
                        } catch (IndexOutOfBoundsException e) {
                        }
                    }
                req.setAttribute("current_number", "" + current_number);
                req.setAttribute("films", sendArrayList);
                requestDispatcher.forward(req, resp);
                return;
            } else {
                req.setAttribute("current_number", "" + default_number);
                for (int i = 0; i < 9; i++) {
                    try {
                        sendArrayList.add(i, films.get(i));
                    } catch (IndexOutOfBoundsException e) {

                    }
                }
                req.setAttribute("films", sendArrayList);
                requestDispatcher.forward(req, resp);
                return;
            }
        } else

        {
            System.out.println("Null films!");
        }

        requestDispatcher.forward(req, resp);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    public void init() throws ServletException {
        videoService = new VideoServiceImpl();
        requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
    }
}
