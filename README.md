# AppSport – Backend

Backend Spring Boot du projet **AppSport** (TD Backend 2026).

---

## Fonctionnalités

- Création de sessions de sport
- Ajout de sets à une session
- Consultation des sessions (liste + détail)
- Publication d’événements Kafka à la création d’une session
- Consommation Kafka via un use case dédié
- Persistance en base H2
- API documentée avec Swagger
- Exécution complète avec Docker Compose

---

## Architecture

Clean Architecture :
- Controllers REST sans logique métier
- Use cases indépendants de Spring
- Kafka isolé dans la couche infrastructure

---

## API REST

| Méthode | Endpoint |
|------|--------|
| POST | `/api/sessions` |
| POST | `/api/sessions/{id}/sets` |
| GET | `/api/sessions` |
| GET | `/api/sessions/{id}` |

---

## Swagger
http://localhost:8081/swagger-ui/index.html

---

## Kafka

- Topic : `workout.created`
- Producer : publication lors de la création d’une session
- Consumer : réception de l’événement et traitement via un use case

Exemple de log :
[KAFKA CONSUMER] Workout session received | workoutId=1 userId=1 calories=320

---

## Lancer le projet (Docker)

### Prérequis
- Docker
- Docker Compose

### Commandes
```bash
./gradlew clean build
docker compose up --build

## Accès
	•	API : http://localhost:8081
	•	Swagger : http://localhost:8081/swagger-ui/index.html
	•	H2 Console : http://localhost:8081/h2-console
