<%--
Created by IntelliJ IDEA.
User: Тимур
Date: 16.10.2016
Time: 5:50
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c1" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<c1:set var="film_name" value="${film_name}" scope="request"/>
<c1:set var="film_date" value="${film_date}" scope="request"/>
<c1:set var="film_description" value="${film_description}" scope="request"/>
<c1:set var="film_url" value="${film_url}" scope="request"/>
<c1:set var="film_remark" value="${film_remark}" scope="request"/>
<c1:set var="film_producer" value="${film_producer}" scope="request"/>
<c1:set var="film_studio" value="${film_studio}" scope="request"/>
<c1:set var="film_genres" value="${film_genres}" scope="request"/>
<c1:set var="film_roles" value="${film_roles}" scope="request"/>
<c1:set var="film_quantity" value="${film_quantity}" scope="request"/>
<c1:set var="film_price" value="${film_price}" scope="request"/>
<% if (request.getAttribute("filmIsAdded") == null) {%>
<div class="addfilmform">
        <%if (request.getAttribute("film_name")!=null){%>
            <form action="/updatefilm" method="post">
        <%} else { %>
            <form action="/addfilm" method="post">
        <%}%>
        <h2>Add film</h2>
        <div id="datafilmforms">
            <input type="text" name="name" class="input-block-level" id="addfilmfields" placeholder="Name" value="${film_name}">
            <br>
            <input type="text" name="producer" class="input-block-level" id="addfilmfields" placeholder="Producer" value="${film_producer}">
            <br>
            <input type="text" name="studio" class="input-block-level" id="addfilmfields" placeholder="Studio" value="${film_studio}">
            <br>
            <input type="date" name="date" class="input-block-level" id="addfilmfields" placeholder="Date" value="${film_date}">
            <br>
            <input type="text" name="roles" class="input-block-level" id="addfilmfields"
                   placeholder="Roles: Example: Role One,Role Two" value="${film_roles}">
            <br>
            <input type="text" name="genres" class="input-block-level" id="addfilmfields" placeholder="Genres" value="${film_genres}">
            <br>
            <input type="text" name="description" class="input-block-level" id="addfilmfields"
                   placeholder="Description" value="${film_description}">
            <br>
            <input type="number" name="remark" class="input-block-level" id="addfilmfields" placeholder="Remark" value="${film_remark}">
            <br>
            <input type="text" name="url" class="input-block-level" id="addfilmfields" placeholder="URL-image(700x400)" value="${film_url}">
            <br>
            <details>
                <summary>Is available in library?</summary>
                <input type="number" name="quantity" class="input-block-level"  placeholder="quantity" style="margin: 3px" value="${film_quantity}">
                <br>
                <input type="number" name="price" class="input-block-level" placeholder="price" style="margin: 3px" value="${film_price}">
                <br>
            </details>
            <%if (request.getAttribute("film_name")!=null){%>
            <button class="btn btn-large btn-primary" type="submit">Update</button>
            <%} else { %>
            <button class="btn btn-large btn-primary" type="submit">Add</button>
            <%}%>
            <% if (request.getAttribute("genresError") != null) {%>
            <p><%=request.getAttribute("genresError")%>
            </p>
            <%}%>
        </div>
    </form>
        <%} else {%>
    <br>
    <div class="filmisadded">
        <p>
        <H2><%=request.getAttribute("filmIsAdded")%>
        </H2></p>
        <button><a href="/addfilm">Add another film</a></button>
        <button><a href="/home">Go home</a></button>
    </div>
        <%}%>
</body>
</html>
