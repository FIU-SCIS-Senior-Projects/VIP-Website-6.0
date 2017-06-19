var mailer = require('nodemailer');
var User = require('../models/users');

var transporter = mailer.createTransport('smtps://fiuvipmailer%40gmail.com:vipadmin123@smtp.gmail.com');

var sendEmail = function (recipient, text, subject, errorHandler, successHandler) {
    var mailOptions = {
        from: 'FIU VIP <vipadmin@fiu.edu>', // sender address
        to: 'fiuvipmailer@gmail.com', // list of receivers
        subject: subject, // Subject line
        bcc: [recipient],
        text: text,
        html: text
    };

    transporter.sendMail(mailOptions, function (error, info) {
        if (error) {
            if (errorHandler) {
                errorHandler(error);
            }
        } else if (successHandler) {
            successHandler();
        }
    });
};

var sendEmailWithHeaderAndSignature = function (user, mainText, subject, errorHandler, successHandler) {
    var name = (user.firstName) ? user.firstName + " " + user.lastName : "VIP user";
    var greeting = "Dear " + name + ",<br/><br/>";
    var signature = "<br/><br/>Sincerely,<br/>Masoud Sadjadi<br/>VIP PI";

    sendEmail(user.email, greeting + mainText + signature, subject, errorHandler, successHandler);
};

exports.sendEmail = sendEmail;
exports.sendEmailWithHeaderAndSignature = sendEmailWithHeaderAndSignature;

exports.sendEmailWithHeaderAndSignatureNoUser = function (recipient, mainText, subject, errorHandler, successHandler) {
    User.findOne({ email: recipient }, function(error, user) {
        if (error || !user) {
            console.log("Failed to find user " + recipient + " to send an email to.\n" + error.toString());
            sendEmailWithHeaderAndSignature({ email: recipient }, mainText, subject, errorHandler, successHandler);
        } else {
            sendEmailWithHeaderAndSignature(user, mainText, subject, errorHandler, successHandler);
        }
    });
}