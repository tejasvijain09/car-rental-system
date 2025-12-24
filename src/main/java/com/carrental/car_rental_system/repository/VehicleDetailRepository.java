package com.carrental.car_rental_system.repository;

import com.carrental.car_rental_system.entity.VehicleDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleDetailRepository extends JpaRepository<VehicleDetail, Long> {
}