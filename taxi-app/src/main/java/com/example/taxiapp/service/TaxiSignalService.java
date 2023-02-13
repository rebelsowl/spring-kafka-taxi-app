package com.example.taxiapp.service;

import com.example.taxiapp.kafka.producer.KafkaProducer;
import com.example.taxiapp.data.model.TaxiSignal;
import org.springframework.stereotype.Service;

@Service
public class TaxiSignalService {
    private final KafkaProducer kafkaProducer;

    public TaxiSignalService(KafkaProducer kafkaProducer){
        this.kafkaProducer = kafkaProducer;
    }

    public void addTaxiSignal(TaxiSignal taxiSignal) throws IllegalArgumentException {
        if (!isValidVehicleId(taxiSignal.getVehicleId())) {
            throw new IllegalArgumentException("Invalid vehicle ID");
        }

        kafkaProducer.sendTaxiSignal(taxiSignal.getVehicleId(), taxiSignal.getCoordinates());

    }

    private boolean isValidVehicleId(int vehicleId) {
        if (vehicleId < 0)
            return false;
        return true;
    }


}
