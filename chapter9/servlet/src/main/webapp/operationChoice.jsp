<%--
  Created by IntelliJ IDEA.
  User: greensnow
  Date: 13.09.2017
  Time: 08:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set var="result" value="${param.operation}"></c:set>
<c:choose>
    <c:when test="${result.equals('add')}">
        <br>
        <br>
        <br>
        <center>
            <form action="/add" method="post">
                Enter user login : <input name="login" value="login" type="text">
                <br>
                Enter new user email : <input name="eMail" value="login" type="text">
                <input name="add" type="submit" value="Send">
            </form>
        </center>
    </c:when>

    <c:when test="${result.equals('read')}">
        <center>
            <a href="/show">Click if you wont to view the table </a>
        </center>
    </c:when>

    <c:when test="${result.equals('update')}">
        <center>
            <form action="/update" method="post">
                Enter user login : <input name="login" type="text">
                <br>
                Enter new user email : <input name="newMail" type="text">
                <input name="add" type="submit" value="Send">
            </form>
        </center>
    </c:when>


    <c:when test="${result.equals('delete')}">
        <center>
            <form action="/delete" method="post">
                Enter user login : <input name="login" type="text">
                <input type="hidden" name="operation" value="delete"/>
                <input name="add" type="submit" value="Send">
            </form>
        </center>

    </c:when>

</c:choose>
</body>
</html>