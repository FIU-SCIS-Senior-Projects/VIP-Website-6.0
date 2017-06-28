/**
 * Created by Dafna on 6/17/17.
 */

var Setting = require('../models/settings');
var bodyParser = require('body-parser');

module.exports = function(app, express) {
    var apiRouter = express.Router();

    apiRouter.route('/settings')
        .post(function (req, res) {

            console.log(req);
            console.log(res);

            Setting.create(req.body, function (err) {
                if (err) {
                    res.status(400);
                    return res.send(err);
                }

                return res.json({success: true});

            });
        })
        .get(function (req, res) {

        });
    apiRouter.route('/settings/:id')
        .put(function (req, res) {

        })
        .get(function (req, res) {

        })
        .delete(function (req, res) {

            Setting.remove({_id: req.params.id}, function (err)
            {
                if (err)
                    return res.send(err);
                res.json({message: 'Successfully deleted!'});
            })

        });
    apiRouter.route('/admin')
        .get(function (req, res)
        {
            Setting.findOne({owner: "admin"}, function(err, settings)
            {
                if (err)
                    return res.send(err);

                res.json(settings);
            })
        })
        .put(function(req, res)
        {
            Setting.findOne({owner: "admin"}, function(err, settings)
            {
                settings.owner = "admin";
                settings.emails = req.body.emails;
                settings.current_email = req.body.current_email;
                settings.emailSignature = (req.body.emailSignature) ? req.body.emailSignature : settings.emailSignature;
                settings.save(function(err)
                {
                    if (err)
                    {
                        res.status(400);
                        return res.send(err);
                    }
                    res.json({message: 'Saved!' })
                });
            });
        });
    apiRouter.route('/allsettings')
        .get(function (req, res) {

            Setting.find({}, function(err, settings) {
                if (err)
                    return res.send(err);

                res.json(settings);
            });

        });

    return apiRouter;
};