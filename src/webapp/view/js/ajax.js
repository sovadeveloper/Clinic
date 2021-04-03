/* Article FructCode.com */
$(document).ready(function () {
    $("#btn").click(
        function () {
            sendAjaxForm('ajax_form', 'http://localhost:8081/sendData');
            return false;
        }
    );
});

$(document).ready(function () {
    $("#btn1").click(
        function (){
            sendAjaxForm('ajax_form1', 'http://localhost:8081/changeData');
            return false;
        }
    )
})

$(document).ready(function () {
    $("#btn2").click(
        function (){
            sendAjaxForm('ajax_form2', 'http://localhost:8081/deleteData');
            return false;
        }
    )
})

function sendAjaxForm(ajax_form, url) {
    $.ajax({
        url: url, //url страницы
        type: "POST", //метод отправки
        dataType: "html", //формат данных
        data: $("#" + ajax_form).serialize(), // Сеарилизуем объект
        error: function (response) { // Данные не отправлены
            $('#result_form').html('Ошибка. Данные не отправлены.');
        }
    });
};

/*получиение инфы */
var btnResponse = document.getElementById("btnResponse");
btnResponse.addEventListener("click", function () {
    $.ajax({
        url: 'http://localhost:8081/getOwners' // url сервера
    }).then(function (result) {
        let list = JSON.parse(result);
        let $container = document.querySelector('#container');
        $container.innerHTML = ""
        console.log(result);
        for (let i = 0; i < list.length; i++) {
            let elementA = document.createElement("a");
            let elementH4 = document.createElement("h4");
            elementH4.classList.add("list-group-item-heading");
            elementH4.textContent = i+1 +". "+list[i].name;
            elementA.classList.add("list-group-item");
            elementA.appendChild(elementH4);
            $container.appendChild(elementA);
        }
    }).catch(function (err) {
        console.log('err', err)
    })
});
