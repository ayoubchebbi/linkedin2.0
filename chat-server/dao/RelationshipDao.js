let db = require('../dbconnection');

let Relationship = {
    sendFriendRequest: function (user_one_id, user_two_id, callback) {
        return db.query("INSERT INTO relationship (user_one_id, user_two_id, status, action_user_id) VALUES (?, ?, 'pending', ?)", [user_one_id, user_two_id, user_one_id], callback);
    },

    acceptFriendRequest: function (user_two_id, user_one_id, callback) {
        return db.query("UPDATE relationship SET status = 'accepted', action_user_id = ? WHERE user_one_id = ? AND user_two_id = ?", [user_two_id, user_one_id, user_two_id], callback);
    },

    getFriendsListByUserId: function (id, callback) {
        return db.query(
            "SELECT DISTINCT " +
                "u.id, u.nom,  u.prenom , u.titre_profil, u.email, u.image_path " +
            "FROM " +
            "connexion r " +
                "INNER JOIN " +
            "utilisateur u ON u.id IN (SELECT " +
                "CASE " +
                    "WHEN id_utilisateur1 <> ? " +
                    "THEN id_utilisateur1 " +
                    "ELSE id_utilisateur2 " +
                "END " +
            "FROM " +
                "connexion r " +
            "WHERE " +
                "(id_utilisateur1 = ? OR id_utilisateur2 = ?) " +
                    "AND ajout = 1)", [id, id, id], callback);
    },

};
module.exports = Relationship;