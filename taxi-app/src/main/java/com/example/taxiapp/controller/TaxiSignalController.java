package com.example.taxiapp.controller;

import com.example.taxiapp.data.model.TaxiSignal;
import com.example.taxiapp.service.TaxiSignalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaxiSignalController {

    private final TaxiSignalService taxiSignalService;

    public TaxiSignalController(TaxiSignalService taxiSignalService) {
        this.taxiSignalService = taxiSignalService;
    }


    @PostMapping("/taxi-signal")
    public ResponseEntity<Void> addTaxiSignal(@RequestBody TaxiSignal taxiSignal) {
        try {
            taxiSignalService.addTaxiSignal(taxiSignal);
            System.out.println(taxiSignal);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
