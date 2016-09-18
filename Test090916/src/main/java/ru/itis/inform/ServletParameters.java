package ru.itis.inform;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.itis.inform.Group;
import ru.itis.inform.ManagementSystem;

public class ServletParameters extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text / html;charset=UTF-8");
        PrintWriter pw = resp.getWriter();
        pw.println("<B> Список групп</B>");
        pw.println("<table border = 1>");
        try {
            List l = ManagementSystem.getInstance().getGroups();
            for (Iterator it = l.iterator(); it.hasNext(); ) {
                Group gr = (Group) it.next();
                pw.println("<tr>");
                pw.println("<td>" + gr.getGroupId() + "</td>");
                pw.println("<td>" + gr.getNameGroup() + "</td>");
                pw.println("<td>" + gr.getCurator() + "</td>");
                pw.println("<td>" + gr.getSpeciality() + "</td>");
                pw.println("</tr >");
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
        pw.println("</table>");
    }
}}