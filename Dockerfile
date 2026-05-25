# Build stage
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app
# Copy project files from the repository root
COPY pom.xml mvnw .mvn/ ./
COPY src ./src
RUN chmod +x mvnw && ./mvnw -DskipTests package -q

# Run stage
FROM maven:3.10.1-jdk-21 AS build
WORKDIR /app
COPY --from=build /app/target/GirlStore-0.0.1-SNAPSHOT.jar /app/app.jar
COPY pom.xml .mvn/ ./
COPY src ./src
RUN mvn -B -DskipTests package -q
