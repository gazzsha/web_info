// document.addEventListener("DOMContentLoaded", function() {
//     var card = document.getElementById("card1");
//     card.addEventListener("click", function() {
//         window.open("testing", '_self');
//     });
// });

document.addEventListener("DOMContentLoaded", function() {
    var cards = document.querySelectorAll(".card");
    cards.forEach(function(card) {
        card.addEventListener("click", function() {
            // Получаем id карточки
            var cardId = card.id;
            // Здесь можно получить URL теста на основе cardId из вашего объекта test
            // Открываем тест
            if (cardId) {
                window.open("testing/"+cardId, '_self');
            } else {
                console.log("URL теста не найден для данного id карточки");
            }
        });
    });
});
