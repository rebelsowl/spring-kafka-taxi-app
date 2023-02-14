package com.example.taxiapp.service;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.stereotype.Component;

@Component
public class DistanceCache {

    private Cache<Integer, Double> distanceCache;

    public DistanceCache(){
        this.distanceCache = Caffeine.newBuilder()
                .maximumSize(1000)
                .build();
    }


    public void putTotalDistance(int locationId, double totalDistance) {
        distanceCache.put(locationId, totalDistance);
    }

    public Double getTotalDistance(int locationId) {
        return distanceCache.getIfPresent(locationId);
    }

}
