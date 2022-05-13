FROM openjdk:17

# srv default port
EXPOSE 25565/tcp

# home srv
WORKDIR /home/minecraft-server

# copies all needed files
COPY minecraft-server/ /home/minecraft-server/

# runs server by default
CMD ["java", "-Xms1024M", "-Xmx1024M", "-jar", "server.jar", "--nogui"]
