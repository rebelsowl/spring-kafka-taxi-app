package com.example.taxiapp.kafka.consumer;

import com.example.taxiapp.config.KafkaConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class LoggingConsumer {
    Logger logger = LoggerFactory.getLogger(LoggingConsumer.class);

    @KafkaListener(topics = KafkaConfig.OUTPUT_TOPIC_NAME , groupId = "taxi-app-output-consumer")
    public void consume(ConsumerRecord<String, Integer> record) {
        logger.info("output topic : key -> " + record.key() + " valeu -> " + record.value());
    }

}
