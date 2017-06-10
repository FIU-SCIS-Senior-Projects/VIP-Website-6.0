var cron = require('node-cron');
var emailService = require('./EmailService');
var Project = require('../models/projects');
var User = require('../models/users');

var sendNotification = function(app, emails, projects) {
    var subject = "Existing Vip projects notification";
    var body = "Dear Vip user:<br/>The following projects are available right now for you to apply to:<br/>";
    projects.forEach(function(project) {
        var url = app.get("baseWebUrl") + '/vip-projects-detailed/' + project._id;
        body += "<a href='" + url + "'>" + project.title + "</a><br/>";
    });
    body += "To opt out of this notifications, visit the <a href='" + app.get("baseWebUrl") + "/login'>vip website<a/><br/>." +
        " Login, click on the profile icon, and then uncheck the \"allow notifications\" checkbox.";

    emailService.sendEmail(emails, body, subject, function(error) {
        console.log('Failed to send existing projects notification email to ' + emails + ".\nWith error: " + error.toString());
    });
};

exports.configureNotifications = function(cronPattern, app) {
    var valid = cron.validate(cronPattern);
    if (!valid) {
        throw "Invalid cron expression set for existing projects notifications.";
    }
    cron.schedule(cronPattern, function() {
        Project.find({ status: 'Active' }, '_id title', function (err, projects) {
            if (err) {
                console.log("Failed to get a list of projects from the database to send existing project notifications." +
                    "\nWith error: " + err.toString());
            } else if (projects.length === 0) {
                console.log("No active projects found to notify users about in our monthly email.");
            } else {
                var error = null;
                var emails = "";

                User.find(null, 'email').stream().on('data', function(user) {
                    emails += "," + user.email;
                }).on('error', function(e) {
                    error = e;
                    console.log("Failed to get a list of user emails from the database to send existing project notifications." +
                        "\nWith error: " + err.toString());
                }).on('close', function() {
                    if (!error) {
                        emails = emails.substring(1);//delete initial comma
                        sendNotification(app, emails, projects);
                    }
                });
            }
        });
    }, true);
};