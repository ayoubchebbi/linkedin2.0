The objective of this meeting with the developer team to revolve around enhancing our - -. We aim to collectively address existing challenges 
and issues within the platform, ensuring a thorough understanding of the hurdles we face. Moreover, it is important to explore and discuss 
emerging technologies that can be effectively integrated into our Salesforce environment,
 leveraging innovation to optimize performance and user experience.

Furthermore, the meeting will serve as a platform to brainstorm and strategize for upcoming projects and tasks.
 We will delve into project timelines, resource allocation, and task prioritization to ensure alignment with organizational
 goals and objectives. In Addition, reinforcement open communication and collaboration among team members will be prioritized to encourage 
 the sharing of insights, ideas, and best practices.





# linkedin2.0

-----------------------------------------------------------------------------------------------------------------------------

# How to run the Chat !!

(You must have the server running in terminal (Soon It will be integrated with Dcoker :3 ) )

> cd chat-server

> npm install

> npm start

--> Run the client Side and go to message 

-----------------------------------------------------------------------------------------------------------------------------
# How to Run the Client side !!

> cd client

> npm install

> ng serve --aot

-----------------------------------------------------------------------------------------------------------------------------

# How to run the Server ! with Docker :p 
(Install doker ofc xD)
(No need to open XAMPP or phpmyadmin or any Server)

> docker pull mysql

> sudo docker run --name mysql-standalone -e MYSQL_ROOT_PASSWORD=IlogPassLi -e MYSQL_DATABASE=linkedin2 -e MYSQL_USER=user -e MYSQL_PASSWORD=IlogPassLi -d mysql:5.6

Inside Project folder (hosni@Xochn:~/Documents/linkedin2.0$)

> sudo docker build . -t linkedin-mysql -f Dockerfile.spring

> sudo docker run -p 8080:8080 --name linkedin-mysql --link mysql-standalone:mysql -d linkedin-mysql

# chat

> sudo docker build . -t chat-mysql

> sudo docker run -p 5000:5000 --name chat-mysql --link mysql-standalone:mysql -d chat-mysql


If you make change to the code you have to redeploy the app 

> sudo docker stop linkedin-mysql

> sudo docker rm linkedin-mysql

> sudo docker image rm linkedin-mysql


----------------------------------

# Start Old container

> sudo docker start mysql-standalone

> sudo docker start chat-mysql

> sudo docker start linkedin-mysql

