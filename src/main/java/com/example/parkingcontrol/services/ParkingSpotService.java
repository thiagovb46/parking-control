package com.example.parkingcontrol.services;

import com.example.parkingcontrol.dtos.ParkingSpotRecord;
import com.example.parkingcontrol.models.ParkingSpotModel;
import com.example.parkingcontrol.repositories.ParkingSpotRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class ParkingSpotService {
    @Autowired
    ParkingSpotRepository parkingSpotRepository;
    public ParkingSpotModel createOne(@Valid  @RequestBody ParkingSpotRecord parkingSpotRecord){
        ParkingSpotModel parkingSpotModel = new ParkingSpotModel();
        BeanUtils.copyProperties(parkingSpotRecord, parkingSpotModel);
        parkingSpotModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        parkingSpotRepository.save(parkingSpotModel);
        return parkingSpotModel;
    }
}
