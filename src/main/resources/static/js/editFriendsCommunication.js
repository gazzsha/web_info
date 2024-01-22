$('document').ready(function () {
    $('.table #updateButton').on('click',function(event){
        event.preventDefault();

        var href = $(this).attr('href');
        $.get(href,function (friends,status) {
            $('#sourcePeerEdit').val(friends.sourcePeer);
            $('#targetPeerEdit').val(friends.targetPeer);
        });

        $('#editModal').modal();
    });
});