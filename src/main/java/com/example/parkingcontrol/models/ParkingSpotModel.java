package com.example.parkingcontrol.models;

import jakarta.persistence.*;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_PARKING_SPOT")
public class ParkingSpotModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, unique = true, length = 10)
    private String parkingSpotNumber;
    @Column(nullable = false, unique = true, length = 7)
    private String licensePlateCar;
    @Column(nullable = false)
    private String brandCar;
    @Column(nullable = false)
    private String modelCar;
    @Column(nullable = false)
    private String colorCar;
    @Column(nullable = false)
    @Setter
    private LocalDateTime registrationDate;
    @Column(nullable = false)
    private String reponsibleName;
    @Column(nullable = false, length = 30)
    private String apartment;
    @Column(nullable = false, length = 30)
    private String block;
}
