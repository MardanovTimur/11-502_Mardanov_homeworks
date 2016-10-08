<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Auth</title>
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet">
</head>
<body id="body">

<form action="/login" method="POST" id="auth_form">
    <label for="auth_login">Login:</label>
    <input type="text" id="auth_login" name="login"><br>
    <label for="auth_password">Password:</label>
    <input type="password" id="auth_password" name="password"><br>
    <input type="submit" value="Log In">
</form>
<br>
<% if (request.getAttribute("user_not_find") != null) {%>
<%=request.getAttribute("user_not_find")%>
<%}%>
<% if (request.getAttribute("incorrect_password") != null) {%>
<%=request.getAttribute("incorrect_password")%>
<%}%>
</body>
</html>
