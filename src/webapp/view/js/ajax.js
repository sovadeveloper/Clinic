/* Article FructCode.com */
$(document).ready(function () {
	$("#btn").click(
		function () {
			sendAjaxForm('ajax_form', 'http://localhost:8081/sendData');
			return false;
		}
	);
});

function sendAjaxForm(ajax_form, url) {
	$.ajax({
		url: url, //url страницы
		type: "POST", //метод отправки
		dataType: "html", //формат данных
		origin: "*",
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
		url: 'http://localhost:8081/getOwners', // url сервера
	}).then(function (result) {
		console.log(result);
		let list = JSON.parse(result);
		$parent = document.querySelector('.container');
		for (let i = 0;i<list.length;i++){
			let id = list[i].clientId;
			let el = document.createTextNode('ID: '+ String(id) + '; Name: ' + list[i].clientName);
			$parent.appendChild(el);
			let perenos = document.createElement('br');
			$parent.appendChild(perenos);
		}

	}).catch(function (err) {
		console.log('err', err)
	})
});