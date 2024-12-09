package com.project.uberApp.uber.stratigies.impl;

import com.project.uberApp.uber.dto.RideRequestDto;
import com.project.uberApp.uber.stratigies.RideFareCalculationStrategy;

public class RiderFareDefaultFareCalculationStrategy implements RideFareCalculationStrategy {
    @Override
    public double calculateFare(RideRequestDto rideRequestDto) {
        return 0;
    }
}
