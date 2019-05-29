$(document).ready(function () {
    $.getJSON("/info", function (data) {
        printServerInfo(data);
    });
    $('#updateButton').on('click', function(event) {
        event.preventDefault(); // To prevent following the link (optional)
        sendUpdateServer();
    });
    // var data = ;
});

function printServerInfo(data) {
    var elem = document.getElementById("inputHost");
    elem.value = data['hostName'];

    elem = document.getElementById("inputPasscode");
    elem.value = data['passcode'];

    elem = document.getElementById("inputIp");
    var interfaces = '';
    data['netInterfaces'].forEach(function (i) {
        interfaces += i['name'] + ": " + i['ip'] + '  ';
    });
    elem.value = interfaces;

    elem = document.getElementById("checkboxIsVisible");
    if (data['isVisible'] == true) {
        elem.checked="checked";
    }

}

function sendUpdateServer(){
    var data = {};
    var elem = document.getElementById("inputHost");
    data['hostName'] = elem.value;

    elem = document.getElementById("inputPasscode");
    data['passcode'] = elem.value;

    elem = document.getElementById("checkboxIsVisible");

    if(elem.checked == "checked"){
        data['isVisible'] = true;
        console.log(true);
    }else{
        data['isVisible'] = false;
        console.log(false);
    }
    console.log(data);
    // data = JSON.stringify(data);
    console.log(data);
    $.post("/update",
        data,
        function(){console.log("success!!!")});
    // $.ajax({
    //     type: "POST",
    //     url: "http://localhost:8777/update",
    //     dataType: 'json',
    //     data: data,
    //     success: function(){console.log("success!!!")},
    //     error: function(){console.log("ERORORORO!!!")}
    // });
}