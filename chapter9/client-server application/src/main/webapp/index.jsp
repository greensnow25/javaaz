<%--
  Created by IntelliJ IDEA.
  User: greensnow
  Date: 31.08.2017
  Time: 08:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <table>
        <tr>
            <td>Count visitors</td>
            <td><%=((request.getAttribute("current_count")) == null ? "error" : (request.getAttribute("current count")))%>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
