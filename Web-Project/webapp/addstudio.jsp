<%@ page import="ru.itis.inform.models.Studio" %><%--
  Created by IntelliJ IDEA.
  User: Тимур
  Date: 10.12.2016
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="display: inline">
    <% if (request.getAttribute("ok") == null) {%>
    <form class="addstudio" action="/addstudio" method="post">
        <p>
        <div id = "same" style="display: inline">
            <h2>Add studio</h2>
        </div>
        <p>
            <input type="text" name="name" class="input-block-level" id="addfilmfields" placeholder="Name">
            <br>
            <button class="btn btn-large btn-primary" type="submit">Add</button>
                <% if (request.getAttribute("no")!=null) {%>
        <p><%=request.getAttribute("no")%>
        </p>
        <%}%>
    </form>
    <%} else {%>
    <br>
    <div style="left: 15%" class="filmisadded">
        <p>
        <H2><%=request.getAttribute("ok")%>
        </H2></p>
        <button><a href="/addstudio">Add another studio.</a></button>
        <button><a href="/home">Go home!</a></button>
    </div>
    <%}%>
</div>
<% if (request.getAttribute("genres")!=null) {%>
<div class="container">
    <p>Studios</p>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>id</th>
            <th>Studio</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <% for (Studio genre : (LinkedList<Studio>)request.getAttribute("genres")) {%>
        <tr>
            <td><%=genre.getId()%></td>
            <td><%=genre.getName()%></td>
            <td><a class="btn btn-sm btn-danger btn-block" style="width:100px;"
                   href="/delete?studio_id=<%=genre.getId()%>" role="button">Delete</a></td>
        </tr>
        <%}%>

        </tbody>
    </table>
</div>
<%}%>