FROM openjdk:17

EXPOSE 8089

WORKDIR /projet-web-distribué

COPY target/springProject-1.0.jar .

RUN ls -l

RUN chmod 644 springProject-1.0.jar

ENTRYPOINT ["java", "-jar", "springProject-1.0.jar"]
