<%@ page import="java.util.LinkedList" %>
<%@ page import="ru.itis.inform.models.Film" %><%--
  Created by IntelliJ IDEA.
  User: Тимур
  Date: 21.10.2016
  Time: 0:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    if (request.getAttribute("films") != null) {
        LinkedList<Film> films = (LinkedList<Film>) request.getAttribute("films");
        String current_number = (String) request.getAttribute("current_number");
        for (int i = 1; i <= 10; i++) {
            try {
                films.get(10 * (Integer.parseInt(current_number) - 1) + i - 1);
%>

<div class="film">
    <div class="container">
    <H2><a style="link: black" href="/film?id=<%=films.get(10*(Integer.parseInt(current_number)-1)+i-1).getId()%>"
           about="See this film"><%=films.get(10 * (Integer.parseInt(current_number) - 1) + i - 1).getName()%>
    </a></H2>
    <br>
    <%=films.get(10 * (Integer.parseInt(current_number) - 1) + i - 1).getDescription().substring(0, films.get(10 * (Integer.parseInt(current_number) - 1) + i - 1).getDescription().length() / 2)%>
    ...
    <br>
    </div>
</div>
<br>
<% } catch (IndexOutOfBoundsException e) {
}
}
}
%>
<div>
<div class="knopochki">
    <%if (request.getAttribute("films") != null) %>
    <% String current_number = (String) request.getAttribute("current_number");%>
    <button><a href="/home?current_number=1"><<-</a></button>
    <% if (Integer.parseInt(current_number) > 1) {%>
    <button><a
            href="/home?current_number=<%=Integer.parseInt(current_number)-1%>"><%=Integer.parseInt(current_number) - 1%>
    </a></button>
    <%}%>
    <button><a href="/home?current_number=<%=current_number%>"><%=Integer.parseInt(current_number)%>
    </a></button>
    <%if (request.getAttribute("films") != null)%>
    <%LinkedList<Film> films = (LinkedList<Film>) request.getAttribute("films");%>
    <% if (Integer.parseInt(current_number) <= films.size() / 10) {%>
    <button><a
            href="/home?current_number=<%=Integer.parseInt(current_number)+1%>"><%=Integer.parseInt(current_number) + 1%>
    </a></button>
    <%}%>
    <button><a href="/home?current_number=fin">->></a></button>
</div>
    </div>
<br>
<br>


