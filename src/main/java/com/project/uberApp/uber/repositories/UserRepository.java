package com.project.uberApp.uber.repositories;

import com.project.uberApp.uber.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
