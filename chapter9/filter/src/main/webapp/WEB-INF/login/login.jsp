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
    <link rel="stylesheet" href="../../css/style.css">

    <script src="../../js/sripts.js" type="text/javascript"></script>
    <%--<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>--%>
    <%--<script--%>
    <%--src="http://maps.googleapis.com/maps/api/js?key=YOUR_APIKEY&sensor=false">--%>
    <%--</script>--%>

</head>
<body>
<div id="formResult" class="login"></div>
<c:set var="ent" value="${enter}" scope="session">

</c:set>
<c:if test="${ent == null || ent.equals('')}">
    <div class="login">
        <form action="/login" onsubmit="return validate()" method="post" id="login">
            <h3>Enter name:</h3> <input name="login" type="text" id="name"><br>
            <h3>Enter password :</h3> <input name="password" type="password" id="password">
            <input name="submit" type="submit" id="send" value="login">
        </form>
    </div>
</c:if>
<c:if test="${ent.equals(true)}">
    <div class="login">
        <p> HI ${cookie.get('user').value}, login successful!!</p>
        <br>

        <form name="resume" method="post" action="actions">
            <input type="submit" name="resume" value="resume">
        </form>

        <form name="logOut" action="logout" method="post">
            <input type="submit" name="logOut" value="logOut">
        </form>
    </div>
</c:if>
<c:if test="${ent eq false}">
    <font color=red>Either user name or password is wrong.</font>
</c:if>


</body>
</html>
