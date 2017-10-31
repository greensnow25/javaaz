/**
 * Created by greensnow on 24.10.2017.
 */
/**
 * page load, return brands.
 */
function selectBrand() {
    $.ajax(
        {
            url: '/selectModel',
            type: 'GET',
            dataType: 'json',
            success: function (data) {
                $('#selectBrand').append($('<option>-------</option>'));
                for (let i = 0; i < data.length; i++) {
                    //  let select = $('#selectModel');
                    $('#selectBrand')
                        .append($("<option></option>")
                            .attr('id', 'brandId')
                            .text(data[i]));
                }

            }
        }
    );
}

function selectModel(brand) {
    $.ajax({
        url: '/selectModel',
        type: 'POST',
        data: {'brand': brand},
        dataType: 'json',
        success: function (data) {
            $('#selectModel').find("option").remove();
            setModel(data[0], '#selectModel');
            setAttr(data[1], '#selectBody');
            setAttr(data[2], '#selectEngine');
            setAttr(data[3], '#selectTransmission')
        }
    });

}

function setAttr(arr, destenation) {
    $(destenation).append($('<option>-------</option>'));
    for (let i = 0; i < arr.length; i++) {

        $(destenation)
            .append($("<option></option>")
            // .attr('id', 'modelId')
                .text(arr[i].name));
    }
}


function setModel(arr, destenation) {
    $(destenation).append($('<option>-------</option>'));
    for (let i = 0; i < arr.length; i++) {
        $(destenation)
            .append($("<option></option>")
            // .attr('id', 'modelId')
                .text(arr[i]));
    }
};

function filter() {
    $('#btnSearch').on('click', function () {
        $.ajax({
            url: 'title/search',
            type: 'POST',
            data: {},
            success: function (data) {
                var w = data;
            }

        })
    })

}
/**
 * when ready then wiev.
 */
function ready(url) {
    var request = new XMLHttpRequest();
    request.open('POST', url, true);
    request.send(null);
    request.onreadystatechange = function () {
        if (request.status == 200 && request.readyState == 4) {
            let response = request.responseText;
            let json = JSON.parse(response);
            let resultTable = '<table border="1">' +
                '<tr> <td>IMAGE</td> <td>MODEL</td> <td>BODY</td> <td>TRANSMISSION</td> <td>ENGINE</td> <td>PRICE</td></tr> ';
            for (let i = 0; i < json.length; i++) {
                resultTable += '<tr>' +
                    '<td id="img">' + '<img src= "' + json[i].image + '"></img>' + json[i].image + '</td>' +
                    '<td>' + json[i].name + '</td>' +
                    '<td>' + json[i].body.name + '</td>' +
                    '<td>' + json[i].transmission.name + '</td>' +
                    '<td>' + json[i].engine.name + '</td>' +
                    '<td>' + json[i].price + '</td>' +
                    '  </td></tr>';
            }
            resultTable += '</table>';
            // resultTable += '<div id="div11">' +
            //     '<button id="btn_reg">Register</button>' +
            //     '<button id="btn_create_acc">Create new account</button>' +
            //     '</div>';
            document.querySelector("#div1").innerHTML = resultTable;
            document.querySelector('#btn1').style.display = 'block';
            // document.querySelector('#div11').style.display = 'block';
        }

    }
}
function welcome() {
    $.ajax({
        url: 'title',
        data: {
            'login': $('login'),
            'paswword': $('password')
        },
        dataType: 'json',
        success: function (data) {
            alert('1111111');
            window.location.href = 'index.html'
        },
        error: function () {
            alert('error')
        }

    })
}