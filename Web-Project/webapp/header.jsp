<!DOCTYPE html>
<%@ page import="ru.itis.inform.models.User" %><%--
  Created by IntelliJ IDEA.
  User: Тимур
  Date: 09.10.2016
  Time: 0:17
  To change this template use File | Settings | File Templates.

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<body id="body">
<%User current_user = (User) session.getAttribute("current_user");%>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <%if (current_user!=null && current_user.getIs_admin()) {%>
                <span class="icon-bar"></span>
                <%}%>
                <%if (current_user!=null && current_user.getIs_admin()) {%>
                <span class="icon-bar"></span>
                <%}%>
                <%if (current_user!=null && current_user.getIs_admin()) {%>
                <span class="icon-bar"></span>
                <%}%>
                <%if (current_user!=null && current_user.getIs_admin()) {%>
                <span class="icon-bar"></span>
                <%}%>
                <%if (current_user!=null && current_user.getIs_admin()) {%>
                <span class="icon-bar"></span>
                <%}%>
            </button>
            <% if (current_user!=null) {%>
            <a class="navbar-brand"
               href="/profile?id=<%=current_user.getId()%>"><%=current_user.getName()%><%=current_user.getIs_admin() ? "(admin)" : ""%>
            </a>
            <%} else {%>
            <a class="navbar-brand"
               href="/home"><%="Guest"%>
            </a>
            <%}%>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/home">Films</a></li>
                <li><a href="/orders">Orders</a></li>
                <%if (current_user!=null && current_user.getIs_admin()) {%>
                <li><a href="/addfilm">Add film</a></li>
                <%}%>
                <%if (current_user!=null && current_user.getIs_admin()) {%>
                <li><a href="/addgenre">Add genre</a></li>
                <%}%>
                <%if (current_user!=null && current_user.getIs_admin()) {%>
                <li><a href="/addproducer">Add producer</a></li>
                <%}%>
                <%if (current_user!=null && current_user.getIs_admin()) {%>
                <li><a href="/addrole">Add role</a></li>
                <%}%>
                <%if (current_user!=null && current_user.getIs_admin()) {%>
                <li><a href="/addstudio">Add studio</a></li>
                <%}%>
                <%if (current_user!=null) {%>
                <li><a href="/logout">Logout(<%=current_user.getLogin()%>)</a></li>
                <%} else {%>
                <li><a href="/login">Login</a></li>
                <%}%>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>
<br>
<br>
<br>



<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->

</body>