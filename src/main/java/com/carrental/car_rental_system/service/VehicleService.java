package com.carrental.car_rental_system.service;

import com.carrental.car_rental_system.entity.Rental;
import com.carrental.car_rental_system.entity.Vehicle;
import com.carrental.car_rental_system.repository.VehicleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VehicleService {
    private final VehicleRepository repo;

    public VehicleService(VehicleRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public Vehicle save(Vehicle vehicle) {
        return repo.save(vehicle);
    }

    @Transactional(readOnly = true)
    public List<Vehicle> findAll() {
        return repo.findAll();
    }

    @Transactional
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
