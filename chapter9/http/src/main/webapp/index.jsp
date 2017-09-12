<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: greensnow
  Date: 08.09.2017
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP Test - SubmitTest.jsp</title>
</head>
<body>
<form action="index.jsp">
    <table border="1">
        <tr>
            <td>Select operation:</td>
            <td><select name="operation">
                <option value=""></option>
                <option value="add">add</option>
                <option value="read">read</option>
                <option value="update">update</option>
                <option value="delete">delete</option>
            </select></td>

            <td><input type="Submit" value="Click to Submit"></td>
        </tr>
    </table>
</form>
<br>
<%
    String myText = request.getParameter("operation");
    if (myText == null || myText.equals("")) {
%><b>you enter empty string, make a choice: </b>
<%} else if (myText.equals("add")) {%>
<c:redirect url="jsp/add.jsp"></c:redirect>
<%} else if (myText.equals("insert")) {%>
<c:redirect url="jsp/insert.jsp"></c:redirect>
<%} else if (myText.equals("update")) {%>
<c:redirect url="jsp/update.jsp"></c:redirect>
<%} else if (myText.equals("delete")) {%>
<c:redirect url="jsp/delete.jsp"></c:redirect>
<%

    }
%>
</body>
</html>
