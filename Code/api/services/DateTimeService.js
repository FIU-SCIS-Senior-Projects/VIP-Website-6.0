exports.getCurrentDateTimeAsString = function() {
    var d = new Date();
    var date = d.getDate();
    var month = d.getMonth()+1;
    var year = d.getFullYear();
    var hours = d.getHours();
    var min = d.getMinutes();
    var sec = d.getSeconds();
    var ampm = hours >= 12 ? 'pm' : 'am';
    hours = hours % 12;
    hours = hours ? hours : 12;
    min = min < 10 ? '0'+min : min;
    return month+"/"+date+"/"+year+" "+hours+":"+min+":"+sec + ' ' + ampm;
};