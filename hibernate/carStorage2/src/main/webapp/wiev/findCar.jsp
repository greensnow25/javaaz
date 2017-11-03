<%--
  Created by IntelliJ IDEA.
  User: greensnow
  Date: 31.10.2017
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>


<html>
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%--<link rel="stylesheet" href="../css/style.css">--%>
    <title>Title</title>
</head>
<body style="background:darkcyan">
<script >

    document.addEventListener("DOMContentLoaded", f);
    function f() {
        <%--var context =${pageContext.request.contextPath};--%>
//        $('#img1').append('<img src="'+context+'images/car.jpg'+">');

        var json = ${sessionScope.car};
        let resultTable = '<table border="1">' +
            '<tr> <td>IMAGE</td> <td>MODEL</td> <td>BODY</td> <td>TRANSMISSION</td> <td>ENGINE</td> <td>PRICE</td></tr> ';
        for (let i = 0; i < json.length; i++) {
            resultTable += '<tr>' +
                '<td id="img">' + '<img id="img1" >' + '</td>' +
                '<td>' + json[i].name + '</td>' +
                '<td>' + json[i].body.name + '</td>' +
                '<td>' + json[i].transmission.name + '</td>' +
                '<td>' + json[i].engine.name + '</td>' +
                '<td>' + json[i].price + '</td>' +
                '  </td></tr>';
        }
        resultTable += '</table>';

        document.querySelector('#div1').innerHTML = resultTable;
        var img = new Image();
        img.src = "${pageContext.request.contextPath}/images/car.jpg";
        $('#img1').appendChild(img);


    }

</script>

<div id="div1">
    <table border="1" id="table">
        <tr id='pos'>
            <td>IMAGE</td>
            <td>MODEL</td>
            <td>BODY</td>
            <td>TRANSMISSION</td>
            <td>ENGINE</td>
            <td>PRICE</td>
        </tr>


    </table>
</div>
<%--<img src="${pageContext.request.contextPath}/images/car.jpg">--%>
</body>
</html>
