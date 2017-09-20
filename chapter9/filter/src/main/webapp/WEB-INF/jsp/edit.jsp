<%--
  Created by IntelliJ IDEA.
  User: greensnow
  Date: 20.09.2017
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <c:if test="${requestScope.operation eq 'EDIT_HIMSELF'}">
        <form action="/editUser" method="post">
            Enter new user name: <input name="newName" type="text">
            Enter new user password : <input name="newPassword" type="text">
            <input type="submit" value="Send">
        </form>
    </c:if>
    <c:if test="${requestScope.operation eq 'EDIT_OTHER_USERS'}">
        <form action="/editUser" method="post">
            Enter user for edit : <input name="oldName" type="text">
            Enter new user name: <input name="newName" type="text">
            Enter new user password : <input name="newPassword" type="text">
            <input type="submit" value="Send">
        </form>
    </c:if>
    <c:if test="${requestScope.operation eq 'EDIT_ROLE'}">
        <form action="/editRole1" method="post">
            <h3>Change role</h3>
            Enter new user name: <input name="userName" type="text">
            Enter new user role :<select name="newRole">
            <option name="admin">admin</option>
            <option name="moderator">moderator</option>
            <option name="user">user</option>
        </select>
            <input type="submit" value="Send">
        </form>
    </c:if>
</center>
</body>
</html>
