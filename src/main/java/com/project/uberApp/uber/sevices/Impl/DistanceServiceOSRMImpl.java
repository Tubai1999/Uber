package com.project.uberApp.uber.sevices.Impl;

import com.project.uberApp.uber.sevices.DistanceService;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;

@Service
public class DistanceServiceOSRMImpl implements DistanceService {
    @Override
    public double calculateDistance(Point src, Point dest) {
        //call third party api OSRM to calculate the distance between two point
        return 0;
    }
}
