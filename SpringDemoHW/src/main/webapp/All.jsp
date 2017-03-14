<%@ page import="ru.itis.inform.model.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.LinkedList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="f" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All</title>
</head>
<body>
<f:forEach items="${user}" var="userMap">
    <f:out value="${userMap.value.name}"></f:out>
    <f:out value="----"></f:out>
    <f:out value="${userMap.value.age}"/>
    <hr>
</f:forEach>
</body>
</html>
