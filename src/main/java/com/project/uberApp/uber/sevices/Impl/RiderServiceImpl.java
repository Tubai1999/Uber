package com.project.uberApp.uber.sevices.Impl;

import com.project.uberApp.uber.dto.DriverDto;
import com.project.uberApp.uber.dto.RideDto;
import com.project.uberApp.uber.dto.RideRequestDto;
import com.project.uberApp.uber.dto.RiderDto;
import com.project.uberApp.uber.entities.Driver;
import com.project.uberApp.uber.entities.RideRequest;
import com.project.uberApp.uber.entities.Rider;
import com.project.uberApp.uber.entities.User;
import com.project.uberApp.uber.entities.enums.RideRequestStatus;
import com.project.uberApp.uber.exceptions.ResourceNotFoundException;
import com.project.uberApp.uber.repositories.RideRequestRepository;
import com.project.uberApp.uber.repositories.RiderRepository;
import com.project.uberApp.uber.sevices.RiderService;
import com.project.uberApp.uber.stratigies.DriverMatchingStrategy;
import com.project.uberApp.uber.stratigies.RideFareCalculationStrategy;
import com.project.uberApp.uber.stratigies.RideStrategyManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RiderServiceImpl implements RiderService {

    private final ModelMapper modelMapper;
//    private final RideFareCalculationStrategy rideFareCalculationStrategy;
//    private final DriverMatchingStrategy driverMatchingStrategy;
    private final RideRequestRepository rideRequestRepository;
    private final RiderRepository riderRepository;
    private final RideStrategyManager rideStrategyManager;
    @Override
    @Transactional
    public RideRequestDto requestRide(RideRequestDto rideRequestDto) {
        Rider rider = getCurrentRider();
        log.info(rider.toString());
        RideRequest rideRequest = modelMapper.map(rideRequestDto,RideRequest.class);
        rideRequest.setRideRequestStatus(RideRequestStatus.PENDING);
        rideRequest.setRider(rider);

//        Double fare = rideFareCalculationStrategy.calculateFare(rideRequest);
        Double fare = rideStrategyManager.rideFareCalculationStrategy().calculateFare(rideRequest);
        rideRequest.setFare(fare);
        RideRequest savedRideRequest = rideRequestRepository.save(rideRequest);

//        driverMatchingStrategy.findMatchingDriver(rideRequest );
        List<Driver> drivers = rideStrategyManager.driverMatchingStrategy(rider.getRating()).findMatchingDriver(rideRequest );

        //TODO : send notification to all the drivers about this ride request

        return modelMapper.map(savedRideRequest, RideRequestDto.class);
    }

    @Override
    public RiderDto acceptRide(Long rideId) {
        return null;
    }

    @Override
    public RideDto cancelRide(Long rideId) {
        return null;
    }

    @Override
    public DriverDto rateDriver(Long rideId, Integer rating) {
        return null;
    }

    @Override
    public RiderDto getMyProfile() {
        return null;
    }

    @Override
    public List<RideDto> getAllMyRides() {
        return null;
    }

    @Override
    public Rider createNewRider(User user) {
        Rider rider = Rider
                .builder()
                .user(user)
                .rating(0.0)
                .build();
        return riderRepository.save(rider);
    }

    @Override
    public Rider getCurrentRider() {
        return riderRepository.findById(1L).orElseThrow(() -> new ResourceNotFoundException("Rider not found"));
    }
}
