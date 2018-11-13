package com.example.testdepthfirstapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testdepthfirstapp.domain.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
