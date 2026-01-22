# Java Backend Enterprise Template

A real-world Spring Boot microservices project for Middle → Senior Java Backend Developers.

## Tech Stack
- Java 17
- Spring Boot
- Spring Cloud Gateway
- Spring Security (JWT)
- Kafka
- Redis
- PostgreSQL
- Docker & Docker Compose
- ELK Stack

## Architecture Overview
- API Gateway
- Auth Service
- Order Service (Saga Orchestrator)
- Payment Service
- Inventory Service
- Common Library

## Key Features
- JWT Authentication & Authorization
- Saga Pattern (Orchestration)
- Kafka Retry & Dead Letter Topic
- Redis Distributed Lock & Rate Limit
- Centralized Logging & Tracing
- Dockerized Microservices

## How to Run
```bash
docker-compose up -d
