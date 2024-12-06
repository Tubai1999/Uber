package com.project.uberApp.uber.dto;

import com.project.uberApp.uber.entities.Driver;
import com.project.uberApp.uber.entities.Rider;
import com.project.uberApp.uber.entities.enums.PaymentMethod;
import com.project.uberApp.uber.entities.enums.RideRequestStatus;
import com.project.uberApp.uber.entities.enums.RideStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

public class RideDto {
    private Long id;


    private Point pickUpLocation;

    private Point dropOffLocation;


    private LocalDateTime createdTime;


    private Rider rider;


    private Driver driver;

    private PaymentMethod paymentMethod;


    private RideRequestStatus rideRequestStatus;


    private RideStatus rideStatus;

    private Double fare;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;
}
