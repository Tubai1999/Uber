package com.project.uberApp.uber.sevices;

import com.project.uberApp.uber.dto.DriverDto;
import com.project.uberApp.uber.dto.RiderDto;
import com.project.uberApp.uber.entities.Driver;
import com.project.uberApp.uber.entities.Ride;
import com.project.uberApp.uber.entities.Rider;

public interface RatingService {
    DriverDto rateDriver(Ride ride, Integer rating);
    RiderDto rateRider(Ride ride, Integer rating);

    void createNewRating(Ride ride);
}
