let express = require('express');
let Dao = require('../dao/ChatDao');

//Creating Router() object
let chat = express.Router();

chat.post('/', function (req, res, next) {
    let user_from_id = req.body.user_from_id;
    let user_to_id = req.body.user_to_id;
    let message = req.body.message;

    Dao.sendMessage(user_from_id, user_to_id, message, function (err, count) {
        if (err) {
            res.json(err);
        } else {
            res.json(req.body);
        }
    })
});

chat.get('/:me/:friend', function (req, res, next) {
    Dao.getMessages(req.params.me, req.params.friend, function (err, rows) {
        if (err) {
            res.json(err);
        } else {
            res.json(rows);
        }
    })
});

chat.get('/:me', function (req, res, next) {
    Dao.getLastMessagesByUserId(req.params.me, function (err, rows) {
        if (err) {
            res.json(err);
        } else {
            res.json(rows);
        }
    })
});

module.exports = chat;