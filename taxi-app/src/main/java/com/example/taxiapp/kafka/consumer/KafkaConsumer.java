package com.example.taxiapp.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.awt.*;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "#{T(com.example.taxiapp.kafka.producer.KafkaProducer).SIGNAL_TOPIC}", groupId = "taxi-app-input-consumer")
    public void consume(ConsumerRecord<String, Point> record){
        System.out.println("taxi id: " + record.key() + " coordinates: " + record.value());
    }

}
