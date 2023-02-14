package com.example.taxiapp.kafka.producer;


import com.example.taxiapp.config.KafkaConfig;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.awt.*;

@Component
public class KafkaProducer {

    private final KafkaTemplate<String, Point> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, Point> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    public void sendTaxiSignal(Integer key, Point value) {
        kafkaTemplate.send(KafkaConfig.INPUT_TOPIC_NAME, key.toString(), value);
    }

}
