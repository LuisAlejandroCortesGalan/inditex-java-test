# Product Similarity API

This project is part of a backend technical assessment. It provides a REST API built with Spring Boot that retrieves similar products for a given product ID by consuming external mock services.

## 🚀 Features

- Exposes a single endpoint:  
  `GET /product/{productId}/similar`
- Internally calls:
  - `/product/{productId}/similarids` to fetch similar product IDs
  - `/product/{id}` for each similar product to fetch its details
- Returns a JSON array with full details of similar products

## 🛠️ Tech Stack

- Java 17  
- Spring Boot  
- RestTemplate  
- Docker & Docker Compose  
- k6 (load testing)  
- Grafana (visual reporting)

## 🧪 How to Run Tests

Ensure Docker is installed and running on your system.

### 1. Clone the test environment

```bash
git clone https://github.com/dalogax/backendDevTest.git
cd backendDevTest
```

### 2. Start mock services and test infrastructure

```bash
docker-compose up -d simulado influxdb grafana
```

### 3. Verify the mocks are working

```bash
curl http://localhost:3001/product/1/similarids
```

Expected response:

```json
[2, 3, 4]
```

### 4. Run your Spring Boot application (on port 5000)

Ensure your application is running at:

```text
http://localhost:5000/product/{id}/similar
```

Test it with:

```bash
curl http://localhost:5000/product/1/similar
```

### 5. Execute performance test with k6

```bash
docker-compose run --rm k6 run /scripts/test.js
```

### 6. View test results in Grafana

Open the following URL in your browser:

```text
http://localhost:3000/d/Le2Ku9NMk/k6-performance-test
```

## ✅ Example Response

```json
[
  {
    "id": "2",
    "name": "Dress",
    "price": 19.99,
    "availability": true
  },
  {
    "id": "3",
    "name": "Blazer",
    "price": 29.99,
    "availability": false
  },
  {
    "id": "4",
    "name": "Boots",
    "price": 39.99,
    "availability": true
  }
]
```

## 👨‍💻 Author

**Alejandro Cortés Galán**  
Junior Full Stack Developer  
[LinkedIn](https://www.linkedin.com/)  
[Portfolio](https://miportafolio-alpha.vercel.app/)  
wincho_04@hotmail.com
