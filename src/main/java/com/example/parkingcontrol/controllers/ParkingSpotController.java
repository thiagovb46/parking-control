package com.example.parkingcontrol.controllers;

import com.example.parkingcontrol.dtos.ParkingSpotRecord;
import com.example.parkingcontrol.models.ParkingSpotModel;
import com.example.parkingcontrol.services.ParkingSpotService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
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
    public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkingSpotRecord parkingSpotRecord){
        if(parkingSpotService.existsByParkingSpotNumber(parkingSpotRecord.parkingSpotNumber()) ||
                parkingSpotService.existsByLicensePlateCar(parkingSpotRecord.licensePlateCar())
                || parkingSpotService.existsByApartmentAndBlock(parkingSpotRecord.apartment(), parkingSpotRecord.block())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Parking Spot Number, LicensePlateCar, or apartament/block is aready in use");
        }
        var createdParkingSpot = parkingSpotService.createOne(parkingSpotRecord);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdParkingSpot);
    }
}
