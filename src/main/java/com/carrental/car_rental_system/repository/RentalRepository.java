package com.carrental.car_rental_system.repository;

import com.carrental.car_rental_system.entity.Customer;
import com.carrental.car_rental_system.entity.Rental;
import com.carrental.car_rental_system.entity.VehicleCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Long> {

    // 1. Find all rentals done by a specific customer
    // Uses customer_id as foreign key
    List<Rental> findByCustomerId(Long customerId);

    // 3.  Find all rentals for a specific vehicle
    // Uses vehicle_id as foreign key
    List<Rental> findByVehicleId(Long vehicleId);

    // 9.  Find rentals whose start date lies between two given dates
    // Used for date range based analysis
    List<Rental> findByStartDateBetween(LocalDate start, LocalDate end);

    // 5.  Find overdue rentals
    // Overdue = rental not returned AND end date is before today
    @Query("SELECT r FROM Rental r WHERE r.returnDate IS NULL AND r.endDate < CURRENT_DATE")
    List<Rental> findOverdueRentals();

    // 7.  Find upcoming pickups
    // Rentals that are scheduled to start in the future
    @Query("SELECT r FROM Rental r WHERE r.startDate > CURRENT_DATE")
    List<Rental> findUpcomingPickups();

    // 6. Count number of rentals for a specific branch
    // Used for branch-wise rental statistics
    @Query("SELECT COUNT(r) FROM Rental r WHERE r.vehicle.branch.id = ?1")
    long countRentalsByBranch(Long branchId);

    // 10. Find most rented vehicle models
    // Uses GROUP BY and COUNT aggregation
    @Query("SELECT r.vehicle.model, COUNT(r) FROM Rental r GROUP BY r.vehicle.model")
    List<Object[]> findMostRentedVehicleModels();

    // Some Extra Queries

    //  Find rentals based on vehicle category (SUV, SEDAN, etc.)
    // Demonstrates JPQL with enum filtering
    @Query("SELECT r FROM Rental r WHERE r.vehicle.category = ?1")
    List<Rental> findRentalsByCategory(VehicleCategory category);

    // Find all customers who have rented vehicles from a specific branch
    // DISTINCT is used to avoid duplicate customers
    @Query("SELECT DISTINCT r.customer FROM Rental r WHERE r.vehicle.branch.id = ?1")
    List<Customer> findCustomersByBranch(Long branchId);

    //  Find all rentals belonging to a specific branch
    // Navigates through vehicle → branch relationship
    @Query("SELECT r FROM Rental r WHERE r.vehicle.branch.id = ?1")
    List<Rental> findRentalsByBranch(Long branchId);
}
