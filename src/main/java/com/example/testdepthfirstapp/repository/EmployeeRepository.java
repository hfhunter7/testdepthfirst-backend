package com.example.testdepthfirstapp.repository;

import com.example.testdepthfirstapp.domain.Department;
import com.example.testdepthfirstapp.domain.JobLevel;
import com.example.testdepthfirstapp.domain.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testdepthfirstapp.domain.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByManager(Manager manager);

    List<Employee> findByJobLevel(JobLevel jobLevel);

    List<Employee> findByDepartment(Department department);
}
