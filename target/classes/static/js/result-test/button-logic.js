$('document').ready(function () {

    $('#search-button').on('click', async function (event) {
        event.preventDefault();
        let filter = document.getElementById("user-search").value;


// Разделить строку на подстроки по пробелу
        let parts = filter.split("//s+");

// Создать переменные для первой и второй части строки
        let firstString = parts[0];
        let secondString = parts[1];

// Если вторая часть отсутствует, второй переменной присвоить значение null или пустую строку
        if (parts.length < 2) {
            secondString = firstString;
        }
        if (firstString != null && !isEmpty(firstString)) {
            let url = '/school/results?name=' + firstString;
            fetch(url, {method: 'GET'})
                .then(response => {
                    window.open(url, '_self');
                })
        } else window.open('/school/results', '_self')
    })

});

function isEmpty(obj) {
    for (let key in obj) {
        // если тело цикла начнет выполняться - значит в объекте есть свойства
        return false;
    }
    return true;
}


document.addEventListener('DOMContentLoaded', function () {
    // Находим все элементы с классом card-body и добавляем им обработчик события click
    const cardBodies = document.querySelectorAll('.card-body[data-id]');
    cardBodies.forEach(cardBody => {
        cardBody.addEventListener('click', function (event) {
            // Останавливаем всплытие события, чтобы предотвратить обработку события клика родительскими элементами
            event.stopPropagation();

            // Получаем идентификатор пользователя из атрибута data-id
            const userId = this.getAttribute('data-id');

            // Выполняем необходимые действия с полученным идентификатором пользователя
            // Например, перенаправление на страницу профиля пользователя
            window.location.href = "/school/profiles/" + userId;
        });
    });
});
