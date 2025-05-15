# 🧠 Product Similarity API

A backend technical assessment project built with **Spring Boot**. This REST API retrieves similar products for a given product ID by consuming external mock services.

---

## 🚀 Features

- Exposes a single endpoint:  
  `GET /product/{productId}/similar`
- Fetches:
  - Similar product IDs from `/product/{productId}/similarids`
  - Product details from `/product/{id}` for each ID
- Returns a structured JSON array with full product details

---

## ⚙️ Tech Stack

- Java 17  
- Spring Boot  
- WebClient (reactive HTTP client)  
- Docker & Docker Compose  
- k6 (load testing)  
- Grafana (performance visualization)

---

## 🐳 Run the Full Environment with Docker

> ✅ **Note**: No need to install Java or Maven locally. Everything runs via Docker.

### 1. Clone this repository

```bash
git clone https://github.com/LuisAlejandroCortesGalan/inditex-java-test.git
cd inditex-java-test
```

### 2. Build and start the environment

```bash
docker-compose build
docker-compose up -d
```

### 3. Access the services

- API: [http://localhost:5000](http://localhost:5000)
- Mocks: [http://localhost:3001](http://localhost:3001)
- Grafana Dashboard: [http://localhost:3000](http://localhost:3000)

### 4. Run performance tests

```bash
docker-compose run --rm k6 run /scripts/test.js
```

---

## 🧭 System Architecture Diagram

![API Flow](./docs/Diagrama%20de%20flujo%20API%20Product%20Similarity.png)

---

## 🚧 Future Improvements

- Add unit and integration testing (JUnit + Mockito)
- Improve resilience with retry/fallback using Resilience4j
- Externalize environment variables via `application.yml` or system envs
- Dockerize the application for full portability (✅ done)
- Add OpenAPI/Swagger for endpoint documentation

---

## 👨‍💻 Author

**Alejandro Cortés Galán**  
Full Stack Developer  
🔗 [LinkedIn](https://www.linkedin.com/)  
🌐 [Portfolio](https://miportafolio-alpha.vercel.app/)  
