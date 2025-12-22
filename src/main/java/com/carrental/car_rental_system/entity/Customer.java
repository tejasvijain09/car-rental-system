package com.carrental.car_rental_system.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    private String email;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "customer")
    private List<Rental> rentals;
}
