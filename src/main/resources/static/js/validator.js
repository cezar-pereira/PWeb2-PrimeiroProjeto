let btnSubmit = document.getElementById('btnSubmit');
function sendForm() {
    if (validatorRegister())
        document.formRegister.submit();
}

function validatorRegister() {
    if (validateName()) {
        if (validateEmail())
            if (validadeCpf())
                if (validateAreaActing())
                    if (validatePassword()) {
                        btnSubmit.disabled = false;
                        return true;
                    } else {
                        btnSubmit.disabled = true;
                    }
    } else {
        return false;
    }
    return false;
}

function validateName() {
    console.log('chamou nome');
    let name = document.getElementById("inputName");

    if (name.value.length > 0) {
        if (name.value.length < 2) {
            name.classList.remove('is-valid');
            name.classList.add('is-invalid');
            spanInputName.innerHTML = "O nome deve ter mais de 2 caracteres";
            return false;
        } else {
            name.classList.remove('is-invalid');
            name.classList.add('is-valid');
            spanInputName.innerHTML = "";
            return true;
        }
    } else {
        return false;
    }
}

function validateEmail() {
    console.log('chamou email');
    let email = document.getElementById("inputEmail");

    if (email.value.length != 0) {
        if (email.value.length < 5) {
            email.classList.remove('is-valid');
            email.classList.add('is-invalid');
            spanInputEmail.innerHTML = "Digite um email válido";
            return false;
        } else {
            if ((email.value.match(/@/)) && (email.value.match(/\./))) {
                email.classList.remove('is-invalid');
                email.classList.add('is-valid');
                spanInputEmail.innerHTML = "";
                return true;
            } else {
                email.classList.remove('is-valid');
                email.classList.add('is-invalid');
                spanInputEmail.innerHTML = "Digite um email válido";
                return false;
            }
        }
    }
}

function validadeCpf() {
    console.log('chamou cpf');
    let cpf = document.getElementById('inputCpf');

    if (cpf.value.length > 3) {
        if (cpf.value.match(/\./) || cpf.value.match(/[a-zA-Z]/)) {
            cpf.classList.remove('is-valid');
            cpf.classList.add('is-invalid');
            spanInputCpf.innerHTML = 'Digite apenas números';
        } else {
            if (cpf.value.length === 11) {
                cpf.classList.remove('is-invalid');
                cpf.classList.add('is-valid');
                spanInputCpf.innerHTML = '';
                return true;
            } else {
                cpf.classList.remove('is-valid');
                cpf.classList.add('is-invalid');
                // spanInputCpf.innerHTML = 'Digite um CPF válido';
                return false;
            }
        }
    } else {
        spanInputCpf.innerHTML = '';
        return false;
    }
}

function validateSex() {

}

function validateAreaActing() {
    console.log('chamou area');
    let areaActing = document.getElementsByName("areas");

    for (let i = 0; i < areaActing.length; i++) {
        if (areaActing[i].checked) {
            spanAreaActing.innerHTML = "";
            return true;
        } else
            spanAreaActing.innerHTML = "Selecione ao menos uma opção";
    }
}

function validatePassword() {
    console.log('chamou senha');
    let password = document.getElementById("inputPassword");
    let confirmPassword = document.getElementById("inputConfirmPassword");

    if (password.value.length >= 6) {
        spanInputPassword.innerHTML = "";
        password.classList.remove('is-invalid');
        password.classList.add('is-valid');
        if (password.value === confirmPassword.value) {
            confirmPassword.classList.remove('is-invalid');
            confirmPassword.classList.add('is-valid');
            return true;
        } else {
            if (confirmPassword.value != 0) {
                confirmPassword.classList.remove('is-valid');
                confirmPassword.classList.add('is-invalid');
            }
            return false;
        }
    } else if (password.value.length != 0) {
        password.classList.add('is-invalid');
        spanInputPassword.innerHTML = "A senha deve ter ao menos 6 caracteres";
        return false;
    }
}