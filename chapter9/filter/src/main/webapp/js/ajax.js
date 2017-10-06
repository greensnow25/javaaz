/**
 * Created by greensnow on 06.10.2017.
 */

function login1() {

    var name = document.querySelector('#name').nodeValue;
    var password = document.querySelector('#password').nodeValue;
    var url = "login?name=" + name + "&password=" + password;
    ajaxPost(url, function callback() {

    });
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
function ajaxPost(url, callback) {
    var request = new XMLHttpRequest();
    if (request == null) {
        alert('request is null')
    }
    request.open('POST', url, false);
    request.onreadystatechange = function () {
        if (request.readyState == 4 && request.status == 200) {
            document.querySelector("#formResult").innerHTML = request.responseText;
           // callback();
        }
    };

    request.send(null);
}