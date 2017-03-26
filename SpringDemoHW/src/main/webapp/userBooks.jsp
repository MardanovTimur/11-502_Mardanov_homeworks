<%--
  Created by IntelliJ IDEA.
  User: timur
  Date: 26.03.17
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="f" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Books <f:out value="${user.name}"/></title>
</head>
<body>
<p>Hello <f:out value="${user.name}"/></p>
<p><i>Your books:</i></p>
<ul>
    <f:forEach items="${books}" var="book">

        <li><f:out value="${book.name}"/></li>

    </f:forEach>
</ul>

</body>
</html>
