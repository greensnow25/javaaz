/**
 * Created by greensnow on 01.11.2017.
 */
function addNewUser() {
    $.ajax({
        url: 'addUser',
        type: 'POST',
        data: {
            'login': $('#login').val(),
            'password': $('#password').val()
        },
        dataType: 'json',
        success: function (data) {
            let info = $('#info')
            info.append('<h2>' + data + '</h2>')
        },
        error: function () {
            alert('error')
        }

    })


}