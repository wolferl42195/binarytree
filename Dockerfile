FROM openjdk:11-jdk
LABEL maintainer="wolfgang.radinger@gmail.com"
VOLUME /tmp
ARG JAR_FILE
ADD binarytree-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
