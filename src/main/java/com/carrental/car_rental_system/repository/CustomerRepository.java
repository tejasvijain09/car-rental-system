package com.carrental.car_rental_system.repository;

import com.carrental.car_rental_system.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
