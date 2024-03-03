$('document').ready(function () {

    $('#addNew').on('click', async function (event) {
        event.preventDefault();
        let nickname = document.getElementById("nicknameForm").value;
        let birthday = document.getElementById("birthdayForm").value;

        let data = {
            "nickname": nickname,
            "birthday": birthday
        };

        console.log(data);

        let response = fetch('peer', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify(data)
        }).then(response => {
            if (response.ok) {
                // Если ответ успешен (статус код 200-299), открываем ссылку
                window.open("peers", '_self');
            } else {
                console.error('Ошибка удаления:', response.body);
            }
        });
        let result = await response.json();
        alert(result.message);
    });

    $('.table a.btn-warning').on('click', function (event) {
        event.preventDefault();

        var href = $(this).attr('href');
        $.get(href, function (peer, status) {
            $('#nicknameEdit').val(peer.nickname);
            $('#birthdayEdit').val(peer.birthday);
        });

        $('#editModal').modal();
    });

    $('.table #deleteButton').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#deleteModal #delRef').attr('href', href);
        $('#deleteModal').modal();
    });
    $('#delRef').on('click', function (event) {
        event.preventDefault();
        var url = $(this).attr('href');
        fetch(url, {method: 'DELETE'})
            .then(response => {
                if (response.ok) {
                    // Если ответ успешен (статус код 200-299), открываем ссылку
                    window.open("peers", '_self');
                } else {
                    console.error('Ошибка удаления:', response.body);
                }
            })
    });
});
