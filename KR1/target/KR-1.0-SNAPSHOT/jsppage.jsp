<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.sql.*" %>
<%@ page import="ru.itis.inform.Film" %>
<%@ page import="java.util.LinkedList" %><%--
  Created by IntelliJ IDEA.
  User: Тимур
  Date: 28.10.2016
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Page</title>
</head>
<body>
<%!Connection connection = null;%>
<%!PreparedStatement statement = null;%>

<%try{
    Class.forName("org.postgresql.Driver");
    connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/videodata","postgres","alisa654789");}

    catch (SQLException s) {
        s.printStackTrace();
    }
    catch (ClassNotFoundException s) {
        s.printStackTrace();
    }
%>
<%
if (connection!= null) {%>
<%!String request1 = "SELECT * FROM films ";%>
<%try {
statement = connection.prepareStatement(request1);
ResultSet rs =statement.executeQuery();%>
<%!LinkedList<Film> linkedList = new LinkedList<Film>();%>
<%
    Film film = null;
    while (rs.next()) {
    try {
    film = new Film(rs.getInt("id"),rs.getString("film_name"),rs.getInt("film_producer"),rs.getInt("film_studio"),rs.getString("description"),rs.getInt("remark"),rs.getDate("film_year"));
    } catch (Exception e) {
    film = null;
    e.printStackTrace();
    }
    linkedList.addFirst(film);
    }
            request.setAttribute("linklist1",linkedList);
    } catch (SQLException e) {
    e.printStackTrace();}}
%>

<c:set var="linklist1" value="${linklist1}" scope="request"/>
<c:forEach var="linklist" items="${linklist1}">
    <c:out value="${linklist.toString()}"/>
</c:forEach>

</body>
</html>
