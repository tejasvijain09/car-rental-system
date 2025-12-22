package com.carrental.car_rental_system.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;

    @Enumerated(EnumType.STRING)
    private VehicleCategory category;

    private int mileage;

    private boolean available;

    @ManyToOne
    private Branch branch;

    @OneToOne(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private VehicleDetail vehicleDetail;
}
