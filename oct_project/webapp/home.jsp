<%@ page import="ru.itis.inform.models.User" %><%--
  Created by IntelliJ IDEA.
  User: Тимур
  Date: 09.10.2016
  Time: 0:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
<p>Hello, <%=session.getAttribute("user")%></p>
</body>
</html>
