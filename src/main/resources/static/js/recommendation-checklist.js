$('document').ready(function () {
    $('#recommendedPeers').modal({
        backdrop: 'static',
        keyboard: false
    });


    $('.button').on('click',function(event) {
        event.preventDefault();
        var currentUrl = window.location.href;
        var parts = currentUrl.split('/');
        var lastPart = parts[parts.length - 1];
        var spanText = this.querySelector('span').innerText;
        var url = '/school/recommendations/deleteRecommendations?peer=' + encodeURIComponent(lastPart) + '&recommendedPeer=' + encodeURIComponent(spanText);
        window.location.href = url;
    })
});
