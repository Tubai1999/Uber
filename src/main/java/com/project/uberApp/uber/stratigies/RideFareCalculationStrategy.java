package com.project.uberApp.uber.stratigies;

import com.project.uberApp.uber.dto.RideRequestDto;
import com.project.uberApp.uber.entities.RideRequest;

public interface RideFareCalculationStrategy {
     double RIDE_FARE_MULTIPLAYER = 10;
    double calculateFare(RideRequest rideRequest);
}
