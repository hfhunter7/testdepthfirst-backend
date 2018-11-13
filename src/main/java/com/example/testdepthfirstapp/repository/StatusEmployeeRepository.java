package com.example.testdepthfirstapp.repository;

import com.example.testdepthfirstapp.domain.StatusEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testdepthfirstapp.domain.StatusEmployee;

public interface StatusEmployeeRepository extends JpaRepository<StatusEmployee, Long> {

}
