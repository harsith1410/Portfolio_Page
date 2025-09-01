# Use an official OpenJDK runtime as a parent image
FROM openjdk:21-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the packaged JAR file from the target folder into the container
COPY target/Portfolio-0.0.1-SNAPSHOT.jar app.jar

# Make port 8080 available to the world outside this container
EXPOSE 4720

# Run the JAR file when the container launches
ENTRYPOINT ["java", "-jar", "app.jar"]