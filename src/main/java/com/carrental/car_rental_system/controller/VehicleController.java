package com.carrental.car_rental_system.controller;

import com.carrental.car_rental_system.entity.Vehicle;
import com.carrental.car_rental_system.repository.VehicleRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleRepository repo;

    public VehicleController(VehicleRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public Vehicle create(@RequestBody Vehicle v) {
        return repo.save(v);
    }

    @GetMapping
    public List<Vehicle> getAll() {
        return repo.findAll();
    }
}