/**
 * Created by greensnow on 02.10.2017.
 */

window.onload = function () {
    var send = document.querySelector('#send');
    send.onclick = function () {
      //  dosmt();
    }
//     $(document).ready(function () {
//         $("#send").onclick(function () {
//                 $ajax({url: dosmt, success: document.querySelector("#formResult").innerHTML = request.responseText})
//             }
//         );
//
//     });
// };
};
/**
 * check name.
 * @returns {boolean} false if name is empty.
 */
function checkName() {
    var string = document.querySelector('#name');
    if (string.value.toString() === '') {
        alert("Message : Name can not be empty!!!")
        return false;
    }
    else {
        return true;
    }
}
/**
 * check password.
 * @returns {boolean} false if password smallest 7 symbols.
 */
function checkPassword() {
    var password = document.querySelector('#password');
    if (password.value.length <= 2) {
        //document.querySelector("#formResult").innerHTML = "Message : Password too small.";
        alert("Message : Password too small.");
        return false;
    }
    else {
        return true;
    }
}
/**
 * Resultant check.
 * @returns {boolean}true if all checks return true.
 */
function validate() {
    if (checkName() && checkPassword()) {
        return true;
    } else {
        return false;
    }


}

function dosmt() {

    var name = document.querySelector('#name');
    var password = document.querySelector('#password');
    var url = "login?name=" + name + "&password=" + password;
    ajaxPost(url);

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
    if (request == null) {
        alert('request is null')
    }
    request.open('POST', url, false);
    request.onreadystatechange = function () {
        if (request.readyState == 4 && request.status == 200) {
            document.querySelector("#formResult").innerHTML = request.responseText;
        }
    };

    request.send(null);
}