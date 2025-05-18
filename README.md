# 🌦️ Weather Service - Spring Boot

This is a Spring Boot application that provides weather information using external APIs like OpenWeatherMap and WeatherStack. It demonstrates the **Chain of Responsibility pattern** for API fallback and includes a simple caching mechanism.

---

## 🚀 Features

- REST API to fetch weather data (`/v1/weather`)
- Supports multiple providers (OpenWeatherMap, WeatherStack)
- Graceful fallback chain
- In-memory caching for fast repeated calls
- Uses `RestTemplate` for HTTP calls
- Easily extendable with new providers

---

## 🛠️ Technologies Used

- Java 17+
- Spring Boot
- Maven
- Jackson (for JSON parsing)
- Lombok
- External APIs: OpenWeatherMap, WeatherStack

---

## 📦 Setup Instructions

### 1. Clone the repository

```bash
git clone https://github.com/your-username/weather-app-spring.git
cd weather-app-spring
```

### 2. Add your API keys

```bash
# API Keys
api.key.ow=YOUR_OPENWEATHERMAP_API_KEY
api.key.ws=YOUR_WEATHERSTACK_API_KEY
```
### 3. Run the application

```bash
./mvnw spring-boot:run
```

## 🌐 API Endpoint
### `GET /v1/weather`

Fetch current weather information (temperature and wind speed) for a given city. The service uses multiple weather providers with fallback and caching support.

---

### 🔧 Request

**URL:** `GET /v1/weather`


**Query Parameters:**

| Name | Type | Required | Default | Description |
|------|------|----------|---------|-------------|
| `city` | `string` | No | `Melbourne` | Name of the city to fetch weather for |

**Example Request:**

```http
GET /v1/weather?city=Delhi
Host: localhost:8080
```


