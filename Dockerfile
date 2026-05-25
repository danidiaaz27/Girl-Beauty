# Build stage
FROM maven:3.10.1-eclipse-temurin-21 AS build
WORKDIR /app
# Project files live in the nested folder `GirlStore` in the repo root
COPY GirlStore/pom.xml GirlStore/mvnw GirlStore/.mvn/ ./
COPY GirlStore/src ./src
RUN mvn -DskipTests package -q

# Run stage
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/GirlStore-0.0.1-SNAPSHOT.jar /app/app.jar
ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["sh","-c","java -jar /app/app.jar --server.port=${PORT}"]
