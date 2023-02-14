# Spring Kafka Taxi Application

## Integration Test

Integration test with embedded kafka

Integration test with Testcontainers to instantiate and manage an external Apache Kafka broker hosted inside a Docker container


## Taxi Application

Receives taxi location signals over REST endpoint, stores them in kafka topic, then process the location data, outputs total distance travaled to another topic, which is also consumed by loggers.
