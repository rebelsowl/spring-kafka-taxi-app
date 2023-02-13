package com.example.taxiapp.kafka.processor;

import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerde;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.Arrays;

@Component
public class KafkaSignalProcessor {

    final Serde<String> STRING_SERDE = Serdes.String();
    private static final Serde<Integer> INTEGER_SERDE = Serdes.Integer();


    @Autowired
    void buildPipeline(StreamsBuilder streamsBuilder) {
        KStream<String, String> inputStream = streamsBuilder
                .stream("inputTest", Consumed.with(STRING_SERDE, STRING_SERDE));


        //
        KTable<String, String> vehicleLocationTable = inputStream
                .groupByKey()
                .reduce((oldValue, newValue) -> newValue, Materialized.as("location"));

        vehicleLocationTable.toStream().to("output-topic");

        //



    }


}
