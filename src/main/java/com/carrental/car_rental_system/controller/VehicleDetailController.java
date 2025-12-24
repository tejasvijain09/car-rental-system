package com.carrental.car_rental_system.controller;

import com.carrental.car_rental_system.entity.VehicleDetail;
import com.carrental.car_rental_system.service.VehicleDetailService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicle-details")
public class VehicleDetailController {

    private final VehicleDetailService service;

    public VehicleDetailController(VehicleDetailService service) {
        this.service = service;
    }

    // CREATE VehicleDetail
    @PostMapping
    public VehicleDetail create(@RequestBody VehicleDetail vehicleDetail) {
        return service.save(vehicleDetail);
    }

    // GET all VehicleDetails
    @GetMapping
    public List<VehicleDetail> getAll() {
        return service.findAll();
    }
}