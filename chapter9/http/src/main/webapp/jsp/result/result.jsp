<%--
  Created by IntelliJ IDEA.
  User: greensnow
  Date: 12.09.2017
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<br>
<br>
<center> Result of operation</center>
<br>
<div>
    <%! boolean res = false;%>
    <% res = Boolean.parseBoolean(request.getParameter("result"));
        if (res) {%>
    <b> The operation<% out.print(request.getParameter("operation"));%> was successful </b><%
    } else {}%>

</div>
</body>
</html>
