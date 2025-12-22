package com.carrental.car_rental_system.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class VehicleDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String registrationNumber;
    private boolean insured;

    @OneToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
}
