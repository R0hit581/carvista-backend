FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY pom.xml .
COPY src ./src

# Install Maven
RUN apt-get update && apt-get install -y maven

# Build the app
RUN mvn clean package -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "target/carvista-backend-0.0.1-SNAPSHOT.jar"]