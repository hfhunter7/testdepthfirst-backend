package com.example.testdepthfirstapp.repository.impl;

import com.example.testdepthfirstapp.domain.Department;
import com.example.testdepthfirstapp.domain.Employee;
import com.example.testdepthfirstapp.domain.JobLevel;
import com.example.testdepthfirstapp.domain.Manager;
import com.example.testdepthfirstapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeRepositoryService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeRepositoryService() {

    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void update(Employee employee) {
        employeeRepository.save(employee);
    }

    public void update(List<Employee> employeeList) {
        employeeRepository.save(employeeList);
    }

    public void delete(Long id) {
        employeeRepository.delete(id);
    }

    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }

    public Employee find(Long id) {
        return employeeRepository.findOne(id);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public List<Employee> findEmployeeByManager(Manager manager) {
        return employeeRepository.findByManager(manager);
    }

    public List<Employee> findByJobLevel(JobLevel jobLevel) {
        return employeeRepository.findByJobLevel(jobLevel);
    }

    public List<Employee> findByDepartment(Department department) {
        return employeeRepository.findByDepartment(department);
    }
}
