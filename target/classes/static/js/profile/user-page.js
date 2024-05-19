document.addEventListener('DOMContentLoaded', async function () {
    // Извлекаем id пользователя из URL
    var url = window.location.href;

// Разделение URL по символу '/'
    var parts = url.split('/');

// Последний элемент в массиве будет содержать идентификатор пользователя с дополнительными параметрами
    var lastPart = parts[parts.length - 1];

// Извлечение чисел из последней части URL с помощью регулярного выражения
    var userId = lastPart.match(/\d+/)[0];

    console.log(userId);

    // Выполняем запрос к серверу для получения данных о пользователе
    let response = await fetch('/school/profiles/user/' + userId);

    let responseTest = await fetch('/school/profiles/user/' + userId + '/test');

    if (response.ok && responseTest.ok) {
        let data = await response.json();
        let testData = await responseTest.json();
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

        let passedTestsList = document.getElementById('passedTestsList');
        passedTestsList.innerHTML = ''; // Очищаем список перед добавлением новых элементов

        for (let testName in testData) {
            let testResult = testData[testName];
            let listItem = document.createElement('div');

            // Создаем элементы списка с классом input-box для стилизации
            let testNameItem = document.createElement('span');
            testNameItem.textContent = `Название: ${testName}`;
            testNameItem.classList.add('input-box');

            let resultItemRight = document.createElement('input');
            let resultItemAll = document.createElement('input');
            let resultItemPercent = document.createElement('input');
            resultItemRight.value = `Верных: ${testResult.first}`;
            resultItemAll.value = ` Всего: ${testResult.second}`;
            let percent = Math.round((testResult.first / testResult.second) * 100);
            resultItemPercent.value = `Процент: ${percent}%`;
            //   Всего: ${testResult.second} Процент: ${Math.round((testResult.first / testResult.second) * 100)}%`;
            resultItemRight.classList.add('input-box');
            resultItemAll.classList.add('input-box');
            resultItemPercent.classList.add('input-box');

            if (percent > 85) {
                resultItemPercent.style.backgroundColor = 'green';
            } else if (percent >= 50) {
                resultItemPercent.style.backgroundColor = 'yellow';
            } else {
                resultItemPercent.style.backgroundColor = 'red';
            }


            // Добавляем элементы списка в родительский элемент
            listItem.appendChild(testNameItem);
            listItem.appendChild(resultItemRight);
            listItem.appendChild(resultItemAll);
            listItem.appendChild(resultItemPercent);
            passedTestsList.appendChild(listItem);
        }
    } else {
        console.error('Failed to fetch user data');
    }
});
