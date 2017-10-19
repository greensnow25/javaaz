

/**
 * Created by greensnow on 06.10.2017.
 */

    function loginAjax(url) {

    var request = getXMLHTTPObject();

    request.open('POST', url, true);
    request.send(null);

    request.onreadystatechange = function () {
        if (request.readyState == 4) {
            if (request.status == 200) {
                var buttons = '<button onclick="resume()" id="btn1">resume</button>  ' +
                    '<button onclick="logOut()" id="btn2">logOut</button>';
                document.querySelector("#bossForm").style.display = "none";
                document.querySelector("#formResult").innerHTML = buttons + request.responseText;
            }
        }
    };
}
function getXMLHTTPObject() {
    var xmlhttpObject = null;
    try {
        // For Old Microsoft Browsers
        xmlhttpObject = new ActiveXObject("Msxml2.XMLHTTP");
    } catch (e) {
        try {
            // For Microsoft IE 6.0+
            xmlhttpObject = new ActiveXObject("Microsoft.XMLHTTP");
        } catch (e1) {
            // No Browser accepts the XMLHTTP Object then false
            xmlhttpObject = false;
        }
    }
    if (!xmlhttpObject && typeof XMLHttpRequest != 'undefined') {
        // For Mozilla, Opera Browsers
        xmlhttpObject = new XMLHttpRequest();
    }
    // Mandatory Statement returning the ajax object created
    return xmlhttpObject;
}
function login1() {
    var name = document.querySelector('#name').value;
    var password = document.querySelector('#password').value;
    var url = "login?name=" + name + "&password=" + password;
    loginAjax(url);
}

function resume() {
    var request = getXMLHTTPObject();
    request.open('POST', 'actions', true);
    request.onreadystatechange = function () {
        if (request.readyState == 4) {
            if (request.status == 200) {
                var json = request.responseText;
                var arr = JSON.parse(json);
                var qqq = '<form action="/editUser" method="post">';
                qqq += "<select name='operation'>"
                for (var i = 0; i < arr.length; i++) {
                    qqq += '<option>' + arr[i] + '</option>'
                }
                qqq += '</select>';
                qqq += '<input type="submit" name="Click to submit">';
                qqq += '</form>';
                // qqq += '<button onclick="editUser()">Click to submit</button>';
                document.querySelector("#formResult").innerHTML = "";
                document.querySelector("#formResult").innerHTML = qqq;
            }
        }
    };
    request.send(null);
}

function logOut() {
    var request = getXMLHTTPObject();

    request.open('POST', 'logout', true);
    request.send(null);

    request.onreadystatechange = function () {
        if (request.readyState == 4) {
            if (request.status == 200) {
                document.querySelector("#bossForm").style.display = "block";
                document.querySelector("#formResult").style.display = "none";
            }
        }
        ;
    };
}
