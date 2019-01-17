let db = require('../dbconnection');

let User = {
    getAllUsers: function (callback) {
        return db.query("SELECT * FROM utilisateur", callback);
    },
    getUserByNameAndPassword: function (email, password, callback) {
        return db.query("SELECT * FROM utilisateur WHERE email = ? AND mot_de_passe = ?", [email, password], callback);

    },
    getUserById: function (id, callback) {
        return db.query("SELECT * FROM utilisateur WHERE id = ?", [id], callback);
    }
};
module.exports = User;