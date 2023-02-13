package com.example.taxiapp.kafka.producer;


import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.awt.*;

@Component
public class KafkaProducer {
    //    public static final String SIGNAL_TOPIC = "input";
    public static final String SIGNAL_TOPIC = "inputTest";

    private final KafkaTemplate<String, Point> kafkaTemplate;


    public KafkaProducer(KafkaTemplate<String, Point> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    public void sendTaxiSignal(Integer key, Point value) {
        kafkaTemplate.send(SIGNAL_TOPIC, key.toString(), value);
    }

}
