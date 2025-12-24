package com.carrental.car_rental_system.service;

import com.carrental.car_rental_system.entity.Branch;
import com.carrental.car_rental_system.repository.BranchRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BranchService {
    private final BranchRepository repo;

    public BranchService(BranchRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public Branch save(Branch branch) {
        return repo.save(branch);
    }

    @Transactional(readOnly = true)
    public List<Branch> findAll() {
        return repo.findAll();
    }

    @Transactional
    public void delete(Long id) {
        repo.deleteById(id);
    }
    @Transactional
    public void deleteAllBranches() {
        repo.deleteAll();
    }
}
