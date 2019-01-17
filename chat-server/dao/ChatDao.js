let db = require('../dbconnection');

let Chat = {
    sendMessage: function (user_from_id, user_to_id, message, callback) {
        return db.query("INSERT INTO chat (user_from_id, user_to_id, message, date) VALUES (?, ?, ?, ?)", [user_from_id, user_to_id, message, new Date()], callback);
    },
    getMessages: function (me, friend, callback) {
        return db.query("SELECT * FROM chat " +
            "WHERE " +
            "(user_from_id = ? AND user_to_id = ?) " +
            "OR " +
            "(user_from_id = ? AND user_to_id = ?) " +
            "ORDER BY date asc", [me, friend, friend, me], callback);
    },
    getMessageById: function (id, callback) {
        return db.query("SELECT * FROM chat WHERE chat_id = ?", [id], callback);
    },
    getLastMessagesByUserId: function (me, callback) {
        return db.query("SELECT " +
            "temp.chat_id," +
            "temp.user_from_id," +
            "temp.user_to_id," +
            "temp.message," +
            "temp.date " +
            "FROM " +
            "(SELECT " +
            "CASE " +
            "WHEN c.user_from_id <> ? THEN c.user_from_id " +
            "ELSE c.user_to_id " +
            "END AS id," +
            "c.chat_id," +
            "c.user_from_id," +
            "c.user_to_id," +
            "c.message," +
            "c.date " +
            "FROM " +
            "chat c " +
            "ORDER BY c.date DESC) as temp " +
            "group by temp.id ", [me], callback);
    },
};
module.exports = Chat;