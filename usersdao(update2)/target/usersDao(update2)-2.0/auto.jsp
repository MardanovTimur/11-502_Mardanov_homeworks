<%@ page import="ru.itis.inform.Auto" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="http://scriptjava.net/source/scriptjava/scriptjava.js"></script>
    <title>Auto's</title>
    <style>
        body {
            background-image: url(image/background.jpg);
        }
    </style>
</head>
<body>
<%
    List<Auto> listAuto = (List<Auto>) request.getAttribute("autos");
    for (int i = 0; i < listAuto.size(); i++) {
%>
<%=listAuto.get(i).getName()%>
<%=listAuto.get(i).getYear()%>
<br>
<%
    }
%>
<input type="button" value="sout" onclick="js()">

<%! Boolean f = null;%>

<input type="button" onclick="systemout(true)">
<div id = "out1"></div>






<script type="text/javascript">
    function systemout(a) {
        <%System.out.println("Function is working!");%>
    }
</script>

</body>
</html>


