<%@ page import="ru.itis.inform.models.Film" %><%--
  Created by IntelliJ IDEA.
  User: Тимур
  Date: 23.10.2016
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <%
        if (request.getAttribute("film") != null)%>
    <%Film film = (Film) request.getAttribute("film");%>

    <title><%=film.getName()%>
    </title>
</head>

<body>
<div id="wrap">
    <div class="container">
        <div class="page-header">
            <h1><%=film.getName()%></h1>
        </div>
        <p>Producer: </p>
        <p>Genre: </p>
        <p>Roles: </p>
        <p>Published date: <%=film.getDate().toString()%></p>
        <p class="lead"><%=film.getDescription()%></p>
        <p>Remark: <%=film.getRemark()%></p>
    </div>
</div>
</body>
