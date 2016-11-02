<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ru.itis.inform.models.Film" %>
<%@ page import="ru.itis.inform.models.Genre" %>
<%@ page import="ru.itis.inform.models.Role" %><%--
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
<div id="wrap">
    <h1><%=film.getName()%></h1>

        <p>Producer: <c:out value="${producer}"/></p>
        <p>Genre: <%
            for (int i = 0; i < ((LinkedList<Genre>) request.getAttribute("genres")).size(); i++) {%>
            <a href="/genre?id=<%=((LinkedList<Genre>)request.getAttribute("genres")).get(i).getId()%>"><%=((LinkedList<Genre>) request.getAttribute("genres")).get(i).getName()%>
            </a>
            <%if (i != ((LinkedList<Genre>) request.getAttribute("genres")).size() - 1) {%>
            <%=", "%>
            <%
                    }
                }
            %>.</p>
        <p>Roles:<%
            for (int i = 0; i < ((LinkedList<Role>) request.getAttribute("roles")).size(); i++) {%>
            <a href="/role?id=<%=((LinkedList<Role>)request.getAttribute("roles")).get(i).getId()%>"><%=((LinkedList<Role>) request.getAttribute("roles")).get(i).getName()%>
            </a>
            <%if (i != ((LinkedList<Role>) request.getAttribute("roles")).size() - 1) {%>
            <%=", "%>
            <%
                    }
                }
            %>. </p>
        <p>Published date: <%=film.getDate().toString()%>
        </p>
        <p class="lead"><%=film.getDescription()%>
        </p>
        <p>
        <p>Remark: <%=film.getRemark()%>
        </p>
</div>


