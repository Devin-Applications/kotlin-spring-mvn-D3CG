---
Title: Kotlin Spring Boot (Maven)
Description: A basic Kotlin Spring boot web server with PostgreSQL
Tags:
- spring
- kotlin
- web-flux
- r2dbc
- postgreSQL
---

![alt image](https://devicons.railway.app/i/spring.svg)
# Kotlin Spring Boot (Maven)

This example starts a basic [Kotlin Spring Boot](https://spring.io/projects/spring-boot) web server.

[![Deploy on Railway](https://railway.app/button.svg)](https://railway.app/template/d7dHuj?referralCode=eeaXpJ)

### Features:
- WebFlux Framework - Reactive programming
- PostgreSQL - R2DBC
- Maven build system

### How to use
- Click the Railway button to deploy the app
- Clone the project and connect to it using `railway link`

### Task Management Application

This application is a basic CRUD task management system built using Kotlin Spring Boot and PostgreSQL. It allows you to create, read, update, and delete tasks. Each task has a title, description, and status.

### API Endpoints

#### Create Task
```sh
curl -X POST https://kotlin-spring-webflux-production-f282.up.railway.app/tasks -H "Content-Type: application/json" -d '{"title":"Test Task","description":"This is a test task","status":"pending"}'
```

#### Read All Tasks
```sh
curl -X GET https://kotlin-spring-webflux-production-f282.up.railway.app/tasks
```

#### Read Single Task
```sh
curl -X GET https://kotlin-spring-webflux-production-f282.up.railway.app/tasks/{TASK_ID}
```

#### Update Task
```sh
curl -X PUT https://kotlin-spring-webflux-production-f282.up.railway.app/tasks/{TASK_ID} -H "Content-Type: application/json" -d '{"title":"Updated Task","description":"This is an updated test task","status":"completed"}'
```

#### Delete Task
```sh
curl -X DELETE https://kotlin-spring-webflux-production-f282.up.railway.app/tasks/{TASK_ID}
```

### Note
Replace `{TASK_ID}` with the actual task ID in the cURL commands for Read Single Task, Update Task, and Delete Task operations.
