<%@ page import="com.greensnow25.servlets.EchoServlet" %><%--
  Created by IntelliJ IDEA.
  User: greensnow
  Date: 04.09.2017
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<b>First Name:</b><%= request.getParameter("first_name")%><br/>
<b>Last  Name:</b><%= request.getParameter("last_name")%>
</body>
</html>