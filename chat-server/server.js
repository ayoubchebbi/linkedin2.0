const express = require('express');
const bodyParser = require('body-parser');

let app = express();

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: false}));

app.use(function (req, res, next) {

    res.header("Access-Control-Allow-Origin", "*");
    res.header("Access-Control-Allow-Methods", 'POST, GET, OPTIONS, DELETE, PUT, PATCH');
    res.header("Access-Control-Allow-Credentials", "true");
    res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization");
    res.header('Access-Control-Expose-Headers', 'x-authorization');

    next();
});

let routerUser = require('./routes/UserRoute');
let routerRelationship = require('./routes/RelationshipRoute');
let routerChat = require('./routes/ChatRoute');


// Tell express to use this router with /api before.
app.use("/user", routerUser);
app.use("/relationship", routerRelationship);
app.use("/chat", routerChat);

// partie socket
let http = require('http').Server(app);

// serveur du socket http://localhost:5000
http.listen(5000,"0.0.0.0", function () {
    console.log('started on port 5000');
});