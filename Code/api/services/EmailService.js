var mailer = require('nodemailer');

var transporter = mailer.createTransport('smtps://fiuvipmailer%40gmail.com:vipadmin123@smtp.gmail.com');

exports.sendEmail = function (recipient, text, subject, errorHandler) {
    var mailOptions = {
        from: 'fiuvipmailer@gmail.com', // sender address
        to: 'fiuvipmailer@gmail.com', // list of receivers
        subject: subject, // Subject line
        bcc: [recipient],
        text: text,
        html: text
    };

    transporter.sendMail(mailOptions, function (error, info) {
        if (error) {
            errorHandler(error);
        }
    });
};