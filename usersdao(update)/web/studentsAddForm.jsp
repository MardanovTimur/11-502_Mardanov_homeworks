<%--
  Created by IntelliJ IDEA.
  User: Тимур
  Date: 27.09.2016
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>students form</title>
</head>
<body>
<form name="studentsAddForm" action="/studentsAddForm/" method="POST">
    <h3>Name: </h3><input type="text" name="name">
    <br>
    <h3>Your personal: </h3><input type="number" name="id"><br>
    <h3>Password: </h3><input type="text" name="password"><br>
    <h3>Password again: </h3><input type="text" name="passwordAgain"><br>
    <h3>City: </h3><input type="text" name="city"><br>
    <h3>Year: </h3><input type="number" name="data"><br>
    <%=request.getParameter("error")%>
    <input type="submit" value="submit">
</form>
</body>
</html>
