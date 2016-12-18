<%--
  Created by IntelliJ IDEA.
  User: Тимур
  Date: 12.11.2016
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="name" value="${film_name}" scope="request"/>
<c:set var="filmId" value="${filmId}" scope="request"/>
<c:set var="quantity" value="${quantity}" scope="request"/>
<c:set var="price" value="${price}" scope="request"/>
<c:set var="user" value="${current_user}" scope="session"/>
<div>
    <div class="buyInfoBlock">
        <H2><c:out value="${name}"/></H2>
        <hr>
        Price: <c:out value="${price}"/>rub.
        <br>
        Quantity: <c:out value="${quantity}"/>
        <br>
    </div>
    <div class="buyUserBlock">
        <H3><c:out value="${user.getName()}"/></H3>
        <br>
        <form action="/buy?id=<c:out value="${filmId}"/>" method="post">
            <label class="label" for="card" style="color: #000;">Input your credit card number</label>
            <input type="number" id="card" name="card">
            <br>
            <label class="label" for="quantity" style="color:black" >Quantity: </label>
            <input type="number" id="quantity" name="quantity">
            <br>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Buy</button>
        </form>
    </div>
</div>
