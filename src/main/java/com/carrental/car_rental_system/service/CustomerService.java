package com.carrental.car_rental_system.service;

import com.carrental.car_rental_system.entity.Customer;
import com.carrental.car_rental_system.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository repo;

    public CustomerService(CustomerRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public Customer save(Customer customer) {
        return repo.save(customer);
    }

    @Transactional(readOnly = true)
    public List<Customer> findAll() {
        return repo.findAll();
    }

    @Transactional
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
