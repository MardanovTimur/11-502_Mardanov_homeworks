<%--
  Created by IntelliJ IDEA.
  User: timur
  Date: 20.03.17
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Add user</title>
</head>
<body>
<form:form method="post" action="add" commandName="user">

    <table>
        <tr>
            <td><form:label path="name">

            </form:label></td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td><form:label path="age">

            </form:label></td>
            <td><form:input path="age"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit"
                                   value="Submit"/></td>
        </tr>
    </table>
</form:form>


</body>
</html>
