<%--
  Created by IntelliJ IDEA.
  User: greensnow
  Date: 19.10.2017
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../../css/style.css">
    <script>
        function show() {
            var request = new XMLHttpRequest();
            request.open('POST', 'showTable', true);
            request.onreadystatechange = function () {
                if (request.status == 200 && request.readyState == 4) {
                    var json = request.responseText;
                    var arr = JSON.parse(json);
                    var result;
                    result += '<table border="1">' +
                        '<tr> <td>name</td>' +
                        '<td>country</td>' +
                        '<td>city</td>' +
                        '<td>role</td>' +
                        '<td>type</td></tr>';
                    for (let i = 0; i < arr.length; i++) {
                        result += '<tr> <td>' + arr[i].name + '</td>' +
                            '<td>' + arr[i].address.country + '</td>' +
                            '<td>' + arr[i].address.city + '</td>' +
                            '<td>' + arr[i].role.role + '</td>' +
                            '<td>' + arr[i].type.type + '</td>' +
                            '</tr>';
                    }
                    result += '</table>';
                    document.querySelector("#result").style.display = "";
                    document.querySelector("#result").innerHTML = result;
                }
            };
            request.send(null);

        }
    </script>
</head>
<body>
<div id="result">
    <input name="do you really want to see" value="do you really want to see" onclick="show()">
</div>

</body>
</html>
