package com.project.uberApp.uber.stratigies;

import com.project.uberApp.uber.dto.RideRequestDto;

public interface RideFareCalculationStrategy {
    double calculateFare(RideRequestDto rideRequestDto);
}
