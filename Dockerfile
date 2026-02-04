# ====== STAGE 1: build ======
FROM eclipse-temurin:17-jdk AS builder
WORKDIR /build
COPY . .
RUN ./mvnw clean package -DskipTests

# ====== STAGE 2: run ======
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=builder /build/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Xmx512m","-jar","/app/app.jar"]
