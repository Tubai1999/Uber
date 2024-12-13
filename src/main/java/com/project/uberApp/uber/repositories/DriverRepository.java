package com.project.uberApp.uber.repositories;

import com.project.uberApp.uber.entities.Driver;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DriverRepository extends JpaRepository<Driver, Long> {

    @Query("SELECT d.*, ST_Distance(d.current_location, :pickUpLocation, 10000) AS distance " +
            " FROM driver AS d " +
            "WHERE available = true AND ST_DWithin(d.current_location, :pickupLocation, 10000) " +
            "ORDER BY distance " +
            "LIMIT 10"
    )
    void findTenNearestDrivers(Point pickUpLocation);
}
