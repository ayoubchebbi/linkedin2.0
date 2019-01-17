var mysql = require('mysql');
var connection = mysql.createPool({
    host: 'localhost',
    user: 'root',
    password: '',
    database: 'linkedin2'
});
module.exports = connection;

// No Docker

/*
var connection = mysql.createPool({
	host: 'mysql-standalone',
    user: 'user',
    password: 'IlogPassLi',
    database: 'linkedin2'
});
 */