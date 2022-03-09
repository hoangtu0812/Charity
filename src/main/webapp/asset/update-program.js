$(document).ready(function (){
    $("#name").blur(function () {
        nameValidation();
    })
    $("#des").blur(function () {
        desValidation();
    })
    $("#detail").blur(function (){
        detailValidation();
    })
    $("#foundation").blur(function () {
        foundationValidation();
    })
    $("#src").blur(function () {
        srcValidation();
    })
    $("#target").blur(function () {
        targetValidation();
    })
    $("#endtime").blur(function () {
        dateValidation();
    })

})

function nameValidation() {
    let input = $("#name").val();
    console.log(input.length);
    console.log(input);
    if(input.trim() === "") {
        $("#name").css("border-color", "red");
        $("#name-mess").text("This field is required!");
        return false;
    } else if(input.length >= 200) {
        $("#name").css("border-color", "red");
        $("#name-mess").text("Program name must be less than 200 character!");
        return false;
    } else {
        $("#name").css("border-color", "#cccccc");
        $("#name-mess").text("");
        return true;
    }
}
function desValidation() {
    let input = $("#des").val();
    console.log(input);
    if(input.trim() === '' || input.length<1) {
        $("#des").css("border-color", "red");
        $("#des-mess").text("This field is required!");
        return false;
    } else if(input.length >= 255) {
        $("#des").css("border-color", "red");
        $("#des-mess").text("This field must be less then 255 character!");
        return false;
    } else {
        $("#des").css("border-color", "#cccccc");
        $("#des-mess").text("");
        return true;
    }

}

function detailValidation() {
    let input = $("#detail").val();
    console.log(input);
    if(input.trim() === '' || input.length < 1) {
        $("#detail").css("border-color", "red");
        $("#detail-mess").text("This field is required!");
        return false;
    } else {
        $("#detail").css("border-color", "#cccccc");
        $("#detail-mess").text("");
        return true;
    }

}

function foundationValidation() {
    let input = $("#foundation").val();
    if(input.trim() === '' || input.length < 1) {
        $("#foundation").css("border-color", "red");
        $("#foundation-mess").text("This field is required!");
        return false;
    } else if(input.length >= 100) {
        $("#foundation").css("border-color", "red");
        $("#foundation-mess").text("This must be less than 100 characters!");
        return false;
    } else {
        $("#foundation").css("border-color", "#cccccc");
        $("#foundation-mess").text("");
        return true;
    }
}

function srcValidation() {
    let input = $("#src").val();
    if(input.trim() === '' || input.length < 1) {
        $('#src').css('border-color', ' red');
        $('#src-mess').text('This field can not empty!');
        return false;
    } else if(input.length >= 255) {
        $('#src').css('border-color', ' red');
        $('#src-mess').text('This field must be less than 255 characters!');
        return false;
    } else {
        $('#src').css('border-color', '#cccccc');
        $('#src-mess').text('');
        return true;
    }

}

function targetValidation() {
    let input = $('#target').val();
    if(isNaN(input)) {
        $('#target').css('border-color', 'red');
        $('#target-mess').text('Invalid input!');
        return false;
    } else if(input > 2000000000){
        $('#target').css('border-color', 'red');
        $('#target-mess').text('Target must be less than 2.000.000.000 VND');
        return false;
    }else if(input.trim() === '' || input.length < 1) {
        $('#target').css('border-color', 'red');
        $('#target-mess').text('This field can not empty!');
        return false;
    } else if(input <= 0) {
        $('#target').css('border-color', 'red');
        $('#target-mess').text('Target must be more than 0 VND');
        return false;
    }else {
        $('#target').css('border-color', '#cccccc');
        $('#target-mess').text('');
        return true;
    }
}

function dateValidation() {
    let input = $('#endtime').val();
    let today = new Date().toISOString().slice(0, 10)
    var dt1 = new Date(today);
    var dt2 = new Date(input);

    var time_difference = dt2.getTime() - dt1.getTime();
    var result = time_difference / (1000 * 60 * 60 * 24);
    console.log(result);
    if(input === '') {
        $('#endtime').css('border-color', 'red');
        $('#endtime-mess').text('Please choose one day!');
        return false;
    } else if(input<= today) {
        console.log("false!");
        $('#endtime').css('border-color', 'red');
        $('#endtime-mess').text('Please do not choose previous day!');
        return false;
    } else {
        console.log(today)
        console.log(input);
        console.log(today < input);
        $('#endtime').css('border-color', '#cccccc');
        $('#endtime-mess').text('');
        return true;
    }

}


function confirmUpdateClick() {
    return nameValidation() && desValidation() && detailValidation() && foundationValidation() && srcValidation() && targetValidation() && dateValidation();

}