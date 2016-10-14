<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="bootstrap-3.3.7/docs/favicon.ico">
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet">

    <title>Auth</title>

    <!-- Bootstrap core CSS -->
    <link href="bootstrap-3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body id="body">

<div class="container">
    <form class="form-signin" action="/login" method="POST">
        <h2 class="form-signin-heading">Sign in</h2>
        <label for="inputEmail" class="sr-only">Login</label>
        <input name="login" type="text" id="inputEmail" class="form-control" placeholder="Login" value="<% if (request.getAttribute("incorrect_password") != null) {%><%=request.getAttribute("login")%><%}%>" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input name="password" type="password" id="inputPassword" class="form-control" placeholder="Password" required>
        <div class="checkbox">
            <label>
                <input name="cookie" type="checkbox" value="remember-me"> Remember me
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        <% if (request.getAttribute("user_not_find") != null) {%>
        <%=request.getAttribute("user_not_find")%>
        <%}%>
        <% if (request.getAttribute("incorrect_password") != null) {%>
        <%=request.getAttribute("incorrect_password")%>
        <%}%>
    </form>

</div> <!-- /container -->


<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>

<%--<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Auth</title>
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet">
</head>
<body>

<form action="/login" method="POST" id="auth_form">
    <label for="auth_login">Login:</label>
    <input type="text" id="auth_login" name="login"><br>
    <label for="auth_password">Password:</label>
    <input type="password" id="auth_password" name="password"><br>
    <input type="submit" value="Log In">
    <br>
    <% if (request.getAttribute("user_not_find") != null) {%>
    <%=request.getAttribute("user_not_find")%>
    <%}%>
    <% if (request.getAttribute("incorrect_password") != null) {%>
    <%=request.getAttribute("incorrect_password")%>
    <%}%>
</form>

</body>
</html>--%>
