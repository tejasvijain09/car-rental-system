package com.carrental.car_rental_system.service;

import com.carrental.car_rental_system.entity.Rental;
import com.carrental.car_rental_system.entity.Vehicle;
import com.carrental.car_rental_system.repository.RentalRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
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
    @Transactional
    public Rental returnVehicle(Long rentalId) {

        Rental rental = repo.findById(rentalId)
                .orElseThrow(() -> new RuntimeException("Rental not found"));

        rental.setReturnDate(LocalDate.now());

        Vehicle vehicle = rental.getVehicle();
        vehicle.setAvailable(true);

        return repo.save(rental);
    }

    @Transactional
    public List<Rental> findByCustomer(Long customerId) {
        return repo.findByCustomerId(customerId);
    }

    @Transactional(readOnly = true)
    public List<Rental> findByVehicle(Long vehicleId) {
        return repo.findByVehicleId(vehicleId);
    }

    @Transactional(readOnly = true)
    public List<Rental> findOverdueRentals() {
        return repo.findOverdueRentals();
    }
    @Transactional(readOnly = true)
    public long countRentalsByBranch(Long branchId) {
        return repo.countRentalsByBranch(branchId);
    }
    @Transactional(readOnly = true)
    public List<Rental> findUpcomingPickups() {
        return repo.findUpcomingPickups();
    }
    @Transactional(readOnly = true)
    public List<Rental> findRentalsInDateRange(LocalDate start, LocalDate end) {
        return repo.findByStartDateBetween(start, end);
    }

    @Transactional(readOnly = true)
    public List<Object[]> findMostRentedVehicleModels() {
        return repo.findMostRentedVehicleModels();
    }
}
