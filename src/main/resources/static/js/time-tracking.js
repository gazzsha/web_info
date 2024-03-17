$('document').ready(function () {

    $('#search-button').on('click', async function (event) {
        event.preventDefault();
        let nickname = document.getElementById("username-search").value;

        let url = '/school/timetracking?nickname=' + nickname;
        fetch(url, {method: 'GET'})
            .then(response => {
                    window.open(url, '_self');
                })
    })
});