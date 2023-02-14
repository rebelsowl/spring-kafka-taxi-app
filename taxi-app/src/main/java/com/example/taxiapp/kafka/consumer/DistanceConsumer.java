package com.example.taxiapp.kafka.consumer;

import com.example.taxiapp.config.KafkaConfig;
import com.example.taxiapp.data.CoordinateConverter;
import com.example.taxiapp.kafka.producer.KafkaProducer;
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
    KafkaProducer producer;

    public DistanceConsumer(LocationCache locationCache, DistanceCache distanceCache, KafkaProducer producer){
        this.locationCache = locationCache;
        this.distanceCache = distanceCache;
        this.producer = producer;
    }


    @KafkaListener(topics = KafkaConfig.INPUT_TOPIC_NAME, id = "distance-consumer-1", groupId = "taxi-app-distance-consumer")
    public void consumer1(ConsumerRecord<String, String> record) {
        processSignal(record);
    }

    @KafkaListener(topics = KafkaConfig.INPUT_TOPIC_NAME, id = "distance-consumer-2", groupId = "taxi-app-distance-consumer")
    public void consumer2(ConsumerRecord<String, String> record) {
        processSignal(record);
    }

    @KafkaListener(topics = KafkaConfig.INPUT_TOPIC_NAME, id = "distance-consumer-3", groupId = "taxi-app-distance-consumer")
    public void consumer3(ConsumerRecord<String, String> record) {
        processSignal(record);
    }

    private void processSignal(ConsumerRecord<String, String> record) {
        int key = Integer.parseInt(record.key());
        Point currentLocation = CoordinateConverter.stringToPoint(record.value());

        if(locationCache.getLocationData(key) == null){
            locationCache.putLocationData(key, currentLocation); // first signal
        } else {
            Point lastCoordinates = locationCache.getLocationData(key);
            double currentDistance = currentLocation.distance(lastCoordinates);
            double totalDistance = (distanceCache.getTotalDistance(key) == null ? 0 : distanceCache.getTotalDistance(key)) + currentDistance;

            producer.sendDistanceSignal(key, totalDistance);

            locationCache.putLocationData(key, currentLocation); // update last location
            distanceCache.putTotalDistance(key, totalDistance); // update total distance
        }
    }


}
