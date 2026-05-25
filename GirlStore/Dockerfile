# Build stage
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app
# Copy project files explicitly from the repo's GirlStore folder (works when build context is repo root)
COPY GirlStore/pom.xml GirlStore/mvnw GirlStore/.mvn/ ./
COPY GirlStore/src ./src
RUN chmod +x mvnw && ./mvnw -B -DskipTests package -q

# Run stage
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/GirlStore-0.0.1-SNAPSHOT.jar /app/app.jar
ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["sh","-c","java -jar /app/app.jar --server.port=${PORT}"]
