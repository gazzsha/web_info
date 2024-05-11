document.addEventListener('DOMContentLoaded', async function () {
    // Извлекаем id пользователя из URL
    var url = window.location.href;

    console.log(url)

// Извлекаем часть URL после последнего слеша
    var lastPart = url.substr(url.lastIndexOf('/') + 1);

    console.log(lastPart)
// Извлекаем последнюю цифру из последней части URL
    var userId = parseInt(lastPart.charAt(lastPart.length - 1));

    console.log(userId)
    // Выполняем запрос к серверу для получения данных о пользователе
    let response = await fetch('/school/profiles/user/' + userId);

    if (response.ok) {
        let data = await response.json();
        // Заполнить форму существующими данными
        document.getElementById("surname").value = data.surname;
        let timestampDate = data.birthday;
        let date = new Date(timestampDate);
        let formattedDate = date.toISOString().split('T')[0];
        document.getElementById("name").value = data.lastName;
        document.getElementById("lastname").value = data.firstName;
        document.getElementById("surname").value = data.surname;
        document.getElementById("birthday").value = formattedDate;
        document.getElementById("faculty").value = data.faculty;
        document.getElementById("institution").value = data.educationalInstitution;
        document.getElementById("city").value = data.city;
        document.getElementById("cpp").value = data.levelCpp;
        document.getElementById("admission").value = data.admission;
        document.getElementById("java").value = data.levelJava;
        document.getElementById("python").value = data.levelPython;
        document.getElementById("sql").value = data.levelSql;
        document.getElementById("csharp").value = data.levelCSharp;
    } else {
        console.error('Failed to fetch user data');
    }
});
