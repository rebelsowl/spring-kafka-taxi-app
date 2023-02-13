package com.example.taxiapp.data.model;

import java.awt.*;

public class TaxiSignal {
    private int vehicleId;
    private Point coordinates;

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Point getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Point coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "TaxiSignal{" +
                "vehicleId='" + vehicleId + '\'' +
                ", coordinates=" + coordinates +
                '}';
    }
}