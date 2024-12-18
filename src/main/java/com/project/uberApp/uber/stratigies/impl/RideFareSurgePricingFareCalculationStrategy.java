package com.project.uberApp.uber.stratigies.impl;

import com.project.uberApp.uber.dto.RideRequestDto;
import com.project.uberApp.uber.entities.RideRequest;
import com.project.uberApp.uber.sevices.DistanceService;
import com.project.uberApp.uber.stratigies.RideFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RideFareSurgePricingFareCalculationStrategy implements RideFareCalculationStrategy {
    private final DistanceService distanceService;
    private static final double SURGE_FACTOR = 2;
    @Override
    public double calculateFare(RideRequest rideRequest) {
        double distance = distanceService.calculateDistance(rideRequest.getPickUpLocation()
                ,rideRequest.getDropOffLocation());
        return distance * RIDE_FARE_MULTIPLAYER*SURGE_FACTOR;
    }
}
