// script.js

// Создаем переменные для общих элементов теста


function addQuestion() {
    const questionsContainer = document.getElementById('container-user');

    // Создаем блок с вопросом
    const questionDiv = document.createElement('div');
    questionDiv.className = 'input-box'

    // Создаем поле для ввода вопроса
    const questionInput = document.createElement('input');
    questionInput.type = 'text';
    questionInput.placeholder = 'Введите ваш вопрос';
    questionDiv.appendChild(questionInput);

    // Создаем блок для вариантов ответов
    const answerOptions = document.createElement('div');
    answerOptions.className = 'answer-options';

    // Создаем поля для 4 вариантов ответа по умолчанию
    for (let i = 1; i <= 4; i++) {
        const answerInput = document.createElement('input');
        answerInput.type = 'text';
        answerInput.placeholder = `Вариант ${i}`;
        answerOptions.appendChild(answerInput);
    }
    questionDiv.appendChild(answerOptions);

    // Создаем кнопку для добавления нового варианта ответа
    const addButton = document.createElement('input')
    addButton.type = 'button'
    addButton.value = 'Добавить ответ';
//    addAnswerButton.textContent = 'Добавить ответ';
    addButton.addEventListener('click', () => {
        const newAnswerInput = document.createElement('input');
        newAnswerInput.type = 'text';
        newAnswerInput.placeholder = 'Введите новый ответ';
        answerOptions.appendChild(newAnswerInput);
        updateCorrectAnswerOptions(answerOptions, correctAnswerSelect);
    });
    questionDiv.appendChild(addButton)

    // Создаем кнопку для удаления последнего варианта ответа
    const deleteButton = document.createElement('input')
    deleteButton.type = 'button'
    deleteButton.value = 'Удалить ответ';
    // removeAnswerButton.textContent = 'Удалить ответ';
    deleteButton.addEventListener('click', () => {
        const answerInputs = answerOptions.querySelectorAll('input[type="text"]');
        if (answerInputs.length > 1) {
            answerOptions.removeChild(answerInputs[answerInputs.length - 1]);
            updateCorrectAnswerOptions(answerOptions, correctAnswerSelect);
        }
    });
    questionDiv.appendChild(deleteButton)

    // Создаем селектор для выбора правильного ответа
    const correctAnswerLabel = document.createElement('label');
    correctAnswerLabel.textContent = 'Выберите правильный ответ:';
    const correctAnswerSelect = document.createElement('select');
    correctAnswerLabel.appendChild(correctAnswerSelect);
    questionDiv.appendChild(correctAnswerLabel);

    // Добавляем вопрос в контейнер
    questionsContainer.appendChild(questionDiv);

    // Обновляем опции для селектора правильного ответа
    updateCorrectAnswerOptions(answerOptions, correctAnswerSelect);
}

function updateCorrectAnswerOptions(answerOptions, selectElement) {
    // Очищаем существующие опции
    selectElement.innerHTML = '';

    // Создаем опции для выбора правильного ответа на основе количества вариантов ответов
    const answerInputs = answerOptions.querySelectorAll('input[type="text"]');
    answerInputs.forEach((input, index) => {
        const option = document.createElement('option');
        option.value = `Вариант ${index + 1}`;
        option.textContent = `Вариант ${index + 1}`;
        selectElement.appendChild(option);
    });
}


function saveTest() {
    // Собираем данные о тесте
    const testName = document.getElementById('test-name').value;
    const testTitle = document.getElementById('test-title').value;
    const description = document.getElementById('description').value;
    const photoInput = document.getElementById('photo'); // Получаем элемент input с изображением
    let photoFileName = ''; // Переменная для хранения только имени файла

    // Проверяем, выбрано ли изображение
    if (photoInput.files.length > 0) {
        const photoFile = photoInput.files[0]; // Получаем объект файла
        photoFileName = photoFile.name; // Извлекаем только имя файла
    }


    // Создаем массив для хранения вопросов
    const questions = [];

    // Получаем все блоки с вопросами
    const questionDivs = document.querySelectorAll('#container-user > div');

    // Проходим по каждому блоку с вопросом
    questionDivs.forEach(questionDiv => {
        // Получаем вопрос
        const question = questionDiv.querySelector('input[type="text"]').value;

        // Получаем варианты ответов
        const answerInputs = questionDiv.querySelectorAll('.answer-options input[type="text"]');
        const answers = [];
        answerInputs.forEach(answerInput => {
            answers.push(answerInput.value);
        });

        // Получаем правильный ответ
        const correctAnswerSelect = questionDiv.querySelector('select');
        const correctAnswerIndex = correctAnswerSelect.selectedIndex; // Индекс выбранного варианта ответа
        const rightAnswer = answers[correctAnswerIndex]; // Правильный ответ - текст из соответствующего поля ввода

        // Создаем объект вопроса и добавляем его в массив вопросов
        questions.push({
            question: question,
            answers: answers,
            rightAnswer: rightAnswer
        });
    });

    // Создаем объект теста
    const test = {
        name: testName,
        title: testTitle,
        description: description,
        imgUrl: photoFileName, // Пока что так, потребуется доработка для обработки изображения
        answerList: questions
    };

    console.log(test);

    // Преобразуем объект теста в формат JSON
    const testJSON = JSON.stringify(test);

    // Для примера выводим JSON в консоль
    console.log(testJSON);

    let response = fetch('/school/admin/test', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify(test)
    }).then(response => {
        if (response.ok) {
            // Если ответ успешен (статус код 200-299), открываем ссылку
            window.open("/school/test", '_self');
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

    // Дальнейшая обработка JSON, например, отправка на сервер
}
