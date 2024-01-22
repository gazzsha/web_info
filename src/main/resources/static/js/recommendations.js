$('document').ready(function () {

    $('#fieldAddButton').on('click',function(event) {
        event.preventDefault();
        var peer = document.getElementById('peer').value;
        var recommendedPeer = document.getElementById('recommendedPeer').value;
        var url = '/school/recommendations/addRecommendations?peer=' + encodeURIComponent(peer) + '&recommendedPeer=' + encodeURIComponent(recommendedPeer);
        window.location.href = url;

    })

    $('.btn').on('click',function(event) {
        event.preventDefault();

        var spanText = this.querySelector('span').innerText;
        var url = '/school/recommendations/' + encodeURIComponent(spanText);
        window.open(url,"_self")
    })

});

