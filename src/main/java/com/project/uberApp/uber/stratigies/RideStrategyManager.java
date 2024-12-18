package com.project.uberApp.uber.stratigies;

import com.project.uberApp.uber.stratigies.impl.DriverMatchingHighestRatedDriverStrategy;
import com.project.uberApp.uber.stratigies.impl.DriverMatchingNearestDriverStrategy;
import com.project.uberApp.uber.stratigies.impl.RideFareSurgePricingFareCalculationStrategy;
import com.project.uberApp.uber.stratigies.impl.RiderFareDefaultFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@RequiredArgsConstructor
public class RideStrategyManager {
    private final DriverMatchingHighestRatedDriverStrategy highestRatedDriverStrategy;
    private final DriverMatchingNearestDriverStrategy nearestDriverStrategy;
    private final RideFareSurgePricingFareCalculationStrategy surgePricingFareCalculationStrategy;
    private final RiderFareDefaultFareCalculationStrategy defaultFareCalculationStrategy;

    public DriverMatchingStrategy driverMatchingStrategy(double rideRating){
        if(rideRating >= 4.8) {
            return highestRatedDriverStrategy;
        }
        else{
            return nearestDriverStrategy;
        }
    }

    public RideFareCalculationStrategy rideFareCalculationStrategy(){
        LocalTime surgeStartTime = LocalTime.of(18,0);
        LocalTime surgeEndTime = LocalTime.of(21,0);

        LocalTime currentTime = LocalTime.now();

        if(currentTime.isAfter(surgeStartTime) && currentTime.isBefore(surgeEndTime)){
            return surgePricingFareCalculationStrategy;
        }
        else {
            return defaultFareCalculationStrategy;
        }
    }
}
