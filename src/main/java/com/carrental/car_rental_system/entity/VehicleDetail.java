package com.carrental.car_rental_system.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class VehicleDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String registrationNumber;

    @Column(nullable = false)
    private boolean insured;

    @OneToOne
    @NotNull
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;
}