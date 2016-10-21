<%--
  Created by IntelliJ IDEA.
  User: Тимур
  Date: 16.10.2016
  Time: 5:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HomePage</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="bootstrap-3.3.7/docs/favicon.ico">
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet">
    <title>Home</title>

    <!-- Bootstrap core CSS -->
    <link href="bootstrap-3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">


    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<% String template;%>
<% if (request.getAttribute("template")!=null) {
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
            <%switch (template) {
                case "addfilm":%>
                    <%@include file='addfilmform.jsp' %>
                    <%break;
                case "films":%>
                    <%@include file="films.jsp"%>
                    <%break;%>
        </td>
    </tr>
    <tr>
        <td>
            <div class="copyright">
            <strong>(c)Timur Mardanov 11-502</strong>
            </div>
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
