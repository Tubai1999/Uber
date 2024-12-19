package com.project.uberApp.uber.sevices;

import com.project.uberApp.uber.entities.RideRequest;

public interface RideRequestService {
    RideRequest findRideRequestById(Long rideRequestId);
}
