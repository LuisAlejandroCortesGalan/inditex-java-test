# 🧠 Product Similarity API

A backend technical assessment built with **Spring Boot**. This REST API retrieves similar products for a given product ID by consuming external mock services.

---

## 📦 Prerequisites

Before running this project, make sure you have:

- [Docker](https://www.docker.com/) installed and running
- Git installed
- Internet connection (to pull Docker images)

---

## 🚀 Setup Instructions

### 1. Clone and run the mock service environment

This project relies on mock services provided by another repository.

```bash
git clone https://github.com/dalogax/backendDevTest.git
cd backendDevTest
docker-compose up -d simulado influxdb grafana
```

Check that the mocks are working:

```bash
curl http://localhost:3001/product/1/similarids
# Expected: [2,3,4]
```

### 2. Create the shared Docker network (if you haven’t yet)

This ensures the containers can communicate:

```bash
docker network create backendnet
```

> ⚠️ Only needed once in your local environment.

---

### 3. Clone this repository

```bash
git clone https://github.com/LuisAlejandroCortesGalan/inditex-java-test.git
cd inditex-java-test
```

### 4. Build and run the backend API

```bash
docker-compose build
docker-compose up -d
```

Test it:

```bash
curl http://localhost:5000/product/1/similar
```

---

### 5. Run the performance tests

```bash
docker-compose run --rm k6 run /scripts/test.js
```

---

### 6. Visualize test results in Grafana

Access the dashboard at:  
👉 [http://localhost:3000](http://localhost:3000)  
_Default credentials are preconfigured for anonymous access._

---

## ⚙️ Tech Stack

- Java 17  
- Spring Boot  
- WebClient (reactive HTTP client)  
- Docker & Docker Compose  
- k6 (load testing)  
- Grafana (performance visualization)

---

## 🧭 System Architecture Diagram

You can view the complete flow diagram here:  
📎 [`docs/Diagrama de flujo API Product Similarity.png`](./docs/Diagrama%20de%20flujo%20API%20Product%20Similarity.png)

---

## 🚧 Future Improvements

- Add unit and integration testing (JUnit + Mockito)
- Improve resilience with retry/fallback using Resilience4j
- Externalize configuration via `application.yml` or environment variables
- Add OpenAPI/Swagger for endpoint documentation
- Migrate to a fully reactive stack using Spring WebFlux (if needed)
- Automate testing and deployment using CI/CD (e.g. GitHub Actions)

---

## 👨‍💻 Author

**Alejandro Cortés Galán**  
Full Stack Developer

🔗 [LinkedIn](https://www.linkedin.com/)  
🌐 [Portfolio](https://miportafolio-alpha.vercel.app/)
