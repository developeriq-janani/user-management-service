FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Duser.timezone=UTC", "-jar", "application.jar"]

## Use the OpenJDK 17 slim image as the base image
#FROM openjdk:17-jdk-slim
#
## Define an argument named JAR_FILE and set its value to the path of the JAR file in the 'target' directory
#ARG JAR_FILE=target/*.jar
#
## Copy the JAR file specified by the JAR_FILE argument to the root directory of the image and rename it to 'application.jar'
#COPY ${JAR_FILE} application.jar
#
## Expose port 8080 to allow external connections to the application
#EXPOSE 8080
#
## Set the entry point for the container. This specifies how the container should run the Java application.
## The entry point includes setting the user timezone to UTC and running the JAR file with the 'java' command.
#ENTRYPOINT ["java", "-Duser.timezone=UTC", "-jar", "application.jar"]
