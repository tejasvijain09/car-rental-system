package com.carrental.car_rental_system.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate returnDate;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Vehicle vehicle;
}
