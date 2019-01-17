let express = require('express');
let Dao = require('../dao/UserDao');

//Creating Router() object
let user = express.Router();

user.post('/login', function (req, res) {
    Dao.getUserByNameAndPassword(req.body.username, req.body.password, function (err, rows) {
        if (err) {
            res.json(err);
        } else {
            res.json(rows);
        }
    })
});

user.get('/:id?', function (req, res, next) {
    if (req.params.id) {
        Dao.getUserById(req.params.id, function (err, rows) {
            if (err) {
                res.json(err);
            } else {
                res.json(rows);
            }
        });
    } else {
        Dao.getAllUsers(function (err, rows) {
            if (err) {
                res.json(err);
            }
            else {
                res.json(rows);
            }
        });
    }
});

module.exports = user;
