let express = require('express');
let Dao = require('../dao/RelationshipDao');

//Creating Router() object
let relationship = express.Router();

relationship.post('/sendRequest', function (req, res, next) {
    let user_one_id = req.body.user_one_id;
    let user_two_id = req.body.user_two_id;

    Dao.sendFriendRequest(user_one_id, user_two_id, function (err, count) {
        if (err) {
            res.json(err);
        } else {
            res.json(req.body);
        }
    });
});

relationship.post('/acceptRequest', function (req, res, next) {
    let user_two_id = req.body.user_two_id;
    let user_one_id = req.body.user_one_id;

    Dao.acceptFriendRequest(user_two_id, user_one_id, function (err, count) {
        if (err) {
            res.json(err);
        } else {
            res.json(req.body);
        }
    });
});

relationship.get('/friendsList/:id', function (req, res, next) {
    Dao.getFriendsListByUserId(req.params.id, function (err, rows) {
        if (err) {
            res.json(err);
        } else {
            res.json(rows);
        }
    })
});

module.exports = relationship;