/**
 * Created by greensnow on 02.10.2017.
 */
function dosmt() {
    // document.querySelector('#login.send').onclick = function () {
    var name = document.querySelector('#name');
    var password = document.querySelector('#password');
var url = "ajax?name=" + name + "&password=" + password;
    this.ajaxPost(url);

    //  }
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
function ajaxPost(url) {
    var request = new XMLHttpRequest();
    if(request==null){
        alert('request is null')
    }
    request.open('POST', url,true);
    request.onreadystatechange = function () {
        if (request.readyState == 4 && request.status == 200) {
            document.querySelector("#formResult").innerHTML = "sdfghtreaw";
        }
        else {
            alert("error");

        }

    }

    request.send(null);
}