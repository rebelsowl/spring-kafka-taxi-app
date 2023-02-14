package com.example.taxiapp.kafka.consumer;

import com.example.taxiapp.config.KafkaConfig;
import com.example.taxiapp.service.DistanceCache;
import com.example.taxiapp.service.LocationCache;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.awt.*;

@Component
public class DistanceConsumer {

    LocationCache locationCache;
    DistanceCache distanceCache;

    public DistanceConsumer(LocationCache locationCache, DistanceCache distanceCache){
        this.locationCache = locationCache;
        this.distanceCache = distanceCache;
    }


    @KafkaListener(topics = KafkaConfig.INPUT_TOPIC_NAME, id = "distance-consumer-1", groupId = "taxi-app-distance-consumer")
    public void consume(ConsumerRecord<String, Point> record) {
        System.out.println("input topic consumer | taxi id: " + record.key() + " coordinates: " + record.value());





    }


}
