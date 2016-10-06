<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Auth</title>
</head>
<body>
<div id="auth_div_form">
    <form action="/" method="POST">
        <label for="auth_login">Login:</label>
        <input type="text" id="auth_login" name="login">
        <label for="auth_password">Password:</label>
        <input type="password" id="auth_password" name="password">
        <input type="submit" value="Log In">
    </form>
</div>
</body>
</html>
