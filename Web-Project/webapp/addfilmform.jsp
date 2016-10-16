<%--
  Created by IntelliJ IDEA.
  User: Тимур
  Date: 16.10.2016
  Time: 5:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<form action="/addfilm" method="post">
    <p><h2 class="form-signin-heading">Add film</h2><p>
    <input type="text" name="name" class="input-block-level" placeholder="Name">
    <br>
    <input type="text" name="producer" class="input-block-level" placeholder="Name">
    <br>
    <input type="text" name="studio" class="input-block-level" placeholder="Studio">
    <br>
    <input type="date" name="date" class="input-block-level" placeholder="Date">
    <br>
    <input type="text" name="roles" class="input-block-level" placeholder="Roles: Example: Role One,Role Two">
    <br>
    <input type="text" name="genres" class="input-block-level" placeholder="Genres">
    <br>
    <input type="text" name="description" class="input-block-level" placeholder="Description">
    <br>
    <input type="text" name="remark" class="input-block-level" placeholder="Remark">
    <br>
    <button class="btn btn-large btn-primary" type="submit">Add</button>
</form>
</body>
</html>
