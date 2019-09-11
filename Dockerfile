FROM openjdk:8-jdk-alpine
LABEL maintainer="yankolyaspas@gmail.com"
EXPOSE 8082
ARG JAR_FILE=target/fservice.jar
ADD ${JAR_FILE} fservice.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/fservice.jar"]

