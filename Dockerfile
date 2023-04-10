FROM openjdk:11-jdk-slim
COPY . /app
WORKDIR /app
RUN ./gradlew build
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "build/libs/webapps-0.0.1-SNAPSHOT.jar"]
