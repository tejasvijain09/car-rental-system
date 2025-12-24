package com.carrental.car_rental_system.service;

import com.carrental.car_rental_system.entity.Rental;
import com.carrental.car_rental_system.entity.Vehicle;
import com.carrental.car_rental_system.entity.VehicleCategory;
import com.carrental.car_rental_system.repository.VehicleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class VehicleService {

    private final VehicleRepository repo;

    public VehicleService(VehicleRepository repo) {
        this.repo = repo;
    }

    // 1️⃣ Save vehicle
    @Transactional
    public Vehicle save(Vehicle vehicle) {
        return repo.save(vehicle);
    }

    // 2️⃣ Get all vehicles
    @Transactional(readOnly = true)
    public List<Vehicle> findAll() {
        return repo.findAll();
    }

    // 3️⃣ Delete by ID
    @Transactional
    public void delete(Long id) {
        repo.deleteById(id);
    }

    // 4️⃣ Delete all vehicles
    @Transactional
    public void deleteAllVehicles() {
        repo.deleteAll();
    }


    // 5️⃣ Available vehicles at a branch
    @Transactional(readOnly = true)
    public List<Vehicle> findAvailableByBranch(Long branchId) {
        return repo.findByBranchIdAndAvailableTrue(branchId);
    }

    // 6️⃣ Vehicles by category
    @Transactional(readOnly = true)
    public List<Vehicle> findByCategory(VehicleCategory category) {
        return repo.findByCategory(category);
    }

    // 7️⃣ Vehicles needing maintenance
    @Transactional(readOnly = true)
    public List<Vehicle> findVehiclesNeedingMaintenance(int mileage) {
        return repo.findByMileageGreaterThan(mileage);
    }

}