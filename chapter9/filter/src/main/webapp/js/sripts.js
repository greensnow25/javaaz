/**
 * Created by greensnow on 02.10.2017.
 */

/**
 * check name.
 * @returns {boolean} false if name is empty.
 */
function checkName() {
    var string = document.querySelector('#name');
    if (string.value.toString() === '') {
        alert("Message : Name can not be empty!!!");
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

