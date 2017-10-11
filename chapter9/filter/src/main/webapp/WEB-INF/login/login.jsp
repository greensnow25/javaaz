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
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
    <script type="text/javascript" src="../../js/ajax.js"></script>
    <script src="http://code.jquery.com/jquery-1.10.2.js"
            type="text/javascript"></script>

</head>

<body>
<div id="formResult"></div>
<div id="bossForm" class="login">
    <h3>Enter name:</h3> <input name="name" type="text" id="name"><br>
    <h3>Enter password :</h3> <input name="password" type="password" id="password">
    <input name="send" type="submit" id="send" onclick="login1()">
</div>

</body>
</html>
