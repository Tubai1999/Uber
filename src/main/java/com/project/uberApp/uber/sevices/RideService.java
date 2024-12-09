package com.project.uberApp.uber.sevices;

import com.project.uberApp.uber.dto.RideRequestDto;
import com.project.uberApp.uber.entities.Driver;
import com.project.uberApp.uber.entities.Ride;
import com.project.uberApp.uber.entities.RideRequest;
import com.project.uberApp.uber.entities.enums.RideStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface RideService {
    Ride getRideById(Long rideId);

    void matchWithDrivers(RideRequestDto rideRequestDto);

    Ride createNewRide(RideRequestDto rideRequestDto, Driver driver);

    Ride updateRideStatus(Long rideId, RideStatus rideStatus);

    //have to watch 3rd week , pagination
    Page<Ride> getAllRidesOfRider(Long riderId, PageRequest pageRequest);

    Page<Ride> getAllRidesOfDriver(Long driverId, PageRequest pageRequest);
}
