package com.project.uberApp.uber.repositories;

import com.project.uberApp.uber.entities.Rider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RiderRepository extends JpaRepository<Rider, Long> {
}
