<%--
  Created by IntelliJ IDEA.
  User: greensnow
  Date: 15.09.2017
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set var="ent" value="${enter}" scope="session">

</c:set>
<c:if test="${ent == null || ent.equals('')}">
    <form action="/login" method="post">
        Enter name: <input name="login" type="text"><br>
        Enter password : <input name="password" type="password">
        <input name="submit" type="submit" value="login">
    </form>
</c:if>
<c:if test="${ent.equals(true)}">
    HI ${cookie.get('user').value}, login successful!!
    <br>

    <form name="resume" method="post" action="actions">
        <input type="submit" name="resume" value="resume">
    </form>

    <form name="logOut" action="logout" method="post">
        <input type="submit" name="logOut" value="logOut">
    </form>
</c:if>
<c:if test="${ent eq false}">
    <font color=red>Either user name or password is wrong.</font>
</c:if>

</body>
</html>
