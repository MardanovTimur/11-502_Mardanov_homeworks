<%--
  Created by IntelliJ IDEA.
  User:
  Date: 16.10.2016
  Time: 5:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="bootstrap-3.3.7/docs/favicon.ico">
    <link href="css/styles.css" rel="stylesheet">

    <!-- Bootstrap core CSS -->
    <link href="bootstrap-3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">


    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body link="black" vlink="black" alink="#a52a2a">
<% String template;%>
<% if (request.getAttribute("template") != null) {
    template = (String) request.getAttribute("template");
} else {
    template = "";
}%>
<table>
    <tr>
        <td>
            <%@include file="header.jsp" %>
        </td>
    </tr>
    <tr>
        <td>
            <%
                switch (template) {
                    case "addfilm":
            %>
            <%@include file='addfilmform.jsp' %>
            <%
                    break;
                case "errortemplate":
            %>
            <%@include file='errortmp.jsp' %>
            <%
                    break;
                case "orders":
            %>
            <%@include file='orders.jsp' %>
            <%
                    break;
                case "buyOk":
            %>
            <%@include file='buyOk.jsp' %>
            <%
                    break;
                case "filmIsNotAvailable":
            %>
            <%@include file='film404.jsp' %>
            <%
                    break;
                case "buy":
            %>
            <%@include file='buy.jsp' %>
            <%
                    break;
                case "films":
            %>
            <%@include file='films.jsp' %>
            <%
                    break;
                case "addproducer":
            %>
            <%@include file='addproducer.jsp' %>
            <%
                    break;
                case "addrole":
            %>
            <%@include file='addroleform.jsp' %>
            <%
                    break;
                case "film":
            %>
            <%@include file='filmid.jsp' %>
            <%
                    break;
                case "addgenre":
            %>
            <%@include file='addgenreform.jsp' %>
            <%
                    break;
                case "addstudio":
            %>
            <%@include file='addstudio.jsp' %>
            <%
                    break;
                case "profile":
            %>
            <%@include file="profile.jsp" %>
            <%
                    break;
                default:
            %>
            <%response.sendRedirect("/home");%>
            <%}%>
        </td>
    </tr>
</table>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="bootstrap-3.3.7/dist/js/bootstrap.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="bootstrap-3.3.7/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>