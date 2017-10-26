/**
 * Created by greensnow on 25.10.2017.
 */
$(document).ready(function () {
    $('input[type = "file"]').ajaxfileupload({
        'action':'upload',
        'onComplete': function (response) {
            
        }
    })
});