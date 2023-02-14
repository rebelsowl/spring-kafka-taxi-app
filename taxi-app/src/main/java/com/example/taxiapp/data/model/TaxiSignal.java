package com.example.taxiapp.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.Point;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaxiSignal {
    private int vehicleId;
    private Point coordinates;


}