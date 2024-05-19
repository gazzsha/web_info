// $('document').ready(function () {
//     // Получаем все кнопки с классом peerButton
//
//     // Добавляем обработчик события клика для каждой кнопки
//     $('#peerButton').on('click', async function (event) {
//         event.preventDefault();
//         let button = document.getElementById("peerButton")
//         // Получаем идентификатор пользователя из атрибута data-id
//         var userId = button.getAttribute("data-id");
//         console.log(userId)
//         // Переходим на страницу профиля пользователя с указанным идентификатором
//         window.location.href = "/school/profiles/" + userId;
//     });
// });

document.addEventListener('DOMContentLoaded', function () {
    // Получаем все кнопки с классом peerButton
    var peerButtons = document.querySelectorAll("#peerButton");

    // Добавляем обработчик события клика для каждой кнопки
    peerButtons.forEach(function (button) {
        button.addEventListener("click", function () {
            // Получаем идентификатор пользователя из атрибута data-id
            var userId = button.getAttribute("data-id");
            // Переходим на страницу профиля пользователя с указанным идентификатором
            window.location.href = "/school/profiles/" + userId;
        });
    });
});

$('document').ready(function () {

    $('#search-button').on('click', async function (event) {
        event.preventDefault();
        let name = document.getElementById("user-name-search").value.trim();
        let lastname = document.getElementById("user-lastname-search").value.trim();


        let url = '/school/profiles?';
        if (name !== '') {
            url += 'name=' + name;
        }
        if (lastname !== '') {
            url += (name === '') ? 'lastname=' + lastname : '&lastname=' + lastname;
        }

        window.location.href = url;
    })

});


// $('document').ready(function () {
//
//     $('#send-button').on('click', async function (event) {
//         event.preventDefault();
//         let surname = document.getElementById("surname").value;
//         let birthday = document.getElementById("birthday").value;
//         let faculty = document.getElementById("faculty").value;
//         let institution = document.getElementById("institution").value;
//         let city = document.getElementById("city").value;
//         let cppLevel = document.getElementById("c++_know").value;
//         let admission = document.getElementById("admission").value;
//         let javaLevel = document.getElementById("java_know").value;
//         let pythonLevel = document.getElementById("python_know").value;
//         let sqlLevel = document.getElementById("sql_know").value;
//         let c_sharpLevel = document.getElementById("c_sharp").value;
//
//
//         let data = {
//             "surname": surname,
//             "birthday": birthday,
//             "faculty": faculty,
//             "city": city,
//             "educationalInstitution": institution,
//             "admission": admission,
//             "levelCpp": cppLevel,
//             "levelPython": pythonLevel,
//             "levelJava": javaLevel,
//             "levelCSharp": c_sharpLevel,
//             "levelSql": sqlLevel
//         };
//
//         console.log(data);
//
//         let response = fetch('/school/survey', {
//             method: 'POST',
//             headers: {
//                 'Content-Type': 'application/json;charset=utf-8'
//             },
//             body: JSON.stringify(data)
//         }).then(response => {
//             if (response.ok) {
//                 // Если ответ успешен (статус код 200-299), открываем ссылку
//                 window.open("test", '_self');
//             } else {
//                 response.json().then(data => {
//                     if (data && data.violations && data.violations.length > 0) {
//                         // Извлекаем информацию о нарушении и отображаем ее
//                         const violation = data.violations[0];
//                         alert('Error status: ' + response.status + ' Reason: Поле ' + violation.fieldName + " " + violation.message);
//                     }
//                 })
//             }
//         });
//     });
