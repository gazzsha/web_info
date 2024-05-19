$('document').ready(function () {

    $('#login-button').on('click', async function (event) {
        event.preventDefault();
        let username = document.getElementById("username").value;
        let password = document.getElementById("password").value;

        let data = {
            "username": username,
            "password": password,
        };

        console.log(data);

        let response = fetch('/school/login?username=' + username + '&password=' + password, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify(data)
        }).then(response => {
            if (response.ok) {
                // Если ответ успешен (статус код 200-299), открываем ссылку
                window.open(response.url, '_self');
            } else {
                response.json().then(data => {
                        console.log(response);
                    }
                )
            }
        });
    });


    $('#auth-button').on('click', async function (event) {
        event.preventDefault();
        window.location.href = "/school/auth"
    });

})
;
