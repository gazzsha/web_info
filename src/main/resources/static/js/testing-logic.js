document.addEventListener("DOMContentLoaded", function() {
    let selectedAnswers = []; // Массив для хранения выбранных ответов

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
        let response=   fetch(window.location.href, {
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
                window.open("school/test", '_self');
            }});
    }
    // function countTotalOccurrences(arr1, arr2) {
    //     let totalOccurrences = 0;
    //
    //     console.log(arr1);
    //     console.log(arr2);
    //
    //     // Проходим по каждому элементу первого массива (arr1)
    //     arr1.forEach(item => {
    //         // Проверяем, есть ли текущий элемент во втором массиве (arr2)
    //         if (arr2.includes(item)) {
    //             // Если элемент найден, увеличиваем счетчик общего количества вхождений
    //             totalOccurrences++;
    //         }
    //     });
    //
    //     return totalOccurrences;
  //  }
    //
    // // Выполнить GET-запрос для получения верных ответов
    // fetch('/school/testing/answer')
    //     .then(response => response.json())
    //     .then(data => {
    //         correctAnswers = data; // Сохранить верные ответы в массив
    //     })
    //     .catch(error => console.error('Ошибка получения верных ответов:', error));
});
