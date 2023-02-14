package com.example.taxiapp.service;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.stereotype.Component;

import java.awt.*;

@Component
public class LocationCache {

    private Cache<Integer, Point> locationCache;

    public LocationCache(){
        this.locationCache = Caffeine.newBuilder()
                .maximumSize(1000)
                .build();
    }


    public void putLocationData(int locationId, Point coordinates) {
        locationCache.put(locationId, coordinates);
    }

    public Point getLocationData(int locationId) {
        return locationCache.getIfPresent(locationId);
    }

}