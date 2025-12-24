package com.carrental.car_rental_system.controller;

import com.carrental.car_rental_system.entity.Vehicle;
import com.carrental.car_rental_system.entity.VehicleCategory;
import com.carrental.car_rental_system.service.VehicleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleService service;

    public VehicleController(VehicleService service) {
        this.service = service;
    }

    // 1️⃣ Create vehicle
    @PostMapping
    public Vehicle create(@RequestBody Vehicle vehicle) {
        return service.save(vehicle);
    }

    // 2️⃣ Get all vehicles
    @GetMapping
    public List<Vehicle> getAll() {
        return service.findAll();
    }

    // 3️⃣ Delete all vehicles
    @DeleteMapping("/all")
    public String deleteAllVehicles() {
        service.deleteAllVehicles();
        return "All vehicles deleted successfully";
    }


    // 4️⃣ Available vehicles at a branch
    @GetMapping("/branch/{branchId}/available")
    public List<Vehicle> getAvailableAtBranch(@PathVariable Long branchId) {
        return service.findAvailableByBranch(branchId);
    }

    // 5️⃣ Vehicles by category
    @GetMapping("/category/{category}")
    public List<Vehicle> getByCategory(@PathVariable VehicleCategory category) {
        return service.findByCategory(category);
    }

    // 6️⃣ Vehicles needing maintenance
    @GetMapping("/maintenance/{mileage}")
    public List<Vehicle> getVehiclesNeedingMaintenance(@PathVariable int mileage) {
        return service.findVehiclesNeedingMaintenance(mileage);
    }
}