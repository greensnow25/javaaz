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
    <c:set var="userList" value="${sessionScope.userList}"></c:set>
    <table border="1">
        <c:if test="${userList!=null}">
            <tr>
                <td><h4>User</h4></td>
                <td>login</td>
                <td>eMail</td>
                <td>createDate</td>
            </tr>
            <c:forEach items="${userList}" var="user" begin="0" varStatus="status">
                <tr>
                    <td>User ${status.count}</td>
                    <td><c:out value="${user.login}" default="empty"></c:out></td>
                    <td><c:out value="${user.eMail}" default="empty"></c:out><br/></td>
                    <td><c:out value="${user.createDate}" default="empty"></c:out><br/></td>
                </tr>

            </c:forEach>
            <c:remove var="userList" scope="session"></c:remove>
        </c:if>
    </table>
    <c:if test="${result = 'true'}">
        <c:out value="Successful!!!"></c:out>
    </c:if>
    <c:if test="${result = 'false'}">
        <c:out value="Operation is not performed, retry."></c:out>
    </c:if>
</center>
</body>
</html>
