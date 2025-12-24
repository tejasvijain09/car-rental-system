package com.carrental.car_rental_system.repository;

import com.carrental.car_rental_system.entity.Customer;
import com.carrental.car_rental_system.entity.Rental;
import com.carrental.car_rental_system.entity.VehicleCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Long> {
    // 1. Rentals by customer
    List<Rental> findByCustomerId(Long customerId);

    // 3. Rentals for a vehicle
    List<Rental> findByVehicleId(Long vehicleId);

    // 9. Find rentals whose start date lies between two given dates
    // 9. Rentals in date range
    List<Rental> findByStartDateBetween(LocalDate start, LocalDate end);

    // 5. Overdue rentals
    @Query("SELECT r FROM Rental r WHERE r.returnDate IS NULL AND r.returnDate < CURRENT_DATE")
    List<Rental> findOverdueRentals();

    // 7. Upcoming pickups
    @Query("SELECT r FROM Rental r WHERE r.startDate > CURRENT_DATE")
    List<Rental> findUpcomingPickups();

    // 6. Count rentals per branch
    @Query("SELECT COUNT(r) FROM Rental r WHERE r.vehicle.branch.id = ?1")
    long countRentalsByBranch(Long branchId);

    // Extra relationship queries
    @Query("SELECT r FROM Rental r WHERE r.vehicle.branch.id = ?1")
    List<Rental> findRentalsByBranch(Long branchId);

    // 10. Most rented vehicle models
    @Query("SELECT r.vehicle.model, COUNT(r) FROM Rental r GROUP BY r.vehicle.model")
    List<Object[]> findMostRentedVehicleModels();

    @Query("SELECT r FROM Rental r WHERE r.vehicle.category = ?1")
    List<Rental> findRentalsByCategory(VehicleCategory category);

    @Query("SELECT DISTINCT r.customer FROM Rental r WHERE r.vehicle.branch.id = ?1")
    List<Customer> findCustomersByBranch(Long branchId);


}
