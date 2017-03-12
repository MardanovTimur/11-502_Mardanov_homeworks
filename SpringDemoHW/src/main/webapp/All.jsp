<%@ page import="ru.itis.inform.model.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.LinkedList" %><%--
  Created by IntelliJ IDEA.
  User: Тимур
  Date: 09.03.2017
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All</title>
</head>
<body>
<%
    if (request.getAttribute("users") != null) {
        LinkedList<User> users = (LinkedList<User>) request.getAttribute("users");
        for (int i = 0; i < users.size(); i++) {%>
            <%=users.get(i).getName()%>
            <%="<-name----age->"%>
            <%=users.get(i).getAge()%>
    <br>
<%
        }
    }
%>
</body>
</html>
