package com.project.uberApp.uber.repositories;

import com.project.uberApp.uber.entities.Ride;
import com.project.uberApp.uber.entities.RideRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideRequestRepository extends JpaRepository<RideRequest, Long> {
}
