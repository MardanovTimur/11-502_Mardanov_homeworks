<%@ page import="ru.itis.inform.Auto" %>
<%@ page import="java.util.List" %>
<%--
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Auto's</title>
    <style>
        body {
            background-image: url(image/background.jpg);
        }
    </style>
</head>
<body>
<%
    List<Auto> listAuto = (List<Auto>) request.getAttribute("autos");
    for (int i = 0; i < listAuto.size(); i++) {
%>
<%=listAuto.get(i).getName()%>
<%=listAuto.get(i).getYear()%>
<br>
<%
    }
%>
</body>
</html>
