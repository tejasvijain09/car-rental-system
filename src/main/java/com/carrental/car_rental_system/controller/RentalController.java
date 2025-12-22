package com.carrental.car_rental_system.controller;

import com.carrental.car_rental_system.entity.Rental;
import com.carrental.car_rental_system.service.RentalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rentals")
public class RentalController {

    private final RentalService service;

    public RentalController(RentalService service) {
        this.service = service;
    }

    @PostMapping
    public Rental create(@RequestBody Rental r) {
        return service.save(r);
    }

    @GetMapping
    public List<Rental> getAll() {
        return service.findAll();
    }
}