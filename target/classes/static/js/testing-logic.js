// document.addEventListener("DOMContentLoaded", function () {
//     let selectedAnswers = []; // Массив для хранения выбранных ответов
//
//     // Получаем все кнопки ответов на странице
//     const answerButtons = document.querySelectorAll('.answer-button');
//
//     // Добавляем обработчик события клика на каждую кнопку ответа
//     answerButtons.forEach((button, index) => {
//         button.addEventListener('click', function () {
//             const selectedAnswer = button.innerText.trim(); // Получаем текст ответа с кнопки
//             selectedAnswers[index] = selectedAnswer; // Сохраняем выбранный ответ в соответствующем индексе массива
//             highlightSelectedAnswer(button); // Подсвечиваем выбранный ответ
//         });
//     });
//
//
//     // Функция для подсветки выбранного ответа
//     function highlightSelectedAnswer(button) {
//         var answerButtons = button.parentElement.getElementsByClassName('answer-button');
//
//         // Снимаем подсветку со всех кнопок внутри блока с ответами
//         for (var i = 0; i < answerButtons.length; i++) {
//             answerButtons[i].classList.remove('selected');
//         }
//
//         button.classList.add('selected');
//     }
//
//     // Добавляем обработчик события клика на кнопку "Готово"
//     document.getElementById('submitButton').addEventListener('click', function () {
//         checkAnswers(); // Проверяем ответы
//     });
//
//     // Функция для проверки ответов и отображения результата
//     function checkAnswers() {
//         let response = fetch(window.location.href, {
//             method: "POST",
//             body: JSON.stringify({
//                 data: selectedAnswers
//             }),
//             headers: {
//                 "Content-type": "application/json; charset=UTF-8"
//             }
//         }).then(response => {
//             if (response.ok) {
//                 // Если ответ успешен (статус код 200-299), открываем ссылку
//                 window.open("http://localhost:8080/school/test", '_self');
//             }
//         });
//     }
//
//     // function countTotalOccurrences(arr1, arr2) {
//     //     let totalOccurrences = 0;
//     //
//     //     console.log(arr1);
//     //     console.log(arr2);
//     //
//     //     // Проходим по каждому элементу первого массива (arr1)
//     //     arr1.forEach(item => {
//     //         // Проверяем, есть ли текущий элемент во втором массиве (arr2)
//     //         if (arr2.includes(item)) {
//     //             // Если элемент найден, увеличиваем счетчик общего количества вхождений
//     //             totalOccurrences++;
//     //         }
//     //     });
//     //
//     //     return totalOccurrences;
//     //  }
//     //
//     // // Выполнить GET-запрос для получения верных ответов
//     // fetch('/school/testing/answer')
//     //     .then(response => response.json())
//     //     .then(data => {
//     //         correctAnswers = data; // Сохранить верные ответы в массив
//     //     })
//     //     .catch(error => console.error('Ошибка получения верных ответов:', error));
// });

document.addEventListener("DOMContentLoaded", function () {
    let selectedAnswers = []; // Объект для хранения выбранных ответов

    // Получаем все блоки с вопросами и ответами
    const questionBlocks = document.querySelectorAll('.question');

    // Добавляем обработчик события клика на каждую кнопку ответа
    questionBlocks.forEach((block, index) => {
        const answerButtons = block.querySelectorAll('.answer-button');
        answerButtons.forEach((button) => {
            button.addEventListener('click', function () {
                 // Получаем текст ответа с кнопки
                selectedAnswers[index] = button.innerText.trim(); // Сохраняем выбранный ответ в соответствующем блоке
                highlightSelectedAnswer(block, button); // Подсвечиваем выбранный ответ
            });
        });
    });

    // Функция для подсветки выбранного ответа
    function highlightSelectedAnswer(block, button) {
        const answerButtons = block.querySelectorAll('.answer-button');

        // Снимаем подсветку со всех кнопок внутри блока с ответами
        answerButtons.forEach((btn) => {
            btn.classList.remove('selected');
        });

        button.classList.add('selected'); // Подсвечиваем выбранный ответ
    }

    // Добавляем обработчик события клика на кнопку "Готово"
    document.getElementById('submitButton').addEventListener('click', function () {
        checkAnswers(); // Проверяем ответы
    });

    // Функция для проверки ответов и отображения результата
    function checkAnswers() {
        console.log(selectedAnswers);
        let response = fetch(window.location.href, {
            method: "POST",
            body: JSON.stringify({
                data: selectedAnswers
            }),
            headers: {
                "Content-type": "application/json; charset=UTF-8"
            }
        }).then(response => {
            if (response.ok) {
                // Если ответ успешен (статус код 200-299), открываем ссылку
                window.open("http://localhost:8080/school/test", '_self');
            }
        });
    }
});
