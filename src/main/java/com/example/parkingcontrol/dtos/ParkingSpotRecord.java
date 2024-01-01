package com.example.parkingcontrol.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.UUID;

public record ParkingSpotRecord(@NotBlank  String parkingSpotNumber,@NotBlank String licensePlateCar, @NotBlank String brandCar,@NotBlank  String modelCar,
                                @NotBlank String colorCar, @NotBlank String reponsibleName, @NotBlank String apartment,
                                @NotBlank String block
                                ) {}
