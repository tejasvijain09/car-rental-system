package com.carrental.car_rental_system.service;

import com.carrental.car_rental_system.entity.Vehicle;
import com.carrental.car_rental_system.entity.VehicleDetail;
import com.carrental.car_rental_system.repository.VehicleDetailRepository;
import com.carrental.car_rental_system.repository.VehicleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VehicleDetailService {

    private final VehicleDetailRepository repo;
    private final VehicleRepository vehicleRepo;

    public VehicleDetailService(VehicleDetailRepository repo,
                                VehicleRepository vehicleRepo) {
        this.repo = repo;
        this.vehicleRepo = vehicleRepo;
    }

    @Transactional
    public VehicleDetail save(VehicleDetail detail) {

        if (detail.getVehicle() == null || detail.getVehicle().getId() == null) {
            throw new RuntimeException("Vehicle ID must be provided");
        }

        Vehicle vehicle = vehicleRepo.findById(detail.getVehicle().getId())
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        detail.setVehicle(vehicle);

        return repo.save(detail);
    }

    @Transactional(readOnly = true)
    public List<VehicleDetail> findAll() {
        return repo.findAll();
    }
}