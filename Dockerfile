# Use Maven to build the project
FROM maven:3.8.5-openjdk-17 AS build

WORKDIR /app

COPY . .

RUN mvn clean package

# Create runtime image
FROM openjdk:17-slim

WORKDIR /app
#  🔧 Install ping (and bash-related tools)
RUN apt-get update && apt-get install -y iputils-ping net-tools
COPY --from=build /app/target/url-shortener-1.0-SNAPSHOT.jar app.jar
COPY --from=build /app/src/main/resources/application.properties application.properties

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
