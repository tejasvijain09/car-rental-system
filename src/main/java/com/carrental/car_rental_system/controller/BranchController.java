package com.carrental.car_rental_system.controller;

import com.carrental.car_rental_system.entity.Branch;
import com.carrental.car_rental_system.repository.BranchRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/branches")
public class BranchController {

    private final BranchRepository repo;

    public BranchController(BranchRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public Branch create(@RequestBody Branch b) {
        return repo.save(b);
    }

    @GetMapping
    public List<Branch> getAll() {
        return repo.findAll();
    }
}