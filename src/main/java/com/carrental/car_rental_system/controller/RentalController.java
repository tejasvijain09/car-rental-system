package com.carrental.car_rental_system.controller;

import com.carrental.car_rental_system.entity.Rental;
import com.carrental.car_rental_system.service.RentalService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @PutMapping("/{id}/return")
    public Rental returnVehicle(@PathVariable Long id) {
        return service.returnVehicle(id);
    }

    @GetMapping("/customer/{customerId}")
    public List<Rental> getByCustomer(@PathVariable Long customerId) {
        return service.findByCustomer(customerId);
    }

    @GetMapping("/vehicle/{vehicleId}")
    public List<Rental> getByVehicle(@PathVariable Long vehicleId) {
        return service.findByVehicle(vehicleId);
    }

    @GetMapping("/overdue")
    public List<Rental> getOverdueRentals() {
        return service.findOverdueRentals();
    }

    @GetMapping("/count/branch/{branchId}")
    public long countRentalsByBranch(@PathVariable Long branchId) {
        return service.countRentalsByBranch(branchId);
    }

    @GetMapping("/upcoming")
    public List<Rental> getUpcomingPickups() {
        return service.findUpcomingPickups();
    }

    @GetMapping("/date-range")
    public List<Rental> getRentalsInDateRange(
            @RequestParam LocalDate start,
            @RequestParam LocalDate end) {
        return service.findRentalsInDateRange(start, end);
    }

    @GetMapping("/most-rented-vehicles")
    public List<Object[]> getMostRentedVehicles() {
        return service.findMostRentedVehicleModels();
    }
}