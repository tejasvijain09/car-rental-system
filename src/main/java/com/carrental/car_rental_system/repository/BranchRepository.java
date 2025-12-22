package com.carrental.car_rental_system.repository;

import com.carrental.car_rental_system.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch, Long> {
}
