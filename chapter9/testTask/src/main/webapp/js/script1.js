/**
 * Created by greensnow on 17.10.2017.
 */


function choiceAction() {
    let action = document.querySelector('#userAction').value;
    let resultForm = null;
    if (action == 'addNewUser') {
        resultForm = '<form action="createUser" method="post">' +
            '<input name="newName" type="text" value="noName"><br>' +
            '<input name="newPassword" type="password" value="111"><br>' +
            '<input name="newCountry" type="text" value="Ukraine"><br>' +
            '<input name="newCity" type="text" value="Kiev">' +
            '<input type="submit" value="Submit">' +
            '</form>'
    } else if (action == 'editHimself') {
        resultForm = '<form action="editHimself" method="post">' +
            '<input name="newName" type="text" value="newName">' +
            '<input type="submit" value="Submit">' +
            '</form>'
    } else if (action == 'editOtherUser') {
        resultForm = '<form action="editOtherUser" method="post">' +
            '<input name="userOldName" type="text" value="userOldName"><br>' +
            '<input name="newName" type="text" value="newName">' +
            '<input type="submit" value="Submit">' +
            '</form>'
    } else if (action == 'deleteUser') {
        resultForm = '<form action="deleteUser" method="post">' +
            '<input name="deleteUser" type="text" value="deleteName"><br>' +
            '<input type="submit" value="Submit">' +
            '</form>'
    }else if (action == 'showTable'){
        resultForm = '<form action="showTable" method="get">' +
            '<input type="submit" value="show table">' +
            '</form>'
    }
    //document.querySelector("#div1").style.display = "none";
    document.querySelector("#div2").style.display = "";
    document.querySelector("#div2").innerHTML = resultForm;


}

function login() {

    var request = new XMLHttpRequest();
    var data = '?name=' + document.querySelector('#name').value + '&pwd=' + document.querySelector('#pwd').value;
    request.open('POST', 'login' + data, true);

    request.onreadystatechange = function () {
        if (request.status == 200 && request.readyState == 4) {
            var json = request.responseText;
            var arr = JSON.parse(json);
            var qqq = '<form >';
            qqq += "<select name='userAction' id='userAction'>"
            for (var i = 0; i < arr.length; i++) {
                qqq += '<option>' + arr[i] + '</option>'
            }
            qqq += '</select>';
            qqq += '<input type="submit" value="Click to submit" onclick="choiceAction()">';
            qqq += '</form>';
            // qqq += '<button onclick="editUser()">Click to submit</button>';
            //document.querySelector("#formResult").innerHTML = "";
            // document.querySelector("#formResult").innerHTML = qqq;
            document.querySelector("#div1").style.display = "none";
            document.querySelector("#div2").style.display = "block";
            document.querySelector("#div2").innerHTML = qqq;

        }
    };
    request.send(data);

}