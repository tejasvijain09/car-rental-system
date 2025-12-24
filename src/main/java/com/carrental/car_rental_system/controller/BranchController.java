package com.carrental.car_rental_system.controller;

import com.carrental.car_rental_system.entity.Branch;
import com.carrental.car_rental_system.service.BranchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/branches")
public class BranchController {

    private final BranchService service;

    public BranchController(BranchService service) {
        this.service = service;
    }

    @PostMapping
    public Branch create(@RequestBody Branch branch) {
        return service.save(branch);
    }

    @GetMapping
    public List<Branch> getAll() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @DeleteMapping("/all")
    public String deleteAllBranches() {
        service.deleteAllBranches();
        return "All branches deleted";
    }
}