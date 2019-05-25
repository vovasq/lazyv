$(document).ready(function () {
    $.getJSON("/info", function (data) {
        setServerInfo(data);
    });
    // var data = ;
});


function setServerInfo(data) {
    var elem = document.getElementById("inputHost");
    elem.placeholder = data['hostName'];

    elem = document.getElementById("inputPasscode");
    elem.placeholder = data['passcode'];

    elem = document.getElementById("inputIp");
    var interfaces = '';
    data['netInterfaces'].forEach(function (i) {
        interfaces += i['name'] + ": " + i['ip'] + '  ';
    });
    elem.value = interfaces;

    elem = document.getElementById("checkboxIsVisible")
    if (data['isVisible'] == true) {
        elem.checked="checked";
    }

}