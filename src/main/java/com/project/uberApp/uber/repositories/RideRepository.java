package com.project.uberApp.uber.repositories;

import com.project.uberApp.uber.entities.Driver;
import com.project.uberApp.uber.entities.Ride;
import com.project.uberApp.uber.entities.Rider;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideRepository extends JpaRepository<Ride, Long> {

    Page<Ride> findByRider(Rider rider, PageRequest pageRequest);

    Page<Ride> findByDriver(Driver driver, PageRequest pageRequest);
}
