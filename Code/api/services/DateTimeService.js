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

exports.getDateOneYearFromNow = function() {
    var date = new Date();
    return new Date(date.getFullYear() + 1, date.getMonth());
};
var getTodaysDate = function() {
    var date = new Date();
    return new Date(date.getFullYear(), date.getMonth(), date.getDate(), 0, 0, 0, 0);//midnight today(in the past)
};
exports.getTodaysDate = getTodaysDate;

exports.getYesterdaysDate = function() {
    var today = getTodaysDate();
    var oneDay = 1000 * 60 * 60 * 24;
    return new Date(today.getTime() - oneDay);
};
exports.DateTimeEquals = function(date_str1, date_str2)
{
    var date1 = toDateObject(date_str1);
    var date2 = toDateObject(date_str2);

    var diffInMilli = Math.abs( date1.getTime() - date2.getTime());

    if (diffInMilli <= 20000)
        return true;
    else
        return false;
};

var toDateObject = function(dateString)
{
    var parsed = Date.parse(dateString);
    return new Date(parsed);
};