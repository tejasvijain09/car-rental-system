package com.carrental.car_rental_system.repository;

import com.carrental.car_rental_system.entity.Vehicle;
import com.carrental.car_rental_system.entity.VehicleCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    // 2. Available vehicles at a branch
    List<Vehicle> findByBranchIdAndAvailableTrue(Long branchId);

    // 4. Vehicles by category
    List<Vehicle> findByCategory(VehicleCategory category);

    // 8. Vehicles needing maintenance
    List<Vehicle> findByMileageGreaterThan(int mileage);
}
