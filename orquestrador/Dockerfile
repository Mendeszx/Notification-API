FROM maven:3.8.4-openjdk-17-slim AS build

WORKDIR /orquestrador

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests -X

COPY target/orquestrador-SNAPSHOT.jar .

CMD ["java", "-jar", "-Dspring.profiles.active=prd", "orquestrador-SNAPSHOT.jar"]
