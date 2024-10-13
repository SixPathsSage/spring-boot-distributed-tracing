# Distributed Tracing in Spring Boot using Micrometer and Jaeger

## Running in Local
> Note: Use Java 21
1. **Clone the Repository:**
   ```bash
   git clone https://github.com/SixPathsSage/spring-boot-distributed-tracing.git
   cd spring-boot-distributed-tracing
   ```
2. **Run the Docker Command:**
   ```bash
   docker compose up --build -d
   ```
3. **Invoking the API:**
   ```bash
   curl 'http://localhost:8081/account-info/20'
   ```
4. **Jaeger UI:**
   Access the UI and analyse the traces http://localhost:16686/
