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
            <%System.out.println("AAA");%>
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
                    '&passwordAgain=' + encodeURIComponent(document.getElementById("passwordAgain_id").value) +
                    '&city=' + encodeURIComponent(document.getElementById("city_id").value) +
                    '&year=' + encodeURIComponent(document.getElementById("year_id").value);

            Request.open("POST", "/studentsAddForm", true);
            Request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
            Request.send(body);
        }

        function responseHandler(Request) {
            document.getElementById("formDiv").innerText = Request.responseText;
        }
    </script>


</head>
<body>

<form method="post">
    <h3>Name: </h3><input type="text" name="name" id="s_name"><br>
    <h4>Password: </h4><input type="password" name="password" id="password_id"><br>
    <h4>Password again: </h4><input type="password" name="passwordAgain" id="password_id"><br>
    <h4>City: </h4><input type="text" name="city" id="city_id"><br>
    <h4>Year: </h4><input type="text" name="year" id="year_id"><br>
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
    <input type="button" value="Send" onclick="loginRequest">
    <div id="formDiv"></div>
</form>
<input type="button" value="Send" id="1" name="2" onclick="loginRequest()"/>


</body>
</html>
