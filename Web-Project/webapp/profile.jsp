<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Тимур
  Date: 04.11.2016
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="name" value="${name}" scope="request"/>
<c:set var="admin" value="${admin}" scope="request"/>
<c:set var="login" value="${login}" scope="request"/>
<div style="margin-top: 10%; margin-left: 17%; padding: 10px" class="Profile">
    <p>Name: <c:out value="${name}"/></p>
    <br>
    <p>Login: <c:out value="${login}"/></p>
    <br>
    <p>Is admin: <c:out value="${admin}"/></p>
</div>