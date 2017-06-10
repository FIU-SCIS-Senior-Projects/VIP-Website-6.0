//base setup michael
var express		= require('express');
var nodemailer = require('nodemailer');
var dateTimeService = require('./api/services/DateTimeService');
var mongoose	        = require('mongoose');
var passport			= require('passport');
var cookieParser		= require('cookie-parser');
var flash				= require('connect-flash');
var session             = require('express-session');
var bodyParser	        = require('body-parser');
var path		= require('path');
var config		= require('./api/config/config');
var app			= express();

//Set HOST
app.set("host", "localhost");
app.set("protocol", "http");
app.set("baseWebUrl", app.get("protocol") + "://" + app.get("host") + "/#");

require('./deployment/gulpfile')('./webapp/');//this will take care to generate the distrib js and css files.
require('./api/services/ExistingProjectsNotificationService').configureNotifications('0 0 0 1 * *', app);//setup existing projects notifications for the first day of each month

//connect to mongodb
mongoose.connect(config.database, { server: { poolSize: 30 } });
mongoose.connection.on('error', function(err) {
	//console.log('Error: could not connect to MongoDB.');
});

require('./api/config/passport')(passport,app);
app.use(bodyParser.json({limit: '5mb'}));
app.use(bodyParser.urlencoded({limit: '5mb', extended: true}));
app.use(cookieParser());

app.use(function(req, res, next) {
	res.setHeader('Access-Control-Allow-Origin', '*');
	res.setHeader('Access-Control-Allow-Methods', 'GET, POST');
	res.setHeader('Access-Control-Allow-Headers', 'X-Requested-With,content-type, Authorization');
	next();
});

app.use(session({
    secret: 'ThisIsMyDirtyLittleSecretChocolatebunniesson',
    cookie: {
        expires: dateTimeService.getDateOneYearFromNow()
    }
}));
app.use(passport.initialize());
app.use(passport.session());
app.use(flash());

// set static files location
// used for requests that our frontend will make
app.use(express.static(__dirname + '/webapp', { maxage: '1d' }));
app.set('root',__dirname + '/webapp');

var userRoutes = require('./api/routes/userRoutes')(app, express);
var projectRoutes = require('./api/routes/projectsRoutes')(app,express);
var toDoRoutes = require('./api/routes/toDoRoutes')(app,express);
var profileRoutes = require('./api/routes/profileApi')(app,express);
var supportRoutes = require('./api/routes/support')(app,express);
var logRoutes = require('./api/routes/logRoutes')(app,express);


app.use('/api', projectRoutes);
app.use('/vip', userRoutes);
app.use('/api', profileRoutes);
app.use('/todo', toDoRoutes);
app.use('/support', supportRoutes);
app.use('/log', logRoutes);





//home page
app.get('*', function (req, res) {
	//console.log(req.user);
	res.sendFile(path.join(__dirname + '/webapp/index.html'));
});

//start the server
app.listen(config.port);
//console.log('Express router listening on port: ' + config.port);
