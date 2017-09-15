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

<form action="/title" method="post" >
    Enter name:      <input name="user" type="text"><br>
    Enter password : <input name="password" type="password">
    <input name="submit" type="submit" value="login">
</form>
</body>
</html>
