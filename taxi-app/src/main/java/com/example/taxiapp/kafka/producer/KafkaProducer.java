package com.example.taxiapp.kafka.producer;


import com.example.taxiapp.config.KafkaConfig;
import com.example.taxiapp.data.CoordinateConverter;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.awt.*;

@Component
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    public void sendTaxiSignal(Integer key, Point value) {
        kafkaTemplate.send(KafkaConfig.INPUT_TOPIC_NAME, key.toString(), CoordinateConverter.pointToString(value));
    }

    public void sendDistanceSignal(Integer key, Double value) {
        kafkaTemplate.send(KafkaConfig.OUTPUT_TOPIC_NAME, key.toString(), value.toString());
    }

}
