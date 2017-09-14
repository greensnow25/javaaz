<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: greensnow
  Date: 12.09.2017
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<br>
<br>
<center><h3>Result of operation</h3>
    <br>
    <%
        if (request.getSession().getAttribute("userList") != null)
        {%>
    <c:set var="userList" value="${sessionScope.userList}"></c:set>
    <c:forEach items="${userList}" var="user" begin="0">
        <h4>User</h4>
        <c:out value="${user.login}" default="empty"></c:out><br/>
        <c:out value="${user.eMail}" default="empty"></c:out><br/>
        <c:out value="${user.createDate}" default="empty"></c:out><br/>
        <br>
    </c:forEach>
<c:remove var="userList" scope="session"></c:remove>
    <%} else if (!request.getSession().getAttribute("result").equals("true")) {%>
    Successful!!!
    <%} else {%>
    Operation is not performed, retry.
    <%}%>
</center>
</body>
</html>
