package com.project.uberApp.uber.stratigies.impl;

import com.project.uberApp.uber.dto.RideRequestDto;
import com.project.uberApp.uber.entities.Driver;
import com.project.uberApp.uber.stratigies.DriverMatchingStrategy;

import java.util.List;

public class DriverMatchingHighestRatedDriverStrategy implements DriverMatchingStrategy {
    @Override
    public List<Driver> findMatchingDriver(RideRequestDto rideRequestDto) {
        return List.of();
    }
}
