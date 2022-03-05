$(document).ready(function () {
    $('#email').blur(function () {
        validateEmail();
    })
    $('#password').blur(function () {
        pwdValidate();
    })
    $('#name').blur(function (){
        nameValidate();
    })
    $('#address').blur(function () {
        addValidate();
    })
    $('#phone').blur(function () {
        phoneValidate();
    })
})

function validateEmail() {
    let input = $('#email').val();
    let emailPattern = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    let testSpace = /^S/;
    if (input.trim() === '' || input.trim() == null || emailPattern.test(input) === false || testSpace.test(input)) {
        $('#email').addClass('error');

        $('#email-mess').text('Username is invalid!');
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
        $('#password-mess').text('Password is invalid!');
        return false;
    } else {
        $('#password').removeClass('error');
        $('#password-mess').text('');
        return true;
    }
}

function nameValidate() {
    let input = $('#name').val();
    if(input.trim() === '' || input.trim() == null){
        $('#name').addClass('error');
        $('#name-mess').text('Please enter your name!');
        return false;
    } else {
        $('#name').removeClass('error');
        $('#name-mess').val();
        return true;
    }
}

function addValidate() {
    let input = $('#address').val();
    if(input.trim() === '' || input.trim() == null) {
        $('#address').addClass('error');
        $('#address-mess').text('Please enter your address!');
        return false;
    } else {
        $('#address').removeClass('error');
        $('#address-mess').text('');
        return true;
    }
}

function phoneValidate() {
    let input = $('#phone').val();
    if(input.trim() === '' || input.trim() == null || input.length !== 10) {
        $('#phone').addClass('error');
        $('#phone-mess').text('Phone number is invalid!');
        return false;
    } else {
        $('#phone').removeClass('error');
        $('#phone-mess').text('');
        return true;
    }
}
function submitValidate() {
    if (validateEmail() && pwdValidate() && nameValidate() && addValidate() && phoneValidate()) {
        return true;
    } else {
        return false;
    }
}