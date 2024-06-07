# Use an official Maven image to build the app
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app

EXPOSE 8081
# Copy the source code into the container
COPY pom.xml .
COPY src ./src

# Package the application
RUN mvn clean package

# Use an official OpenJDK runtime image
FROM openjdk:17-jdk-alpine
WORKDIR /app

# Copy the packaged application into the container
COPY --from=build /app/target/cliente-3.2.2.jar /app/cliente-3.2.2.jar

# Run the application
ENTRYPOINT ["java", "-jar", "/app/cliente-3.2.2.jar"]
