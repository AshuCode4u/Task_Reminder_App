# 📋 Task App — Spring Boot Backend

A full CRUD task management REST API built with **Spring Boot 4**, **Java 21**, and **Spring Data JPA**, containerized with **Docker Compose** alongside a ready-made frontend UI.

> Built as a hands-on project to learn backend fundamentals — REST API design, validation, layered architecture (Controller → Service → Repository), and containerized deployment.

## 📸 Screenshots

**Task list — view, complete, edit, and delete tasks**

<img width="1920" height="994" alt="Screenshot 2026-08-24 105004" src="https://github.com/user-attachments/assets/18976cf3-fe7a-4b25-8796-a2b0900bdbc2" />

<img width="1920" height="992" alt="Screenshot 2026-08-24 104957" src="https://github.com/user-attachments/assets/5acb0f8d-d104-4c3f-b7c0-c954d908223b" />

<img width="1920" height="994" alt="Screenshot 2026-08-24 104947" src="https://github.com/user-attachments/assets/be8cfad7-15e9-4ffd-a379-17626aaf7d42" />

<img width="1920" height="994" alt="Screenshot 2026-08-24 104931" src="https://github.com/user-attachments/assets/918ae00b-5f89-4b5f-b5e4-dd5e4df73261" />

<img width="1920" height="989" alt="Screenshot 2026-08-24 104925" src="https://github.com/user-attachments/assets/74115459-94ce-49b3-b5d6-7e6bc49a50d9" />

---

## ✨ Features

- ✅ **Create** tasks with title, description, due date, and priority
- ✅ **List** all tasks, sorted by creation date
- ✅ **Update** existing tasks (status, priority, details)
- ✅ **Delete** tasks
- ✅ Request validation with clear, custom error messages (e.g. title length, future-dated due dates, required priority)
- ✅ Enum-based `TaskStatus` and `TaskPriority` for type-safe, predictable state
- ✅ Clean layered architecture — Controller, Service, Repository, DTOs, and Mappers kept separate
- ✅ Fully containerized — spin up the backend, database, and frontend UI with a single command

---

## 🛠️ Tech Stack

| Layer          | Technology                          |
|----------------|--------------------------------------|
| Language       | Java 21                              |
| Framework      | Spring Boot 4.1                      |
| Data Access    | Spring Data JPA / Hibernate          |
| Database       | H2 (in-memory)                       |
| Validation     | Jakarta Bean Validation               |
| Build Tool     | Maven                                |
| Containerization | Docker & Docker Compose            |
| Frontend       | Provided UI (Docker image)           |

---

## 🏗️ Architecture

The backend follows a clean, layered structure to keep responsibilities separated and the codebase easy to navigate:

```
Controller  →  Service  →  Repository  →  Database
    ↓             ↓
   DTOs        Domain Entity
    ↓
  Mapper (DTO ⇄ Entity conversion)
```

- **Controller** — exposes REST endpoints, handles HTTP requests/responses
- **Service** — contains business logic
- **Repository** — talks to the database via Spring Data JPA
- **DTOs** — control exactly what data goes in/out of the API (with validation)
- **Mapper** — converts between DTOs and domain entities

---

## 📡 API Endpoints

| Method | Endpoint                | Description              |
|--------|--------------------------|---------------------------|
| POST   | `/api/v1/tasks`          | Create a new task         |
| GET    | `/api/v1/tasks`          | List all tasks            |
| PUT    | `/api/v1/tasks/{taskId}` | Update an existing task   |
| DELETE | `/api/v1/tasks/{taskId}` | Delete a task              |

### Example: Create a Task

**Request**
```http
POST /api/v1/tasks
Content-Type: application/json

{
  "title": "Car Wash",
  "description": "Ford needs a wash",
  "dueDate": "2026-08-30",
  "priority": "HIGH"
}
```

**Response — `201 Created`**
```json
{
  "id": "a1b2c3d4-e5f6-7890-abcd-ef1234567890",
  "title": "Car Wash",
  "description": "Ford needs a wash",
  "dueDate": "2026-08-30",
  "status": "OPEN",
  "priority": "HIGH",
  "createdAt": "2026-08-24T10:15:30Z",
  "updatedAt": "2026-08-24T10:15:30Z"
}
```

---

## 🚀 Getting Started

### Prerequisites
- [Docker Desktop](https://www.docker.com/products/docker-desktop/) installed and running

### Run the whole app (backend + database + frontend UI)

```bash
docker-compose up
```

That's it — one command spins up everything.

- **Frontend UI:** [http://localhost:3000](http://localhost:3000)
- **Backend API:** [http://localhost:8080/api/v1/tasks](http://localhost:8080/api/v1/tasks)

### Run just the backend (for local development)

```bash
./mvnw spring-boot:run
```

---

## 🧪 Testing the API

You can test endpoints directly with [Postman](https://www.postman.com/) or `curl`:

```bash
curl -X GET http://localhost:8080/api/v1/tasks
```

---

## 📚 What I Learned Building This

This project was built while learning backend development from the ground up — starting with core Java,
moving through Collections and Streams, SQL fundamentals, and finally Spring Boot.
Along the way i learn many things these were involved in my Journey 

- Designing a REST API with proper layered architecture
- Implementing request validation and meaningful error handling
- Debugging real issues (dependency/version mismatches, validation constraint errors, missing endpoint mappings)
- Setting up and troubleshooting a full Docker + WSL2 environment on Windows
- Understanding how a frontend and backend communicate over HTTP
- How Api communicate with the Server/Client

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

---

<p align="center">Built with ☕ while learning backend development.</p>
