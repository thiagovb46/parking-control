package com.example.parkingcontrol.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_PARKING_SPOT")
public class ParkingSpotModel implements Serializable {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Setter @Getter
    @Column(nullable = false, unique = true, length = 10)
    private String parkingSpotNumber;
    @Setter @Getter
    @Column(nullable = false, unique = true, length = 7)
    private String licensePlateCar;
    @Setter @Getter
    @Column(nullable = false)
    private String brandCar;
    @Setter @Getter
    @Column(nullable = false)
    private String modelCar;
    @Setter @Getter
    @Column(nullable = false)
    private String colorCar;
    @Column(nullable = false)
    @Setter
    private LocalDateTime registrationDate;
    @Setter @Getter
    @Column(nullable = false)
    private String reponsibleName;
    @Column(nullable = false, length = 30)
    @Setter @Getter
    private String apartment;
    @Column(nullable = false, length = 30)
    @Setter @Getter
    private String block;
}
