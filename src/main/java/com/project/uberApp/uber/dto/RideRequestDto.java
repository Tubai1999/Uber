package com.project.uberApp.uber.dto;

import com.project.uberApp.uber.entities.Rider;
import com.project.uberApp.uber.entities.enums.PaymentMethod;
import com.project.uberApp.uber.entities.enums.RideRequestStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RideRequestDto {
    private Long id;

    private PointDto pickUpLocation;

    private PointDto dropOffLocation;

    private LocalDateTime requestedTime;

    private RiderDto rider;
    private Double fare;

    private PaymentMethod paymentMethod;

    private RideRequestStatus rideRequestStatus;
}
