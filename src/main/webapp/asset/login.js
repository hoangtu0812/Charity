$(document).ready(function () {
    $('#email').blur(function () {
        validateEmail();
    })
    $('#password').blur(function () {
        pwdValidate();
    })
})
function validateEmail() {
    let input = $('#email').val();
    let emailPattern = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    let testSpace = /^S/;
    if (input.trim() === '' || input.trim() == null || emailPattern.test(input) === false || testSpace.test(input)) {
        $('#email').addClass('error');

        $('#email-mess').text('Email không hợp lệ!');
        return false;
    } else {
        $('#email').removeClass('error');
        $('#email-mess').text('');
        return true;
    }
}
function pwdValidate() {
    let input = $('#password').val();
    let pwdPattern = /^(?=[a-zA-Z0-9._]{8,20}$)(?!.*[_.]{2})[^_.].*[^_.]$/;
    let testSpace = /^S/;
    if (input.trim() === '' || input.trim() == null || pwdPattern.test(input) === false || testSpace.test(input)) {
        $('#password').addClass('error');
        $('#password-mess').text('Mật khẩu không hợp lệ!');
        return false;
    } else {
        $('#password').removeClass('error');
        $('#password-mess').text('');
        return true;
    }
}

function submitValidate() {
    if (validateEmail() && pwdValidate()) {
        return true;
    } else {
        return false;
    }
}
