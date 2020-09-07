FROM openjdk:1.8-jdk
ARG JAR_FILE=target/*.jar
COPY target/back.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
