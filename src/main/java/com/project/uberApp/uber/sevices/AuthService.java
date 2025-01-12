package com.project.uberApp.uber.sevices;

import com.project.uberApp.uber.dto.DriverDto;
import com.project.uberApp.uber.dto.SignupDto;
import com.project.uberApp.uber.dto.UserDto;
import org.springframework.stereotype.Service;


public interface AuthService {
    String login(String email, String password);
    UserDto signup(SignupDto signupDto);

    DriverDto onboardNewDriver(Long userId, String vehicleId);
}
