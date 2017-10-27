/**
 * Created by greensnow on 24.10.2017.
 */

function getAllModels() {
    $.ajax(
        {
            url: '/search',
            type: 'GET',
            dataType: 'json',
            success: function (data) {
                for (let i = 0; i < data.length; i++) {
                    //  let select = $('#selectModel')
                    $('#selectModel')
                        .append($("<option></option>")
                            .attr('id', 'modelId')
                            .text(data[i]));
                }

            }
        }
    );
}

function selectBrand() {
    $('#selectModel').on('change', function (e) {
        var optionSelected = $("option:selected", this);
        var valueSelected = this.value;
        $.ajax()
    });
}


function filter() {
    $(document).ready(function () {
        $('#btnSearch').on('click', function () {
            $.ajax({
                url: 'title/search',
                type: 'POST',
                data: {},
                success: function () {

                }

            })
        })
    });

}