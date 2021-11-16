$(document.ready(function (){
    $('.table .eBtn').on('click', function (e) {
        e.preventDefault();
        var href = $(this).attr('href');

        $.get(href, function (company, status) {
            $('.myform #code').val(company.code);
            $('.myform #name').val(company.name);
            $('.myform #email').val(company.email);
            $('.myform #phone').val(company.phone);
            $('.myform #status').val(company.status);
        });
        $('.myform #exampleModal').modal();
    })

    $(document).ready( function () {
        $('#my-table').DataTable();
    } )
}));

