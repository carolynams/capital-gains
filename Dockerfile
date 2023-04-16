# Use an official Java runtime as a parent image
FROM maven:3.6.0-jdk-11-slim AS builder

# add pom.xml and source code
ADD ./pom.xml pom.xml

# package jar
RUN mvn clean verify --fail-never
RUN mvn package

# Second stage: minimal runtime environment
From  openjdk:11-jre-slim

WORKDIR /app

# copy jar from the first stage
COPY --from=builder target/capital-gains-1.0.0-jar-with-dependencies.jar /app/capital-gains-1.0.0-jar-with-dependencies.jar

EXPOSE 8080

CMD ["java", "-jar", "capital-gains-1.0.0-jar-with-dependencies.jar"]