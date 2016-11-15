<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ru.itis.inform.models.Film" %>
<%@ page import="ru.itis.inform.models.Genre" %>
<%@ page import="ru.itis.inform.models.Role" %>
<%@ page import="ru.itis.inform.factories.ServiceFactory" %><%--
  Created by IntelliJ IDEA.
  User: Тимур
  Date: 23.10.2016
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    if (request.getAttribute("film") != null)%>
<%Film film = (Film) request.getAttribute("film");%>

<title><%=film.getName()%>
</title>

<c:set scope="request" var="producer" value="${producer}"/>
<c:set scope="request" var="genres" value="${genres}"/>
<div style="overflow: hidden; width: 1000px;">
    <div class="box" style="white-space:nowrap;margin-left: 20%;">
        <div style="width: 300px; display: inline-block;">
            <img class="img-responsive" src="<%=film.getImageURL()%>" width="700" height="400"
                 style="max-height: 198px" alt=""></div>
        <div style="width: 350px;display: inline-block; padding-right: 60%;
                padding-bottom: 30%">
            <h1><%=film.getName()%>
            </h1>

            <p>Producer: <c:out value="${producer}"/></p>
            Genre:<%
            for (int i = 0; i < ((LinkedList<Genre>) request.getAttribute("genres")).size(); i++) {%>
            <a href="/genre?id=<%=((LinkedList<Genre>)request.getAttribute("genres")).get(i).getId()%>"><%=((LinkedList<Genre>) request.getAttribute("genres")).get(i).getName()%>
            </a>
            <%if (i != ((LinkedList<Genre>) request.getAttribute("genres")).size() - 1) {%>
            <%=", "%>
            <%
                    }
                }
            %>.
            <br>
            Roles:<%
            for (int i = 0; i < ((LinkedList<Role>) request.getAttribute("roles")).size(); i++) {%>
            <a href="/role?id=<%=((LinkedList<Role>)request.getAttribute("roles")).get(i).getId()%>"><%=((LinkedList<Role>) request.getAttribute("roles")).get(i).getName()%>
            </a>
            <%if (i != ((LinkedList<Role>) request.getAttribute("roles")).size() - 1) {%>
            <%=", "%>
            <%
                    }
                }
            %>.
            <p>Published date: <%=film.getDate().toString()%>
            </p>
            <div class="description">
                <%=film.getDescription()%>
            </div>
            <p>
            <p>Remark: <%=film.getRemark()%>
            </p>
            <a class="btn btn-sm btn-primary btn-block" href="/buy?film_id=<%=film.getId()%>" role="button">Get film</a>
        </div>
    </div>
</div>
<hr>

<!-- Blog Comments -->

<!-- Comments Form -->
<div class="well" style="max-width: 70%; margin-left: 17%; ">
    <h4>Leave a Comment:</h4>
    <form role="form" action="/film?id=<%=film.getId()%>" method="POST">
        <div class="form-group">
            <textarea class="form-control" rows="3" name="textMessage"></textarea>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

<hr>

<!-- Posted Comments -->

<c:set scope="request" value="${comments}" var="commentsLL"/>
<c:forEach var="item" items="${commentsLL}">
    <div class="media" style="margin-left: 17%;">
        <a class="pull-left" href="#">
            <img class="media-object" src="http://placehold.it/64x64" alt="">
        </a>
        <div class="media-body" style="link: black">
            <h4 class="media-heading"><a href="/profile?id=<c:out value="${item.getUserId()}"/>"><c:out
                    value="${item.getLogin()}"/></a>
                <small><c:out value="${item.getDate()}"/></small>
            </h4>
            <c:out value="${item.getMessage()}"/>
        </div>
    </div>
</c:forEach>

<%--<!-- Comment -->
<div class="media">
    <a class="pull-left" href="#">
        <img class="media-object" src="http://placehold.it/64x64" alt="">
    </a>
    <div class="media-body">
        <h4 class="media-heading">Start Bootstrap
            <small>August 25, 2014 at 9:30 PM</small>
        </h4>
        Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
        <!-- Nested Comment -->
        <div class="media">
            <a class="pull-left" href="#">
                <img class="media-object" src="http://placehold.it/64x64" alt="">
            </a>
            <div class="media-body">
                <h4 class="media-heading">Nested Start Bootstrap
                    <small>August 25, 2014 at 9:30 PM</small>
                </h4>
                Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
            </div>
        </div>
        <!-- End Nested Comment -->
    </div>
</div>--%>

</div>


