$('document').ready(function () {
    $('#deleteButton').on('click',function(event) {
        event.preventDefault();


        var sourcePeer = document.getElementById('sourcePeer').value;
        var targetPeer = document.getElementById('targetPeer').value;

        var url = '/school/friends/deleteFriends?sourcePeer=' + encodeURIComponent(sourcePeer) + '&targetPeer=' + encodeURIComponent(targetPeer);
        window.location.href = url;
    })});