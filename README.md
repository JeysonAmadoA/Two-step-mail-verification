# Two-step-mail-verification
This project aims to implement a two-step user registration verification system. It uses Apache Kafka to connect two 
microservices: one responsible for user registration and another for sending emails.

To start the Docker container for Kafka, you should execute the following command in the root directory.

```bash
docker compose -f .devops/docker-compose.yml up
```
Once the container is up, we need to access the broker and execute the following command.
```bash
kafka-topics --bootstrap-server kafka-broker-1:9092 --create --topic <TOPIC_NAME>
```
To test if our container is working, we can create a producer and a consumer. This way, we can verify that the 
produced messages are being consumed correctly.
```bash
kafka-console-producer --bootstrap-server kafka-broker-1:9092 --topic <TOPIC_NAME>
```

```bash
kafka-console-consumer --bootstrap-server kafka-broker-1:9092 --topic <TOPIC_NAME>
```

