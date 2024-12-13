package com.project.uberApp.uber.dto;

import com.project.uberApp.uber.entities.Driver;
import com.project.uberApp.uber.entities.Rider;
import com.project.uberApp.uber.entities.enums.PaymentMethod;
import com.project.uberApp.uber.entities.enums.RideRequestStatus;
import com.project.uberApp.uber.entities.enums.RideStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RideDto {
    private Long id;
    private Point pickUpLocation;
    private Point dropOffLocation;

    private LocalDateTime createdTime;
    private RiderDto rider;
    private DriverDto driver;
    private PaymentMethod paymentMethod;

    //check wheather
    private RideRequestStatus rideRequestStatus;

    private RideStatus rideStatus;

    private String otp;
    private Double fare;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;
}
