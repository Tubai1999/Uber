package com.project.uberApp.uber.sevices.Impl;

import com.project.uberApp.uber.dto.DriverDto;
import com.project.uberApp.uber.dto.RideDto;
import com.project.uberApp.uber.dto.RideRequestDto;
import com.project.uberApp.uber.dto.RiderDto;
import com.project.uberApp.uber.entities.Driver;
import com.project.uberApp.uber.entities.Ride;
import com.project.uberApp.uber.entities.RideRequest;
import com.project.uberApp.uber.entities.Rider;
import com.project.uberApp.uber.entities.enums.RideRequestStatus;
import com.project.uberApp.uber.entities.enums.RideStatus;
import com.project.uberApp.uber.exceptions.ResourceNotFoundException;
import com.project.uberApp.uber.repositories.RideRepository;
import com.project.uberApp.uber.repositories.RiderRepository;
import com.project.uberApp.uber.sevices.RideRequestService;
import com.project.uberApp.uber.sevices.RideService;
import com.project.uberApp.uber.sevices.RiderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class RideServiceImpl implements RideService {

    private final ModelMapper modelMapper;
    private final RideRequestService rideRequestService;
    private final RideRepository rideRepository;

    @Override
    public Ride getRideById(Long rideId) {
        return rideRepository.findById(rideId)
                .orElseThrow(() -> new ResourceNotFoundException("Ride not found with is: "+rideId));
    }

    @Override
    public void matchWithDrivers(RideRequestDto rideRequestDto) {

    }

    @Override
    public Ride createNewRide(RideRequest rideRequest, Driver driver) {
        rideRequest.setRideRequestStatus(RideRequestStatus.CONFIRMED);

        Ride ride = modelMapper.map(rideRequest,Ride.class);
        ride.setRideStatus(RideStatus.CONFIRMED);
        ride.setDriver(driver);
        ride.setOtp(generateRandomOTP());
        ride.setId(null);

        rideRequestService.update(rideRequest);
        return rideRepository.save(ride);
    }


    @Override
    public Ride updateRideStatus(Ride ride, RideStatus rideStatus) {
        ride.setRideStatus(rideStatus);
        return rideRepository.save(ride);
    }

    @Override
    public Page<Ride> getAllRidesOfRider(Rider rider, PageRequest pageRequest) {
        return rideRepository.findByRider(rider,pageRequest);
    }

    @Override
    public Page<Ride> getAllRidesOfDriver(Driver driver, PageRequest pageRequest) {
        return rideRepository.findByDriver(driver,pageRequest);
    }



    private String generateRandomOTP(){
        Random random = new Random();
        int otpInt = random.nextInt(1000);
        return String.format("%04d",otpInt);
    }
}
