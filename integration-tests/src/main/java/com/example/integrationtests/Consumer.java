package com.example.integrationtests;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class Consumer {



    @KafkaListener(topics = {"test"}, groupId = "test-consumer-group")
    public void consume(ConsumerRecord<String, String> record){
        System.out.println("Message | key : " + record.key() + " value: " + record.value());

    }

}
