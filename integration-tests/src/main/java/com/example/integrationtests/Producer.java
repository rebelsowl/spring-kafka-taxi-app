package com.example.integrationtests;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public Producer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    /*
    private static int i = 0;

    @Scheduled(fixedRate = 1000)
    @Async
    public void produce(){
        kafkaTemplate.send("test", "Message " + Math.random() + "-" + i);
        i ++;
    }
    */

    public void send(String topic, String payload) {
        kafkaTemplate.send(topic, payload);
    }

}
