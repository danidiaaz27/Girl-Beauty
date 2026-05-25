# Build stage
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app
# Copy project into container
COPY . /app
# Install Maven and build using system mvn to avoid wrapper issues
RUN apt-get update \
 && apt-get install -y maven --no-install-recommends \
 && mvn -f pom.xml -B -DskipTests package -q \
 && rm -rf /var/lib/apt/lists/*

# Run stage
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/GirlStore-0.0.1-SNAPSHOT.jar /app/app.jar
ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["sh","-c","java -jar /app/app.jar --server.port=${PORT}"]
