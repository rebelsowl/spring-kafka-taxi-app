package com.example.integrationtests;

import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Producer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private static int i = 0;

    public Producer(KafkaTemplate<String, String> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    /*
    @Scheduled(fixedRate = 1000)
    @Async
    public void produce(){
        kafkaTemplate.send("test", "Message " + Math.random() + "-" + i);
        i ++;
    }
    */

    public void send(String topic, String payload){
        kafkaTemplate.send(topic, payload);
    }

}
