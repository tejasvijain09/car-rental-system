package com.carrental.car_rental_system.service;

import com.carrental.car_rental_system.entity.Rental;
import com.carrental.car_rental_system.repository.RentalRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RentalService {
    private final RentalRepository repo;

    public RentalService(RentalRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public Rental save(Rental rental) {
        return repo.save(rental);
    }

    @Transactional(readOnly = true)
    public List<Rental> findAll() {
        return repo.findAll();
    }
}
