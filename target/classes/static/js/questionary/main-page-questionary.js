document.addEventListener('DOMContentLoaded', async function () {
    try {
        let response = await fetch('/school/survey/my');
        if (response.ok) {
            let data = await response.json();
            // Заполнить форму существующими данными
            document.getElementById("surname").value = data.surname;
            let timestampDate = data.birthday;
            let date = new Date(timestampDate);
            let formattedDate = date.toISOString().split('T')[0];
            document.getElementById("birthday").value = formattedDate;
            document.getElementById("faculty").value = data.faculty;
            document.getElementById("institution").value = data.educationalInstitution;
            document.getElementById("city").value = data.city;
            document.getElementById("c++_know").value = data.levelCpp;
            document.getElementById("admission").value = data.admission;
            document.getElementById("java_know").value = data.levelJava;
            document.getElementById("python_know").value = data.levelPython;
            document.getElementById("sql_know").value = data.levelSql;
            document.getElementById("c_sharp").value = data.levelCSharp;
        } else {
            console.error('Failed to fetch survey data');
        }
    } catch (error) {
        console.error('Error fetching survey data:', error);
    }

    console.log(data);
});

$('document').ready(function () {

    $('#send-button').on('click', async function (event) {
        event.preventDefault();
        let surname = document.getElementById("surname").value;
        let birthday = document.getElementById("birthday").value;
        let faculty = document.getElementById("faculty").value;
        let institution = document.getElementById("institution").value;
        let city = document.getElementById("city").value;
        let cppLevel = document.getElementById("c++_know").value;
        let admission = document.getElementById("admission").value;
        let javaLevel = document.getElementById("java_know").value;
        let pythonLevel = document.getElementById("python_know").value;
        let sqlLevel = document.getElementById("sql_know").value;
        let c_sharpLevel = document.getElementById("c_sharp").value;


        let data = {
            "surname": surname,
            "birthday": birthday,
            "faculty": faculty,
            "city": city,
            "educationalInstitution": institution,
            "admission": admission,
            "levelCpp": cppLevel,
            "levelPython": pythonLevel,
            "levelJava": javaLevel,
            "levelCSharp": c_sharpLevel,
            "levelSql": sqlLevel
        };

        console.log(data);

        let response = fetch('/school/survey', {
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
