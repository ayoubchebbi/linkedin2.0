FROM node:latest
RUN mkdir /chat-server
COPY ./chat-server /chat-server
RUN npm install chat-server
RUN ls /chat-server
EXPOSE 5000

ENTRYPOINT ["npm", "start","--prefix", "chat-server"]

