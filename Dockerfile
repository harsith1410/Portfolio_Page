FROM maven:3.9-eclipse-temurin-21 AS build

# Set the working directory
WORKDIR /app

# Copy the Maven wrapper and pom.xml to leverage Docker cache
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Copy the rest of the application source code
COPY src ./src

# Run the Maven package command to build the JAR file
RUN ./mvnw -B package


# STAGE 2: Create the final, lightweight runtime image
FROM openjdk:21-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the packaged JAR file from the 'build' stage
COPY --from=build /app/target/Portfolio-0.0.1-SNAPSHOT.jar app.jar

# Make port 8080 available
EXPOSE 8080

# Run the JAR file when the container launches
ENTRYPOINT ["java", "-jar", "app.jar"]