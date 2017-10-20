/**
 * Created by greensnow on 20.10.2017.
 */

function addItem() {
    let form = //action="add" method="post" +
        '<input type="text" name="desc" id = "desc">' +
        '<input type="checkbox" name="done" id="done" checked ="checked">' +
        '<input type="submit" value="AddItem" onclick="callback()">';
    document.querySelector("#div1").style.display = "none";
    document.querySelector("#div2").innerHTML = form;

}

function callback() {
    let request = new XMLHttpRequest();
    let desc = document.querySelector("#desc").value;
    let done = document.querySelector("#done").value
    request.open('POST', 'add?desc=' + desc + "&" + "done=" + done, true);
    request.onreadystatechange = function () {
        if (request.status == 200 && request.readyState == 4) {
            document.querySelector("#div1").style.display = "block";
            document.querySelector("#div2").innerHTML = "";
            document.querySelector("#div2").innerHTML = request.responseText;
        }
    };

    request.send();
}
function show() {
    let request = new XMLHttpRequest();
    request.open('POST', 'show', true);
    request.onreadystatechange = function () {
        let result;
        if (request.status == 200 && request.readyState == 4) {
            let resp = request.responseText;
            let json = JSON.parse(resp);
            result = '<table border="1"><tr>' +
                ' <td>id</td>' +
                ' <td>description</td> ' +
                '<td>created</td> ' +
                '<td>done</td> ' +
                '</tr>';

            for (let i = 0; i < json.length; i++) {
                result += '<tr>' +
                    '<td>' + json[i].id + '</td>' +
                    '<td>' + json[i].desc + '</td>' +
                    '<td>' + json[i].created + '</td>' +
                    '<td>' + json[i].done + '</td>' +
                    '</tr>'
            }
            result += '</table>'
        }
        document.querySelector("#div2").innerHTML = "";
        document.querySelector("#div2").innerHTML = result;
    };
    request.send(null);
}