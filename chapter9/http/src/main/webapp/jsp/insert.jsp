<%--
  Created by IntelliJ IDEA.
  User: greensnow
  Date: 08.09.2017
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Insert Data</title>
</head>
<body>
<br>
<br>
<br>
<center>
    <form id="myForm" method="post" action="/user">
        Enter user login: <input name="login" type="text">

        <br>
        Enter user email<input name="newLogin" type="text">
        <input name="update" type="submit">

    </form>
</center>
</body>
</html>
