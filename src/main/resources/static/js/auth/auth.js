$('document').ready(function () {

    $('#register-button').on('click', async function (event) {
        event.preventDefault();
        let name = document.getElementById("name").value;
        let lastName = document.getElementById("lastName").value;
        let password = document.getElementById("password").value;
        let email = document.getElementById("email").value;
        let fullName = name + " " + lastName;

        let data = {
            "fullName": fullName,
            "password": password,
            "email": email,
            "roles": "ROLE_USER"
        };

        console.log(data);

        let response = fetch('/school/auth/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify(data)
        }).then(response => {
            if (response.ok) {
                // Если ответ успешен (статус код 200-299), открываем ссылку
                window.open("test", '_self');
            } else {
                response.json().then(data => {
                    if (data && data.violations && data.violations.length > 0) {
                        // Извлекаем информацию о нарушении и отображаем ее
                        const violation = data.violations[0];
                        alert('Error status: ' + response.status + ' Reason: Поле ' + violation.fieldName + " " + violation.message);
                    }
                })
            }
        });
    });

});
