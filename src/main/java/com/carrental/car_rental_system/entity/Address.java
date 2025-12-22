package com.carrental.car_rental_system.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Address {
    private String city;
    private String state;
    private String pincode;
}
