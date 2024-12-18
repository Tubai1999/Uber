package com.project.uberApp.uber.stratigies.impl;

import com.project.uberApp.uber.dto.RideRequestDto;
import com.project.uberApp.uber.entities.Driver;
import com.project.uberApp.uber.entities.RideRequest;
import com.project.uberApp.uber.repositories.DriverRepository;
import com.project.uberApp.uber.stratigies.DriverMatchingStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverMatchingHighestRatedDriverStrategy implements DriverMatchingStrategy {
    private final DriverRepository driverRepository;
    @Override
    public List<Driver> findMatchingDriver(RideRequest rideRequest) {
       return driverRepository.findTenNearbyTopRatedDrivers(rideRequest.getPickUpLocation());
    }
}
