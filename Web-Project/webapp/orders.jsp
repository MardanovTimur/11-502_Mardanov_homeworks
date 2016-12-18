<%@ page import="ru.itis.inform.models.Buy" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="ru.itis.inform.factories.DaoFactory" %>
<%@ page import="ru.itis.inform.factories.ServiceFactory" %>
<%@ page import="ru.itis.inform.services.VideoService" %>
<%@ page import="ru.itis.inform.services.VideoServiceImpl" %>
<%@ page import="ru.itis.inform.models.BuyMod" %><%--
  Created by IntelliJ IDEA.
  User: Тимур
  Date: 08.12.2016
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<br>
<br>
<div class="container">
    <table class="table table-bordered">
        <tr>
            <%if (request.getAttribute("buysAdmin")!=null) {%>
            <td>
                <b>User name</b>
            </td>
            <td>
                <b>User uniq ID</b>
            </td>
            <%}%>
            <td>
                <b>Film name</b>
            </td>
            <td>
                <b>Initial date</b>
            </td>
            <td>
                <b>Final date</b>
            </td>
            <td>
                <b>Quantity</b>
            </td>
            <%if (request.getAttribute("buysAdmin")!=null) {%>
            <td>
                <b>Accept</b>
            </td>
            <%}%>
        </tr>
        <% if (request.getAttribute("buys") != null) {%>
        <%
            for (Buy buy : (LinkedList<Buy>) request.getAttribute("buys")) {%>
        <tr>
            <td><%
                VideoService videoService = new VideoServiceImpl();
                String name = videoService.getFilm(buy.getId()).getName();
            %>
                <a href="/film?id=<%=videoService.getFilm(buy.getId()).getId()%>"><%=name%></a>
            </td>
            <td>
                <%=buy.getDate()%>
            </td>
            <td>
                <%=buy.getDate2()%>
            </td>
            <td>
                <%=buy.getQuantity()%>
            </td>
        </tr>
        <% }%>
        <%} else if (request.getAttribute("buysAdmin")!=null) {%>
        <%
            for (BuyMod buy : (LinkedList<BuyMod>) request.getAttribute("buysAdmin")) {%>
        <tr>
            <td>
                <%=buy.getUser_name()%>
            </td>
            <td>
               <%=buy.getUser_id()%>
            </td>
            <td>
               <%=buy.getFilm_name()%>
            </td>
            <td>
                <%=buy.getStart()%>
            </td>
            <td>
                <%=buy.getFin()%>
            </td>
            <td>
                <%=buy.getQuantity()%>
            </td>
            <td>
                <a class="btn btn-sm btn-primary btn-block" href="/deleteorder?userId=<%=buy.getUser_id()%>&filmId=<%=buy.getFilm_id()%>&film_Date=<%=buy.getStart()%>&quantity=<%=buy.getQuantity()%>" role="button">Accept</a>
            </td>
        </tr>
        <%}%>
        <%}%>
    </table>
</div>
