// document.addEventListener("DOMContentLoaded", function() {
//     // Получаем все кнопки ответов
//     const answerButtons = document.querySelectorAll('.answer-button');
//
//     // Добавляем обработчик события клика на каждую кнопку ответа
//     answerButtons.forEach(button => {
//         button.addEventListener('click', function() {
//             const question = this.closest('.question'); // Находим родительский вопрос для данной кнопки
//             const allButtons = question.querySelectorAll('.answer-button'); // Получаем все кнопки ответов для данного вопроса
//
//             // Снимаем подсветку со всех кнопок ответов для данного вопроса
//             allButtons.forEach(btn => {
//                 btn.classList.remove('selected');
//             });
//
//             // Подсвечиваем выбранный ответ
//             this.classList.add('selected');
//         });
//     });
// });


document.addEventListener("DOMContentLoaded", function() {
    let selectedAnswers = []; // Массив для хранения выбранных ответов
    let correctAnswers = []; // Массив для хранения верных ответов

    // Получаем все кнопки ответов на странице
    const answerButtons = document.querySelectorAll('.answer-button');

    // Добавляем обработчик события клика на каждую кнопку ответа
    answerButtons.forEach((button, index) => {
        button.addEventListener('click', function() {
            const selectedAnswer = button.innerText.trim(); // Получаем текст ответа с кнопки
            selectedAnswers[index] = selectedAnswer; // Сохраняем выбранный ответ в соответствующем индексе массива
            highlightSelectedAnswer(button); // Подсвечиваем выбранный ответ
        });
    });

    // Функция для подсветки выбранного ответа
    function highlightSelectedAnswer(button) {
        // answerButtons.forEach(btn => {
        //     btn.classList.remove('selected');
        // });
        button.classList.add('selected');
    }

    // Добавляем обработчик события клика на кнопку "Готово"
    document.getElementById('submitButton').addEventListener('click', function() {
        checkAnswers(); // Проверяем ответы
    });

    // Функция для проверки ответов и отображения результата
    function checkAnswers() {
        let score = countTotalOccurrences(correctAnswers,selectedAnswers);
        alert('Вы набрали ' + score + ' из ' + correctAnswers.length + ' баллов.');
    }

    function countTotalOccurrences(arr1, arr2) {
        let totalOccurrences = 0;

        console.log(arr1);
        console.log(arr2);

        // Проходим по каждому элементу первого массива (arr1)
        arr1.forEach(item => {
            // Проверяем, есть ли текущий элемент во втором массиве (arr2)
            if (arr2.includes(item)) {
                // Если элемент найден, увеличиваем счетчик общего количества вхождений
                totalOccurrences++;
            }
        });

        return totalOccurrences;
    }

    // Выполнить GET-запрос для получения верных ответов
    fetch('/school/testing/answer')
        .then(response => response.json())
        .then(data => {
            correctAnswers = data; // Сохранить верные ответы в массив
        })
        .catch(error => console.error('Ошибка получения верных ответов:', error));
});
