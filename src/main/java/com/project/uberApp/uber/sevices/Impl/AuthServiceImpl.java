package com.project.uberApp.uber.sevices.Impl;

import com.project.uberApp.uber.dto.DriverDto;
import com.project.uberApp.uber.dto.SignupDto;
import com.project.uberApp.uber.dto.UserDto;
import com.project.uberApp.uber.sevices.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public String login(String email, String password) {
        return "";
    }

    @Override
    public UserDto signup(SignupDto signupDto) {
        return null;
    }

    @Override
    public DriverDto onboardNewDriver(Long userId) {
        return null;
    }
}
