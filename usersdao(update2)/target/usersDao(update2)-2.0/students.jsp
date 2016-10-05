<%@ page import="ru.itis.inform.User" %>
<%@ page import="java.util.List" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Students</title>
    <style>
        body {
            background-image: url(image/background.jpg);
        }
    </style>
</head>
<body>
<table border="1">
    <%
        List<User> list = (List<User>) request.getAttribute("users");
        for (int i = 0; i < list.size(); i++) {
    %>
    <tr>
        <td>
            <%=list.get(i).getName()%>
        </td>

        <td>
            <%=list.get(i).getId()%>
        </td>

        <td>
            <%=list.get(i).getPassword()%>
        </td>

        <td>
            <%=list.get(i).getYear()%>
        </td>

        <td>
            <%=list.get(i).getCity()%>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>