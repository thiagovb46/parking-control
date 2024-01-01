package com.example.parkingcontrol.controllers;

import com.example.parkingcontrol.dtos.ParkingSpotRecord;
import com.example.parkingcontrol.models.ParkingSpotModel;
import com.example.parkingcontrol.services.ParkingSpotService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking-spot")
public class ParkingSpotController {
    @Autowired
    ParkingSpotService parkingSpotService;
    @PostMapping
    public ResponseEntity<ParkingSpotModel> createOne(@RequestBody @Valid ParkingSpotRecord parkingSpotRecord){
        var createdParkingSpot = parkingSpotService.createOne(parkingSpotRecord);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdParkingSpot);
    }
}
