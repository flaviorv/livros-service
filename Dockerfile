FROM openjdk:19
COPY ./target/livros-service-0.0.1-SNAPSHOT.jar /app/livros-service-0.0.1-SNAPSHOT.jar
WORKDIR /app
ENTRYPOINT ["java", "-jar", "livros-service-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080