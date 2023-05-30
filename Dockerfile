FROM gradle:jdk11 as gradleimage
COPY . /home/gradle/source
WORKDIR /home/gradle/source
RUN gradle build


FROM openjdk:11-jdk-slim
COPY --from=gradleimage /home/gradle/source/build/libs/webapps-0.0.1-SNAPSHOT.jar /app/
WORKDIR /app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "webapps-0.0.1-SNAPSHOT.jar"]
