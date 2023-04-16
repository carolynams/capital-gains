FROM maven:3.6.0-jdk-11-slim AS builder

# copy only the pom.xml file and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# add the source code and package the jar
COPY src /src
RUN mvn package -DskipTests

# Second stage: minimal runtime environment
FROM openjdk:11-jre-slim

WORKDIR /app

# copy the jar from the first stage with a specific name
COPY --from=builder target/capital-gains-1.0.0-jar-with-dependencies.jar capital-gains.jar

EXPOSE 8080

CMD ["java", "-jar", "capital-gains.jar"]