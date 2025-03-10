# Stage 1: Build the application
FROM maven:3.9.8-openjdk-17 AS builder

# Set the working directory inside the container
WORKDIR /bets

# Copy the pom.xml and download dependencies
COPY pom.xml .

# Download the dependency jars; this step will cache the Maven dependencies
RUN mvn dependency:go-offline

# Copy the entire project into the Docker image
COPY . .

# Build the application
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM openjdk:23-jdk-slim

# Set the working directory inside the container
WORKDIR /bets

# Copy the jar from the builder stage
COPY --from=builder /bets/target/*.jar bets.jar

# Expose the application port (adjust if your application uses a different port)
EXPOSE 8080

# Set the default command to run the jar
CMD ["java", "-jar", "bets.jar"]