Subject: Sharing Apex Best Practices Presentation

Dear [Recipient's Name],

I trust this message finds you well. Following our recent discussion on Apex best practices, I am pleased to share the presentation summarizing the key insights and recommendations.

Subject: Apex Best Practices Presentation

The attached PowerPoint presentation encapsulates the best practices for Apex classes, methods, and variables, along with additional insights on test classes. The content is structured to provide a comprehensive guide for enhancing code quality and maintainability in Salesforce development.

Please feel free to review the presentation at your convenience. Should you have any questions or require further clarification on specific points, I am more than happy to schedule a follow-up discussion.

Thank you for your time and attention to this matter. Looking forward to our continued collaboration.

Best regards,

[Your Full Name]
[Your Position]
[Your Company]
[Your Contact Information]

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

