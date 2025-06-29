# Use Maven to build the project
FROM maven:3.8.5-openjdk-17 AS build

WORKDIR /app

COPY . .

RUN mvn clean package

# Create runtime image
FROM openjdk:17

WORKDIR /app

COPY --from=build /app/target/url-shortener-1.0-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
