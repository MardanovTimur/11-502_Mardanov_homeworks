<%@ page import="java.util.LinkedList" %>
<%@ page import="ru.itis.inform.User" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Students</title>
</head>
<body>
<%
    List<User> list = (List<User>) request.getAttribute("users");
    for (int i = 0; i < list.size(); i++) {
%>
<%=list.get(i).getName()%>
<%=list.get(i).getId()%>
<%=list.get(i).getPassword()%>
<br>
<%
    }
%>

</body>
</html>