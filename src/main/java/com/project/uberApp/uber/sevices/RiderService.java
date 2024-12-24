package com.project.uberApp.uber.sevices;

import com.project.uberApp.uber.dto.DriverDto;
import com.project.uberApp.uber.dto.RideDto;
import com.project.uberApp.uber.dto.RideRequestDto;
import com.project.uberApp.uber.dto.RiderDto;
import com.project.uberApp.uber.entities.Ride;
import com.project.uberApp.uber.entities.Rider;
import com.project.uberApp.uber.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface RiderService {
    RideRequestDto requestRide(RideRequestDto rideRequestDto);
    RiderDto acceptRide(Long rideId);
    RideDto cancelRide(Long rideId);



    DriverDto rateDriver(Long rideId,Integer rating);

    RiderDto getMyProfile();

    Page<RideDto> getAllMyRides(PageRequest pageRequest);

    Rider createNewRider(User user);

    Rider getCurrentRider();
}
