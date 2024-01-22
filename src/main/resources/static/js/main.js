$('document').ready(function () {
  $('.table a.btn-warning').on('click',function(event){
      event.preventDefault();

      var href = $(this).attr('href');
      $.get(href,function (peer,status) {
          $('#nicknameEdit').val(peer.nickname);
          $('#birthdayEdit').val(peer.birthday);
      });

      $('#editModal').modal();
  });

    $('.table #deleteButton').on('click',function(event){
        event.preventDefault();
        var href = $(this).attr('href');
        $('#deleteModal #delRef').attr('href', href);
        $('#deleteModal').modal();
    });
});