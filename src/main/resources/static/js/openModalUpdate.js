$(document).ready(function () {
    $('.table .eBtn').on('click', function (event) {
        event.preventDefault();
        let href = $(this).attr('href');
        let areaActing = document.getElementsByName("areas");

        $.get(href, function (student, status) {
            $('#inputId').val(student.id);
            $('#inputName').val(student.name);
            $('#inputEmail').val(student.email);
            $('#inputCpf').val(student.cpf);
            $('#inputGender').val(student.sex);
            $('#inputModule').val(student.module);
            $('#inputPassword').val(student.password);
            $('#inputConfirmPassword').val(student.password);

            if (student.areas.includes("Programação"))
                areaActing[0].checked = true;
            if (student.areas.includes("Redes de computadores"))
                areaActing[1].checked = true;
            if (student.areas.includes("Manutenção de computadores"))
                areaActing[2].checked = true;
        });
    });
});