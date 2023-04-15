# Use an official Java runtime as a parent image
FROM openjdk:11-jdk-slim

# Set the working directory to /app
WORKDIR /app

# Copy the pom.xml file to the working directory
COPY pom.xml .

# Install Maven
RUN apk add --no-cache maven

# Install the project dependencies
RUN mvn dependency:go-offline

# Copy the rest of the application code to the working directory
COPY . .

# Compile the Java code
RUN mvn package

# Set the command to run the application
CMD ["java", "-jar", "target/capital-gains-1.0.0.jar"]