package com.project.uberApp.uber.sevices.Impl;

import com.project.uberApp.uber.dto.DriverDto;
import com.project.uberApp.uber.dto.RideDto;
import com.project.uberApp.uber.dto.RiderDto;
import com.project.uberApp.uber.entities.Driver;
import com.project.uberApp.uber.entities.Ride;
import com.project.uberApp.uber.entities.RideRequest;
import com.project.uberApp.uber.entities.enums.RideRequestStatus;
import com.project.uberApp.uber.entities.enums.RideStatus;
import com.project.uberApp.uber.exceptions.ResourceNotFoundException;
import com.project.uberApp.uber.repositories.DriverRepository;
import com.project.uberApp.uber.sevices.DriverService;
import com.project.uberApp.uber.sevices.RideRequestService;
import com.project.uberApp.uber.sevices.RideService;
import com.project.uberApp.uber.sevices.RiderService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DriverServiceImpl implements DriverService {
    private final RideRequestService rideRequestService;
    private final DriverRepository driverRepository;
    private final RideService rideService;
    private final ModelMapper modelMapper;
    @Override
    @Transactional
    public RideDto acceptRide(Long rideRequestId) {
        RideRequest rideRequest = rideRequestService.findRideRequestById(rideRequestId);
        if(!rideRequest.getRideRequestStatus().equals(RideRequestStatus.PENDING)){
            throw new RuntimeException("RideRequest cannot be accepted, status is "+rideRequest.getRideRequestStatus());
        }

        Driver currentDriver = getCurrentDriver();
        if(!currentDriver.getAvailable()){
            throw new RuntimeException("Driver cannot accept ride due to unavailability");
        }


        Driver savedDriver = updateDriverAvailability(currentDriver,false);

        Ride ride = rideService.createNewRide(rideRequest,savedDriver);
        return modelMapper.map(ride,RideDto.class);
    }

    @Override
    public RideDto cancelRide(Long rideId) {
        Ride ride = rideService.getRideById(rideId);
        Driver driver = getCurrentDriver();
        if(!driver.equals(ride.getDriver())){
            throw new RuntimeException("Driver cannot start ride as he has not accepted it earlier");
        }

        if(!ride.getRideStatus().equals(RideStatus.CONFIRMED)){
            throw new RuntimeException(("Ride cannot be cancelled,invalid status: "+ride.getRideStatus()));
        }

        rideService.updateRideStatus(ride,RideStatus.CANCELLED);
        updateDriverAvailability(driver,true);
        return modelMapper.map(ride,RideDto.class);
    }

    @Override
    @Transactional
    public RideDto startRide(Long rideId, String otp) {
        Ride ride = rideService.getRideById(rideId);
        log.info(ride.toString());
        Driver driver = getCurrentDriver();

        if(!driver.equals(ride.getDriver())){
            throw new RuntimeException("Driver cannot start a ride as he has not accepted it earlier");
        }

        if(!ride.getRideStatus().equals(RideStatus.CONFIRMED)){
            throw new RuntimeException("Ride status is not CONFIRMED hence can not be started, status: "+ride.getRideRequestStatus());
        }

        if(!otp.equals(ride.getOtp())){
            throw new RuntimeException("otp is not valid, otp: "+otp);
        }

        ride.setStartedAt(LocalDateTime.now());
        Ride savedRide = rideService.updateRideStatus(ride, RideStatus.ONGOING);
//        System.out.println("Ride: " + ride);
//        System.out.println("Driver: " + driver);
//        System.out.println("Ride Status: " + ride.getRideStatus());
//        System.out.println("Saved Ride: " + savedRide);
        log.info(savedRide.toString());

        return modelMapper.map(savedRide,RideDto.class);
    }

    @Override
    public RideDto endRide(Long rideId) {
        return null;
    }

    @Override
    public RiderDto rateRider(Long rideId, Integer rating) {
        return null;
    }

    @Override
    public DriverDto getMyProfile() {
        Driver currentDriver = getCurrentDriver();
        return modelMapper.map(currentDriver, DriverDto.class);

    }

    @Override
    public Page<RideDto>getAllMyRides(PageRequest pageRequest) {
        Driver currentDriver = getCurrentDriver();
        return rideService.getAllRidesOfDriver(currentDriver,pageRequest).map(
                ride -> modelMapper.map(ride,RideDto.class)
        );
    }

    @Override
    public Driver getCurrentDriver() {
        return driverRepository.findById(2L).orElseThrow(() ->
                new ResourceNotFoundException("driver not found with id "+2)
                );
    }

    @Override
    public Driver updateDriverAvailability(Driver driver, boolean available) {
        driver.setAvailable(available);
        return driverRepository.save(driver);
    }
}
