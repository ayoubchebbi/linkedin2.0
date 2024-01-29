Subject: Organizational Updates and Action Plan for PLM Project

Dear Team,

I hope this email finds you well. As we progress with our PLM (Product Lifecycle Management) project, it's essential to ensure that we are organized and aligned with our technical efforts, documentation processes, and issue management. Therefore, I'd like to address a few key points to streamline our operations and enhance collaboration:

Technical Organization:
Let's take a moment to review and organize our technical workflows. It's crucial that everyone understands their roles and responsibilities clearly. We should also assess our current technical infrastructure and identify any areas for improvement or optimization.

Confluence Reorganization:
Our Confluence space serves as a central hub for project documentation and collaboration. To improve accessibility and efficiency, we need to reorganize the content structure. Let's categorize information logically, ensure proper labeling, and update outdated documentation as needed.

Documentation Creation:
Each stage of our PLM project requires comprehensive documentation to track progress, decisions made, and any changes implemented. I propose that we create structured documentation for every part of the project, covering requirements, designs, implementation details, and testing procedures.

Issue Management:
Effective issue management is crucial for identifying and resolving problems promptly. Let's incorporate a standardized approach for logging and tracking issues within our project management system. Additionally, we should introduce a classification system to categorize issues based on their type and severity.

I encourage everyone to actively participate in these initiatives to ensure their success. Collaboration and communication are key to achieving our project objectives efficiently.

Please feel free to share any insights or suggestions you may have regarding the proposed actions. Let's work together to drive our PLM project forward effectively.

Best regards,

[Your Name]
[Your Position/Role]
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

