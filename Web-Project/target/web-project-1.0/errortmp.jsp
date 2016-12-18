<!doctype html>
<%if (request.getAttribute("err")!=null) {%>
<hr>
    <p><%=request.getAttribute("err")%></p>
<hr>
<%}%>