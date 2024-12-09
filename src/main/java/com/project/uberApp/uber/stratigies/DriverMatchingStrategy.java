package com.project.uberApp.uber.stratigies;

import com.project.uberApp.uber.dto.RideRequestDto;
import com.project.uberApp.uber.entities.Driver;

import java.util.List;

public interface DriverMatchingStrategy {
    List<Driver> findMatchingDriver(RideRequestDto rideRequestDto);
}
