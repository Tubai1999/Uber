package com.project.uberApp.uber.repositories;

import com.project.uberApp.uber.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {

}
