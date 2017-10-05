<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: greensnow
  Date: 12.09.2017
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="../../../css/style.css">
<html>
<head>
    <title>Title</title>
</head>
<body>
<br>
<br>
<center><h3>Result of operation</h3>
    <br>
    <c:set var="base1" value="${sessionScope.base}"></c:set>
    <table border="1">
        <c:if test="${base1!=null}">
            <tr>
                <td><h4>User</h4></td>
                <td>login</td>
                <td>password</td>
                <td>role</td>
            </tr>
            <c:forEach items="${base1}" var="user" begin="0" varStatus="status">
                <tr>
                    <td>User ${status.count}</td>
                    <td><c:out value="${user.login}" default="empty"></c:out></td>
                    <td><c:out value="${user.password}" default="empty"></c:out><br/></td>
                    <td><c:out value="${user.role}" default="empty"></c:out><br/></td>
                </tr>

            </c:forEach>
        </c:if>
    </table>
</center>
</body>
</html>
