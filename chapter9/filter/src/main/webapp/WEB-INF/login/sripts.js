/**
 * Created by greensnow on 02.10.2017.
//  */
// window.onload = function () {
//     document.querySelector('#send').onclick = function () {
// this.ajaxPost("login.jsp");
//     }
// }
// function ajaxPost(url) {
//     var request = new XMLHttpRequest();
//
//     request.onreadystatechange = function () {
//         if (request.readyState == 4 && request.status == 400) {
//             document.querySelector("#formResult").innerHTML = request.responseText;
//         }
//     }
//     request.open('POST', url);
//     request.send();
//
//
// }

//Get XMLHTTP Object
// function getXMLHTTPObject() {
//     var xmlhttpObject = null;
//     try {
//         // For Old Microsoft Browsers
//         xmlhttpObject = new ActiveXObject("Msxml2.XMLHTTP");
//     } catch (e) {
//         try {
//             // For Microsoft IE 6.0+
//             xmlhttpObject = new ActiveXObject("Microsoft.XMLHTTP");
//         } catch (e1) {
//             // No Browser accepts the XMLHTTP Object then false
//             xmlhttpObject = false;
//         }
//     }
//     if (!xmlhttpObject && typeof XMLHttpRequest != 'undefined') {
//         // For Mozilla, Opera Browsers
//         xmlhttpObject = new XMLHttpRequest();
//     }
//     // Mandatory Statement returning the ajax object created
//     return xmlhttpObject;
// }
//
// // Change the value of the outputText field
// function setAjaxOutput() {
//     document.getElementById('send').innerHTML = xmlhttpObject.responseText;
// }
//
// function handleServerResponse() {
//     if (xmlhttpObject.readyState == 4) {
//         if (xmlhttpObject.status == 200) {
//             setAjaxOutput();
//         } else {
//             alert("Error during AJAX call. Please try again");
//         }
//     }
// }
//
// // Implement business logic
// function doAjaxCall() {
//     xmlhttpObject = getXMLHTTPObject();
//     if (xmlhttpObject != null) {
//         var URL = "AjaxAction?userName="
//             + document.getElementById('userName').value;
//         xmlhttpObject.open("POST", URL, true);
//         xmlhttpObject.send(null);
//         xmlhttpObject.onreadystatechange ='awdwqdfwqf'; //handleServerResponse;
//     }
// }
$(document).ready(function() {
    $('#send').blur(function(event) {
        var name = $('#login').val();
        $.get('AjaxController', {
            userName : name
        }, function(responseText) {
            $('#formResult').text(responseText);
        });
    });
});