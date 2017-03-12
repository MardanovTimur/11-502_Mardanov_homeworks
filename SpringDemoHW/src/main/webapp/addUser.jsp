<%--
  Created by IntelliJ IDEA.
  User: Тимур
  Date: 09.03.2017
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add User</title>
</head>
<body>
<form action="/add" method="post">
    <input type="text" name="name"/>
    <input type="number" max="100" name="age"/>
    <input type="submit" value="Save"/>
</form>
</body>
</html>
