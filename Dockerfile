# =========================
# Stage 1 : Build avec Gradle
# =========================
FROM gradle:8.6-jdk17 AS build
WORKDIR /app
COPY . .
RUN gradle clean build -x test

# =========================
# Stage 2 : Run
# =========================
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]