<%--
  Created by IntelliJ IDEA.
  User: greensnow
  Date: 31.10.2017
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="../css/style.css">
<html>
<head>
    <title>Title</title>
</head>
<body style="background:darkcyan">
<script>
    var position = 1;
    document.addEventListener("DOMContentLoaded", w);
    function w() {
        document.querySelector('#div1');
        $('#div1').append('<img src="../images/car1.png" alt=" ">');
    }
    function f() {
        var json = ${sessionScope.car};
        let resultTable = '<table border="1">' +
            '<tr> <td>IMAGE</td> <td>MODEL</td> <td>BODY</td> <td>TRANSMISSION</td> <td>ENGINE</td> <td>PRICE</td></tr> ';
        for (let i = 0; i < json.length; i++) {
            resultTable += '<tr>' +
                '<td id="img">' + '<img src="../images/car1.png" alt=" ">' + '</td>' +
                '<td>' + json[i].name + '</td>' +
                '<td>' + json[i].body.name + '</td>' +
                '<td>' + json[i].transmission.name + '</td>' +
                '<td>' + json[i].engine.name + '</td>' +
                '<td>' + json[i].price + '</td>' +
                '  </td></tr>';
        }
        resultTable += '</table>';

        document.querySelector('#div1').innerHTML = resultTable;

    }
    function simpleAppend(model, body, trans, engine, price) {
        // let res = '<tr ></tr>'
        $('#table').append('<tr><td id="pos' + position + '"></td>' +
            '            <td id="pos' + position + '">' + model + '</td>  ' +
            '          <td id="pos' + position + '">' + body + '</td>     ' +
            '       <td id="pos' + position + '">' + trans + '</td>   ' +
            '         <td id="pos' + position + '">' + engine + '</td>     ' +
            '       <td id="pos' + position + '">' + price + '</td></tr>');
        position++;
    }


    function newVersion() {
        var json = ${sessionScope.car};
        for (let i = 0; i < json.length; i++) {
            simpleAppend(json[i].name, json[i].body.name, json[i].transmission.name, json[i].engine.name, json[i].price)
            let posit = position--;
            let q = '#' + posit;
            $(q).append('<img src="../images/car1.png" alt=" ">')


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
</body>
</html>
