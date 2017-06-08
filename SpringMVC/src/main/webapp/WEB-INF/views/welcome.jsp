<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alisa
  Date: 07.06.2017
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<h2>Welcome to my initial app in spring web mvc!</h2>
<div>
    <p>This is first paragraph! ${message}</p>
    <c:forEach var="listValue" items="${list}">
        ${listValue}
    </c:forEach>
</div>
</body>
</html>
