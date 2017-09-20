<%--
  Created by IntelliJ IDEA.
  User: greensnow
  Date: 19.09.2017
  Time: 08:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set value="${role}" var="roles" scope="session"></c:set>
<c:set var="whatCanIDo" value="${canDo}" scope="session"></c:set>
<form action="/editUser" method="post">
    <center>
        <table border="1">
            <tr>
                <td>Select operation:</td>
                <td><select name="operation" >
                    <c:set var="count1" value="0"></c:set>
                    <c:set var="name" value=""></c:set>
                    <c:forEach var="action" items="${whatCanIDo}">

                        <c:set var="qq" value="${action.val()}"></c:set>
                        <c:forEach var="q" items="${qq}" begin="0" varStatus="counter">
                            <c:if test="${(counter.index==count1) && (action.capability.equals(true))}">
                                ${name = q.name()}
                                <option value="${name}">${name}</option>
                            </c:if>
                            ${counter.count}
                        </c:forEach>
                        ${count1 = count1+1}
                    </c:forEach>
                </select></td>

                <td><input type="Submit" value="Click to Submit" ></td>
            </tr>
        </table>
    </center>
</form>

</body>
</html>
