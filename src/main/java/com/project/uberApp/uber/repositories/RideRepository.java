package com.project.uberApp.uber.repositories;

import com.project.uberApp.uber.entities.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideRepository extends JpaRepository<Ride, Long> {

}
