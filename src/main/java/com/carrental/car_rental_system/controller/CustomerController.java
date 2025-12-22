package com.carrental.car_rental_system.controller;
import com.carrental.car_rental_system.entity.Customer;
import com.carrental.car_rental_system.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerRepository repo;

    public CustomerController(CustomerRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public Customer create(@RequestBody Customer c){
        return repo.save(c);
    }

    @GetMapping
    public List<Customer> getAll() {
        return repo.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
