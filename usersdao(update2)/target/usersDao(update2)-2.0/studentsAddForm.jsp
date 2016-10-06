<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>students form</title>
    <meta charset="utf-8">
    <script>
        function createRequest() {
            var Request = new XMLHttpRequest();
            if (!Request) {
                alert("Невозможно создать Request!");
            }
            return Request;
        }

        function loginRequest() {
            var Request = createRequest();
            Request.onreadystatechange = function () {
                if (Request.readyState == 4) {
                    if (Request.status == 200) {
                        responseHandler(Request);
                    } else {
                        alert("Error");
                    }
                } else {
                    document.getElementById("formDiv").value = "Loading...";
                }
            };
            body = 'name=' + encodeURIComponent(document.getElementById("s_name").value) +
                    '&password=' + encodeURIComponent(document.getElementById("password_id").value) +
                    '&passwordAgain=' + encodeURIComponent(document.getElementById("password_id2").value) +
                    '&city=' + encodeURIComponent(document.getElementById("city_id").value) +
                    '&year=' + encodeURIComponent(document.getElementById("year_id").value);

            Request.open('POST', '/studentsAddForm', true);
            Request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            Request.send(body);
        }
        function responseHandler(Request) {
            document.getElementById("formDiv").innerText = Request.responseText;
        }
    </script>
</head>
<body>

<form>

    <label for="s_name">Name</label> <input type="text" name="name" id="s_name"><br>
    <label for="password_id">Password</label> <input type="password" name="password" id="password_id"><br>
    <label for="password_id2">Password Again</label> <input type="password" name="passwordAgain" id="password_id2"><br>
    <label for="city_id">City</label> <input type="text" name="city" id="city_id"><br>
    <label for="year_id">Year</label> <input type="text" name="year" id="year_id"><br>
</form>
<%! String error = "";%>
<%! String error_f_u = "";%>
<% if (request.getAttribute("error") != null) {
    error = (String) request.getAttribute("error");
}
%>
<% if (request.getAttribute("error_fail_user") != null) {
    error_f_u = (String) request.getAttribute("error_fail_user");
}%>
<% if (error.length() != 0 && error_f_u.length() != 0) { %>
<%=error%>, <%=error_f_u%>
<%} else {%>
<% if (error.length() == 0) { %>
<%=error_f_u%>
<%} else %>
<% if (error_f_u.length() == 0) { %>
<%=error%>
<%
        }
    }
%>

<input type="button" value="Send" id="buttons" onclick="loginRequest()">
<div id="formDiv"></div>


</body>
</html>
