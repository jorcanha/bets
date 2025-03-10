# Event Driven Notification Application

An event-driven notification application built with Spring Boot.

## Author

- **Name:** Jorge C
- **Email:** [](mailto:)

## Prerequisites

Ensure you have the following installed before proceeding:

- **Java JDK 23**
- **Apache Maven 3.9.9**
- **Docker or Podman**
- **Lombok** (Ensure it's configured in your IDE to avoid compilation errors)

## Setting Up the Environment

Use Podman to set up your environment:

```sh
podman compose up -d
```
### Check Status
To verify the status of your containers:

```sh
podman ps
```

## Kafka Setup
### Access the Kafka Pod

```sh
podman exec -it kafka bash
```

### Create Topics
Create necessary Kafka topics:

```sh
kafka-topics --create --topic topic-bet-events --bootstrap-server kafka:9092 --replication-factor 1 --partitions 1
kafka-topics --create --topic topic-event-updates --bootstrap-server kafka:9092 --replication-factor 1 --partitions 1
```

### List Topics
To list all available topics:

```sh
kafka-topics --list --bootstrap-server kafka:9092
```

### Test Topics
### Producer
To produce messages to the topics:

```sh
kafka-console-producer --topic topic-bet-events --bootstrap-server kafka:9092
kafka-console-producer --topic topic-event-updates --bootstrap-server kafka:9092
```

### Consumer
To consume messages from the topics:

```sh
kafka-console-consumer --topic topic-bet-events --bootstrap-server kafka:9092 --from-beginning
kafka-console-consumer --topic topic-event-updates --bootstrap-server kafka:9092 --from-beginning
```

## MySQL Setup
### Access the MySQL Pod

```sh
podman exec -it mysql bash
```

### Connect to MySQL

```sh
mysql -h mysql -P 3306 -u root -p
```

Enter the default password when prompted.

## Maven Commands
Use the following Maven commands for various tasks:

### Clean Project:

```sh
mvn clean
```

### Compile Project:

```sh
mvn clean compile
```

### Test Project:

```sh
mvn clean compile test
```

### Build Project:

```sh
mvn clean install
```

### Run Application:

```sh
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

## Swagger UI
http://localhost:8080/swagger-ui/index.html

## Health Check
http://localhost:8080/actuator/health

## Additional Notes

- Ensure your environment variables are set correctly for the application to run.
- Modify the default configurations in the `application.properties` or `application.yml` as per your requirements.
- This application uses a dev profile by default. Adjust the profiles as necessary for production or other environments.