$('document').ready(function () {

    $('#addNew').on('click', async function (event) {
        event.preventDefault();
        let nickname = document.getElementById("nicknameForm").value;
        let birthday = document.getElementById("birthdayForm").value;

        let data = {
            "nickname": nickname,
            "birthday": birthday
        };

        let response = fetch('peer', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify(data)
        }).then(response => {
            if (response.ok) {
                // Если ответ успешен (статус код 200-299), открываем ссылку
                window.open("peers", '_self');
            } else {
                response.json().then(data => {
                    if (data && data.violations && data.violations.length > 0) {
                        // Извлекаем информацию о нарушении и отображаем ее
                        const violation = data.violations[0];
                        alert('Error status: ' + response.status + ' Reason: Поле ' + violation.fieldName + " " + violation.message);
                        if (data.violations.lenght > 1) {
                            const violation2 = data.violations[1];
                            alert('Error status: ' + response.status + ' Reason: Поле ' + violation2.fieldName + " " + violation2.message);
                        }
                    } else {
                        // Если информация о нарушении недоступна, просто отображаем статус и текст ошибки
                        alert('Error status: ' + response.status + ' Reason: ' + response.statusText);
                    }
                })
            }
        });
        let result = await response.json();
        alert(result.message);
    });

    $('.table a.btn-warning').on('click', async function (event) {
            event.preventDefault();

            let url = $(this).attr('href');
            let response = await fetch(url);

            if (response.ok) { // если HTTP-статус в диапазоне 200-299
                // получаем тело ответа (см. про этот метод ниже)
                let json = await response.json();
                $('#nicknameEdit').val(json.nickname);
                $('#editModal').modal();
            } else {
                response.json().then(data => {
                    if (data) {
                        // Извлекаем информацию о нарушении и отображаем ее
                        alert('Error status: ' + data.status + ' Reason: ' + data.reason + " " + new Date(data.timestamp).toLocaleTimeString());
                    } else {
                        console.log(url);
                        // Если информация о нарушении недоступна, просто отображаем статус и текст ошибки
                        alert('Error status: ' + response.status + ' Reason: ' + response.statusText);
                    }
                })
            }
        }
    );

    $('#save-button').on('click', async function (event) {
        event.preventDefault();
        let nickname = document.getElementById("nicknameEdit").value;
        let birthday = document.getElementById("birthdayEdit").value;

        let data = {
            "nickname": nickname,
            "birthday": birthday
        };


        let response = fetch('peer', {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify(data)
        }).then(response => {
            if (response.ok) {
                // Если ответ успешен (статус код 200-299), открываем ссылку
                window.open("peers", '_self');
            } else {
                response.json().then(data => {
                    if (data && data.violations && data.violations.length > 0) {
                        // Извлекаем информацию о нарушении и отображаем ее
                        const violation = data.violations[0];
                        alert('Error status: ' + response.status + ' Reason: Поле ' + violation.fieldName + " " + violation.message);
                        if (data.violations.lenght > 1) {
                            const violation2 = data.violations[1];
                            alert('Error status: ' + response.status + ' Reason: Поле ' + violation2.fieldName + " " + violation2.message);
                        }
                    } else {
                        // Если информация о нарушении недоступна, просто отображаем статус и текст ошибки
                        alert('Error status: ' + response.status + ' Reason: ' + response.statusText);
                    }
                })
            }
        });
        let result = await response.json();
        alert(result.message);
    });

    $('.table #deleteButton').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#deleteModal #delRef').attr('href', href);
        $('#deleteModal').modal();
    });
    $('#delRef').on('click', function (event) {
        event.preventDefault();
        var url = $(this).attr('href');
        fetch(url, {method: 'DELETE'})
            .then(response => {
                if (response.ok) {
                    // Если ответ успешен (статус код 200-299), открываем ссылку
                    window.open("peers", '_self');
                } else {
                    response.json().then(data => {
                        if (data) {
                            // Извлекаем информацию о нарушении и отображаем ее
                            alert('Error status: ' + data.status + ' Reason: ' + data.reason + " " + new Date(data.timestamp).toLocaleTimeString());
                        } else {
                            console.log(url);
                            // Если информация о нарушении недоступна, просто отображаем статус и текст ошибки
                            alert('Error status: ' + response.status + ' Reason: ' + response.statusText);
                        }
                    })
                }
            })
    });
});
