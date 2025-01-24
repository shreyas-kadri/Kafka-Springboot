FROM openjdk:17

WORKDIR /app

COPY Consumer/target/Consumer-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8072

ENTRYPOINT ["java", "-jar", "app.jar"]