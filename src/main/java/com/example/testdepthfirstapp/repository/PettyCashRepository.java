package com.example.testdepthfirstapp.repository;

import com.example.testdepthfirstapp.domain.Employee;
import com.example.testdepthfirstapp.domain.StatusPrettyCash;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testdepthfirstapp.domain.PettyCash;

import java.util.List;

public interface PettyCashRepository extends JpaRepository<PettyCash, Long> {
    List<PettyCash> findByEmployee(Employee employee);

    List<PettyCash> findByStatusPrettyCash(StatusPrettyCash statusPrettyCash);
}
