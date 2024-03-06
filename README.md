Objet : Clarification et Points à Tester - API Data Logs et Autres Champs Techniques

Chers tous,

J'espère que vous allez bien. Je souhaite clarifier quelques points importants concernant certains aspects techniques et champs spécifiques que nous avons rencontrés récemment, ainsi que partager nos prochaines étapes concernant les tests et les modifications à apporter.

API Data Logs:

L'objet API Data Logs est conçu principalement pour les développeurs, et il sert de point central pour stocker toutes les données fournies par KPMG.
Cet objet a été créé de manière générique et peut potentiellement être utilisé dans d'autres contextes, en dehors de KPMG.
Champ "Document Key":

Ce champ est utilisé pour récupérer des documents binaires. Je suis un peu confus par la remarque mentionnant le document PDF 1.4 ou 1.7. Si quelqu'un peut fournir plus de clarté à ce sujet, cela serait grandement apprécié.
Champ Final Kid:

Après avoir effectué des vérifications sur toutes les données disponibles, je n'ai trouvé aucun "Final Kid" créé pour chaque KID request validé sur KID. Si quelqu'un a des informations supplémentaires à ce sujet, veuillez les partager.
Champ Language:

Il semble que la valeur sur ce champ soit en minuscules. Ceci est normal car la valeur est récupérée via KPMG et n'a aucun impact sur notre processus interne.
Noms avec "_ ":

J'ai demandé à l'équipe Salesforce de traiter le problème des noms avec des espaces remplacés par des underscores par défaut. Il y a un article disponible sur ce sujet qui pourrait être utile à consulter pour plus de détails.
Noms avec des problèmes tels que "APIDATA":

J'ai partagé l'architecture sur Confluence le 19/02 et je n'ai pas encore reçu de commentaires à ce sujet. Il est important que lorsque des documents sont partagés, ils soient examinés et des retours d'informations soient donnés si nécessaire.
En conclusion, je souhaite entamer les tests sur la partie IM Library et KID Request en Full. Je serais reconnaissant si vous pouviez fournir des retours sur toute fonctionnalité qui ne fonctionnerait pas correctement. De plus, veuillez noter que la partie technique est gérée conjointement par l'équipe d'architecture et moi-même, et nous avons une réunion prévue à ce sujet aujourd'hui.

En outre, j'ai l'intention de retirer certains accès aux champs techniques et de ne laisser que les champs nécessaires pour évaluer l'état de chaque partie. Si vous avez des questions ou des préoccupations supplémentaires, n'hésitez pas à les partager.

Merci pour votre attention et votre collaboration.

Cordialement,
[Votre Nom]
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

