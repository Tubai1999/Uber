package com.project.uberApp.uber.controllers;

import com.project.uberApp.uber.dto.*;
import com.project.uberApp.uber.sevices.RiderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rider")
@RequiredArgsConstructor
public class RiderController {
    private final RiderService riderService;
    @PostMapping("/requestRide")
    public ResponseEntity<RideRequestDto> requestRide(@RequestBody RideRequestDto rideRequestDto){
            return ResponseEntity.ok(riderService.requestRide(rideRequestDto));
    }
    @PostMapping("/cancelRide/{rideId}")
    public ResponseEntity<RideDto> cancelRide(@PathVariable Long rideId){
        return ResponseEntity.ok(riderService.cancelRide(rideId));
    }
    @PostMapping("/rateDriver")
    public ResponseEntity<DriverDto> rateDriver(@RequestBody RatingDto ratingDto){
        return ResponseEntity.ok(riderService.rateDriver(ratingDto.getRideId(),ratingDto.getRating()));
    }
    @GetMapping("/getMyProfile")
    public ResponseEntity<RiderDto> getMyProfile(){
        return ResponseEntity.ok(riderService.getMyProfile());
    }
    @GetMapping("/getAllMyRides")
    public ResponseEntity<Page<RideDto>> getAllMyRides(@RequestParam(defaultValue = "0") Integer pageOffset,
                                                       @RequestParam(defaultValue = "10", required = false)Integer pageSize){
        PageRequest pageRequest = PageRequest.of(pageOffset,pageSize);
        return ResponseEntity.ok(riderService.getAllMyRides(pageRequest));
    }

    @PostMapping("/rateDriver/{rideId}/{rating}")
    public ResponseEntity<DriverDto> rateDriver(@PathVariable Long rideId, @PathVariable Integer rating){
        return ResponseEntity.ok(riderService.rateDriver(rideId,rating));
    }

}