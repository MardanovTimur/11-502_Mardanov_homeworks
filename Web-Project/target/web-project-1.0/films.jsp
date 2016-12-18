<%@ page import="java.util.LinkedList" %>
<%@ page import="ru.itis.inform.models.Film" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Тимур
  Date: 21.10.2016
  Time: 0:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="css/3-col-portfolio.css" rel="stylesheet">
<div class="container" style="padding-left: 7%">

    <!-- Page Header -->
    <div class="row">
        <div class="col-lg-12">
            <form method="get" action="/home">
                <input type="text" class="sadw" placeholder="Search" name ="search">
                <input type="submit" value="submit">
            </form>
        </div>
        <div class="col-lg-12">
            <h1 class="page-header">Catalog
                <small>published films</small>
            </h1>
        </div>
    </div>
    <!-- /.row -->
    <%
        if (request.getAttribute("films") != null) {
            ArrayList<Film> films = (ArrayList<Film>) request.getAttribute("films");
            String current_number = (String) request.getAttribute("current_number");
            for (int i = 1; i <= 3; i++) {
    %>
    <!-- Projects Row -->
    <div class="row">
        <%
            try {
                films.get((i - 1) * 3);
        %>
        <div class="col-md-4 portfolio-item">
            <a href="/film?id=<%=films.get((i-1)*3).getId()%>">
                <img class="img-responsive" src="<%=films.get((i-1)*3).getImageURL()%>" width="700" height="400" style="max-height: 198px" alt="">
            </a>
            <h3>
                <a href="/film?id=<%=films.get((i-1)*3).getId()%>"><%=films.get((i - 1) * 3).getName()%>
                </a>
            </h3>
        </div>
        <%
            } catch (IndexOutOfBoundsException e) {
            }
        %>
        <%
            try {
                films.get((i - 1) * 3 + 1);
        %>
        <div class="col-md-4 portfolio-item">
            <a href="/film?id=<%=films.get((i-1)*3+1).getId()%>">
                <img class="img-responsive" src="<%=films.get((i-1)*3+1).getImageURL()%>" width="700" height="400" style="max-height: 198px" alt="">
            </a>
            <h3>
                <a href="/film?id=<%=films.get((i-1)*3+1).getId()%>"><%=films.get((i - 1) * 3 + 1).getName()%>
                </a>
            </h3>
        </div>
        <%
            } catch (IndexOutOfBoundsException e) {
            }
        %>
        <%
            try {
                films.get((i - 1) * 3 + 2);
        %>
        <div class="col-md-4 portfolio-item">
            <a href="/film?id=<%=films.get((i-1)*3+2).getId()%>">
                <img class="img-responsive" src="<%=films.get((i-1)*3+2).getImageURL()%>" width="700" height="400" style="max-height: 198px" alt="">
            </a>
            <h3>
                <a href="/film?id=<%=films.get((i-1)*3+2).getId()%>"><%=films.get((i - 1) * 3 + 2).getName()%>
                </a>
            </h3>
        </div>
        <%
            } catch (IndexOutOfBoundsException e) {
            }
        %>
    </div>
    <%}%>
    <%-- <%
    if (request.getAttribute("films") != null) {
     LinkedList<Film> films = (LinkedList<Film>) request.getAttribute("films");
     String current_number = (String) request.getAttribute("current_number");
     for (int i = 1; i <= 10; i++) {
         try {
             films.get(10 * (Integer.parseInt(current_number) - 1) + i - 1);
    %>
    <div class="film">
     <div class="container">
         <H2><a style="link: black"
                href="/film?id=<%=films.get(10*(Integer.parseInt(current_number)-1)+i-1).getId()%>"
                about="See this film"><%=films.get(10 * (Integer.parseInt(current_number) - 1) + i - 1).getName()%>
         </a></H2>
         <br>
         <%=films.get(10 * (Integer.parseInt(current_number) - 1) + i - 1).getDescription().substring(0, films.get(10 * (Integer.parseInt(current_number) - 1) + i - 1).getDescription().length() / 2)%>
         ...
         <br>
     </div>
    </div>
    <br>
     <% } catch (IndexOutOfBoundsException e) {
    }
    }
    }
    %>--%>
    <hr>

    <div class="row text-center">
        <div class="col-lg-12">
            <ul class="pagination">
                <li>
                    <a href="/home?current_number=1">&laquo;</a>
                </li>
                <% if (Integer.parseInt(current_number) > 1) {%>
                <li >
                    <a href="/home?current_number=<%=Integer.parseInt(current_number)-1%>"><%=Integer.parseInt(current_number) - 1%>
                    </a>
                </li>
                <%}%>
                <li class="active">
                    <a href="/home?current_number=<%=current_number%>"><%=Integer.parseInt(current_number)%>
                    </a>
                </li>
                <%if (request.getAttribute("films") != null)%>
                <%LinkedList<Film> filmsAll = (LinkedList<Film>) request.getAttribute("filmsAll");%>
                <% if (filmsAll.size() / 9.0 - Integer.parseInt(current_number) > 0) {%>
                <li>
                    <a href="/home?current_number=<%=Integer.parseInt(current_number)+1%>"><%=Integer.parseInt(current_number) + 1%>
                    </a>
                </li>
                <%}%>
                <li>
                    <a href="/home?current_number=fin">&raquo;</a>
                </li>
            </ul>
        </div>
    </div>


    <%--<div>
        <div class="knopochki">
            <%if (request.getAttribute("films") != null) %>
            <button><a href="/home?current_number=1"><<-</a></button>
            <% if (Integer.parseInt(current_number) > 1) {%>
            <button><a
                    href="/home?current_number=<%=Integer.parseInt(current_number)-1%>"><%=Integer.parseInt(current_number) - 1%>
            </a></button>
            <%}%>
            <button><a href="/home?current_number=<%=current_number%>"><%=Integer.parseInt(current_number)%>
            </a></button>
            <%if (request.getAttribute("films") != null)%>
            <%LinkedList<Film> filmsAll = (LinkedList<Film>) request.getAttribute("filmsAll");%>
            <% if (Integer.parseInt(current_number) <= filmsAll.size() / 10) {%>
            <button><a
                    href="/home?current_number=<%=Integer.parseInt(current_number)+1%>"><%=Integer.parseInt(current_number) + 1%>
            </a></button>
            <%}%>
            <button><a href="/home?current_number=fin">->></a></button>
        </div>
    </div>--%>
    <hr>
    <%}%>
</div>
