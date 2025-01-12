package com.project.uberApp.uber.controllers;

import com.project.uberApp.uber.dto.DriverDto;
import com.project.uberApp.uber.dto.OnboardDriverDto;
import com.project.uberApp.uber.dto.SignupDto;
import com.project.uberApp.uber.dto.UserDto;
import com.project.uberApp.uber.sevices.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping("/signup")
    ResponseEntity<UserDto> signUp(@RequestBody SignupDto signupDto){
        return new ResponseEntity<>(authService.signup(signupDto), HttpStatus.CREATED);
    }

    @PostMapping("/onBoardNewDriver/{userId}")
    ResponseEntity<DriverDto> onBoardNewDriver(@PathVariable Long userId,
                                               @RequestBody OnboardDriverDto onboardDriverDto){
        return new ResponseEntity<>(authService.onboardNewDriver(userId,onboardDriverDto.getVehicleId()),HttpStatus.CREATED);
    }
}
