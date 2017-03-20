<%@ page import="ru.itis.inform.model.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.LinkedList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="f" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>all</title>
</head>
<body>
<H2>Users</H2>
<f:forEach items="${user}" var="key">
    <p>
        <f:out value="${key.name}"></f:out>
        <f:out value="----"></f:out>
        <f:out value="${key.age}"/>
    </p>
    <hr>
</f:forEach>
</body>
</html>