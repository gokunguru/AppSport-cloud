# Image Java 17 (
FROM eclipse-temurin:17-jdk

# Dossier de travail dans le conteneur
WORKDIR /app

# Copier le jar généré par Gradle
COPY build/libs/*.jar app.jar

# Port exposé par Spring Boot
EXPOSE 8081

# Commande de démarrage
ENTRYPOINT ["java", "-jar", "app.jar"]